package com.ococci.mvpdemo;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 *
 * 具体的逻辑业务处理类，该类为纯java类，不包含任何android api，负责请求数据，并对数据请求的反馈进行处理
 *
 * presenter类的构造方法中有一个view接口的参数，是为了能够通过view接口通知activity进行更新界面等操作
 */

public class MvpPresenter {
    //view接口
    private MvpView mView;
    public MvpPresenter(MvpView view){

    }

    /**
     * 绑定view,一般在初始化中调用该方法
     * @param view
     */
    public void attachView(MvpView view){
        this.mView = view;
    }

    /**
     * 断开view,一般在onDestroy中调用
     */
    public void detachView(){
        this.mView = null;
    }

    /**
     * 是否与view建立连接
     * @return
     */
    public boolean isViewAttached(){
        return mView != null;
    }




    /***
     * 获取网络数据
     * @param params
     */
    public void getData(String params){
        //显示正在加载进度条
        mView.showLoading();
        //调用Model请求数据
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                //调用view接口显示数据
                if (isViewAttached()){
                    mView.showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showFailureMessage(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showErrorMessage();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()){
                    mView.hideLoading();
                }
            }
        });

    }
}
