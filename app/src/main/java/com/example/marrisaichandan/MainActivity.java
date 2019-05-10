package com.example.marrisaichandan;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer t;
    ImageView im,im1;
    Runnable mStartActivityTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im = findViewById(R.id.imageView);
        im1 = findViewById(R.id.imageView2);


//        t = new Timer();
//        t.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        },500);
        t = new Timer();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        im1.setVisibility(View.VISIBLE);
                        YoYo.with(Techniques.FadeIn).duration(1000).repeat(0).playOn(im);
                        YoYo.with(Techniques.FadeIn).duration(1000).repeat(0).playOn(im1);
                    }
                });

                t = new Timer();
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent i = new Intent(MainActivity.this,Main3Activity.class);
                        Animatoo.animateFade(MainActivity.this);
                        startActivity(i);
                        finish();
                    }
                },1500);


//        AnimationSet as = new AnimationSet(true);
//        TranslateAnimation animation1 = new TranslateAnimation(
//                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
//                Animation.ABSOLUTE, 150.0f, Animation.ABSOLUTE, 0.0f);
//        animation1.setDuration(200);
//        animation1.setStartOffset(200);
//        as.addAnimation(animation1);
//        im1.startAnimation(as);
//
//        TranslateAnimation animation2 = new TranslateAnimation(
//                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
//                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -150.0f);
//        animation2.setDuration(200);
//        animation2.setStartOffset(200);
//        as.addAnimation(animation2);
//        im.startAnimation(as);

    }
}
