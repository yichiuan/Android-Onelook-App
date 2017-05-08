package com.yichiuan.onelook.injection;

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;
import com.yichiuan.onelook.BuildConfig;
import com.yichiuan.onelook.data.DictionaryRepository;
import com.yichiuan.onelook.data.remote.OneLookService;
import com.yichiuan.onelook.util.StethoHelper;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import timber.log.Timber;


@Module
public final class DataModule {
    private static final int ONNECT_TIMEOUT_SECINDS = 10;
    private static final String ONELOOK_BASE_URL = "http://www.onelook.com/";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging =
                    new HttpLoggingInterceptor((message) ->
                            Timber.tag("OneLookService").d(message));
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

            httpClientBuilder.addInterceptor(logging);

            StethoHelper.configureInterceptor(httpClientBuilder);
        }

        httpClientBuilder.connectTimeout(ONNECT_TIMEOUT_SECINDS, TimeUnit.SECONDS);
        return httpClientBuilder.build();
    }

    @Provides
    @Singleton
    OneLookService provideOneLookService(OkHttpClient okHttpClient) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(ONELOOK_BASE_URL)
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(TikXmlConverterFactory.create())
                .build();
        return retrofit.create(OneLookService.class);
    }

    @Provides
    @Singleton
    DictionaryRepository provideDictionaryRepository(OneLookService oneLookService) {
        return new DictionaryRepository(oneLookService);
    }
}
