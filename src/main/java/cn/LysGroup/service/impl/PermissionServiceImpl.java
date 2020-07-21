package cn.LysGroup.service.impl;

import cn.LysGroup.dao.PermissionDao;
import cn.LysGroup.domain.Permission;
import cn.LysGroup.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao dao;
    @Override
    public List<Permission> findAll() {
        List<Permission> permissionList=null;
        try {
            permissionList=dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionList;
    }

    @Override
    public void save(Permission permission) {
        try {
            dao.save(permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePermission(int id) {
        try {
            dao.deleteR_P(id);
            dao.deletePermission(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Permission> findNotInId(int id) {
        List<Permission> permissions =dao.findNotInId(id);
        return permissions;
    }
}
