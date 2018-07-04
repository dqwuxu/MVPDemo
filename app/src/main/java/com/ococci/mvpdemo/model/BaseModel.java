package com.ococci.mvpdemo.model;

import com.ococci.mvpdemo.Callback;

import java.util.Map;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public abstract class BaseModel<T> {
    //数据请求参数
    protected String[] mParams;

    /**
     * 设置数据请求参数
     * @param args 参数数组
     * @return
     */
    public BaseModel params(String... args){
        mParams = args;
        return this;
    }

    /**
     * 添加Callback并执行数据请求 ,必须实现的接口
     * @param callback
     */
    public abstract void execute(Callback<T> callback);

    /**
     * 执行Get网络请求，此类看需求由自己选择写不写
     * @param url
     * @param callback
     */
    protected void requestGetApi(String url,Callback<T> callback){};

    protected void requestPostApi(String url, Map params,Callback<T> callback){};



}
