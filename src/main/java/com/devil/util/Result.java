package com.devil.util;

import com.devil.emun.ResultEnum;

/**
 * ClassName：Rusult
 *
 * @author: Devil
 * @Date: 2024/8/31
 * @Description:
 * @version: 1.0
 */
public class Result<T> {
    //返回状态码
    private Integer code;
    //提示信息
    private String message;
    //返回数据
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }

    //返回数据
    protected static <T>Result<T> build(T data){
        Result<T> result = new Result<>();
        if(data != null){
            result.setData(data);
        }
        return result;
    }

    public static <T>Result<T> build(T data,Integer code,String message){
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T>Result<T> build(T data, ResultEnum resultEnum){
        Result<T> result = new Result<>();
        result.setData(data);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
    //成功操作
//    public static<T> Result<T> ok(T data){
//        Result<T> result = build(data,200,"success");
//        return result;
//    }
}
