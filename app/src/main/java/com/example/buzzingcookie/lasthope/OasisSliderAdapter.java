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

public class OasisSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public OasisSliderAdapter(Context context){
        this.context = context;
    }

    public String[] oasis_slide_artistName = {
            "Tom Hamilton","Tom Petty",
            "John Mellencamp", "David Ruffin",
            "Frank Sinatra","Sergio Vallin",
            "Tina Turner","Alice Cooper",
            "Tony Iommi","James Brown",
            "Justin Timberlake","Dave Davies",
            "Clarence Clemons","The Rolling Stones",
            "Shakira","Billy Joel"
    };
    public String[] oasis_slide_bandName = {
            "(Aerosmith)","",
            "", "(The Temptations)",
            "","(Mana)",
            "","",
            "(Black Sabbath)","",
            "","(The Kinks)",
            "(Bruce Springsteen)","",
            "",""
    };

    public String[] oasis_slide_description = {

            "Aerosmith bassist Tom Hamilton wore this shirt on stage during the band's 2001-2002 'Just Push Play' tour.",

            "This sleeveless shirt was worn on stage and signed by Tom Petty.",

            "American legend John Mellencamp signed this this Yamaha SE-700 guitar.",

            "This stylish motorcycle vest belonged to the late, great David Ruffin of Motown legends The Temptations.",

            "The legendary 'Chairman of the Board' defined traditional American Pop and swing styles, was the very first 'teen idol' and" +
                    "became one of the most iconic figures in history. Frank's larger than life persona is so ingrained in our culture, that" +
                    "it's easy to overlook how truly gifted he was as a vocalist and lyric interpreter. He owned this tuxedo shirt in the 1970's",

            "Guitar Virtuoso Sergio Vallin of Mexican rock legends Mana wore this vest on stage with the group.",

            "This stylish 'swamp dress' was part of Tine Turner's stage wardrobe.",

            "Throughout the 1970s and 1980s, Alice Cooper defined the art of theatricality in heavy music." +
                    "This studded denim vest belonged to alice and he wore it very often.",

            "A bona-fide metal icon, Black Sabbath guitarist Tonny Iommi forged the template for what became 'Heavy Metal'" +
                    "and is quite possibly the single most influential rock guitarist ever. This velvet jacket is from his personal wardrobe.",

            "Undeniably one of the most important artists in music history, James Brown set the template for funk and influenced every" +
                    "genre of popular music that followed. This velour shirt is from his personal wardrobe.",

            "Although he got his start during the late-1990s with 'boy band' 'N Sync, Justin Timberlake quickly established himself" +
                    " as a pop phenomenon and solo superstar. Now into his third decade as a star, Justin has amazed audiences worldwide with his skills as a performer," +
                    "producer and actor. He owned and wore this cardigan sweater.",

            "In what is quite possibly the greatest quote in rock, Kinks guitarist Dave Davies once said, 'It wasn't called heavy metal back when i invented it'." +
                    "He was referring to 'You Really Got Me' - the 1964 track that made The Kinks famous. Dave owned and wore this wool jacket.",

            "The late, great Clarence Clemons was much more than Bruce Springsteen's saxophone player - he was the heart and soul of the E Street Band. This ruffled" +
                    " shirt was part of his stage wardrobe while on tour with Bruce.",

            "This sweater, which features the classic Rolling Stones 'tongue' logo, was signed by Mick Jagger, Keith Richards and Ron Wood.",

            "Colombian pop superstar Shakira owned and wore this tank top. She donated it to the Hard Rock collection in exchange for a contribution" +
                    " to her charity, Fundacion Pies Descalzos.",

            "With hits like 'You May Be Right' and 'Still Rock 'n' Roll To Me', Billy Joel's 1980's album, 'Glass Houses', is one of the most critically acclaimed" +
                    " and commercially successful releases of his long career. This is the leather jacket Billy wore in the cover photo of that classic album."
    };


    public int[] oasis_slide_images = {
            R.drawable.tomhamiltongood, R.drawable.tompettygood,
            R.drawable.johnmellencampgood,R.drawable.davidruffingood,
            R.drawable.franksinatragood, R.drawable.sergiovallingood,
            R.drawable.tinaturnergood,R.drawable.alicecoopergood,
            R.drawable.tonnyiomigood, R.drawable.jamesbrowngood,
            R.drawable.justintimberlakegood,R.drawable.davedaviesgood,
            R.drawable.clerenceclemonsgood, R.drawable.therollingstonesgood,
            R.drawable.shakiragood,R.drawable.billyjoelgood
    };


    @Override
    public int getCount() {
        return oasis_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.oasis_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.oasisView_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.oasisView_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.oasisView_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.oasisView_description);


        slideImageView.setImageResource(oasis_slide_images[position]);
        slideArtistName.setText(oasis_slide_artistName[position]);
        slideBandName.setText(oasis_slide_bandName[position]);
        slideDescription.setText(oasis_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




