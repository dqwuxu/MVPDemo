package com.ococci.mvpdemo;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public interface Callback<T> {
    /**
     * 数据请求成功
     * @param data
     */
    void onSuccess(String data);

    /**
     * 使用网络API接口请求方式时，虽然已经成功请求到数据，但是由于解析异常，无法正常返回数据
     * @param msg
     */
    void onFailure(String msg);

    /**
     * 数据请求失败，无法联网、缺少权限等无法获取到源数据
     */
    void onError();

    /**
     * 当请求数据结束时，无论请求结果是成功，还是失败或是抛出异常都会执行此方法给用户处理，通常
     * 做网络请求时可以在此处隐藏“正在加载”的等待控件
     */
    void onComplete();

}
