package com.yichiuan.onelook.presentation.dictionarydetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.yichiuan.onelook.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DictionaryDetailActivity extends AppCompatActivity implements DictionaryDetailContract.View {

    @BindView(R.id.layout_dictionarydetail)
    FrameLayout dictionarydetailLayout;

    private WebView dictionaryDetailWebview;

    private DictionaryDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_detail);
        ButterKnife.bind(this);

        dictionaryDetailWebview = new WebView(getApplicationContext());
        dictionaryDetailWebview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        dictionarydetailLayout.addView(dictionaryDetailWebview);

        WebSettings webSettings = dictionaryDetailWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);

        dictionaryDetailWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }
        });

        presenter = new DictionaryDetailPresenter(this);

        Intent intent = getIntent();
        String url = intent.getStringExtra("dictionary_url");
        dictionaryDetailWebview.loadUrl(url);
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
    public void setPresenter(@NonNull DictionaryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        if (dictionaryDetailWebview != null) {
            dictionaryDetailWebview.removeAllViews();
            // in android 5.1(sdk:21) we should invoke this to avoid memory leak
            // see (https://coolpers.github.io/webview/memory/leak/2015/07/16/
            // android-5.1-webview-memory-leak.html)
            dictionarydetailLayout.removeView(dictionaryDetailWebview);
            dictionaryDetailWebview.setTag(null);
            dictionaryDetailWebview.clearHistory();
            dictionaryDetailWebview.destroy();
            dictionaryDetailWebview = null;
        }
        super.onDestroy();
    }
}
