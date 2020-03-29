package com.example.slience.mvprxjavaretrofitokhttp.network;

import com.example.slience.mvprxjavaretrofitokhttp.mvpbase.BaseResponseBean;
import com.example.slience.mvprxjavaretrofitokhttp.mvpbase.BasicResponseBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by PeiShanqing on 2020/3/27 21:23.
 */
public interface ApiServer {

    @GET("musicDetails?id=604392760")
    Observable<BaseResponseBean<BasicResponseBean>> getCall();

}
