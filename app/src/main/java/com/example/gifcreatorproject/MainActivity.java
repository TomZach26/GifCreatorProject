package com.example.gifcreatorproject;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView, animationView;
    private AnimationDrawable animation;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView pauseImageView = findViewById(R.id.pauseIcon);
        imageView = findViewById(R.id.imageView);
        animationView = findViewById(R.id.animation);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                animation.run();
                if (animation.isRunning()) {
                    handler.postDelayed(this, 100);
                }
            }
        };
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.INVISIBLE);
                    pauseImageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    pauseImageView.setVisibility(View.INVISIBLE);


                }

                if (!isPlaying) {
                    animationView.setBackgroundResource(R.drawable.p0);
                    animation = (AnimationDrawable) animationView.getBackground();
                    animation.start();
                    handler.postDelayed(runnable, 100);
                //    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.SpanishGuitar);
                    mediaPlayer.start();
                    isPlaying = true;
                } else {
                    animation.stop();
                    handler.removeCallbacks(runnable);
                    mediaPlayer.stop();
                    isPlaying = false;
                }
            }
        });



        pauseImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (imageView.getVisibility() == View.VISIBLE) {
                    imageView.setVisibility(View.INVISIBLE);
                    pauseImageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    pauseImageView.setVisibility(View.INVISIBLE);


                }

                if (!isPlaying) {
                    animationView.setBackgroundResource(R.drawable.p0);
                    animation = (AnimationDrawable) animationView.getBackground();
                    animation.start();
                    handler.postDelayed(runnable, 100);
              //      mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.SpanishGuitar);
                    mediaPlayer.start();
                    isPlaying = true;
                } else {
                    animation.stop();
                    handler.removeCallbacks(runnable);
                    mediaPlayer.stop();
                    isPlaying = false;
                }
            }
        });




    }
}
