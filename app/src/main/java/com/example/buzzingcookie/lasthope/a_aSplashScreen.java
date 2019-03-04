package com.example.buzzingcookie.lasthope;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
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
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class a_aSplashScreen extends AppCompatActivity {

    public static final String TAG = "SplashScreen";
    Animation feelTheVibeOffSet, logoButtonOffSet;
    ViewPager mViewPager;
    NavigationView mNavigationView;
    MediaPlayer mPlayer;


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ConstraintLayout cLayout;
    private float lastTranslate = 0.0f;

    private TextView[] mDots;
    private LinearLayout mDotLayout;
    private VideoView videoBG;

    public MediaPlayer mMediaPlayer;
    public ImageButton mHamburger;
;   private ImageButton logoButton;
    private ImageButton backButton;
    private ImageButton muteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash_screen);

        cLayout = (ConstraintLayout) findViewById(R.id.content_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_Pager);
        mDotLayout = (LinearLayout) findViewById(R.id.dot_layout);

        mHamburger = findViewById(R.id.white_hamburgerIcon);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        backButton = findViewById(R.id.back_button);
        muteButton = findViewById(R.id.white_muteButton);

            mPlayer = MediaPlayer.create(this,R.raw.backinblack);
            mPlayer.start();
            mPlayer.setLooping(true);

            videoINIT();
            backButton.setVisibility(View.INVISIBLE);
            hamburgerIcon();
            addDotsIndicator(0);
            mViewPager.addOnPageChangeListener(viewListener);
            mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


    }

    public void navigationItemSelector(){

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.nav_home:

                    case R.id.nav_shows:

                    case R.id.nav_hotel:

                    case R.id.nav_memorabilias:

                    case R.id.nav_aboutUs:

                }
                return false;
            }
        });
    }

    public ImageButton getBackButton() {
        return this.backButton;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlayer.start();
        Log.i(TAG, "OnResume()");
        videoBG.start();
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

    private void stopPlayer() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
    }

    public void videoINIT(){

        videoBG = (VideoView) findViewById(R.id.video_splash);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hotelvideo);

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

    public void hamburgerIcon(){

        mHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.RIGHT);
                drawerSlider();
            }
        });

    }

    public void drawerSlider(){

        //Drawer Layout Sliding.
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_launcher_background, R.string.acc_drawer_close)
        {

            @SuppressLint("NewApi")
            public void onDrawerSlide(View drawerView, float slideOffset)
            {
                super.onDrawerSlide(drawerView, slideOffset);

                float moveFactor = (mNavigationView.getWidth() * (-1 * (slideOffset)));

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

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                if (item != null && item.getItemId() == android.R.id.home) {
                    if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                        mDrawerLayout.closeDrawer(Gravity.RIGHT);
                    }
                    else {
                        mDrawerLayout.openDrawer(Gravity.RIGHT);
                    }
                }
                return false;
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    public void Activity2(){
        Intent i = new Intent(this, b_Zones.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for(int i=0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(70);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimaryDark));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0 ) {
            mDots[position].setTextColor(getResources().getColor(R.color.hardRockGold));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            if(i > 0 ){
                backButton.setVisibility(View.VISIBLE);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mViewPager.getCurrentItem() != 0) {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1,true);
                        }else{
                            finish();
                        }
                    }
                });
            }else {
                backButton.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

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
