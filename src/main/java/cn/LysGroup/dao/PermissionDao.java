package cn.LysGroup.dao;

import cn.LysGroup.domain.Permission;
import org.springframework.stereotype.Repository;

//资源权限
@Repository
public interface PermissionDao {
    /**
     * 通过id查询Permission
     * @param id
     * @return
     */
    Permission findById(int id);
}
