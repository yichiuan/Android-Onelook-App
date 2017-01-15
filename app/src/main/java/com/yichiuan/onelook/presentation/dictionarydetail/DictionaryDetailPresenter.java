package com.yichiuan.onelook.presentation.dictionarydetail;

import android.support.annotation.NonNull;

import com.yichiuan.onelook.presentation.base.BasePresenter;


public class DictionaryDetailPresenter extends BasePresenter implements DictionaryDetailContract.Presenter {

    private final DictionaryDetailContract.View view;

    public DictionaryDetailPresenter(@NonNull DictionaryDetailContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }
}