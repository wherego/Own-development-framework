package com.android.project1.ui.home;

import android.os.Bundle;

import com.android.project1.AppComponent;
import com.android.project1.R;
import com.android.project1.base.BaseActivity;

import javax.inject.Inject;

/**
 * 主Activity
 * Created by 赵杰 on 2017/2/23.
 */

public class HomeActivity extends BaseActivity implements HomeActivityContract.View{

    @Inject HomeActivityPresenter presenter;//注入所需要的Presenter

    /**
     * 检查用户登录，软件更新等与界面无关的操作交给Presenter来做
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
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .homeContractModule(new HomeContractModule(this))
                .build()
                .inject(this);
    }

}
