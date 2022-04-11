package com.hongdenglv.puick.notification.bark;

import com.hongdenglv.puick.common.vo.Result;

/**
 * @author PeiXy_J
 * @date 2022-4-10 22:44
 */
public enum BarkExceptionEnum {
    /**
     * 通知错误
     */
    TOKEN_IS_NULL(Result.error(-10010, "token is null.")),
    TITLE_IS_NULL(Result.error(-10011, "title is null.")),
    CONTENT_IS_NULL(Result.error(-10012, "content is null."));

    private Result<?> result;

    BarkExceptionEnum(Result<?> result) {
        this.result = result;
    }

    public Result<?> getResult() {
        return result;
    }
}
