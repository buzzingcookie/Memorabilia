package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RockRoyaltyView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private RockRoyaltySliderAdapter RockRoyaltySliderAdapter;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_royalty_view);

        mSlideViewPager = (ViewPager) findViewById(R.id.rockRoyaltyView_viewPager);
        RockRoyaltySliderAdapter = new RockRoyaltySliderAdapter(this);
        mSlideViewPager.setAdapter(RockRoyaltySliderAdapter);

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
