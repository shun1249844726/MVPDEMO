package com.lexinsmart.xushun.mvpdemo.ui.login;

import android.content.Context;

import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;
import com.lexinsmart.xushun.mvpdemo.mvp.BasePresenter;
import com.lexinsmart.xushun.mvpdemo.mvp.BaseView;

import org.reactivestreams.Subscriber;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void showLogin();

    }

    interface  Presenter extends BasePresenter<View> {
        void login(String username, String psd);
        
    }
    interface Model {

    }
}
