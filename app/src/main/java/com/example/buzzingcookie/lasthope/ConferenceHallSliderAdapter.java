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

import com.example.buzzingcookie.lasthope.databinding.ConferencehallSlideLayoutBinding;
import com.example.buzzingcookie.lasthope.model.Memorabilia;
import com.example.buzzingcookie.lasthope.util.Memorabilias;

public class ConferenceHallSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ConferenceHallSliderAdapter(Context context){
        this.context = context;
    }

    public String[] conferenceHall_artistName = {"That Guy","The Beatles","Divinity Roxxx"};
    public String[] conferenceHall_bandName = {"(Marilyn Manson)","","(Beyonce)"};

    public String[] conferenceHall_slide_description = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
                    " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",

            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
                    " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",

            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
                    " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
                    " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur."
    };


    public int[] conferenceHall_images = {R.drawable.whitelogo, R.drawable.whitelogo, R.drawable.whitelogo};

    @Override
    public int getCount() {return conferenceHall_artistName.length; }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.conferencehall_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.conferenceHall_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.conferenceHall_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.conferenceHall_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.conferenceHall_description);


        slideImageView.setImageResource(conferenceHall_images[position]);
        slideArtistName.setText(conferenceHall_artistName[position]);
        slideBandName.setText(conferenceHall_bandName[position]);
        slideDescription.setText(conferenceHall_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

}
