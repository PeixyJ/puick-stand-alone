package com.hongdenglv.puick.service.receive.controller;

import com.hongdenglv.puick.service.receive.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 虚假的控制层
 *
 * @author PeiXy_J
 * @since 2022-4-22 22:15
 */
@Slf4j
@RestController
@RequestMapping("sham")
public class ShamController {

    /**
     * 虚假的Post请求
     *
     * @param httpServletRequest http请求
     * @author PeiXy_J
     * @since 22:20 2022-4-22
     */
    @PostMapping
    public void shamPost(HttpServletRequest httpServletRequest) throws IOException {
        log.info(RequestUtils.getRequestPostStr(httpServletRequest));
    }

    /**
     * 虚假的Get请求
     *
     * @param httpServletRequest http请求
     * @author PeiXy_J
     * @since 22:32 2022-4-22
     */
    @GetMapping
    public void shamGet(HttpServletRequest httpServletRequest) {
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String parameter = httpServletRequest.getParameter(key);
            log.info("key:{} parameter:{}", key, parameter);
        }
    }

}
