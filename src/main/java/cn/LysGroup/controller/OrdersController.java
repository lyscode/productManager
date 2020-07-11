package cn.LysGroup.controller;

import cn.LysGroup.domain.Orders;
import cn.LysGroup.domain.Product;
import cn.LysGroup.service.OrdersService;
import cn.LysGroup.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单控制类
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService service;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue ="1") int page,@RequestParam(name = "size",defaultValue = "4") int  size){
        ModelAndView mv = new ModelAndView();
        try {
            //查询总共的订单信息
            List<Orders> all = service.findAll(page,size);
            //把all传给PageInfo
            PageInfo pageInfo=new PageInfo(all);
            //把分页信息传给前台
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("orders-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }
}
