package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class KingsHallView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private KingsHallSliderAdapter KingsHallSliderAdapter;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kings_hall);

        mSlideViewPager = (ViewPager) findViewById(R.id.KingsHallView_viewPager);
        KingsHallSliderAdapter = new KingsHallSliderAdapter(this);
        mSlideViewPager.setAdapter(KingsHallSliderAdapter);

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
