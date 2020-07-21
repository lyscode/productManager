package cn.LysGroup.utils;

import cn.LysGroup.domain.SysLog;
import cn.LysGroup.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

//自定义日志类切面
public class LogAop {
    private Date visitTime;//开始时间
    private Class clazz; //访问的类
    private Method method; //访问的方法
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;


    //前置通知,获取开始时间和执行的类和方法是什么
    public void before(JoinPoint jp) throws NoSuchMethodException {
        // 访问时间
        visitTime = new Date();
        // 获取访问的类
        clazz = jp.getTarget().getClass();
        // 获取访问的方法的名称
        String methodName = jp.getSignature().getName();
        // 获取访问的方法的参数
        Object[] args = jp.getArgs();
         if(args == null || args.length == 0) {
            // 无参数，只能获取无参数方法
            method = clazz.getMethod(methodName);
        }else{
             // 有参数，就将args中所有元素遍历，获取对应的Class,装入到一个Class[]
             Class[] classArgs = new Class[args.length];
             for (int i = 0; i < args.length; i++) {
                 classArgs[i] = args[i].getClass();
             }
             // 获取有参数方法
             method = clazz.getMethod(methodName, classArgs);
         }
    }

    //后置通知 主要获取日志中其它信息，时长、ip、url
    public void after(JoinPoint jp){
        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长
        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null &&   !classAnnotation.value()[0].equals("/sysLog")) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];
                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    //获取当前操作的用户
                    // 可以通过securityContext获取，也可以从request.getSession中获取
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]: " + clazz.getName() + ",[方法名] :" + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);
                    //调用Service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }
    }
}
