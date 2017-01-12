package com.yichiuan.onelook.injection;

import com.yichiuan.onelook.BuildConfig;
import com.yichiuan.onelook.util.StethoHelper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;


@Module
public final class DataModule {
    private static final int ONNECT_TIMEOUT_SECINDS = 10;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging =
                    new HttpLoggingInterceptor((message) ->
                            Timber.tag("OkHttp").d(message));
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClientBuilder.addInterceptor(logging);

            StethoHelper.configureInterceptor(httpClientBuilder);
        }

        httpClientBuilder.connectTimeout(ONNECT_TIMEOUT_SECINDS, TimeUnit.SECONDS);
        return httpClientBuilder.build();
    }
}
