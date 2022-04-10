package com.hongdenglv.puick.cors.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 应用启动
 *
 * @author PeiXy_J
 * @date 2022-4-10 16:12
 */
@SpringBootApplication
@RestController
@RequestMapping
public class RunApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

    @RequestMapping("/")
    public String sayHello(HttpServletRequest httpServletRequest) {
        String puick = httpServletRequest.getHeader("puick");
        return System.currentTimeMillis() + ": Hello World!" + puick;
    }

}
