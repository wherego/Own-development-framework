package com.android.project1.appservice.imageloader;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * 对Glide的简单封装
 * Created by 赵杰 on 2017/2/28.
 */

public class GlideImageLoaderStrategy implements ImageLoaderStrategy {

    @Override
    public void showImage(View v, String url, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            //将类型转换为ImageView
            ImageView imageView= (ImageView) v;
            //装配基本的参数
            DrawableTypeRequest dtr = Glide.with(imageView.getContext()).load(url);
            //装配附加参数
            loadOptions(dtr, options).into(imageView);
        }
    }

    @Override
    public void showImage(View v, int drawable, ImageLoaderOptions options) {
        if (v instanceof ImageView) {
            ImageView imageView= (ImageView) v;
            DrawableTypeRequest dtr = Glide.with(imageView.getContext()).load(drawable);
            loadOptions(dtr, options).into(imageView);
        }
    }
    //这个方法用来装载由外部设置的参数
    private DrawableTypeRequest loadOptions(DrawableTypeRequest dtr,ImageLoaderOptions options){
        if (options==null) {
            return dtr;
        }
        if (options.getPlaceHolder()!=-1) {
            dtr.placeholder(options.getPlaceHolder());
        }
        if (options.getErrorDrawable()!=-1){
            dtr.error(options.getErrorDrawable());
        }
        if (options.isCrossFade()) {
            dtr.crossFade();
        }
        if (options.isSkipMemoryCache()){
            dtr.skipMemoryCache(options.isSkipMemoryCache());
        }
        if (options.getAnimator()!=null) {
            dtr.animate(options.getAnimator());
        }
        if (options.getSize()!=null) {
            dtr.override(options.getSize().reWidth,options.getSize().reHeight);
        }
        return dtr;
    }

}
