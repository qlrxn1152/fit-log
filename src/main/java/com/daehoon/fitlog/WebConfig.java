package com.daehoon.fitlog;

import com.daehoon.fitlog.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**") // 모든 패턴들에 대해서 적용
                .excludePathPatterns(
                        "/",
                        "/login",
                        "/logout",
                        "/members/add",
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/*.ico",
                        "/error",
                        "/.well-known/**"
                );
    }
}
