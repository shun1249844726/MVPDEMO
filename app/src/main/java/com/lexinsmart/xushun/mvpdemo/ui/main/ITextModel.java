package com.lexinsmart.xushun.mvpdemo.ui.main;

/**
 * Created by xushun on 2017/7/27.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public interface ITextModel {
    void loadText(TextLoadListener listener);

    interface TextLoadListener {
        /**
         * 加载完成监听
         *
         * @param text
         */
        void onComplete(String text);
    }
}
