package com.example.buzzingcookie.lasthope;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

public class a_FourthFragment extends Fragment {

    private TextView feelTheVibe;
    private ImageButton logoButton;

    Animation feelTheVibeOffSet, logoButtonOffSet;

    public ImageButton mHamburger;
    private DrawerLayout mDrawerLayout;
    private TextView mMemoTour;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.a_fourth_frag, container, false);

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)v.findViewById(R.id.horizontal_cycle);

        MySlickAdapter adapter = new MySlickAdapter(getActivity());
        pager.setAdapter(adapter);
        pager.getRealItem();

        return v;
    }



    public static a_FourthFragment newInstance(String text) {

        a_FourthFragment f = new a_FourthFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}