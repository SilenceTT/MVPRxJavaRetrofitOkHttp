package com.example.slience.mvprxjavaretrofitokhttp.mvpbase;

import android.accounts.NetworkErrorException;
import android.util.Log;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by PeiShanqing on 2020/3/28 13:49.
 */
public abstract class BaseObserver<T> implements Observer<BaseResponseBean<T>> {

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponseBean<T> tBaseResponseBean) {
        if(tBaseResponseBean.getCode() == 200)
            onSuccess(tBaseResponseBean.getResult());
        else
            onFailure(tBaseResponseBean.getMessage());
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG" , e.toString());
        if (e instanceof NetworkErrorException) { //网络错误
            onError("请检查网络");
        } else if (e instanceof TimeoutException) {    //请求超时
            onError("请求超时，网络不好或服务器不稳定");
        } else if (e instanceof UnknownHostException) {       //找不到服务器
            onError("未发现指定服务器");
        } else if (e instanceof ConnectException) {    //连接失败
            onError("连接失败，请检查网络是否通畅");
        } else {
            onError("未知错误");
        }
    }

    @Override
    public void onComplete() {

    }

    abstract public void onSuccess(T response);

    abstract public void onFailure(String message);

    abstract public void onError(String message);

}
