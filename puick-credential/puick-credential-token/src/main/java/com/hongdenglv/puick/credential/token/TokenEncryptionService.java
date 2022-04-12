package com.hongdenglv.puick.credential.token;

/**
 * 凭证加密服务
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:55
 */
public interface TokenEncryptionService {

    /**
     * 加密凭证
     *
     * @param token 未加密的凭证
     * @return java.lang.String
     * @author PeiXy_J
     * @since 23:56 2022-4-12
     */
    String encryption(String token);

    /**
     * 解密凭证
     *
     * @param token 加密过的凭证
     * @return java.lang.String
     * @author PeiXy_J
     * @since 23:56 2022-4-12
     */
    String decryption(String token);

    /**
     * 生成凭证
     *
     * @param salt
     * @return java.lang.String
     * @author PeiXy_J
     * @since 23:58 2022-4-12
     */
    String generateToken(String salt);

    /**
     * 检查凭证
     *
     * @param token 凭证
     * @return java.lang.Boolean
     * @author PeiXy_J
     * @since 00:02 2022-4-13
     */
    Boolean checkToken(String token);


}
