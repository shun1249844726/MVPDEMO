package com.lexinsmart.xushun.mvpdemo.ui.main;

/**
 * Created by xushun on 2017/7/27.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public class TextPresenterV1 {

    //view
    ITextView mITextView;


    //model
    ITextModel mITextModel = new TextModelImpV1();

    public TextPresenterV1(ITextView iTextView){
        super();
        this.mITextView = iTextView;
    }

    //将 m  v绑定
    public void  fetch(){
        mITextView.loading();

        if (mITextModel != null){
            mITextModel.loadText(new ITextModel.TextLoadListener() {
                @Override
                public void onComplete(String text) {
                    mITextView.showText(text);
                }
            });
        }


    }

}
