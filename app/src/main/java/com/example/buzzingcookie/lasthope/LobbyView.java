package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LobbyView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LobbySliderAdapter LobbySliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lobby_activty_view);

        mSlideViewPager = (ViewPager) findViewById(R.id.lobby_viewPager);
        LobbySliderAdapter = new LobbySliderAdapter(this);
        mSlideViewPager.setAdapter(LobbySliderAdapter);
    }
}
