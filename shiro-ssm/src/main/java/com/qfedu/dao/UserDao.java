package com.qfedu.dao;

import com.qfedu.pojo.SysUsers;

/**
 * 创建者: zzq
 * 创建时间: 2023/4/25 11:39
 * 描述:
 */
public interface UserDao {
    SysUsers findByUsername(String username);

}
