package com.android.project1.dagger2.module;

import com.android.project1.dagger2.scope.ActivityScope;
import com.android.project1.ui.activity.HomeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Module
public class HomeModule {
    private HomeActivity activity;

    public HomeModule(HomeActivity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    HomeActivity provideHomeActivity() {
        return activity;
    }

}
