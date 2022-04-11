package com.hongdenglv.puick.notification.bark;

import lombok.Data;

/**
 * bark 返回结果
 *
 * @author PeiXy_J
 * @date 2022-4-10 21:00
 */
@Data
public class BarkResult {

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息
     */
    private String message;

    /**
     * 时间戳
     */
    private Long timestamp;

}
