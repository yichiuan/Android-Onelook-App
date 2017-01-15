package com.yichiuan.onelook.presentation.main;

import android.support.annotation.NonNull;

import com.yichiuan.onelook.data.DictionaryRepository;
import com.yichiuan.onelook.presentation.base.BasePresenter;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;


public class MainPresenter extends BasePresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final DictionaryRepository dictionaryRepository;

    public MainPresenter(@NonNull MainContract.View view, @NonNull DictionaryRepository dictionaryRepository) {
        this.view = view;
        view.setPresenter(this);
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public void fetchWordInfo(String word) {

        view.setLoadingIndicator(true);

        addSubscription(dictionaryRepository.fetchWordInfo(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> view.showWordInfo(word, response),
                        error -> Timber.e(error),
                        () -> view.setLoadingIndicator(false)
                )
        );
    }
}