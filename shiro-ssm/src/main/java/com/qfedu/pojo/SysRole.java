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
public class SysRole implements Serializable {
    //角色id
    private Integer id;

    //角色名字
    private String name;

    //角色描述
    private String desc;
}
