package com.example.newroof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Animation splashanim,textanim;
    ImageView img;
    TextView txtv;
    private static int SPLASH_SCREEN_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        splashanim = AnimationUtils.loadAnimation(this,R.anim.roofintro);
        textanim = AnimationUtils.loadAnimation(this,R.anim.textintro);
        img = findViewById(R.id.rooflogo);
        txtv = findViewById(R.id.slogan);

        img.setAnimation(splashanim);
        txtv.setAnimation(textanim);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(MainActivity.this,
                        loginactivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);
                //invoke the SecondActivity.

                finish();
            }
        },SPLASH_SCREEN_TIME_OUT);
    }
}