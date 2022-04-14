package com.hongdenglv.puick.credential.token;

import com.hongdenglv.puick.credential.token.property.CredentialTokenProperty;
import com.hongdenglv.puick.credential.token.utils.GenerateTokenUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Token拦截器
 *
 * @author PeiXy_J
 * @date 2022-4-12 23:23
 */
@Component
public class TokenInterceptor implements HandlerInterceptor , InitializingBean {

    @Resource
    CredentialTokenProperty credentialTokenProperty;

    @Resource
    GenerateTokenUtils generateTokenUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String headToken = request.getHeader(credentialTokenProperty.getCredential());
        String bodyToken = request.getParameter(credentialTokenProperty.getCredential());
        return credentialTokenProperty.getToken().equals(headToken) || credentialTokenProperty.getToken().equals(bodyToken);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        generateTokenUtils.autoGenerateToken();
    }
}
