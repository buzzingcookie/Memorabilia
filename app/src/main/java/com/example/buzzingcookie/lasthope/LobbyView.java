package com.example.buzzingcookie.lasthope;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LobbyView extends AppCompatActivity {

    ViewPager mSlideViewPager;
    LobbySliderAdapter LobbySliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activty_view);

        mSlideViewPager = findViewById(R.id.lobby_viewPager);

        LobbySliderAdapter = new LobbySliderAdapter(this);

        mSlideViewPager.setAdapter(LobbySliderAdapter);
    }

}


