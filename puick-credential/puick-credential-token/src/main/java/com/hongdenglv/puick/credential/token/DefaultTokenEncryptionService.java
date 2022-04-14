package com.hongdenglv.puick.credential.token;

import com.hongdenglv.puick.credential.token.property.CredentialTokenProperty;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 默认实现凭证加密解密
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:59
 */
public class DefaultTokenEncryptionService implements TokenEncryptionService {

    @Resource
    CredentialTokenProperty credentialTokenProperty;

    @Override
    public String encryption(String token) {
        return token;
    }

    @Override
    public String decryption(String token) {
        return token;
    }

    @Override
    public String generateToken(String salt) {
        return UUID.randomUUID().toString();
    }

    @Override
    public Boolean checkToken(String token) {
        return credentialTokenProperty.getToken().equals(token);
    }

}
