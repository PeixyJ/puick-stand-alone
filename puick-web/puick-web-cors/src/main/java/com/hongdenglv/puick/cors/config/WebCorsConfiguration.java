package com.hongdenglv.puick.cors.config;

import com.hongdenglv.puick.cors.property.CorsProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

/**
 * Puick跨域配置
 *
 * @author PeiXy_J
 * @date 2022-4-9 22:52
 */
@Slf4j
@Configuration
public class WebCorsConfiguration {

    @Bean
    CorsProperty corsProperty() {
        return new CorsProperty();
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        CorsProperty corsProperty = corsProperty();
        if (corsProperty.getAllowedAll()) {
            log.info("quick cors allowed all!");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedMethod("*");
        } else {
            log.info("quick cors allowed to be selected!");
            //放行Header
            corsProperty.getAllowedHeaderList().forEach(corsConfiguration::addAllowedHeader);
            //放行方法
            corsProperty.getAllowedMethodList().forEach(corsConfiguration::addAllowedMethod);
            //放行起源地址
            corsProperty.getAllowedOriginList().forEach(corsConfiguration::addAllowedOrigin);
        }
        return corsConfiguration;
    }


    @Bean
    @ConditionalOnMissingBean(CorsFilter.class)
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty().getCorsPath(), buildCorsConfiguration());
        return new CorsFilter(source);
    }

}
