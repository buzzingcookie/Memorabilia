package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MySlickAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public MySlickAdapter(Context context) { this.context = context;layoutInflater = LayoutInflater.from(context); }

    public String[] slick_artistNames = {"Nirvana","Metallica","Oasis", "Loquillo","The Beatles","Taylor Swift","Steven Tyler"};
    public int[] slick_imageViews = {R.drawable.nirvanatower, R.drawable.rockroyalty, R.drawable.nirvanatower, R.drawable.rockroyalty, R.drawable.nirvanatower, R.drawable.rockroyalty, R.drawable.nirvanatower};

    @Override
    public int getCount() { return slick_artistNames.length; }

    @Override
    public boolean isViewFromObject(View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object o) {
        container.removeView((View) o);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = layoutInflater.inflate(R.layout.slick_item, container, false);

        TextView artistName = (TextView)view.findViewById(R.id.slick_artistName);
        ImageView imageView = (ImageView)view.findViewById(R.id.slick_imageView);

        artistName.setText(slick_artistNames[position]);
        imageView.setImageResource(slick_imageViews[position]);
        container.addView(view);

        return view;
    }
}
