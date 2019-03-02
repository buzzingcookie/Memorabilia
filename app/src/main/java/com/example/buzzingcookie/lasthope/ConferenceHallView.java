package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.buzzingcookie.lasthope.databinding.ConferencehallSlideLayoutBinding;

public class ConferenceHallView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private ConferenceHallSliderAdapter ConferenceHallSliderAdapter;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conference_hall_activity_view);

        mSlideViewPager = (ViewPager) findViewById(R.id.conferenceHall_viewPager);
        ConferenceHallSliderAdapter = new ConferenceHallSliderAdapter(this);
        mSlideViewPager.setAdapter(ConferenceHallSliderAdapter);

        backButton = findViewById(R.id.back_button);

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
