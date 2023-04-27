package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.pojo.SysUsers;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName:MybatisPlus
 * author:zzq
 * time:2023/4/25 18:00
 * description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public SysUsers findByUsername(String username) {
        return null;
    }
}
