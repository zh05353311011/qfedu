package com.qfedu.service;

import java.util.Set;

/**
 * 创建者: QF-SUN
 * 创建时间: 2023/4/25 16:18
 * 描述:
 */
public interface PermissionService  {
    Set<String> findPermisByUserId(int id);
}
