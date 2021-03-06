package cn.LysGroup.controller;

import cn.LysGroup.domain.Product;
import cn.LysGroup.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 产品控制类
 */
@Controller
@RequestMapping("/product")
public class ProductController  {
    @Autowired
    private ProductService service;

    /**
     * 查询产品信息并分页展示
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/findAll")
    @RolesAllowed("admin")
    //@Secured("ROLE_admin")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue ="1") Integer page, @RequestParam(name = "size",defaultValue = "4") Integer size){
        ModelAndView mv = new ModelAndView();
        try {
            //查询所有数据
            List<Product> all = service.findAll(page,size);
            //传给分页bean
            PageInfo pageInfo = new PageInfo(all);
            mv.addObject("pageInfo",pageInfo);
            mv.setViewName("product-list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    /**
     * 保存产品
     * @param product
     */
    @RequestMapping("/save")
    @PreAuthorize("authentication.principal.username == 'tom'")
    public String save(Product product) throws Exception {
        service.save(product);
        //重定向，添加成功，然后请求查询所有
        return "redirect:findAll";
    }

}
