package com.ococci.mvpdemo.model;

import android.os.Handler;

import com.ococci.mvpdemo.Callback;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final Callback<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //mParams是从父类得到的请求参数
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess(mParams[0]);
                        break;
                    case "failure":
                        break;
                    case "error":
                        break;
                }
                callback.onComplete();
            }
        }, 2000);

    }
}
