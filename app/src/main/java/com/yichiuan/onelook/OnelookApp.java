package com.yichiuan.onelook;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.yichiuan.onelook.injection.AppModule;
import com.yichiuan.onelook.injection.DaggerAppComponent;
import com.yichiuan.onelook.util.StethoHelper;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;


public class OnelookApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        // StrictMode setup
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .build());
        }

        // LeakCanary init
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        // Timber init
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new FakeCrashReportTree());
        }

        // Stetho init
        if (BuildConfig.DEBUG) {
            StethoHelper.init(this);
        }

        DaggerAppComponent.builder().appModule(new AppModule(this))
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }

    private static class FakeCrashReportTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable throwable) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return;
            }
        }
    }
}
