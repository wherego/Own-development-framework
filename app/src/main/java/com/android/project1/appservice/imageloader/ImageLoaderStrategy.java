package com.android.project1.appservice.imageloader;

import android.view.View;

/**
 * 图片加载框架封装
 * Created by 赵杰 on 2017/2/28.
 */

public interface ImageLoaderStrategy {
    void showImage(View v, String url, ImageLoaderOptions options);
    void showImage(View v, int drawable,ImageLoaderOptions options);
}
