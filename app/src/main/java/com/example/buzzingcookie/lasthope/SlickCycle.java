package com.example.buzzingcookie.lasthope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class SlickCycle extends AppCompatActivity {

    List<Integer> lstImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slick_cycle);

        initData();

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        MySlickAdapter adapter = new MySlickAdapter(lstImages, getBaseContext());
        pager.setAdapter(adapter);
    }

    private void initData(){
        lstImages.add(R.drawable.nirvanatower);
        lstImages.add(R.drawable.rockroyalty);
        lstImages.add(R.drawable.nirvanatower);
        lstImages.add(R.drawable.rockroyalty);
        lstImages.add(R.drawable.nirvanatower);
        lstImages.add(R.drawable.rockroyalty);
        lstImages.add(R.drawable.nirvanatower);
    }
}
