package com.hongdenglv.puick.cors.db.exception;

import com.hongdenglv.puick.common.vo.Result;
import lombok.Getter;

/**
 * 跨域异常Enum
 *
 * @author PeiXy_J
 * @date 2022-4-10 15:27
 */
@Getter
public enum CorsExceptionEnum {
    /**
     * 跨域异常
     */
    PARAMETER_ERROR(Result.error("参数错误"));

    private Result<?> result;

    CorsExceptionEnum(Result<?> result) {
        this.result = result;
    }
}
