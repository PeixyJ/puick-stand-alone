package com.hongdenglv.puick.cors.db.service.impl;

import com.hongdenglv.puick.cors.db.service.SysCurrentUser;

/**
 * 在没有用户系统的使用进行使用
 *
 * @author PeiXy_J
 * @date 2022-4-10 13:38
 */
public class NoneSysCurrentUser implements SysCurrentUser {

    @Override
    public Long getUserId() {
        return null;
    }

}
