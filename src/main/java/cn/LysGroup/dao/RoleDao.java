package cn.LysGroup.dao;

import cn.LysGroup.domain.Role;
import cn.LysGroup.domain.UserId_Ids;
import org.springframework.stereotype.Repository;

import java.util.List;

//角色dao
@Repository
public interface RoleDao {
    /**
     * 通过id查询role
     * @param id
     * @return
     */
    Role findById(int id);

    /**
     * 查询所有role
     * @return
     */
    List<Role> findAll();

    /**
     * 添加角色
     * @param role
     */
    void save(Role role);

    /**
     * 通过id查询role
     * @param id
     * @return
     */
    Role findById1(int id);

    /**
     * 删除角色
     * @param roleId
     */
    void deleteById(int roleId);

    /**
     * 先删除中间表的roleId
     * @param roleId
     */
    void deletePermissionById(int roleId);

    /**
     * 先删除中间表的roleId
     * @param roleId
     */
    void deleteUser(int roleId);

    /**
     * 查询不在id的所有角色
     * @param id
     * @return
     */
    List<Role> findNotInId(int id);

    /**
     * 给角色添加权限
     * @param id_ids
     */
    void addPermission(UserId_Ids id_ids);
}
