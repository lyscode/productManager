package cn.LysGroup.dao;

import cn.LysGroup.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

//资源权限
@Repository
public interface PermissionDao {
    /**
     * 通过id查询Permission
     * @param id
     * @return
     */
    Permission findById(int id);

    /**
     * 查询所有权限
     * @return
     */
    List<Permission> findAll();

    /**
     * 保存
     * @param permission
     */
    void save(Permission permission);

    /**
     * 删除权限角色中间表
     * @param id
     */
    void deleteR_P(int id);

    /**
     * 删除权限
     * @param id
     */
    void deletePermission(int id);

    /**
     * 通过id查询角色的详细信息,以及角色可以添加的权限
     * @param id
     * @return
     */
    List<Permission> findNotInId(int id);
}
