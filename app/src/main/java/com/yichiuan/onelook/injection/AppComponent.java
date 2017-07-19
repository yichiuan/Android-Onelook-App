package com.yichiuan.onelook.injection;

import com.yichiuan.onelook.OnelookApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;


@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, DataModule.class, BuilderModule.class})
public interface AppComponent {

    void inject(OnelookApp application);
}
