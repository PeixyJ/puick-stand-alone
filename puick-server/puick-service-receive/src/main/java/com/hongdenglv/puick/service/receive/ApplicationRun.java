package com.hongdenglv.puick.service.receive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 模拟接收
 *
 * @author PeiXy_J
 * @since 2022-4-22 22:11
 */
@SpringBootApplication
public class ApplicationRun {

    /**
     * 是否开启详细信息
     */
    public static Boolean enableDetailedInformation = false;

    public static void main(String[] args) {
        if (args.length != 0) {
            enableDetailedInformation = true;
        }
        SpringApplication.run(ApplicationRun.class, args);
    }
}
