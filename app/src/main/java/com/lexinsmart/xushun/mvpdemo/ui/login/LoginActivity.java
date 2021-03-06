package com.lexinsmart.xushun.mvpdemo.ui.login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lexinsmart.xushun.mvpdemo.R;
import com.lexinsmart.xushun.mvpdemo.entity.LoginResult;
import com.lexinsmart.xushun.mvpdemo.mvp.MVPBaseActivity;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {
    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.editText2)
    EditText mEditText2;
    @BindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (mPresenter != null){
            mPresenter.attachView(this);
        }

    }

    @OnClick(R.id.button2)
    public void login(){
        String uname = mEditText.getText().toString();
        String psd = mEditText2.getText().toString();
        mPresenter.login(uname,psd);
    }
    @Override
    public void showLogin() {
        Toast.makeText(this,"login ing",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showSucess() {
        Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show();

    }
}
