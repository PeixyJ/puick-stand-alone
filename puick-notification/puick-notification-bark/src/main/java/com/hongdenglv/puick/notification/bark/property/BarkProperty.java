package com.hongdenglv.puick.notification.bark.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Bark通知属性
 *
 * @author PeiXy_J
 * @date 2022-4-10 20:56
 */

@Data
@Configuration
@ConfigurationProperties("puick.notification.bark")
public class BarkProperty {

    /**
     * 通知标题
     */
    private String barkTitle;

    /**
     * bark api 地址
     */
    private String apiAddress = "https://api.day.app/push/";

    /**
     * 默认Icon
     */
    private String iconUrl;

    /**
     * bark api key 默认
     */
    private String token;

    /**
     * 默认跳转地址
     */
    private String jumpUrl;

}
