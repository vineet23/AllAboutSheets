package com.allabout.sheets.allaboutsheets;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        toolbar = findViewById(R.id.toolbar);
        title = findViewById(R.id.title_bar);
        title.setText(getString(R.string.app_name));
        loadFragment(HomeFragment.getInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(itemSelectedListener);
        bottomNavigationView.setOnNavigationItemReselectedListener(reselectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_one:
                    loadFragment(HomeFragment.getInstance());
                    title.setText(getString(R.string.app_name));
                    return true;
                case R.id.navigation_two:
                    loadFragment(OnGoingFragment.getInstance());
                    title.setText("On Going Sheets");
                    return true;
                case R.id.navigation_three:
                    loadFragment(CompletedFragment.getInstance());
                    title.setText("Completed Sheets");
                    return true;
                case R.id.navigation_four:
                    loadFragment(SettingFragment.getInstance());
                    title.setText("Settings");
                    return true;
            }
            return false;
        }
    };

    private BottomNavigationView.OnNavigationItemReselectedListener reselectedListener
            = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_two:
                    loadFragment(OnGoingFragment.refresh());
                    break;
                case R.id.navigation_three:
                    loadFragment(CompletedFragment.refresh());
                    break;
            }
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
