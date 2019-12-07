package cn.zhanw.config;

import cn.zhanw.Interceptor.ResourceInterceptor;
import cn.zhanw.log.LogoAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * springmvc配置：
 * 1.开启包扫描扫描controller层
 * 2.开启mvc支持
 * 3.静态资源放行
 */
//替换xml配置文件，使用注解形式
@Configuration//用于定义配置类，可替换xml配置文件
//1.3  加载映射文件
@ComponentScan(basePackages={"cn.zhanw.controller"})
//开启mvc支持
@EnableWebMvc

@EnableAspectJAutoProxy
public class SpringMvcConfig implements WebMvcConfigurer {
    @Autowired
    ResourceInterceptor resourceInterceptor;
    @Autowired
    LogoAspect logoAspect;
    /**
     * springmvc文件上传：
     * 1.前端处理
     * 2.配置springmvc文件上传解析器  multiparResolerver
     * 3.接收文件上传处理方法上添加 MultipartFile  接收请求数据
     */
    @Bean("multipartResolver")//必须指定bean命名
    public CommonsMultipartResolver getMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return  commonsMultipartResolver;
    }
    //    放行静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //设置拦截和方法规则
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("springMvcConfig设置拦截和方法规则");
        //获取拦截器注册对象
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(resourceInterceptor);
        //拦截所有请求
        interceptorRegistration.addPathPatterns("/**");
        //忽略拦截器请求    记得加斜杠哦
        interceptorRegistration.excludePathPatterns(new String[]{"/index.html","/login.html","/manager/login"});

    }
}
