package com.example.config;
import javax.annotation.Resource;


import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;


public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");

        // 获取用户的输入的账号.
        String name = (String) token.getPrincipal();
        System.out.println(token.getCredentials());

        // 通过name和password从数据库中查找 User对象，
        User userInfo = userService.getUserByName(name);
        if (userInfo == null) {
            return null;
        }

        Long uid = userInfo.getUserId();
        List<Role> roles = userService.getRoles(uid);
        int roleId = roles.get(0).getId();
        List<Permission> permissions = userService.getPermissions(roleId);
        roles.get(0).setPermissions(permissions);
        userInfo.setRoleList(roles);
        // 加密方式;
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        String password = userInfo.getPassword();
        // 秘钥
        ByteSource salt = ByteSource.Util.bytes(userInfo.getSalt());
        // 当前域的名称（MyShiroRealm）
        String realmName = getName();
        // 认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, password, salt, realmName);

        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        return null;
    }

}
