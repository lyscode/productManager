package cn.LysGroup.controller;

import cn.LysGroup.domain.Role;
import cn.LysGroup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//角色管理
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;

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
    public void saveRole(Role role, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.save(role);
        //添加完成之后跳转到查询所有
        response.sendRedirect(request.getContextPath()+"/role/findAll");
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(int id){
        Role role=service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
    /**
     * 查询详情
     * @param id
     * @return
     */
    @RequestMapping("/deleteRole")
    public void deleteRole(int id,HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.deleteById(id);
        //删除之后重定向
        response.sendRedirect(request.getContextPath()+"/role/findAll");
    }
}
