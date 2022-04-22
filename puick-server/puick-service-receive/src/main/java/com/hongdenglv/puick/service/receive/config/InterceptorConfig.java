package com.hongdenglv.puick.service.receive.config;

import com.hongdenglv.puick.service.receive.interceptor.ShamInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @author PeiXy_J
 * @since 2022-4-22 22:38
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    ShamInterceptor shamInterceptor;

    public InterceptorConfig(ShamInterceptor shamInterceptor) {
        this.shamInterceptor = shamInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shamInterceptor);
    }

}
