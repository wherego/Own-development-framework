package com.android.project1.dagger2.module;

import android.app.Application;

import com.android.project1.data.api.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android.project1.common.Constant.BASE_URL;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Module
public class ApiServiceModule {

    @Provides @Singleton Cache provideCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;//10 MB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides @Singleton OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .cache(cache)
                .build();
        return okHttpClient;
    }

    @Provides @Singleton ApiService provideApiService(OkHttpClient client) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiService.class);
    }
}
