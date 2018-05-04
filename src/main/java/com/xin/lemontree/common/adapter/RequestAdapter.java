package com.xin.lemontree.common.adapter;

import com.xin.lemontree.common.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author creator mafh 2018/2/6 11:49
 * @author updater mafh
 * @version 1.0.0
 * @description
 */
@Configuration
public class RequestAdapter extends WebMvcConfigurerAdapter {
    /**
     * 登录拦截器
     */
    private RequestInterceptor requestInterceptor;

    @Autowired
    public RequestAdapter(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**")
                // 登录不做拦截
                .excludePathPatterns("/login")
                .excludePathPatterns("/websocket")
                .excludePathPatterns("/mywebsocket")
                .excludePathPatterns("/api/user/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("error").setViewName("error.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}
