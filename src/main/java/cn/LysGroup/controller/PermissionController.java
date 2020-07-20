package cn.LysGroup.controller;

import cn.LysGroup.domain.Permission;
import cn.LysGroup.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService service;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Permission> permissionList= service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    /**
     * 添加权限
     * @param permission
     */
    @RequestMapping("/save")
    public void saveRole(Permission permission, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.save(permission);
        //添加完成之后跳转到查询所有
        response.sendRedirect(request.getContextPath()+"/permission/findAll");
    }
    /**
     * 删除权限
     * @param permission
     */
    @RequestMapping("/deletePermission")
    public void deletePermission(int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.deletePermission(id);
        //删除完成之后跳转到查询所有
        response.sendRedirect(request.getContextPath()+"/permission/findAll");
    }
}
