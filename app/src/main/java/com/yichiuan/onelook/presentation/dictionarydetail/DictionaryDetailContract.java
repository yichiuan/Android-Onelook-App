package com.yichiuan.onelook.presentation.dictionarydetail;

import com.yichiuan.onelook.presentation.base.BaseView;
import com.yichiuan.onelook.presentation.base.MvpPresenter;

public interface DictionaryDetailContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends MvpPresenter {
    }
}