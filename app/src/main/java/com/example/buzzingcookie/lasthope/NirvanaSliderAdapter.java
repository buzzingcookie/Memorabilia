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

public class NirvanaSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public NirvanaSliderAdapter(Context context){
        this.context = context;
    }

    public String[] nirvana_slide_artistName = {
            "Slash","Christina Aguilera",
            "George Clinton", "Phill Collins",
            "Juanes", "James LoMenzo",
            "Calle 13", "Jesse Johnson",
            "Tommy Lee", "Ramones",
            "Will.I.Am", "Iggy Azalea",
            "Bruce Springsteen", "Amy Winehouse",
            "Pink Floyd", "Beyonce"

    };

    public String[] nirvana_slide_bandName = {
            "(Guns 'N' Roses)","",
            "", "(Genesis)",
            "", "(White Lion)",
            "", "(The Revolution)",
            "(Motley Crue)", "",
            "(The Black Eyed Peas)", "",
            "", "",
            "", ""
    };

    public String[] nirvana_slide_description = {
            "Here's a page of lyrics for an uncompleted song from Guns N Roses guitarist Slash. The first verse is in Slash's own handwriting," +
                    "but it appears the second verse was written by someone else.",

            "With her 4-octave voice and hit albums, Christina Aguilera is one of the most important artists of the 21st century." +
                    "She wore this bra in the 2011 film 'Burlesque'.",

            "These amazing platform boots were worn on stage by the one and only George Clinton. Wildly influential and totally unique, George has led" +
                    "various incarnations pf Parliament/Funkadelic through five decades of exhilarating psychedelic celebration.",

            "Genesis frontman Phill Collins signed this tambourine during the group's 1991 world tour." +
                    "Though he's fronted the band since 1976, Phill was originally the group's drummer with the legendary Peter Gabriel out front.",

            "Colombian rock legend Juanes wore these stylish pants on stage during his 'Mi Sangre' tour in 2005.",

            "Former White Lion bassist James LoMenzo wore this jacket on stage during the group's 'Pride' tour in 1987. James went to play with Megadeth," +
                    "Ozzy Osbourne and many other metal icons.",

            "This Hohner melodica was signed and donated by Puerto Rican hip hop group Calle 13 at the 2008 MTV 'Los Premios' awards.",

            "Minneapolis guitar legend Jesse Johnson owned and signed this heavily customized Ibanez Rocket Roll guitar. Jesse was a major force in the " +
                    "vibrant Minneapolis music scene of the early 1980's and worked with both the Time and Prince.",

            "This bass drum head was used by Motley Crue's drummer Tommy Lee thoughout the band's 1983-1984 'Shout at the Devil' tour.",

            "This is a signed page of lyrics to The Ramones classic, 'Sheena is a Punk Rocker', in the late Joey Ramone's hand.",

            "Frontman will.i.am of pop/rap group the Black Eyed Peas wore these leather boots when he appeared on the Billboard Music Awards in 2006.",

            "This 'pussycat top' was designed by Meat Clothing and worn by Australian rapper Iggy Azalea.",

            "This humble Hohner Marine Band Harmonica was used on stage during Bruce Springsteen's epic 1984-1985 'Born is The USA' tour. " +
                    "Bruce used it specifically on the songs 'She's The One' and 'Promise Land'.",

            "This collection of backstage ephemera is from Amy Winehouse's appearance at the 50th annual Grammy Awards in 2008. It includes the actual speech notes Amy used on stage.",

            "This is an original animation cel from Pink Floyd's epic 1982 film, 'The Wall'. It was used in the 'Goodbye Blue Sky' scene.",

            "Pop legend Beyonce wore this bikini top in the video for 'Part 2 (on the Run)' - her 2013 collaboration with her husband Jay-Z."

    };


    public int[] nirvana_slide_images = {
            R.drawable.slashgood, R.drawable.christinagood,
            R.drawable.georgeclintongood,R.drawable.philcollinsgood,
            R.drawable.juanesgood, R.drawable.jameslomenogood,
            R.drawable.calle13good,R.drawable.jessejohnsongood,
            R.drawable.tommyleegood, R.drawable.black_gradient,
            R.drawable.williamgood,R.drawable.iggyazaleagood,
            R.drawable.brucegood, R.drawable.amygood,
            R.drawable.black_gradient,R.drawable.beyoncegood
    };


    @Override
    public int getCount() {
        return nirvana_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.nirvana_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.nirvanaView_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.nirvanaView_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.nirvanaView_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.nirvanaView_description);


        slideImageView.setImageResource(nirvana_slide_images[position]);
        slideArtistName.setText(nirvana_slide_artistName[position]);
        slideBandName.setText(nirvana_slide_bandName[position]);
        slideDescription.setText(nirvana_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




