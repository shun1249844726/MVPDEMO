package com.lexinsmart.xushun.mvpdemo.ui.login;

import android.content.Context;

import com.google.gson.Gson;
import com.lexinsmart.xushun.mvpdemo.api.NetWorks;
import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;
import com.lexinsmart.xushun.mvpdemo.mvp.BasePresenterImpl;
import com.orhanobut.logger.Logger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter{

    @Override
    public void login(String username, String psd) {
        mView.showLogin();


        Observer<LoginResult> mSubscriber;

        mSubscriber = new Observer<LoginResult>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull LoginResult loginResult) {
                Gson gson = new Gson();
                Logger.json(gson.toJson(loginResult));
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable observable = NetWorks.getInstance().getmCommonApi().login(username,psd);

        toSubscribe(observable,mSubscriber);

    }
    private <T> void toSubscribe(Observable<T> o, Observer<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Observer<? super T>) s);
    }
}
