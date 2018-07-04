package com.ococci.mvpdemo.model;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public class DataModel {
    public static BaseModel request(String token){
        //声明一个空的BaseModel
        BaseModel model = null;
        try {
            model = (BaseModel) Class.forName(token).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }
}
