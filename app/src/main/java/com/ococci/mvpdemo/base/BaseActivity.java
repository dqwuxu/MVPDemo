package com.ococci.mvpdemo.base;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 作者： tony
 * 时间： 2018/6/22.
 * 邮箱：neuqwux@163.com
 * 公司: Ococci
 */

public abstract class BaseActivity  extends Activity implements BaseView{
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);



    }

    private static float sNoncompatDensity;
    private static float sNoncompatScaledDensity;


    private static void setCustomDensity(Activity activity, final Application application){
        DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        if (sNoncompatDensity == 0){
            sNoncompatDensity = appDisplayMetrics.density;
            sNoncompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0){
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        float targetDensity = appDisplayMetrics.widthPixels / 360;
        float targetScaledDensity = targetDensity * (sNoncompatScaledDensity/sNoncompatDensity);
        int targetDensityDpi = (int)(160 * targetDensity);



        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;


        Map<Integer,String> map = new TreeMap<>();
        for (int i=0;i < 10;i++){
            Random random = new Random();
            int rs = random.nextInt(1000);
            map.put(rs,"v*" + rs);
        }
        Log.e("BaseActivity","TreeMap集合输出：" + map);

        Map<Integer,String> hashMap = new HashMap<>();
        for (int i=0;i < 10;i++){
            Random random = new Random();
            int rs = random.nextInt(1000);
            hashMap.put(rs,"v*" + rs);
        }
        Log.e("BaseActivity","HashMap集合输出:" + hashMap);

        Map<Integer,String> linkedMap = new LinkedHashMap<>();
        for (int i=0;i < 10;i++){
            Random random = new Random();
            int rs = random.nextInt(1000);
            linkedMap.put(rs,"v*"+ rs);
        }
        Log.e("BaseActivity","LinkedHashMap集合输出:" + linkedMap);

        /**
         * 共同点：HashMap ,LinkedHashMap ,TreeMap都属于Map；Map主要用于存储键<key>值<value>对，根据键得到值，因此键不允许重复，但允许值重复
         *
         * 不同点：HashMap键无序，它根据键的HashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度，在Map中插入、删除和定位元素，HashMap是最好的选择
         * LinkedHashMap是HashMap的一个子类，键保存了插入的顺序，使用Iteator遍历时，得到的也是插入顺序的记录
         * TreeMap默认按键的升序排序，可以定制
         * HashTable线程安全，键不能为null,与HashMap类似，但效率较低，HashMap如果需要实现同步，可以使用Collections.synchronizedMap
         *
         *
         * 比如需要存储、获取键值对的顺序区分，LinkedHashMap 存储和取值是按顺序进行，HashMap存储取值都是随机的，TreeMap是按大小顺序存储和取值的
         *
         * Collections是一个包装类 静态方法可以传入一个list,
         *
         * 1、HashSet具有很好的对象检索性能       2、HashSet存储对象的效率相对要低些   3、
         * 1、TreeSet是二叉树实现的，Treeset中的数据是自动排好有序的，不允许放入null值
         * 2、HashSet是哈希表实现的，HashSet中的数据是无序的，可以放入null，但只能放入一个null，两者中的值不能重复
         * 3、HashSet要求放入的对象必须实现HashCode()方法，放入的对象，是以hashCode码作为标识的
         *
         *
         */

        Map<Integer,String> table = new Hashtable<>();
        SparseArray<String> sparse = new SparseArray<>();
        for (int i=0;i<1000;i++){
            sparse.put(i,String.valueOf(i));
        }

        for (int i=0;i < sparse.size();i++){
            String s = sparse.get(i);
        }








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
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showErr(String msg) {
        showToast("error");
    }

    @Override
    public Context getContext() {
        return BaseActivity.this;
    }

}
