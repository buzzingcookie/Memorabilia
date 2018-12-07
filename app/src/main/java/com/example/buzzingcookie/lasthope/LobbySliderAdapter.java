package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LobbySliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public LobbySliderAdapter(Context context){
        this.context = context;
    }

    public String[] lobby_slide_artistName = {"Alice Cooper","Metallica","ZZTop"};
    public int[] lobby_slide_images = {R.drawable.splashscreen_button, R.drawable.whitelogo, R.drawable.whitelogo};


    @Override
    public int getCount() {
        return lobby_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.lobby_slide_layout,container,false);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "This page was clicked: " + position);
                }
            });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.lobby_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.lobby_artist_name);


        slideImageView.setImageResource(lobby_slide_images[position]);
        slideArtistName.setText(lobby_slide_artistName[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




