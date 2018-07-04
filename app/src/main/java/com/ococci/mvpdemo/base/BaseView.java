package com.ococci.mvpdemo.base;

import android.content.Context;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public interface BaseView {
    //显示正在加载View
    void showLoading();

    //关闭正在加载view
    void hideLoading();

    //toast
    void showToast(String msg);

    //显示错误信息
    void showErr(String msg);

    //获取上下文
    Context getContext();

}
