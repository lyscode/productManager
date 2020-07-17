package cn.LysGroup.controller;

import cn.LysGroup.domain.UserInfo;
import cn.LysGroup.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//用户管理
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView  findAll(@RequestParam(name = "page",defaultValue ="1") int page, @RequestParam(name = "size",defaultValue = "4") int size){
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
    public void saveUser(UserInfo userInfo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //保存用户
        service.saveUser(userInfo);
        //重定向到用户查询
        response.sendRedirect( request.getContextPath()+"/user/findAll");
    }
}
