package com.hongdenglv.puick.credential.token.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 凭证Token配置
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:27
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "puick.credential.token")
public class CredentialTokenProperty {

    /**
     * 凭证名称
     */
    private String credential = "puick";

    /**
     * 凭证为空则自动生成
     */
    private String token;

    /**
     * 凭证为空时是否自动生成
     */
    private Boolean generateTokenFile = true;

    /**
     * 凭证文件生成路径
     */
    private String generateTokenPath = "token";

    /**
     * 盐值
     */
    private String salt;

    /**
     * 是否在程序启动时告知凭证和Token
     */
    private Boolean informCredentialToken = true;

}
