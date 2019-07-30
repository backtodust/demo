package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.Room;
import com.example.entity.User;
import com.example.mapper.RoomMapper;
import com.example.mapper.UserMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserService extends ServiceImpl<RoomMapper, Room> {
    @Resource
    UserMapper userMapper;

    public User getUserByName(String name){
        return  userMapper.getUserByName(name);
    }

    public List<Role> getRoles(Long uid){
        return  userMapper.getRoles(uid);

    }
    public List<Permission> getPermissions(int roleId){
        return userMapper.getPermissions(roleId);
    }
    public static String md5(String str, String salt) {
        return new Md5Hash(str, salt).toString();
    }

    public static void main(String[] args) {
        String password = "123456";
        System.out.println(md5(password, "q6taw"));
    }



}
