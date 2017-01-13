package com.yichiuan.onelook.presentation.main;

import com.yichiuan.onelook.presentation.base.BaseView;
import com.yichiuan.onelook.presentation.base.MvpPresenter;


public interface MainContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends MvpPresenter {
    }
}