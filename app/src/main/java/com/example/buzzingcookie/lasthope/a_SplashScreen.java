package com.example.buzzingcookie.lasthope;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class a_SplashScreen extends AppCompatActivity {

    public static final String TAG = "SplashScreen";
    Animation feelTheVibeOffSet, logoButtonOffSet;

    private TextView feelTheVibe;
    private ImageButton logoButton;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private ConstraintLayout cLayout;
    private float lastTranslate = 0.0f;

    private VideoView videoBG;
    public MediaPlayer mMediaPlayer;
    public ImageButton mHamburger;

    ViewPager mViewPager;
    private TextView[] mDots;
    private LinearLayout mDotLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash_screen);

        videoINIT();

        mViewPager = (ViewPager) findViewById(R.id.view_Pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

            mDotLayout = (LinearLayout) findViewById(R.id.dot_layout);
            mHamburger = findViewById(R.id.white_hamburgerIcon);
            mDrawerLayout = findViewById(R.id.drawer_layout);
            mNavigationView = findViewById(R.id.nav_view);
            cLayout = (ConstraintLayout) findViewById(R.id.content_layout);

            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_launcher_background, R.string.acc_drawer_close)
            {
                @SuppressLint("NewApi")
                public void onDrawerSlide(View drawerView, float slideOffset)
                {
                    super.onDrawerSlide(drawerView, slideOffset);
                    float moveFactor = (mNavigationView.getWidth() * slideOffset);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
                    {
                        cLayout.setTranslationX(moveFactor);
                    }
                    else
                    {
                        TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                        anim.setDuration(0);
                        anim.setFillAfter(true);
                        cLayout.startAnimation(anim);

                        lastTranslate = moveFactor;
                    }
                }
            };


            mDrawerLayout.addDrawerListener(mDrawerToggle);


            feelTheVibe = (TextView) findViewById(R.id.feel_the_vibe);
            logoButton = (ImageButton) findViewById(R.id.logo_button);

            Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/hard_rock_font.TTF");
            feelTheVibe.setTypeface(typeface);


            feelTheVibeOffSet = AnimationUtils.loadAnimation(this, R.anim.fade_in_feel);
            logoButtonOffSet = AnimationUtils.loadAnimation(this, R.anim.fade_out_logo);


            feelTheVibe.setVisibility(View.INVISIBLE);

            YoYo.with(Techniques.FadeIn)
                .duration(3500)
                .repeat(0)
                .playOn(logoButton);

            mHamburger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDrawerLayout.openDrawer(Gravity.START);
                }
            });

            logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleAnimation();

                feelTheVibe.setVisibility(View.VISIBLE);
                feelTheVibe.startAnimation(feelTheVibeOffSet);
                Activity2();
            }
        });

            addDotsIndicator(0);
            mViewPager.addOnPageChangeListener(viewListener);
    }


    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(70);
            mDots[i].setTextColor(getResources().getColor(R.color.hardRockGrey));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0 ) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public void Activity2(){
        Intent i = new Intent(this, b_Zones.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    public void handleAnimation(){

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -350);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        logoButton.startAnimation(animation);
    }

    public void handleAnimationOnResume(){

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 0);
        animation.setDuration(0);
        animation.setFillAfter(true);
        logoButton.startAnimation(animation);
    }

    public void videoINIT(){

        videoBG = (VideoView) findViewById(R.id.video_splash);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sunset);

        videoBG.setVideoURI(uri);
        videoBG.start();

        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mMediaPlayer) {
                mMediaPlayer = mMediaPlayer;
                mMediaPlayer.setLooping(true);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume()");
        videoBG.start();
        handleAnimationOnResume();
        feelTheVibe.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return a_FirstFragment.newInstance("a_FirstFragment, Instance 1");
                case 1: return a_SecondFragment.newInstance("a_SecondFragment, Instance 1");
                default: return a_ThirdFragment.newInstance("a_ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
