package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RockRoyaltySliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public RockRoyaltySliderAdapter(Context context){
        this.context = context;
    }

    public String[] rockRoyalty_slide_artistName = {"Matt Sorum", "Bryan Mantia"};
    public String[] rockRoyalty_slide_bandName = {"(Guns 'N' Roses)", "(Guns 'N' Roses)"};

    public String[] rockRoyalty_slide_description = {
            "Drummer Bryan 'Brain' Mantia used this DW drum kit during the recording of 'Chinese Democracy' Guns N' Roses infamous 2008 album." +
                    "Recorded over the span of 10 years, 'Chinese Democracy' is the most expensive rock album ever made.",

            "Drummer Matt Sorum used this Yamaha drum kit in the studio while recording Gun N' Roses legendary 'Use Your Illusion' albums in 1991."
    };


    public int[] rockRoyalty_slide_images = {R.drawable.mattsorumgood, R.drawable.brainmantiagood};


    @Override
    public int getCount() {
        return rockRoyalty_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.rockroyalty_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.rockRoyaltyView_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.rockRoyaltyView_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.rockRoyaltyView_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.rockRoyaltyView_description);


        slideImageView.setImageResource(rockRoyalty_slide_images[position]);
        slideArtistName.setText(rockRoyalty_slide_artistName[position]);
        slideBandName.setText(rockRoyalty_slide_bandName[position]);
        slideDescription.setText(rockRoyalty_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




