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

import com.example.buzzingcookie.lasthope.model.Memorabilia;
import com.example.buzzingcookie.lasthope.util.Memorabilias;

public class ConferenceHallSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ConferenceHallSliderAdapter(Context context){
        this.context = context;
    }

    public String[] conferenceHall_artistName = {
            "Steven Tyler","Rihanna",
            "Robbie Williams", "Taylor Swift",
            "Liberace", "Paul McCartney",
            "David Bowie", "The Temptations"
    };

    public String[] conferenceHall_bandName = {
            "(Aerosmith)","",
            "", "",
            "","The Beatles",
            "", ""
    };

    public String[] conferenceHall_slide_description = {
            "Legendary Aerosmith frontman Steven Tyler wore this striped jumpsuit on stage during the band's 1989 - 1990 tour in support of their smash" +
                    "hit album 'Pump'.",

            "Pop superstar Rihanna wore this JGerald dress in 2009 when she visited the Palais Maillot nightclub in Paris.",

            "British pop legend Robbie Williams wore this Asian-inspired outfit in the video for his 2006 hit, 'Sin Sin Sin'.",

            "Though she got her start as a young Nashville country singer, Taylor Swift evolved into a world-wide pop star and" +
                    " became one of the most successful and beloved artists of the 21st century. Shw wore this vintage floral dress while " +
                    "vacationing in Hyannis Port, Massachusetts, USA in 2012.",

            "This is an original contract for a 1968 Liberace performance in Montreal.",

            "This document is an absolutely incredible piece of history. It's Paul McCartney's handwritten, itemized expense report for The Beatles" +
                    "1960 trip to Hamburg and was a major factor in their development as a band. Take some time to read McCartney's responses." +
                    "Some of his stated expenses include 'leather trousers', 'cigarettes', 'drinks', and 'bass guitar'.",

            "This document is a true piece of history. it's a one-year booking contract between David Bowie and the William Morris Agency " +
                    "signed in 1972. This was at the height of Bowie's iconic 'Ziggy Stardust' period.",

            "With huge hits like 'My Girl', 'Ain't Too Proud to Beg' and 'Papa was a Rollin Stone', Motown legends The Temptations were " +
                    "one of the most successful acts of the 1960s. This page of handwritten lyrics is for a song entitled 'My Eyes Are Wide Open'." +
                    "It's in musical director Cornelius Grant's handwriting."
    };


    public int[] conferenceHall_images = {
            R.drawable.memorabilia_rihanna, R.drawable.memorabilia_rihanna,
            R.drawable.memorabilia_amywine,R.drawable.memorabilia_amywine,
            R.drawable.memorabilia_rihanna, R.drawable.memorabilia_beatlescontract,
            R.drawable.memorabilia_amywine,R.drawable.memorabilia_amywine
    };

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
