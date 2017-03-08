package com.android.project1.data;

import com.android.project1.broadcast.NetworkChangeReceiver;
import com.android.project1.data.imageloader.GlideImageLoaderStrategy;
import com.android.project1.data.imageloader.ImageLoaderOptions;
import com.android.project1.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Module
public class AppServiceModule {

    @Provides @Singleton GlideImageLoaderStrategy provideGlideStrategy(){
        return new GlideImageLoaderStrategy();
    }

    @Provides @Singleton ImageLoaderOptions provideImageLoaderOption() {
        return new ImageLoaderOptions();
    }

    @Provides @Singleton RxBus provideRxbusInstance() {
        return new RxBus();
    }

    @Provides @Singleton NetworkChangeReceiver provideNetworkChangeReceiver(RxBus rxBus) {
        return new NetworkChangeReceiver(rxBus);
    }

    // 提供一个全局管理者，检查用户登录，软件更新，注销用户等等
}
