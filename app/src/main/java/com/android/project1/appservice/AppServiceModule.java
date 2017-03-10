package com.android.project1.appservice;

import com.android.project1.appservice.broadcast.NetworkChangeReceiver;
import com.android.project1.appservice.rxbus.RxBus;
import com.android.project1.appservice.imageloader.GlideImageLoaderStrategy;
import com.android.project1.appservice.imageloader.ImageLoaderOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Module
public class AppServiceModule {

    /**
     * @return Glide封装类
     */
    @Provides @Singleton GlideImageLoaderStrategy provideGlideStrategy(){
        return new GlideImageLoaderStrategy();
    }

    /**
     * @return Glide设置项
     */
    @Provides @Singleton ImageLoaderOptions provideImageLoaderOption() {
        return new ImageLoaderOptions();
    }

    /**
     * @return RxBus
     */
    @Provides @Singleton RxBus provideRxbusInstance() {
        return new RxBus();
    }

    /**
     * @param rxBus
     * @return 检测网络状态的广播
     */
    @Provides @Singleton NetworkChangeReceiver provideNetworkChangeReceiver(RxBus rxBus) {
        return new NetworkChangeReceiver(rxBus);
    }

    // 提供一个全局管理者，检查用户登录，软件更新，注销用户等等
}
