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

public class a_FirstFragment extends Fragment {

    private TextView feelTheVibe;
    private ImageButton logoButton;

    Animation feelTheVibeOffSet, logoButtonOffSet;

    public ImageButton mHamburger;
    private DrawerLayout mDrawerLayout;
    private TextView mMemoTour;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.a_first_frag, container, false);

        final Intent b_zones = new Intent(getActivity(), b_Zones.class);
        ImageButton logoButton = (ImageButton) v.findViewById(R.id.logo_button);
        mMemoTour = (TextView) v.findViewById(R.id.memo_tour);

        YoYo.with(Techniques.FadeIn)
                .duration(2500)
                .repeat(0)
                .playOn(logoButton);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return v;
    }



    public static a_FirstFragment newInstance(String text) {

        a_FirstFragment f = new a_FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
