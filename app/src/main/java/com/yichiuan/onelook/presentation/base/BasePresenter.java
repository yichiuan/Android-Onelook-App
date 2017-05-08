package com.yichiuan.onelook.presentation.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public class BasePresenter implements MvpPresenter {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable ();

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeDisposable.clear();
    }

    protected void addDisposable(Disposable disposable) {
        this.compositeDisposable.add(disposable);
    }
}