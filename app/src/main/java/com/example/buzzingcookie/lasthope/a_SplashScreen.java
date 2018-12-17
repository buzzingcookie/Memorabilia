package com.example.buzzingcookie.lasthope;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class a_SplashScreen extends AppCompatActivity {

    public static final String TAG = "SplashScreen";

    private TextView feelTheVibe;
    private ImageButton logoButton;
    public ImageButton mHamburger;
    Animation feelTheVibeOffSet, logoButtonOffSet;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;
    private ConstraintLayout cLayout;
    private float lastTranslate = 0.0f;

    private VideoView videoBG;
    public MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_splash_screen);

        videoINIT();

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
    }

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
}
