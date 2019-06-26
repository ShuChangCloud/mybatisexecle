package com.xmcc.mapper;

import com.xmcc.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-24 20:31
 */
public interface UsersMapper {

    Users findById(Integer id);

    List<Users> findAll();

    List<Users> findByUsers(Users users);

    int updateByUserSelective(Users users);

    int insertRtnPk(Users users);

    Users selectByIdOruserName(Users users);

    /**
     * 批量向mysql中插入数据
     * @param users 待插入的列表集合
     * @return
     */
    int insertList(@Param("users") List<Users> users);


    /**
     * 动态实现字段的更新
     * @param map key为数据库字段的键,val为待更新的字段
     * @return
     */
    int updateDynamic(@Param("map") Map<String,Object> map);

}
