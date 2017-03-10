package com.android.project1.ui.home;


import com.android.project1.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 建立HomeActivity与HomeContractModule的连接
 * Created by 赵杰 on 2017/2/23.
 */
@ActivityScope
@Component(dependencies = AppComponent.class)
public interface HomeComponent {
    @Singleton HomeActivity inject(HomeActivity activity);
}
