package com.android.project1.appservice.imageloader;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * Glide的设置项
 * Created by 赵杰 on 2017/2/28.
 */

public class ImageLoaderOptions {

    private int placeHolder = -1; //当没有成功加载的时候显示的图片
    private ImageReSize size = null; //重新设定容器宽高
    private int errorDrawable = -1;  //加载错误的时候显示的drawable
    public boolean isCrossFade = false; //是否渐变平滑的显示图片
    public boolean isSkipMemoryCache = false; //是否跳过内存缓存
    public ViewPropertyAnimation.Animator animator = null; // 图片加载动画

    public ImageLoaderOptions() {
    }

    public ImageLoaderOptions setPlaceHolder(int placeHolder) {
        this.placeHolder = placeHolder;
        return this;
    }

    public ImageLoaderOptions setSize(ImageReSize size) {
        this.size = size;
        return this;
    }

    public ImageLoaderOptions setErrorDrawable(int errorDrawable) {
        this.errorDrawable = errorDrawable;
        return this;
    }

    public ImageLoaderOptions setCrossFade(boolean crossFade) {
        isCrossFade = crossFade;
        return this;
    }

    public ImageLoaderOptions setSkipMemoryCache(boolean skipMemoryCache) {
        isSkipMemoryCache = skipMemoryCache;
        return this;
    }

    public ImageLoaderOptions setAnimator(ViewPropertyAnimation.Animator animator) {
        this.animator = animator;
        return this;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public ImageReSize getSize() {
        return size;
    }

    public int getErrorDrawable() {
        return errorDrawable;
    }

    public boolean isCrossFade() {
        return isCrossFade;
    }

    public boolean isSkipMemoryCache() {
        return isSkipMemoryCache;
    }

    public ViewPropertyAnimation.Animator getAnimator() {
        return animator;
    }

    public class ImageReSize {
        int reWidth = 0;
        int reHeight = 0;

        public ImageReSize(int reWidth, int reHeight) {
            if (reHeight <= 0) {
                reHeight = 0;
            }
            if (reWidth <= 0) {
                reWidth = 0;
            }
            this.reHeight = reHeight;
            this.reWidth = reWidth;

        }

    }

}
