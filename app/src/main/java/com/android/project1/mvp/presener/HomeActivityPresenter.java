package com.android.project1.mvp.presener;

import android.util.Log;

import com.android.project1.mvp.contract.HomeActivityContract;

/**
 * 负责处理HomeActivity的业务逻辑和调度HomeActivity和Model
 * Created by 赵杰 on 2017/2/23.
 */

public class HomeActivityPresenter implements HomeActivityContract.Presenter {
    private HomeActivityContract.View view;

    public HomeActivityPresenter(HomeActivityContract.View view) {
        this.view = view;
    }

    /**
     * 检查用户登录，软件更新等
     */
    @Override
    public void start() {
        Log.i("TAG", "Presenter.start");
    }

}
