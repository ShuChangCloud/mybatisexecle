package com.xmcc.test;

import com.xmcc.entity.Users;
import com.xmcc.mapper.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-24 20:38
 */
public class JdbcTest {

public SqlSession session;
    @Test
    public void tes() throws IOException {
        getSqlSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Users users = mapper.findById(1);
        System.out.println(users);
        session.close();
    }

    @Before
    public   void getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session=sqlSessionFactory.openSession();
    }
    @Test
    public void testfindALL2() throws IOException {
        getSqlSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Users users=new Users();
        users.setUsername("t");
        List<Users> list = mapper.findByUsers(users);
        System.out.println(list);
    }

    @Test
    public void testupdateSelective() throws IOException {
        getSqlSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Users users = Users.builder().id(4).username("jerry").password("jerry").rid(2).build();
        mapper.updateByUserSelective(users);
        session.commit();
        session.close();
    }

    @Test
    public void getPKInsert() throws IOException {
        getSqlSession();
        try {
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            Users users = Users.builder().username("tes2t").password("test2").rid(2).build();
            int i = mapper.insertRtnPk(users);
            session.commit();
            System.out.println(users.getId());
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void selectByIdOruserNameTest() throws IOException {
        getSqlSession();
        try {
            UsersMapper mapper = session.getMapper(UsersMapper.class);
            Users users = Users.builder().build();
            Users qu = mapper.selectByIdOruserName(users);
            System.out.println(qu);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void testinsertList() throws IOException {
        getSqlSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        List<Users> usersList = Stream.generate(() -> {
            Users users = Users.builder().id(null).username("te_st_gen").password("te_st_gen").rid(1).build();
            return users;
        }).limit(5).collect(Collectors.toList());
        mapper.insertList(usersList);
        session.commit();
        List<Integer> idList = usersList.stream().map(Users::getId).collect(Collectors.toList());
        System.out.println(idList);

        session.close();
    }

    @Test
    public void testupdateDynamic() throws IOException {
        getSqlSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        Map map =new HashMap();
        map.put("id",1);
        map.put("user_name","dynamic");
        map.put("pass_word","dyn");
        mapper.updateDynamic(map);
        session.commit();
        session.close();
    }
}
