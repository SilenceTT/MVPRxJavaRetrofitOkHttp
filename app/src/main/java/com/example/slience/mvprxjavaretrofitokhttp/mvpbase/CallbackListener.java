package com.example.slience.mvprxjavaretrofitokhttp.mvpbase;

/**
 * Created by PeiShanqing on 2020/3/28 14:00.
 */
public interface CallbackListener<T> {

    /**
     * 数据请求成功
     * @param data 请求到的数据源
     */
    void onSuccess(T data);

    /**
     * 使用网络API接口请求方式时，虽然已经请求成功单实由于{@code msg}的原因无法正常的返回数据
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 请求数据失败，指在请求网络API接口请求方式时，出现无法联网，缺少权限，内存泄漏等原因导致无法连接到请求数据源
     */
    void onError(String exception);

}
