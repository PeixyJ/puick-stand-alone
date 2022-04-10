package com.hongdenglv.puick.cors.db.exception;

import com.hongdenglv.puick.common.vo.Result;
import lombok.Data;

/**
 * 跨域异常
 *
 * @author PeiXy_J
 * @date 2022-4-10 15:08
 */
@Data
public class CorsException extends Exception {

    /**
     * 异常信息
     */
    private CorsExceptionEnum exceptionEnum;

    public CorsException(CorsExceptionEnum corsExceptionEnum) {
        super(corsExceptionEnum.getResult().getMessage());
        this.exceptionEnum = corsExceptionEnum;
    }
}
