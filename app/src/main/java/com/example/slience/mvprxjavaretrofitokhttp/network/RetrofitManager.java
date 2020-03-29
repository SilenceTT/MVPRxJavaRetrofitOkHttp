package com.example.slience.mvprxjavaretrofitokhttp.network;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PeiShanqing on 2020/3/27 22:05.
 */
public class RetrofitManager {

    private volatile static RetrofitManager mInstance;
    private final int TIME_OUT = 10;
    private static Retrofit retrofit;
    private volatile static ApiServer mApiServer;

    private RetrofitManager(){
        init();
    }

    private void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT , TimeUnit.SECONDS)
                .readTimeout(TIME_OUT , TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT , TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(new Cache(new File(Environment.getExternalStorageDirectory() + "/RxJavaDemo"),1024*1024*10))
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new NetCacheInterceptor());

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static RetrofitManager getInstance(){
        if(mInstance == null){
            synchronized (RetrofitManager.class){
                if(mInstance == null){
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }

    public static ApiServer getRequest(){
        if(mApiServer == null){
            synchronized (ApiServer.class){
                if(mApiServer == null){
                    mApiServer = RetrofitManager.getInstance().getRetrofit().create(ApiServer.class);
                }
            }
        }
        return mApiServer;
    }

    public <T> T getServer(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
