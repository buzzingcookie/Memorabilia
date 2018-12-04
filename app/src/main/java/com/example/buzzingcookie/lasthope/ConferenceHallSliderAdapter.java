package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ConferenceHallSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ConferenceHallSliderAdapter(Context context){
        this.context = context;
    }

    public String[] ConferenceHall_slide_artistName = {"Alice Cooper","Metallica","ZZTop"};
    public int[] ConferenceHall_slide_images = {R.drawable.whitelogo, R.drawable.whitelogo, R.drawable.whitelogo};


    @Override
    public int getCount() {
        return ConferenceHall_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.conferencehall_slide_layout,container,false);

        TextView slideArtistName = (TextView) view.findViewById(R.id.conferenceHall_artist_name);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.conferenceHall_memo_image);

        slideArtistName.setText(ConferenceHall_slide_artistName[position]);
        slideImageView.setImageResource(ConferenceHall_slide_images[position]);


        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

}
