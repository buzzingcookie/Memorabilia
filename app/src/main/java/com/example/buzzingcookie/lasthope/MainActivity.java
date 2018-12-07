package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

    ImageButton logoButton;
    private VideoView videoBG;
    MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            videoINIT();

            logoButton = (ImageButton) findViewById(R.id.logo_button);

            YoYo.with(Techniques.ZoomIn)
                .duration(1600)
                .repeat(0)
                .playOn(logoButton);

        YoYo.with(Techniques.FlipInY)
                .duration(2600)
                .repeat(0)
                .playOn(logoButton);

            logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomOut)
                        .duration(1600)
                        .repeat(0)
                        .playOn(logoButton);
                Activity2();
            }
        });



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

    public void Activity2(){
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoBG.start();
        YoYo.with(Techniques.ZoomIn)
                .duration(1600)
                .repeat(0)
                .playOn(logoButton);
    }

    @Override
    protected void onPause() {
        super.onPause();
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
