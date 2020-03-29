package com.example.slience.mvprxjavaretrofitokhttp.mvpbase;

import java.io.Serializable;

/**
 * Created by PeiShanqing on 2020/3/27 21:00.
 */
public class BaseResponseBean<T> implements Serializable {

    private int code;

    private String message;

    private T result;

    @Override
    public String toString() {
        return "BaseResponseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
