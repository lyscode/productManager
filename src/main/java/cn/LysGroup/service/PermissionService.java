package cn.LysGroup.service;

import cn.LysGroup.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询所有角色
     * @return
     */
    List<Permission> findAll();

    /**
     * 保存
     * @param permission
     */
    void save(Permission permission);

    /**
     * 删除权限
     * @param id
     */
    void deletePermission(int id);
}
