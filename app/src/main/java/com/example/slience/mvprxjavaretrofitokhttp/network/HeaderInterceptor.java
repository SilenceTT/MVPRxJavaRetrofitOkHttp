package com.example.slience.mvprxjavaretrofitokhttp.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by PeiShanqing on 2020/3/27 22:15.
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("token", "token");

        return chain.proceed(builder.build());
    }
}
