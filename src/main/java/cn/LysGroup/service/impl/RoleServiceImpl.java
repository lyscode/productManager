package cn.LysGroup.service.impl;

import cn.LysGroup.dao.RoleDao;
import cn.LysGroup.domain.Role;
import cn.LysGroup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao dao;
    @Override
    public List<Role> findAll() {
        List<Role> list=null;
        try {
            list=dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Role role) {
        try {
            dao.save(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(int id) {
        Role role=null;
        try {
            role=dao.findById1(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public void deleteById(int roleId) {
        try {
            //先删除中间表的roleId
            dao.deletePermissionById(roleId);
            dao.deleteUser(roleId);
            //再删除role
            dao.deleteById(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> findNotInId(int id) {
        List<Role> roleList=null;
        try {
            roleList=dao.findNotInId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }
}
