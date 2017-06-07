package com.androidtutorialshub.animatedgradientbackground;

import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayoutNya;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menyembunyikan Action bar
        getSupportActionBar().hide();

        fadeAnimation();
    }

    /**
     * Fungsi ini akan menggunakan gradient untuk membuat animasi
     * untuk durasi lamanya di set dalam file xml (animation_list)
     * */
    public void fadeAnimation(){

        // Menginisialisasi Layout yang di gunakan
        linearLayoutNya = (LinearLayout) findViewById(R.id.linearLayout);

        // initializing animation drawable by getting background from linear layout
        animationDrawable = (AnimationDrawable) linearLayoutNya.getBackground();

        // setting enter fade animation duration to seconds
        animationDrawable.setEnterFadeDuration(6000);

        // setting exit fade animation duration to seconds
        animationDrawable.setExitFadeDuration(6000);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // Start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // Stop the animation
            animationDrawable.stop();
        }
    }
}
