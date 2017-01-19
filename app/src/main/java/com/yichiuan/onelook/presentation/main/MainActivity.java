package com.yichiuan.onelook.presentation.main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yichiuan.onelook.OnelookApp;
import com.yichiuan.onelook.R;
import com.yichiuan.onelook.data.DictionaryRepository;
import com.yichiuan.onelook.injection.AppComponent;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    private MainFragment fragment;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppComponent appComponent = ((OnelookApp) getApplicationContext()).getAppComponent();
        DictionaryRepository dictionaryRepository = appComponent.dictionaryRepository();

        fragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        if (fragment == null) {
            fragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_main, fragment)
                    .commit();
        }

        presenter = new MainPresenter(fragment, dictionaryRepository);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
            if (text != null) {
                fragment.setProcessText(text.toString());
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        fragment.handleNewIntent(intent);
    }
}
