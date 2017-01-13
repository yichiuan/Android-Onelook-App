package com.yichiuan.onelook.presentation.main;

import android.support.annotation.NonNull;

import com.yichiuan.onelook.data.DictionaryRepository;
import com.yichiuan.onelook.presentation.base.BasePresenter;


public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final DictionaryRepository dictionaryRepository;

    public MainPresenter(@NonNull MainContract.View view, @NonNull DictionaryRepository dictionaryRepository) {
        this.view = view;
        view.setPresenter(this);
        this.dictionaryRepository = dictionaryRepository;
    }
}