package com.android.project1.ui.home;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.project1.AppComponent;
import com.android.project1.R;
import com.android.project1.appservice.broadcast.NetworkChangeReceiver;
import com.android.project1.appservice.rxbus.RxBus;
import com.android.project1.base.BaseActivity;
import com.android.project1.appservice.imageloader.GlideImageLoaderStrategy;
import com.android.project1.appservice.imageloader.ImageLoaderOptions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 主Activity
 * Created by 赵杰 on 2017/2/23.
 * WeChat zqx0000
 */

public class HomeActivity extends BaseActivity{

    @Inject
    GlideImageLoaderStrategy glideImageLoaderStrategy;
    @Inject
    ImageLoaderOptions options;
    @Inject
    ImageLoaderOptions option2;
    @Inject
    RxBus mRxBus;
    @Inject
    NetworkChangeReceiver mNetworkChangeReceiver;

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.tv1)
    TextView mTv1;

    private Disposable disposable;

    /**
     * 检查用户登录，软件更新等
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);//绑定ButterKnife
        options.setCrossFade(true).setPlaceHolder(R.mipmap.ic_launcher);
        glideImageLoaderStrategy.showImage(image, "http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-27-002809.jpg", options);

        registerReceiver();

        disposable = mRxBus.register(String.class, new Consumer() {
            @Override
            public void accept(@NonNull Object o) throws Exception {
                if (o != null && o instanceof String) {
                    Log.d("TAG", "RxBus:" + (String) o);
                }
            }
        });

    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(mNetworkChangeReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mNetworkChangeReceiver);//关闭监测网络状态的广播
        mRxBus.unRegister(disposable);//切断RxBus的传输
        super.onDestroy();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

}
