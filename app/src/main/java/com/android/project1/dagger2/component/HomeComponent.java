package com.android.project1.dagger2.component;

import com.android.project1.dagger2.module.HomeModule;
import com.android.project1.dagger2.scope.ActivityScope;
import com.android.project1.ui.activity.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    @Singleton HomeActivity inject(HomeActivity activity);
}
