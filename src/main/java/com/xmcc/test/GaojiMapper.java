package com.xmcc.test;

import com.xmcc.UsersWithRoleDto;
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
 * @create create by qcc on 2019-06-28 15:27
 */
public class GaojiMapper {

    private SqlSession session;

    @Before
    public   void getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session=sqlSessionFactory.openSession();
    }

    @Test
    public void test(){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        List<UsersWithRoleDto> usersRole = mapper.findAllUsersRole();
        usersRole.forEach(System.out::println);

    }

    /**
     * 嵌套关联查询测试
     */
    @Test
    public void findUsersRoleByUserIdTest(){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        UsersWithRoleDto usersWithRoleDto = mapper.findUsersRoleByUserId(1);
        System.out.println(usersWithRoleDto);
    }


    @Test
    public void findUsersRoleByUserId1Test(){
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        UsersWithRoleDto usersWithRoleDto = mapper.findUsersRoleByUserId1(2);
        System.out.println("执行getRole()方法前");
        usersWithRoleDto.getRole();
    }
}
