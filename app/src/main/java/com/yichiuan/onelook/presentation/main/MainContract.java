package com.yichiuan.onelook.presentation.main;

import com.yichiuan.onelook.data.remote.model.OLResponse;
import com.yichiuan.onelook.presentation.base.BaseView;
import com.yichiuan.onelook.presentation.base.MvpPresenter;


public interface MainContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showDefinition(String word, OLResponse response);
    }

    interface Presenter extends MvpPresenter {
        void fetchWordInfo(String word);
    }
}