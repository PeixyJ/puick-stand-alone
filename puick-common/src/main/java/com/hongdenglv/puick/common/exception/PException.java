package com.hongdenglv.puick.common.exception;

import com.hongdenglv.puick.common.vo.Result;

/**
 * Puick异常
 *
 * @author PeiXy_J
 * @date 2022-4-10 22:50
 */
public class PException extends Exception {

    /**
     * 异常返回
     */
    private Result<?> result;

    public PException(Result<?> result) {
        super(result.getMessage());
        this.result = result;
    }

    public Result<?> getResult() {
        return result;
    }

}
