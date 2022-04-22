package com.hongdenglv.puick.service.receive.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 请求处理器
 *
 * @author PeiXy_J
 * @since 2022-4-22 22:17
 */
public class RequestUtils {
    /**
     * 获取POST请求并转为Bytes
     *
     * @param request 请求
     * @return byte[]
     * @author PeiXy_J
     * @since 22:18 2022-4-22
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte[] buffer = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {
            int readable = request.getInputStream().read(buffer, i, contentLength - i);
            if (readable == -1) {
                break;
            }
            i += readable;
        }
        return buffer;
    }

    /**
     * 获取Post请求将内容转为Str类型
     *
     * @param request 请求
     * @return java.lang.String
     * @author PeiXy_J
     * @since 22:18 2022-4-22
     */
    public static String getRequestPostStr(HttpServletRequest request) throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
}
