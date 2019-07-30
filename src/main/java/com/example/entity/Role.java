package com.example.entity;

import java.util.List;

public class Role {

    private Integer id;
    // 角色标识程序中判断使用,如"admin"
    private String role;
    // 一个角色可以有多个权限
    private List<Permission> permissions;
    // 一个角色对应多个用户
    private List<User> userInfos;

    //省略get、set方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<User> userInfos) {
        this.userInfos = userInfos;
    }
}

