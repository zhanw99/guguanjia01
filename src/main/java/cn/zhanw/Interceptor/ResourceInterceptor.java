package cn.zhanw.Interceptor;

import cn.zhanw.entity.SysResource;
import cn.zhanw.entity.SysUser;
import cn.zhanw.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class ResourceInterceptor implements HandlerInterceptor {
    @Autowired
    SysResourceService sysResourceService;

    //请求到达，方法执行前拦截方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();//用户请求
        boolean boo = false;
        System.err.println(uri);
        // StringBuffer requestURL = request.getRequestURL();
        System.out.println("ResourceInterceptor请求到达，方法执行前拦截方法");
        HttpSession session = request.getSession();
        SysUser user = (SysUser) session.getAttribute("user");//个人权限
        List<SysResource> resources = (List<SysResource>) session.getAttribute("resources");//全部权限
        if (!StringUtils.isEmpty(user)) {//判断他是否为登陆成功
            List<SysResource> sysResources = sysResourceService.selectAll();//查询全部权限
            for (SysResource sysResource : sysResources) { //遍历全部权限
                if (!StringUtils.isEmpty(sysResource.getUrl())
                        && !"".equals(sysResource.getUrl())
                        && uri.contains(sysResource.getUrl())) {//查看请求是否包含在全部权限里
                    boo = true;
                }
            }
            if (boo) {
                for (SysResource resource : resources) {//遍历个人权限
                    if (!StringUtils.isEmpty(resource.getUrl())
                            && !"".equals(resource.getUrl())
                            && uri.contains(resource.getUrl())) {//查看请求是否包含在个人权限里
                        return true;
                    }
                }
            }
        } else {
            //登陆失败
            response.sendRedirect("/login.html");
        }
        return false;
    }

    //请求到达，方法执行后，返回视图解析器前执行拦截方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求到达，方法执行后，返回视图解析器前执行拦截方法");
    }

    //请求到达，方法执行后，返回视图解析器，并且响应视图到页面拦截方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("请求到达，方法执行后，返回视图解析器，并且响应视图到页面拦截方法");
    }


}
