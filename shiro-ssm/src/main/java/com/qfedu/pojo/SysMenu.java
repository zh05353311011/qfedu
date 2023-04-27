package com.qfedu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 11:44
 * description:
 */
@Data
public class SysMenu implements Serializable {

    private Integer id;

    //菜单名字
    private String name;

    //符合shiro规范的权限字符串
    private String perms;

    //类型
    private Integer type;

    //上级id
    private Integer parentId;

}
