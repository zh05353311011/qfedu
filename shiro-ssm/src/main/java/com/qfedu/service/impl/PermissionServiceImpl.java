package com.qfedu.service.impl;

import com.qfedu.dao.MenuDao;
import com.qfedu.pojo.SysMenu;
import com.qfedu.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    MenuDao menuDao;

    @Override
    public Set<String> findPermisByUserId(int id) {

        List<SysMenu> list = menuDao.findPermisByUserId(id);


        Set<String> permis = list.stream().map((menu) -> {
            return menu.getPerms();
        }).collect(Collectors.toSet());

        return permis;
    }
}
