package com.android.project1.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.project1.app.AppApplication;
import com.android.project1.dagger2.component.AppComponent;

import butterknife.ButterKnife;

/**
 * Activity 父类
 * Created by 赵杰 on 2017/2/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(AppApplication.get(this).getAppComponent());
    }
    protected abstract void setupActivityComponent(AppComponent appComponent);

}
