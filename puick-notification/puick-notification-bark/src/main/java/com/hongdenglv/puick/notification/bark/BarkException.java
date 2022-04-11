package com.hongdenglv.puick.notification.bark;

import com.hongdenglv.puick.common.exception.PException;

/**
 * Bark异常
 *
 * @author PeiXy_J
 * @date 2022-4-10 22:44
 */
public class BarkException extends PException {

    public BarkException(BarkExceptionEnum barkExceptionEnum) {
        super(barkExceptionEnum.getResult());
    }

}
