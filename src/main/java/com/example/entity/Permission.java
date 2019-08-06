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

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", roles=" + roles +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
//省略get、set方法
}
