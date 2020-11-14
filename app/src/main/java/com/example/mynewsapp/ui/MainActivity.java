package com.example.mynewsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.mynewsapp.R;
import com.example.mynewsapp.util.AppSettings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    NavHostFragment navHostFragment;
    BottomNavigationView bottomNavigationView;

    AppSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        settings = new AppSettings(this);
        applyTheme(settings.getTheme());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
    }

    private void applyTheme(int theme) {

        switch (theme){
            case AppSettings.THEME_LIGHT : setTheme(R.style.AppTheme);break;
            case AppSettings.THEME_DARK : setTheme(R.style.DarkTheme);break;
            case AppSettings.THEME_DARK_AMOLED : setTheme(R.style.DarkTheme);break;// we do not an amoled theme yet so i just set to dark
            default: setTheme(R.style.AppTheme);
        }
    }

    private void setupNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        NavigationUI.setupWithNavController(bottomNavigationView,navHostFragment.getNavController());
    }
}