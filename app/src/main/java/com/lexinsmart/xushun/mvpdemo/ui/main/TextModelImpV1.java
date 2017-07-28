package com.lexinsmart.xushun.mvpdemo.ui.main;

/**
 * Created by xushun on 2017/7/27.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public class TextModelImpV1 implements ITextModel {
    @Override
    public void loadText(TextLoadListener listener) {
        String text = "text   1";
        listener.onComplete(text);
    }
}
