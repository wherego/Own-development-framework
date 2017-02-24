package com.android.project1.ui.fragment;

import android.os.Bundle;

import com.android.project1.base.LazyFragment;
import com.android.project1.dagger2.component.AppComponent;

/**
 * 个人中心 Fragment
 * Created by 赵杰 on 2017/2/23.
 */

public class PersonalCenterFragment extends LazyFragment {
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
//        setContentView();
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {

    }
}
