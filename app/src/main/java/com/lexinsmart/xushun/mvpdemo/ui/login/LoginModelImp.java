package com.lexinsmart.xushun.mvpdemo.ui.login;

import com.google.gson.Gson;
import com.lexinsmart.xushun.mvpdemo.api.NetWorks;
import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by xushun on 2017/7/29.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public class LoginModelImp implements LoginContract.Model{

    @Override
    public void loadLoginResult(final LoginLoadListener listener, String username, String psd) {
        Observer<LoginResult> mSubscriber;

        mSubscriber = new Observer<LoginResult>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull LoginResult loginResult) {
                Gson gson = new Gson();
                Logger.json(gson.toJson(loginResult));
                listener.onComplete(loginResult);
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
