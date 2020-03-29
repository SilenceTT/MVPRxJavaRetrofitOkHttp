package com.example.slience.mvprxjavaretrofitokhttp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PeiShanqing on 2020/3/27 22:17.
 */
public class NetCacheInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        int onlineCacheTime = 60;

        return response.newBuilder()
                .header("Cache-Control", "public, max-age="+onlineCacheTime)
                .removeHeader("Pragma")
                .build();
    }
}
