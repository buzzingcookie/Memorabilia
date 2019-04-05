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

public class KingsHallSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public KingsHallSliderAdapter(Context context){
        this.context = context;
    }

    public String[] kingsHall_slide_artistName = {"Michael Jackson","Elvis Presley","Stevie Nicks"};
    public String[] kingsHall_slide_bandName = {"","",""};

    public String[] kingsHall_slide_description = {
            "During Michael Jackson's epic 1987-1989 'Bad' tour, his musicians and dancers all received tour robes like this one. Never mass produced and only" +
            " made for tour personnel, these robes are extremely rare.",

            "The King of Rock 'n' Roll himself owned this track suit and later gifted it longtime 'Memphis Mafia' member Sonny West.",

            "For her time in Fleetwood Mac to her wildly successful solo career, Stevie Nicks has been among the most influential woman in the history of popular music." +
             "This kimono was part of her personal wardrobe."
    };


    public int[] kingsHall_slide_images = {
            R.drawable.michaeljacksongood, R.drawable.elvispresleygood,
            R.drawable.stevienicksgood
    };


    @Override
    public int getCount() {
        return kingsHall_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.kingshall_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.kingsHallView_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.kingsHallView_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.kingsHallView_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.kingsHallView_description);


        slideImageView.setImageResource(kingsHall_slide_images[position]);
        slideArtistName.setText(kingsHall_slide_artistName[position]);
        slideBandName.setText(kingsHall_slide_bandName[position]);
        slideDescription.setText(kingsHall_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




