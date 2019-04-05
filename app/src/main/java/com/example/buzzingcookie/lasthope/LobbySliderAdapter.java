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

public class LobbySliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public LobbySliderAdapter(Context context){
        this.context = context;
    }

    public String[] lobby_slide_artistName = {
            "Elton John","Billy Duffy",
            "Matt Healy", "Divinity Roxx",
            "Tim Skold", "Britney Spears",
            "Ana Torroja", "Loquillo",
            "Joaquin Sabina", "John Entwistle",
            "John Entwistle", "Sly Stone",
            "Sergio Vallin", "Meat Loaf",
            "The Beatles", "Lady Gaga",
            "Alicia Keys"};


    public String[] lobby_slide_bandName = {
            "","(The Cult)",
            "(The 1975)", "(Beyonce)",
            "(Marilyn Manson)", "",
            "", "",
            "", "(The Who)",
            "(The Who)", "Sly & The Family Stone",
            "(Mana)", "",
            "", "",
            ""
    };

    public String[] lobby_slide_description = {

            "Outfitted by legendary designer and friend, Bob Mackie, Sir Elton John has donned a range of wild outfits throughout his career like the" +
            "the absurd Donald Duck getup worn while playing Central Park in 1980 or this beautiful feathered ensemble. Nearly as renowned in " +
            "the world of music, Elton is the definition of icon.",

            "This absolutley stunning Gretsch White Falcon guitar was played on stage by Billy Duffy of the Cult from 2006 to 2012.",

            "Guitarrist, Matt Healy of English indie rockers The 1975 played this Fender Stratocaster throughout the group's 2016 tour of the United States.",

            "Bassist Divinity Roxx played this Brubaker JJ-5 bass on stage throughout pop icon Beyonce's 2009 'I Am Sasha Fierce' tour.",

            "Bassist Tim Skold played this stunning King double bass on stage with Marilyn Manson from 2004 to 2006.",

            "Pop legend Britney Spears wore this Dolce & Gabbana dress when she presented an award at the American Music Awards in Los Angeles," +
             " California on November 21, 2006. The chair was used on stage during Britney Spears's 2001-2002 'Dream within a Dream' tour.",

            "From her time with Mercano to her succeffsul solo career, Ana Torroja has been at the forefront of the Spanish pop scene since the early 1980's." +
            "She wore this outfit on stage during her 1999-2000 'Girados' tour with Michael Bose.",

            "This blazer was worn on stage by Barcelona native Loquillo while on tour in 2006 supporting his 'Hermanos de Sangre' album.",

            "Latin rock legend Joaquin Sabina wore this classic derby on stage and later signed it.",

            "The late John Entwistle rewrote the book of bass playing during his time with The Who and quite possibly the most influential rock bassist of all time." +
            "He wore this stylish outfit for the cover photo og his 1981 solo album 'Too Late the Hero'.",

            "This Music Man Stingray bass belonged to John Entwistle of The Who. A deeply gifted player, Entwistle is widely regarded as the single best basist in the history of rock music." +
            "This flight case was used on the road for one his many amazing basses.",

            "Though Sly and the Family Stone's name doesn't come up as much as The Beatles, Hendrix or James Brown, there's no question that the band was every bit as important to music and culture" +
            " in the late 1960's as any of those artists. Their leader, Sly Stone, assembled the first truly integrated rock band, in both race and gender and created some of the most vital and aware music of the " +
            "20th century. Sly owned and wore this custom made jacket.",

            "Virtuoso guitarrist Sergio Vallin of Mexican rock legends Mana owned these stylish cowboy boots.",

            "With his larger-than life persona and 'rock oopera' style, Meat Loaf is one of the most compelling artists of the classic rock era. He wore this suit jacket on stage during his 1995 tour.",

            "In 1963 - mere weeks before the became global superstars - The Beatles vacationed right here in Tenerife. The incredible," +
            " candid photos were taken by German photographer and longtime Beatles friend Astrid Kircherr." +
            "These images are among the last taken of The Beatles as relatively normal British lads. John Lennon skipped the Tenerife trip and vacationed in Torremolinos with manager Brian Epstein instead which is why" +
                    "there are no photos of John in this collection.",

            "Pop Star Lady Gaga wore this latex bodysuit on stage during her 2011 world tour.",

            "Pop virtuoso Alicia Keys wore this Giorgo Armani top on stage when she performed at the Cevtor Arena in Auckland, New Zealand on December 6, 2008."

    };

    public int[] lobby_slide_images = {
            R.drawable.eltonjohnnygood, R.drawable.billyduffygood,
            R.drawable.matthealygood,R.drawable.divinityroxxgood,
            R.drawable.timskoldgood,R.drawable.britneyspearsgood1,
            R.drawable.anatorrojagood,R.drawable.loquillogood,
            R.drawable.joaquinsabinagood,R.drawable.johnentwistlegood,
            R.drawable.johnentwistlegood,R.drawable.slystonegood,
            R.drawable.sergiovallingood,R.drawable.ladygagagood,
            R.drawable.beatlestenerifegood,R.drawable.ladygagagood,
            R.drawable.aliciakeysgood
    };

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
        TextView slideBandName = (TextView) view.findViewById(R.id.lobby_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.lobby_description);


        slideImageView.setImageResource(lobby_slide_images[position]);
        slideArtistName.setText(lobby_slide_artistName[position]);
        slideBandName.setText(lobby_slide_bandName[position]);
        slideDescription.setText(lobby_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




