package com.yichiuan.onelook.injection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    Context context();
}
