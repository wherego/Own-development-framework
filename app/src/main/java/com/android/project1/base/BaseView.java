package com.android.project1.base;

/**
 * MVP 中的View 父接口
 * Created by 赵杰 on 2017/2/23.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
