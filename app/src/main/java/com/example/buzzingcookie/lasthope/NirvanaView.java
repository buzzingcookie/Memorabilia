package com.example.buzzingcookie.lasthope;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NirvanaView extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private NirvanaSliderAdapter NirvanaSliderAdapter;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nirvana_view);

        mSlideViewPager = (ViewPager) findViewById(R.id.NirvanaView_viewPager);
        NirvanaSliderAdapter = new NirvanaSliderAdapter(this);
        mSlideViewPager.setAdapter(NirvanaSliderAdapter);

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
