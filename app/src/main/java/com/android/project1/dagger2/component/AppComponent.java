package com.android.project1.dagger2.component;

import android.app.Application;

import com.android.project1.dagger2.module.AppModule;
import com.android.project1.dagger2.module.AppServiceModule;
import com.android.project1.data.api.ApiService;
import com.android.project1.dagger2.module.ApiServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class, AppServiceModule.class})
public interface AppComponent {

    Application getApplication();

    ApiService getApiService();
}
