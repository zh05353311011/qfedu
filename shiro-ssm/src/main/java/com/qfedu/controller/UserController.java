package com.qfedu.controller;

import com.qfedu.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.shiro.subject.Subject;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 17:17
 * description:
 */
@RestController
public class UserController {
    @RequestMapping("/doLogin")
    public Result doLogin(String username,String password,String rememberMe){
        Md5Hash md5Hash=new Md5Hash(password,username,1024);
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,md5Hash.toString());
        try {
            subject.login(token);

            System.out.println("是否是管理员: "+subject.hasRole("管理员"));
            System.out.println("是否拥有完全先"+subject.isPermitted("sys:user:add"));
            System.out.println("是否拥有权限:"+subject.isPermitted("sys:role:add"));
            System.out.println("是否拥有权限"+subject.isPermitted("sys:abc:add"));
        }catch (UnknownAccountException e){
            e.printStackTrace();
            return Result.error();
        }catch (LockedAccountException e){
            e.printStackTrace();
            return Result.error();
        }catch (CredentialsException e){
            e.printStackTrace();
            return Result.error("密码错误");
        }
        return Result.ok("登陆成功");
    }
}
