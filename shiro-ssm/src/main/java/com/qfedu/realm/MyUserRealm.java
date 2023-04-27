package com.qfedu.realm;

import com.qfedu.pojo.SysUsers;
import com.qfedu.service.PermissionService;
import com.qfedu.service.RoleService;
import com.qfedu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 17:55
 * description:
 */
public class MyUserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUsers user  = (SysUsers) principals.getPrimaryPrincipal();
        //封装权限信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //查询该用户对应角色
        Set<String> roles = roleService.findRolesByUserId(user.getId());
        //查询该用户对应权限
        Set<String> permissions = permissionService.findPermisByUserId(user.getId());

        //角色
        authorizationInfo.setRoles(roles);
        //权限
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换类型
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取username， password
        String username = token.getUsername();
        String password = new String(token.getPassword());

        //根据用户名 从数据库查询用户
        SysUsers users = userService.findByUsername(username);

        if(users == null) {
            throw new UnknownAccountException("未知的账户名");
        }

        if(users.getStatus() == 0) {
            throw new LockedAccountException("账户已锁定");
        }


        //数据库中的密码
        String passwordDb = users.getPassword();
        if(!passwordDb.equals(password)) {
            throw new CredentialsException("密码不对");
        }
        //认证成功 后要返回的 认证信息
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(users, passwordDb, users.getRealname());

        return authenticationInfo;
    }
}
