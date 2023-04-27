package com.qfedu.service;

import com.qfedu.pojo.SysUsers;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 17:59
 * description:
 */
public interface UserService {
    SysUsers findByUsername(String username);
}
