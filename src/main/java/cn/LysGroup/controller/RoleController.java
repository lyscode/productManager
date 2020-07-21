package cn.LysGroup.controller;

import cn.LysGroup.domain.Permission;
import cn.LysGroup.domain.Role;
import cn.LysGroup.domain.UserId_Ids;
import cn.LysGroup.service.PermissionService;
import cn.LysGroup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//角色管理
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;
    @Autowired
    private PermissionService  permissionService;

    /**
     * 查询所有角色
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Role> list=service.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-list");
        mv.addObject("roleList",list);
        return mv;
    }

    /**
     * 添加角色
     * @param role
     */
    @RequestMapping("/save")
    public String saveRole(Role role) throws IOException {
        service.save(role);
        //添加完成之后跳转到查询所有
        return "redirect:findAll";
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        Role role=service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
    /**
     * 删除角色
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    public String deleteRole(Integer id){
        service.deleteById(id);
        //删除之后重定向
        return "redirect:findAll";
    }

    /**
     * 通过id查询角色的详细信息,以及角色可以添加的权限
     * @param id
     * @return
     */
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView  findRoleByIdAndAllPermission(Integer id){
        //查询
        List<Permission> permissionList = permissionService.findNotInId(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-permission-add");
        mv.addObject("permissionList",permissionList);
        mv.addObject("roleId",id);
        return mv;
    }

    /**
     * 给角色添加权限
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermissionToRole")
    public String addRoleToUser(Integer roleId, Integer[] ids)  {
        List<Integer> list=new ArrayList<>();
        UserId_Ids id_ids = new UserId_Ids();
        for (int id : ids) {
            list.add(id);
        }
        id_ids.setIds(list);
        id_ids.setRoleId(roleId);
        //添加权限
        service.addPermission(id_ids);
        //重定向到权限查询
        return "redirect:findAll";
    }
}
