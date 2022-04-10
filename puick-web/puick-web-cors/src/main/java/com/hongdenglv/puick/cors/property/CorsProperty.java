package com.hongdenglv.puick.cors.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Puick属性
 *
 * @author PeiXy_J
 * @date 2022-4-9 22:55
 */
@Data
@Configuration
@ConfigurationProperties("puick.web.cors")
public class CorsProperty {

    /**
     * 是否允许全部跨域
     */
    private Boolean allowedAll = false;

    /**
     * 拦截地址
     */
    private String corsPath = "/**";

    /**
     * 允许访问地址
     */
    private List<String> allowedOriginList = new ArrayList<>();

    /**
     * 允许消息头
     */
    private List<String> allowedHeaderList = new ArrayList<>();

    /**
     * 允许的请求方式
     */
    private List<String> allowedMethodList = new ArrayList<>();

}
