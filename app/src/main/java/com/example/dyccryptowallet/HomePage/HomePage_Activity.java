package com.example.dyccryptowallet.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dyccryptowallet.Fragment.Settings;
import com.example.dyccryptowallet.Fragment.Swap;
import com.example.dyccryptowallet.Fragment.wallet;
import com.example.dyccryptowallet.R;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomePage_Activity extends AppCompatActivity {

    private com.ismaeldivita.chipnavigation.ChipNavigationBar bottom_nav_bar;

    private RelativeLayout fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        initWidget();
    }


    private void initWidget() {

        fragment_container = findViewById(R.id.fragment_container);
        bottom_nav_bar = findViewById(R.id.bottom_nav_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new wallet()).commit();
        bottom_nav_bar.setItemSelected(R.id.bottom_nav_bar, true);

        bottomMenu();

    }

    private void bottomMenu() {

        bottom_nav_bar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i)
                {
                    case R.id.navigation_wallet:
                        fragment = new wallet();
                        break;

                    case R.id.navigation_swap:
                        fragment = new Swap();
                        break;

                    case R.id.navigation_seting:
                        fragment = new Settings();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }
}