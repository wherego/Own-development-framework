package com.android.project1.dagger2.module;

import com.android.project1.dagger2.scope.ActivityScope;
import com.android.project1.mvp.contract.HomeActivityContract;
import com.android.project1.mvp.presener.HomeActivityPresenter;


import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/24.
 */
@Module
public class HomeContractModule {
    private HomeActivityContract.View view;

    public HomeContractModule(HomeActivityContract.View view) {
        this.view = view;
    }
    @Provides @ActivityScope HomeActivityContract.View provideHomeView() {
        return view;
    }
    @Provides @ActivityScope HomeActivityPresenter provideHomePresenter() {
        return new HomeActivityPresenter(view);
    }
}
