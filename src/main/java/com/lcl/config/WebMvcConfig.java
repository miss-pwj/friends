package com.lcl.config;

import com.lcl.converter.DateConverter;
import com.lcl.intercepors.ToMainInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lcl
 * @date 2019/10/22 15:07
 * @Description
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ToMainInterceptor toMainInterceptor;

    //欢迎页设置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("/main.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main.html").setViewName("main");
    }
    //日期转换器配置
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter( new DateConverter());
    }

    //虚拟路径设置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取文件的真实路径 work_project代表项目工程名 需要更改
        String path2 =System.getProperty("user.dir")+"\\src\\main\\resources\\static\\user\\";
        registry.addResourceHandler("/user/**").
                addResourceLocations("file:///"+path2);

    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("进入拦截器");
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
   //    registry.addInterceptor(toMainInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
    registry.addInterceptor(toMainInterceptor).addPathPatterns("/**").excludePathPatterns("/**/toLogin","/**/toRegister","/**/toUpload");
       // registry.addInterceptor(toMainInterceptor).addPathPatterns("/toMain","/userRegister","/userLogin","/uploadPhoto");
        //WebMvcConfigurer.super.addInterceptors(registry);    //较新Spring Boot的版本中这里可以直接去掉，否则会报错
    }

    public static void main(String[] args){
        System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\static\\user\\");
    }
}
