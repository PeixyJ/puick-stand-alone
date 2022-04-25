package com.hongdenglv.puick.thirpart.megvii.b4h.utils;

import com.burgstaller.okhttp.AuthenticationCacheInterceptor;
import com.burgstaller.okhttp.CachingAuthenticatorDecorator;
import com.burgstaller.okhttp.digest.CachingAuthenticator;
import com.burgstaller.okhttp.digest.Credentials;
import com.burgstaller.okhttp.digest.DigestAuthenticator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hongdenglv.puick.thirpart.megvii.b4h.pojo.H4BClient;
import okhttp3.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 客户端工具类
 *
 * @author PeiXy_J
 * @since 2022-4-25 15:46
 */
public class ClientUtils {

    private static final ObjectMapper JACKSON = new ObjectMapper();


    private H4BClient client;

    static {
        JACKSON.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 获取HTTP CLIENT
     *
     * @param client 请求信息
     * @return okhttp3.OkHttpClient
     * @author PeiXy_J
     * @since 15:50 2022-4-25
     */
    public static OkHttpClient getOkHttpClient(H4BClient client) {
        DigestAuthenticator authenticator = new DigestAuthenticator(new Credentials(client.getUsername(), client.getPassword()));
        Map<String, CachingAuthenticator> authCache = new ConcurrentHashMap<>();
        return new OkHttpClient.Builder().authenticator(new CachingAuthenticatorDecorator(authenticator, authCache)).addInterceptor(new AuthenticationCacheInterceptor(authCache)).build();
    }

    /**
     * H4B GET请求
     *
     * @param client 请求信息
     * @return java.lang.String
     * @author PeiXy_J
     * @since 16:38 2022-4-25
     */
    public static String get(H4BClient client) throws Exception {
        Request request = new Request.Builder().url(client.getUrl()).get().build();
        OkHttpClient okHttpClient = getOkHttpClient(client);
        Response execute = okHttpClient.newCall(request).execute();
        if (execute.body() == null) {
            throw new Exception("获取H4B数据错误.");
        }
        return execute.body().string();
    }

    /**
     * H4B POST请求
     *
     * @param client    清清秀秀
     * @param o         请求对象
     * @param respClass 返回对象
     * @return T
     * @author PeiXy_J
     * @since 16:39 2022-4-25
     */
    public <T> T post(H4BClient client, Object o, Class<T> respClass) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, JACKSON.writeValueAsString(o));
        Request request = new Request.Builder().url(client.getUrl()).post(requestBody).build();
        OkHttpClient okHttpClient = getOkHttpClient(client);
        Response response = okHttpClient.newCall(request).execute();
        if (response.body() == null) {
            throw new Exception("获取H4B数据错误," + request.url().url());
        }
        return JACKSON.readValue(response.body().string(), respClass);
    }

    /**
     * H4B DELETE 请求
     *
     * @param client    请求信息
     * @param o         请求对象
     * @param respClass 返回对象
     * @return T
     * @author PeiXy_J
     * @since 16:39 2022-4-25
     */
    public <T> T delete(H4BClient client, Object o, Class<T> respClass) throws Exception {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, JACKSON.writeValueAsString(o));
        Request request = new Request.Builder().url(client.getUrl()).delete(requestBody).build();
        OkHttpClient okHttpClient = getOkHttpClient(client);
        Response response = okHttpClient.newCall(request).execute();
        if (response.body() == null) {
            throw new Exception("获取H4B数据错误," + request.url().url());
        }
        return JACKSON.readValue(response.body().string(), respClass);
    }

    public H4BClient getClient() {
        return client;
    }

    public void setClient(H4BClient client) {
        this.client = client;
    }
}
