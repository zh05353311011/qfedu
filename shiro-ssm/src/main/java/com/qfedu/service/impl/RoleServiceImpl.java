package com.qfedu.service.impl;

import com.qfedu.dao.RoleDao;
import com.qfedu.pojo.SysRole;
import com.qfedu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 创建者: QF-SUN
 * 创建时间: 2023/4/25 16:18
 * 描述:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Set<String> findRolesByUserId(int userId) {

        List<SysRole> list = roleDao.findRolesByUserId(userId);
        //使用1.8 新特性 stream 转换类型
        //stream: 把源集合转换为流
        //map：映射，把源对象映射为需要的对象
        //collect：指定集合的类型
        Set<String> roles = list.stream().map((role) -> {
            return role.getName();
        }).collect(Collectors.toSet());


        return roles;
    }
}
