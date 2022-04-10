package com.hongdenglv.puick.cors.db.config;

import com.hongdenglv.puick.cors.db.property.CorsProperty;
import com.hongdenglv.puick.cors.db.service.SysCurrentUser;
import com.hongdenglv.puick.cors.db.service.SysWebCorsService;
import com.hongdenglv.puick.cors.db.service.impl.NoneSysCurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * puick跨域配置
 *
 * @author PeiXy_J
 * @date 2022-4-10 13:43
 */
@Slf4j
@Configuration
@ComponentScan("com.hongdenglv.puick.cors.db")
@MapperScan("com.hongdenglv.puick.cors.db.mapper")
public class WebCorsConfiguration {

    @Resource
    SysWebCorsService sysWebCorsService;

    @Resource
    CorsProperty corsProperty;

    public CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        if (corsProperty.getAllowAll()) {
            log.info("quick cors allowed all!");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedMethod("*");
        } else {
            sysWebCorsService.list().forEach(sysWebCors -> {
                switch (sysWebCors.getAllowedType()) {
                    case 1:
                        corsConfiguration.addAllowedOrigin(sysWebCors.getAllowedContent());
                        break;
                    case 2:
                        corsConfiguration.addAllowedHeader(sysWebCors.getAllowedContent());
                        break;
                    case 3:
                        corsConfiguration.addAllowedMethod(sysWebCors.getAllowedContent());
                        break;
                    default:
                }
            });
        }
        return corsConfiguration;
    }


    @Bean
    @ConditionalOnMissingBean(CorsFilter.class)
    public CorsFilter corsFilter() {
        log.info("puick load cors config.");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getCorsPath(), buildCorsConfiguration());
        return new CorsFilter(source);
    }

    /**
     * 获取当前用户
     */
    @Bean
    @ConditionalOnMissingBean(SysCurrentUser.class)
    public SysCurrentUser sysUserInfo() {
        return new NoneSysCurrentUser();
    }

}
