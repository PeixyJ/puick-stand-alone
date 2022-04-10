package com.hongdenglv.puick.cors.db.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置
 *
 * @author PeiXy_J
 * @date 2022-4-10 13:57
 */
@Data
@Configuration
@ConfigurationProperties("puick.web.cors")
public class CorsProperty {

    /**
     * 拦截路径
     */
    private String corsPath = "/**";

    /**
     * 是否允许全部
     */
    private Boolean allowAll = false;

}
