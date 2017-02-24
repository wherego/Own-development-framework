package com.android.project1.dagger2.component;

import com.android.project1.dagger2.module.HomeContractModule;
import com.android.project1.dagger2.scope.ActivityScope;
import com.android.project1.mvp.view.activity.HomeActivity;

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
