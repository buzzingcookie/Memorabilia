package com.example.buzzingcookie.lasthope;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LobbyView extends AppCompatActivity {

    ViewPager mSlideViewPager;
    LobbySliderAdapter LobbySliderAdapter;
    ImageButton backButton;
    public ImageButton mHamburger;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activty_view);

        mSlideViewPager = findViewById(R.id.lobby_viewPager);
        mHamburger = findViewById(R.id.white_hamburgerIcon);
        mDrawerLayout = findViewById(R.id.drawer_layout);


        LobbySliderAdapter = new LobbySliderAdapter(this);

        mSlideViewPager.setAdapter(LobbySliderAdapter);

        backButton = findViewById(R.id.back_button_views);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}


