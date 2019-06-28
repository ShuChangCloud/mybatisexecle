package com.xmcc.test;

import com.xmcc.model.Users;
import com.xmcc.model.UsersExample;
import com.xmcc.model.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-28 14:17
 */
public class ExampleTest {

    private SqlSession session;

    @Before
    public   void getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session=sqlSessionFactory.openSession();
    }


    @Test
    public void tes(){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        UsersExample example=new UsersExample();
        example.setDistinct(true);
//        UsersExample.Criteria criteria = example.createCriteria();
//        criteria.andRidEqualTo(1);
        UsersExample.Criteria or = example.or();
        or.andUserNameLike("%test%");
        or.andIdBetween(5,10);
        List<Users> users = mapper.selectByExample(example);
        users.stream().forEach(System.out::println);
    }

    @Test
    public void testupdExap(){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andRidEqualTo(2);
        Users users=new Users();
        users.setUserName("exam_te_st");
        mapper.updateByExampleSelective(users,example);
        session.commit();
        session.close();
    }
}
