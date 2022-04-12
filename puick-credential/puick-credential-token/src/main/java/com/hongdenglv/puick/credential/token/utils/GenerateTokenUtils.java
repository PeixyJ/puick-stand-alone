package com.hongdenglv.puick.credential.token.utils;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.hongdenglv.puick.credential.token.TokenEncryptionService;
import com.hongdenglv.puick.credential.token.property.CredentialTokenProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/**
 * 凭证生成工具
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:35
 */
@Slf4j
@Component
public class GenerateTokenUtils {

    /**
     * 凭证属性
     */
    @Resource
    CredentialTokenProperty credentialTokenProperty;

    @Resource
    TokenEncryptionService tokenEncryptionService;

    public void autoGenerateToken() {
        //判断凭证是否为空
        if (StringUtils.isEmpty(credentialTokenProperty.getToken())) {
            File file = new File(credentialTokenProperty.getGenerateTokenPath());
            //判断Token文件是否存在
            if (file.exists()) {
                FileReader fileReader = new FileReader(credentialTokenProperty.getGenerateTokenPath());
                credentialTokenProperty.setToken(tokenEncryptionService.decryption(fileReader.readString()));
            } else {
                FileWriter fileWriter = new FileWriter(credentialTokenProperty.getGenerateTokenPath());
                String token = tokenEncryptionService.generateToken(credentialTokenProperty.getSalt());
                credentialTokenProperty.setToken(token);
                fileWriter.write(tokenEncryptionService.encryption(token));
            }
        }
        log.info("puick token load success.}");
        if (credentialTokenProperty.getInformCredentialToken()) {
            log.info("credential:{} token:{}", credentialTokenProperty.getCredential(), credentialTokenProperty.getToken());
        }
    }

}
