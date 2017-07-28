package com.lexinsmart.xushun.mvpdemo.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lexinsmart.xushun.mvpdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements ITextView {

    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.button)
    public void btnClick(){
        new TextPresenterV1(this).fetch();

    }
    @Override
    public void loading() {
        Toast.makeText(MainActivity.this, "loding", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showText(String text) {
        mText.setText(text);
    }
}
