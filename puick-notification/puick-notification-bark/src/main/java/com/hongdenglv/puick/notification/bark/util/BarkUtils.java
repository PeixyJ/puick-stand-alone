package com.hongdenglv.puick.notification.bark.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongdenglv.puick.notification.bark.BarkException;
import com.hongdenglv.puick.notification.bark.BarkRequest;
import com.hongdenglv.puick.notification.bark.property.BarkProperty;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

import static com.hongdenglv.puick.notification.bark.BarkExceptionEnum.*;

/**
 * Bark通知
 *
 * @author PeiXy_J
 * @date 2022-4-10 20:54
 */
@Slf4j
@Component
@AllArgsConstructor
public class BarkUtils {

    BarkProperty barkProperty;

    @Value("${spring.application.name}")
    String applicationName;

    public BarkRequest getBasicRequest() {
        BarkRequest noticeRequest = new BarkRequest();
        noticeRequest.setTitle(!StringUtils.isEmpty(barkProperty.getBarkTitle()) ? barkProperty.getBarkTitle() : applicationName);
        noticeRequest.setDeviceKey(barkProperty.getToken());
        noticeRequest.setIcon(barkProperty.getIconUrl());
        noticeRequest.setUrl(barkProperty.getJumpUrl());
        return noticeRequest;
    }

    /**
     * 快捷通知
     *
     * @param content 内容
     * @return boolean
     * @author PeiXy_J
     * @since 23:12 2022-4-10
     */
    public boolean quickNotice(String content) throws BarkException, IOException {
        BarkRequest basicRequest = getBasicRequest();
        basicRequest.setBody(content);
        return notice(basicRequest);
    }


    /**
     * 发送通知
     *
     * @param noticeRequest 通知请求
     * @return boolean
     * @author PeiXy_J
     * @since 22:38 2022-4-10
     */
    public boolean notice(BarkRequest noticeRequest) throws IOException, BarkException {
        checkRequest(noticeRequest);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        log.debug(mapper.writeValueAsString(noticeRequest));
        RequestBody requestBody = RequestBody.create(mediaType, mapper.writeValueAsString(noticeRequest));
        Request request = new Request.Builder().url(barkProperty.getApiAddress()).method("POST", requestBody).build();
        Response execute = client.newCall(request).execute();
        return execute.isSuccessful();
    }

    public void checkRequest(BarkRequest barkRequest) throws BarkException {
        if (StringUtils.isEmpty(barkRequest.getDeviceKey())) {
            throw new BarkException(TOKEN_IS_NULL);
        }
        if (StringUtils.isEmpty(barkRequest.getTitle())) {
            throw new BarkException(TITLE_IS_NULL);
        }
        if (StringUtils.isEmpty(barkRequest.getBody())) {
            throw new BarkException(CONTENT_IS_NULL);
        }
    }

}
