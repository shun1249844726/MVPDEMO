package com.lexinsmart.xushun.mvpdemo.api;

import com.lexinsmart.xushun.mvpdemo.common.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xushun on 2017/7/28.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public class NetWorks {

    private static final int DEFAULT_TIMEOUT = 5;

    private static Retrofit retrofit;

    private static CommonApi mCommonApi;



    private static NetWorks mNetworks;

    public static NetWorks getInstance() {
        if (mNetworks == null) {
            mNetworks = new NetWorks();
        }
        return mNetworks;
    }

    private <T> T configRetrofit(Class<T> service) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(configClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient configClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return okHttpClient.build();
    }

    public CommonApi getmCommonApi(){
        return mCommonApi == null ?configRetrofit(CommonApi.class) : mCommonApi;
    }
}
