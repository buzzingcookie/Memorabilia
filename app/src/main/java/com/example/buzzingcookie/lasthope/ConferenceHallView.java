package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConferenceHallView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private ConferenceHallSliderAdapter ConferenceHallSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conference_hall_activity_view);

        mSlideViewPager = (ViewPager) findViewById(R.id.conferenceHall_viewPager);
        ConferenceHallSliderAdapter = new ConferenceHallSliderAdapter(this);
        mSlideViewPager.setAdapter(ConferenceHallSliderAdapter);
    }
}
