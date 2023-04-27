package com.qfedu.dao;

import com.qfedu.pojo.SysRole;

import java.util.List;

/**
 * 创建者: zzq
 * 创建时间: 2023/4/25 16:24
 * 描述:
 */
public interface RoleDao {
    List<SysRole> findRolesByUserId(int userId);
}
