package com.android.project1.dagger2.module;

import com.android.project1.dagger2.scope.ActivityScope;
import com.android.project1.mvp.contract.HomeActivityContract;


import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/24.
 */
@Module
public class HomePresenterModule {
    private HomeActivityContract.View view;

    public HomePresenterModule(HomeActivityContract.View view) {
        this.view = view;
    }
    @Provides @ActivityScope HomeActivityContract.View provideHomeView() {
        return view;
    }
}
