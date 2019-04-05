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

public class ThirdHalfSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public ThirdHalfSliderAdapter(Context context){
        this.context = context;
    }

    public String[] thirdHalf_slide_artistName = {
            "Steve Aoki","Katy Perry",
            "Santiago Auseron", "Leiva"
    };

    public String[] thirdHalf_slide_bandName = {
            "","",
            "(Radio Futura)", "(Pereza)"

    };

    public String[] thirdHalf_slide_description = {
            "As the 21st century progressed and DJs began to take over for instrumentalists as the new rock stars, Steve Aoki was at the forefront" +
                    " of the movemente. This U.S-based musician, producer and promoter has set the standard for creative excellence in both" +
                    " original composition and remix asrtistry - and his live performances are cathartic releases of pure freedom and joy." +
                    "The shirt, sunglasses and sneekers on display were all part of Steve's personal wardrobe and worn on stage; headphones, prop cake and" +
                    " flag were all part of his stage gear.",

            "Pop megastar Kety Perry wore this mermaid costume in an advertisement for GHD hair products in 2012. Katy as the brand's spokesperson until 2013.",

            "Guitarist Santiago Auseron of Spanish rock icons Radio Futura used this Gibson Chet Atkins nylon-string guitar on stage in the 1980s.",

            "Spanish singer/songwriter Leiva signed this Fender acoustic at the Hard Rock Cafe right here in Tenerife."
    };


    public int[] thirdHalf_slide_images = {
            R.drawable.memorabilia_bitney_spears, R.drawable.katyperrygood2,
            R.drawable.santiagoauserongood,R.drawable.leivagood
    };


    @Override
    public int getCount() {
        return thirdHalf_slide_artistName.length;
    }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container,final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.thirdhalf_slide_layout,container,false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "This page was clicked: " + position);
            }
        });


        ImageView slideImageView = (ImageView) view.findViewById(R.id.thirdHalfView_memo_image);
        TextView slideArtistName = (TextView) view.findViewById(R.id.thirdHalfView_artist_name);
        TextView slideBandName = (TextView) view.findViewById(R.id.thirdHalfView_band_name);
        TextView slideDescription = (TextView) view.findViewById(R.id.thirdHalfView_description);


        slideImageView.setImageResource(thirdHalf_slide_images[position]);
        slideArtistName.setText(thirdHalf_slide_artistName[position]);
        slideBandName.setText(thirdHalf_slide_bandName[position]);
        slideDescription.setText(thirdHalf_slide_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}




