package cn.LysGroup.controller;

import cn.LysGroup.domain.Role;
import cn.LysGroup.domain.UserId_Ids;
import cn.LysGroup.domain.UserInfo;
import cn.LysGroup.service.RoleService;
import cn.LysGroup.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//用户管理
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView  findAll(@RequestParam(name = "page",defaultValue ="1") Integer page, @RequestParam(name = "size",defaultValue = "4") Integer size){
        List<UserInfo> list = service.findAll(page, size);
        //分页bean
        PageInfo pageInfo = new PageInfo(list);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @RequestMapping("/save")
    public String saveUser(UserInfo userInfo) {
        //保存用户
        service.saveUser(userInfo);
        //重定向到用户查询
        return "redirect:findAll";
    }

    /**
     * 通过id查询用户的详细信息
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView  findById(Integer id){
        UserInfo userInfo=service.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-show");
        mv.addObject("user",userInfo);
        return mv;
    }
    /**
     * 通过id查询用户的详细信息,以及用户可以添加的角色
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView  findUserByIdAndAllRole(Integer id){
        List<Role> roleList = roleService.findNotInId(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-role-add");
        mv.addObject("roleList",roleList);
        mv.addObject("userId",id);
        return mv;
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(Integer userId, Integer[] ids) {
        UserId_Ids userId_ids = new UserId_Ids();
        List<Integer> list=new ArrayList<>();
        for (int id : ids) {
            list.add(id);
        }
        userId_ids.setIds(list);
        userId_ids.setUserId(userId);
        //添加角色
        service.saveUser_Role(userId_ids);
        //重定向到用户查询
        return "redirect:findAll";
    }
}
