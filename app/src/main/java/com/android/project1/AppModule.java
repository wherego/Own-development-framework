package com.android.project1;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 赵杰 on 2017/2/23.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides @Singleton Application provideApplication () {
        return this.application;
    }

}
