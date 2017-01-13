package com.yichiuan.onelook.presentation.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yichiuan.onelook.OnelookApp;
import com.yichiuan.onelook.R;
import com.yichiuan.onelook.data.DictionaryRepository;
import com.yichiuan.onelook.injection.AppComponent;


public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppComponent appComponent = ((OnelookApp) getApplicationContext()).getAppComponent();
        DictionaryRepository dictionaryRepository = appComponent.dictionaryRepository();

        MainFragment fragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        if (fragment == null) {
            fragment = MainFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_main, fragment)
                    .commit();
        }

        presenter = new MainPresenter(fragment, dictionaryRepository);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
