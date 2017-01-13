package com.yichiuan.onelook.presentation.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yichiuan.onelook.R;


public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter presenter;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.subscribe();
    }

    @Override
    public void onStop() {
        presenter.unsubscribe();
        super.onStop();
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
}