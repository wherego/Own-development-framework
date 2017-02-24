package com.android.project1.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.android.project1.R;
import com.android.project1.base.BaseActivity;
import com.android.project1.dagger2.component.AppComponent;
import com.android.project1.dagger2.component.DaggerHomeComponent;
import com.android.project1.dagger2.module.HomeModule;
import com.android.project1.mvp.contract.HomeActivityContract;
import com.android.project1.mvp.presener.HomeActivityPresenter;

import javax.inject.Inject;

/**
 * 主Activity
 * Created by 赵杰 on 2017/2/23.
 */

public class HomeActivity extends BaseActivity implements HomeActivityContract.View{

    @Inject HomeActivityPresenter presenter;//注入所需要的Presenter

    /**
     * 检查用户登录，软件更新等费时操作交给Presenter来做
     */
    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .homeModule(new HomeModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

}
