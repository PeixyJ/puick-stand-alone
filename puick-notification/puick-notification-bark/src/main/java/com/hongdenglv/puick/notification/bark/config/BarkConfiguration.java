package com.hongdenglv.puick.notification.bark.config;

import com.hongdenglv.puick.notification.bark.property.BarkProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bark配置
 *
 * @author PeiXy_J
 * @date 2022-4-11 09:20
 */
@Slf4j
@Configuration
@ComponentScan("com.hongdenglv.puick.notification.bark")
public class BarkConfiguration implements InitializingBean {

    BarkProperty barkProperty;

    public BarkConfiguration(BarkProperty barkProperty) {
        this.barkProperty = barkProperty;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("quick load notification bark api:{}", barkProperty.getApiAddress());
    }
}
