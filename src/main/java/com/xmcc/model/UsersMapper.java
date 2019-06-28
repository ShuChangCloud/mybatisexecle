package com.xmcc.model;

import com.xmcc.UsersWithRoleDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);


    List<UsersWithRoleDto> findAllUsersRole();

    UsersWithRoleDto findUsersRoleByUserId(int userid);


    UsersWithRoleDto findUsersRoleByUserId1(int userid);
}