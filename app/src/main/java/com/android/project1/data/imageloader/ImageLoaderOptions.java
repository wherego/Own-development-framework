package com.android.project1.data.imageloader;

import com.bumptech.glide.request.animation.ViewPropertyAnimation;

/**
 * Created by 赵杰 on 2017/2/28.
 */

public class ImageLoaderOptions {

    private int placeHolder = -1; //当没有成功加载的时候显示的图片
    private ImageReSize size = null; //重新设定容器宽高
    private int errorDrawable = -1;  //加载错误的时候显示的drawable
    public boolean isCrossFade = false; //是否渐变平滑的显示图片
    public boolean isSkipMemoryCache = false; //是否跳过内存缓存
    public ViewPropertyAnimation.Animator animator = null; // 图片加载动画


    private ImageLoaderOptions(ImageReSize resize, int placeHolder, int errorDrawable, boolean isCrossFade, boolean isSkipMemoryCache, ViewPropertyAnimation.Animator animator) {
        this.placeHolder = placeHolder;
        this.size = resize;
        this.errorDrawable = errorDrawable;
        this.isCrossFade = isCrossFade;
        this.isSkipMemoryCache = isSkipMemoryCache;
        this.animator = animator;
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

    public static final class Builder {
        private int placeHolder = -1;
        private ImageReSize size = null;
        private int errorDrawable = -1;
        private boolean isCrossFade = false;
        private boolean isSkipMemoryCache = false;
        private ViewPropertyAnimation.Animator animator = null;

        public Builder() {

        }

        public Builder placeHolder(int drawable) {
            this.placeHolder = drawable;
            return this;
        }

        public Builder reSize(ImageReSize size) {
            this.size = size;
            return this;
        }

        public Builder anmiator(ViewPropertyAnimation.Animator animator) {
            this.animator = animator;
            return this;
        }

        public Builder errorDrawable(int errorDrawable) {
            this.errorDrawable = errorDrawable;
            return this;
        }

        public Builder isCrossFade(boolean isCrossFade) {
            this.isCrossFade = isCrossFade;
            return this;
        }

        public Builder isSkipMemoryCache(boolean isSkipMemoryCache) {
            this.isSkipMemoryCache = isSkipMemoryCache;
            return this;
        }

        public ImageLoaderOptions build() {

            return new ImageLoaderOptions(this.size, this.placeHolder, this.errorDrawable, this.isCrossFade, this.isSkipMemoryCache, this.animator);
        }
    }
}
