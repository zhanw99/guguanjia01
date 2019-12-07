package cn.zhanw.log;

import cn.zhanw.entity.SysLog;
import cn.zhanw.entity.SysUser;
import cn.zhanw.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 系统日志切面类  用于封装通用的日志功能：
 * 1.系统正常操作完成，记录系统正常日志
 * 2.系统出现异常，记录系统异常信息
 */
@Component//交给spring来管理 对应Mybatis 的ComponentScan
@Aspect
public class LogoAspect {

    @Autowired
    SysLogService service;

    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(* cn.zhanw..*Controller.*(..))")
    public void pointcut() {
        System.out.println("进入日志监控");
    }//切入点


    /**
     * 系统正常操作的通知
     * JoinPoint：连接点对象 方法对象
     * obj：当前的连接点对象的返回值
     * 1.获取Syslog对象需要的数据
     * 2.获取SysLogService
     * 3.插入数据到数据库Sys_Log表
     */
    @AfterReturning(value = "pointcut()", returning = "obj")
    public void afterReturn(JoinPoint joinPoint, Object obj) {
        saveLog(joinPoint, null);
    }

    /**
     * 系统正常操作的通知
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrow(JoinPoint joinPoint, Throwable e) {
        saveLog(joinPoint, e);
    }

    public void saveLog(JoinPoint joinPoint,Throwable e){
        SysLog sysLog = new SysLog();
//        1.先判断e是否为null
//        sysLog.setType(e==null?"1":"2");//2为异常
        //2.判断request是否为null（是否正常操作），
        if(request!=null){//正常请求操作
//            3.取session跟user
            HttpSession session = request.getSession();
            SysUser user = (SysUser) session.getAttribute("user");
            if (user!=null&&!"".equals(user)){
//                4.set进log去，前要判断user是否为空
                sysLog.setCreateBy(user.getUsername());//姓名

            }
            sysLog.setCreateDate(new Date());//更新时间
            sysLog.setRemoteAddr(request.getRemoteAddr());
            sysLog.setUserAgent(request.getHeader("User-Agent"));//用户代理  用户浏览器信息
            sysLog.setRequestUri(request.getRequestURI());//请求URI
            sysLog.setMethod(request.getMethod());//操作方式
//            5.去joinPoint.getArgs()拿参数
            Object[] args = joinPoint.getArgs();//操作IP地址
            StringBuilder sb= new StringBuilder();
//            6.循环有几个参数
            for (int i = 0; i < args.length; i++) {
//                7.set进去   反射
                //[参数1，类型:Long，值:69][参数2，类型:String，值:[{"component":"11","createBy":"69,13637799479","createDate":"Mar 23, 2017 12:00:00 AM","morphological":"0","packaging":"0","plateNumber":"1111","wasteCode":"271-001-02","wasteTypeId":2,"weight":11.0,"id":0}]]
                sb.append("[参数"+ (i+1)+",类型："+args[i].getClass().getSimpleName()+",值:"+args[i].toString()+"]");
            }
            //8.  setParams 参数
            sysLog.setParams(sb.toString());
//            9.是否是异常，set进去
//            sysLog.setException(e==null?"":e.toString());//报错原因
//            10.插入进去
            service.insert(sysLog);
        }
    }



}
