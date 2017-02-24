package com.android.project1.ui.home;


import com.android.project1.AppComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@ActivityScope
@Component(modules = {HomeContractModule.class}, dependencies = AppComponent.class)
public interface HomeComponent {
    @Singleton HomeActivity inject(HomeActivity activity);
}
