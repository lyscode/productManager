package cn.LysGroup.service;

import cn.LysGroup.domain.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 添加角色
     * @param role
     */
    void save(Role role);

    /**
     * 角色详情
     * @param id
     * @return
     */
    Role findById(int id);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteById(int roleId);

    /**
     * 查询不在id的所有角色
     * @param id
     * @return
     */
    List<Role> findNotInId(int id);
}
