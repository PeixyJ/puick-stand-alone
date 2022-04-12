package com.hongdenglv.puick.credential.token.config;

import com.hongdenglv.puick.credential.token.DefaultTokenEncryptionService;
import com.hongdenglv.puick.credential.token.TokenEncryptionService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Token配置
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:24
 */
@Configuration
@ComponentScan("com.hongdenglv.puick.credential.token")
public class CredentialTokenConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = TokenEncryptionService.class)
    public TokenEncryptionService tokenEncryptionService() {
        return new DefaultTokenEncryptionService();
    }

}
