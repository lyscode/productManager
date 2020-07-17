package cn.LysGroup.dao;

import cn.LysGroup.domain.Role;
import org.springframework.stereotype.Repository;
//角色dao
@Repository
public interface RoleDao {
    /**
     * 通过id查询role
     * @param id
     * @return
     */
    Role findById(int id);
}
