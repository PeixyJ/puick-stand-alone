package com.hongdenglv.puick.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 启动跨域应用
 *
 * @author PeiXy_J
 * @date 2022-4-9 23:24
 */
@SpringBootApplication
@RestController
@RequestMapping
public class RunApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class);
    }

    @RequestMapping("/")
    public String sayHello(HttpServletRequest httpServletRequest) {
        String puick = httpServletRequest.getHeader("puick");
        return System.currentTimeMillis() + ": Hello World!" + puick;
    }


}
