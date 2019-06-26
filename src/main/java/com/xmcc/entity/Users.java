package com.xmcc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-24 20:30
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    private Integer id;
    private String username;
    private String password;
    private Integer rid;

    public Users(String username,String password){
        this.username=username;
        this.password=password;
    }

}
