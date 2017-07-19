package com.yichiuan.onelook.injection;

import com.yichiuan.onelook.presentation.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuilderModule {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
