package com.hongdenglv.puick.common.VO;

import lombok.Data;

/**
 * 通用返回结果
 *
 * @author peixinyi
 * @date 2022-4-8 23:34
 */
@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回描述
     */
    private String message;

    /**
     * 内容
     */
    private T data;
    /**
     * 状态
     */
    private Boolean state;

    /**
     * 时间戳
     */
    private Long time;

    /**
     * 构造函数
     *
     * @param code 状态码
     * @param message 返回描述
     * @param data 内容
     */
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.state = code > 0;
        this.time = System.currentTimeMillis();
    }

    /**
     * 返回成功
     *
     * @return com.hongdenglv.puick.common.VO.Result<?>
     * @author PeiXy_J
     * @since 23:41 2022-4-8
     */
    public static Result<?> ok(){
        return new Result<>(0,"success",null);
    }

    /**
     * 返回成功包含数据
     *
     * @param data 数据
     * @return com.hongdenglv.puick.common.VO.Result<T>
     * @author PeiXy_J
     * @since 23:44 2022-4-8
     */
    public static <T>  Result<T> ok(T data){
        return new Result<>(0,"success",data);
    }

    /**
     * 返回错误信息
     *
     * @param message 错误描述
     * @return com.hongdenglv.puick.common.VO.Result<?>
     * @author PeiXy_J
     * @since 23:56 2022-4-8
     */
    public static Result<?> error(String message){
        return new Result<>(-1,message,null);
    }

    /**
     * 返回错误信息和错误码
     *
     * @param code 状态码
     * @param message 错误描述
     * @return com.hongdenglv.puick.common.VO.Result<?>
     * @author PeiXy_J
     * @since 23:57 2022-4-8
     */
    public static Result<?> error(int code,String message){
        return new Result<>(code,message,null);
    }

    /**
     * 根据条件返回描述
     *
     * @param condition 条件
     * @param message 消息
     * @return com.hongdenglv.puick.common.VO.Result<?>
     * @author PeiXy_J
     * @since 23:59 2022-4-8
     */
    public static Result<?> condition(Boolean condition,String message){
        return condition ? Result.ok() : Result.error(message);
    }
    
    /**
     *
     *
     * @param condition 条件
     * @param data 数据
     * @param error 返回
     * @return com.hongdenglv.puick.common.VO.Result<?>
     * @author PeiXy_J
     * @since 00:01 2022-4-9
     */
    public static <T> Result<?> condition(Boolean condition,T data,Result<T> error){
        return condition ? Result.ok(data) : error;
    } 
}
