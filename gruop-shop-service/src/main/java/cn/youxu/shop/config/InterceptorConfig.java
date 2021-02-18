package cn.youxu.shop.config;

import cn.youxu.shop.Interceptor.JwtHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册注解拦截器
        registry.addInterceptor(new JwtHandlerInterceptor()).addPathPatterns("/**");
    }
}