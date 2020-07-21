package cn.LysGroup.controller;

import cn.LysGroup.domain.SysLog;
import cn.LysGroup.service.ISysLogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService  sysLogService;

    /**
     * 查询所有日志
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer size){
        List<SysLog> logList=sysLogService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(logList);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("syslog-list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }
}
