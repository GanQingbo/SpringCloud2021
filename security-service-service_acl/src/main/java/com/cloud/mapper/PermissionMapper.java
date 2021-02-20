package com.cloud.mapper;


import com.cloud.entity.Permission;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
public interface PermissionMapper {


    List<String> selectPermissionValueByUserId(Integer id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(Integer uid);
}
