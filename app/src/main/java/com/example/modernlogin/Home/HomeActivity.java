package com.example.modernlogin.Home;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toolbar;

import com.example.modernlogin.R;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

public class HomeActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle t;
    private NavigationView navigationView;
    ChipNavigationBar bottomNavigationView;
    FragmentManager fragmentManager;
    private String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
        toolbar =  findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nv);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withMenuLayout(R.layout.navigation_drawer)
                .inject();


        if (savedInstanceState == null) {
            bottomNavigationView.setItemSelected(R.id.menu_home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,homeFragment).commit();
        }
        bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {

            @Override
            public void onItemSelected(int i) {
                Fragment selectedFragment = null;

                switch (i) {
                    case R.id.menu_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.menu_setting:
                        selectedFragment = new SettingFragment();
                        break;
                }
                if (selectedFragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }
        });

    }

    private void bypassToHomeFragment(Bundle savedInstanceState){

    }


    private void setFragments() {
    }
}


/*
<androidx.appcompat.widget.Toolbar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:minHeight="?attr/actionBarSize"
        android:id="@+id/toolbar"
        app:titleTextColor="@color/white"
        >
    </androidx.appcompat.widget.Toolbar>
 */