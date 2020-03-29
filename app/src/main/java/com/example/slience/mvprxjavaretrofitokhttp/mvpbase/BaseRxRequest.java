package com.example.slience.mvprxjavaretrofitokhttp.mvpbase;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PeiShanqing on 2020/3/28 22:05.
 */
public class BaseRxRequest {

    public static <T> void doRequest(Observable<BaseResponseBean<T>> observable , final CallbackListener<T> callbackListener){
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<T>() {
                    @Override
                    public void onSuccess(T response) {
                        callbackListener.onSuccess(response);
                    }

                    @Override
                    public void onFailure(String message) {
                        callbackListener.onFailure(message);
                    }

                    @Override
                    public void onError(String message) {
                        callbackListener.onError(message);
                    }
                });
    }

}
