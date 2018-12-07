package com.example.buzzingcookie.lasthope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class SlickCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slick_cycle);

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);

        MySlickAdapter adapter = new MySlickAdapter(this);
        pager.setAdapter(adapter);
    }
}
