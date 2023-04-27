package com.qfedu.dao;

import com.qfedu.pojo.SysMenu;

import java.util.List;

/**
 * 创建者: zzq
 * 创建时间: 2023/4/25 16:34
 * 描述:
 */
public interface MenuDao {
    List<SysMenu> findPermisByUserId(int id);
}
