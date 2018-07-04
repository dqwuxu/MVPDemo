package com.ococci.mvpdemo.base;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public class BasePresenter<V extends BaseView> {
    /**
     * 绑定view
     */
    private V mvpView;

    public void attachView(V view){
        this.mvpView = view;
    }

    public void detachView(){
        this.mvpView = null;
    }

    public boolean isViewAttached(){
        return mvpView != null;
    }

    public V getView(){
        return mvpView;
    }




}
