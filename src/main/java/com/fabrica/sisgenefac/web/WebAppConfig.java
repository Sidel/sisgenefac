package com.fabrica.sisgenefac.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan("com.fabrica.sisgenefac.web")
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInSessionInterceptor())
                .addPathPatterns(new String[]{
                    "/**"
                }).excludePathPatterns("/auth/**");
//                }).excludePathPatterns("/auth/**");
    }
}
