package com.yizu.user.config;

import com.yizu.user.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Package: com.yixin.user.config
 * @ClassName: InterceptorConfig
 * @Description: Java类作用
 * @Author: 式神
 * @CreateDate: 2019/5/27 0:41
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Autowired
    private JwtInterceptor jwtInterceptor;
    protected void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器要声明拦截器对象和要拦截的请求
       registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
               .excludePathPatterns("/**/admin/**")
                .excludePathPatterns("/**/login/**");

    }
}
