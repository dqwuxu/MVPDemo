package com.ococci.mvpdemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MvpView {
    private ProgressDialog dialog;
    private TextView tv;
    private MvpPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("正在加载数据");

        tv = (TextView)findViewById(R.id.text);
        presenter = new MvpPresenter(this);

        //绑定view引用
        presenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        if (!dialog.isShowing()){
            dialog.show();
        }

    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()){
            dialog.dismiss();
        }

    }

    @Override
    public void showData(String data) {
        tv.setText(data);

    }

    @Override
    public void showFailureMessage(String msg) {
        tv.setText(msg);
    }

    @Override
    public void showErrorMessage() {

    }
}
