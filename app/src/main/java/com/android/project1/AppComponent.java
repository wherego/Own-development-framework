package com.android.project1;

import android.app.Application;

import com.android.project1.appservice.broadcast.NetworkChangeReceiver;
import com.android.project1.appservice.rxbus.RxBus;
import com.android.project1.appservice.AppServiceModule;
import com.android.project1.appservice.api.ApiService;
import com.android.project1.appservice.api.ApiServiceModule;
import com.android.project1.appservice.imageloader.GlideImageLoaderStrategy;
import com.android.project1.appservice.imageloader.ImageLoaderOptions;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 管理全局共用的类实例
 * Created by 赵杰 on 2017/2/23.
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, AppServiceModule.class})
public interface AppComponent {

    Application getApplication();
    ApiService getApiService();
    GlideImageLoaderStrategy getGlideImageLoaderStrategy();
    ImageLoaderOptions getImageLoaderOption();
    RxBus getRxBusInstance();
    NetworkChangeReceiver getNetworkChangeReceiver();

}
