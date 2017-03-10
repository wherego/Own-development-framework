package com.android.project1.appservice.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.project1.appservice.rxbus.RxBus;


/**
 * 检测网络状态的广播
 * Created by oaier on 2017/3/7.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    private RxBus mRxBus;


    public NetworkChangeReceiver(RxBus rxBus) {//在AppServiceModule进行RxBus的注入
        this.mRxBus = rxBus;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            mRxBus.post("网络连接成功");
        } else {
            mRxBus.post("网络不可用");
        }
    }
}
