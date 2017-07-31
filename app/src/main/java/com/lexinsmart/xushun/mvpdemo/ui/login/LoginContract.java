package com.lexinsmart.xushun.mvpdemo.ui.login;

import android.content.Context;

import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;
import com.lexinsmart.xushun.mvpdemo.mvp.BasePresenter;
import com.lexinsmart.xushun.mvpdemo.mvp.BaseView;
import com.lexinsmart.xushun.mvpdemo.ui.main.ITextModel;

import org.reactivestreams.Subscriber;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void showLogin();
        void showSucess();

    }

    interface  Presenter extends BasePresenter<View> {
        void login(String username, String psd);

    }
    interface Model {
        void loadLoginResult(LoginLoadListener listener,String username,String psd);

        interface LoginLoadListener {
            /**
             * 加载完成监听
             *
             * @param loginResult
             */
            void onComplete(LoginResult loginResult);
        }
    }
}
