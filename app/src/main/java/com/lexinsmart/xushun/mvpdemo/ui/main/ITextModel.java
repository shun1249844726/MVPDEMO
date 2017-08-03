package com.lexinsmart.xushun.mvpdemo.ui.main;

/**
 * Created by xushun on 2017/7/27.
 * QQ : 1035098385
 * 功能描述：
 * 心情：
 */
public interface ITextModel {
    /**
     * 加载文字的方法m,hkjh kjhkjh kjhkljhj
     * @param listener 拉地方阿林大哥啊
     */
    void loadText(TextLoadListener listener);

    /**
     * 接口。。。
     */
    interface TextLoadListener {
        /**
         * 接口完成的方法?
         * @param text
         */
        void onComplete(String text);
    }
}
