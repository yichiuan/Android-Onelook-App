package com.yichiuan.onelook.presentation.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class BasePresenter implements MvpPresenter {

    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
    }

    protected void addSubscription(Subscription subscription) {
        this.compositeSubscription.add(subscription);
    }
}