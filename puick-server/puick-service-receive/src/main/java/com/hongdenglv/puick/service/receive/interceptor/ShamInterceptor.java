package com.hongdenglv.puick.service.receive.interceptor;

import com.hongdenglv.puick.service.receive.ApplicationRun;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 虚假拦截器
 *
 * @author PeiXy_J
 * @since 2022-4-22 22:34
 */
@Slf4j
@Component
public class ShamInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (ApplicationRun.enableDetailedInformation) {
            log.info("---");
            //From
            log.info("remoteHost:{}", request.getRemoteHost());
            log.info("remoteAdder:{}", request.getRemoteAddr());
            log.info("remotePort:{}", request.getRemotePort());
            log.info("method:{}", request.getMethod());
            log.info("characterEncoding:{}", request.getCharacterEncoding());
            log.info("contentLength:{}", request.getContentLength());
            log.info("contentType:{}", request.getContentType());
            //Cookie
            log.info("---");
            for (Cookie cookie : request.getCookies()) {
                log.info("cookies path:{} value:{}", cookie.getName(), cookie.getValue());
            }
            log.info("---");
            //Header
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String parameter = request.getHeader(key);
                log.info("header key:{} parameter:{}", key, parameter);
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("***");
    }
}
