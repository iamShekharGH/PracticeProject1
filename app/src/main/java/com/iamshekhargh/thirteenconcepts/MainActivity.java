package com.iamshekhargh.thirteenconcepts;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.snackbar.Snackbar;
import com.iamshekhargh.thirteenconcepts.ui.RestfulServiceFragment;
import com.iamshekhargh.thirteenconcepts.ui.viewmodels.MainActivityViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        switch (item.getItemId()) {
            case R.id.save:
                showSnackbar("Save Icon Clicked!");

                return true;
            case R.id.search:
                showSnackbar("Search Item Clicked");

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = findViewById(R.id.mainactivity_toolbar);
        setSupportActionBar(t);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.mainactivity_container, RestfulServiceFragment.newInstance())
                .commit();
    }

    private void showSnackbar(String s) {
        Snackbar.make(findViewById(R.id.mainactivity_toolbar), s, Snackbar.LENGTH_SHORT).show();
    }

}