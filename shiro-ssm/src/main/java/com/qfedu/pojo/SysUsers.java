package com.qfedu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 11:43
 * description:
 */
@Data
public class SysUsers implements Serializable {

    //用户id
    private int id;

    //用户名
    private String username;

    //用户密码
    private String password;

    //用户状态
    private int status;

    //用户真实名字
    private String  realname;

}
