package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    User getUserByName(@Param("username")String name);
    List<Role> getRoles(@Param("uid")Long uid);
    List<Permission> getPermissions(@Param("roleId")int roleId);

}
