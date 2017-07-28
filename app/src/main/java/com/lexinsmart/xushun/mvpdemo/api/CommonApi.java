package com.lexinsmart.xushun.mvpdemo.api;

import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xushun on 2017/7/28.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public interface CommonApi {

    @FormUrlEncoded
    @POST("login")
    Observable<LoginResult> login(@Field("username") String username, @Field("password") String password);
}
