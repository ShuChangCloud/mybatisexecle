package com.xmcc;

import com.xmcc.entity.Role;
import com.xmcc.model.Users;

/**
 * @company xmcc
 * @create create by qcc on 2019-06-28 15:17
 */
public class UsersWithRoleDto extends Users {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "UsersWithRoleDto{" +
                "role=" + role +
                "} " + super.toString();
    }
}
