package com.example.buzzingcookie.lasthope;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView feelTheVibe;
    ImageButton logoButton;

    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    Animation feelTheVibeOffSet, logoButtonOffSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoINIT();

            feelTheVibe = (TextView) findViewById(R.id.feel_the_vibe);
            logoButton = (ImageButton) findViewById(R.id.logo_button);

            feelTheVibeOffSet = AnimationUtils.loadAnimation(this, R.anim.fade_in_feel);
            logoButtonOffSet = AnimationUtils.loadAnimation(this, R.anim.fade_out_logo);

        feelTheVibe.setVisibility(View.INVISIBLE);

            YoYo.with(Techniques.FadeIn)
                .duration(3500)
                .repeat(0)
                .playOn(logoButton);

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


    public void handleAnimation(){

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -320);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        logoButton.startAnimation(animation);
    }

    public void handleAnimationOnResume(){

        TranslateAnimation animation = new TranslateAnimation(0, 0, 0, 0);
        animation.setFillAfter(false);
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
    /*
    public void FeelTheVibe(){

        TextView feelTheVibe = (TextView) findViewById(R.id.feel_the_vibe);
        overridePendingTransition(R.anim.fade_in_feel, R.anim.fade_out);
    }*/

    public void Activity2(){
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume()");
        videoBG.start();
        feelTheVibe.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause()");
        videoBG.pause();
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
