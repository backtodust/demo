package com.example.entity;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {
    private Integer id;
    private String name;
    // 资源路径.
    private String url;
    // 权限字符串如 role:create,role:update,role:delete,role:view
    private String permission;
    // 一个权限可以包含多个角色
    private List<Role> roles;

    //省略get、set方法
}
