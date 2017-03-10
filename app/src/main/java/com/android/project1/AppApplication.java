package com.android.project1;

import android.app.Application;
import android.content.Context;


import com.android.project1.appservice.AppServiceModule;
import com.android.project1.appservice.api.ApiServiceModule;

/**
 * 全局Application
 * Created by 赵杰 on 2017/2/23.
 */

public class AppApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .apiServiceModule(new ApiServiceModule())
                .appModule(new AppModule(this))
                .appServiceModule(new AppServiceModule())
                .build();
    }

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
