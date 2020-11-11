package com.com.tasks.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.com.tasks.Home.Home;
import com.com.tasks.R;

public class splash extends AppCompatActivity {
    LottieAnimationView mLottie ;
    StatusBarManager mStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniview();
        Lottie();
    }

    private void Lottie() {

        mLottie.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finish();
                startActivity(new Intent(splash.this, Home.class));
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mLottie.playAnimation();
    }

    private void iniview() {
       getWindow().setStatusBarColor(getResources().getColor(R.color.plue));
        mLottie=findViewById(R.id.lottie_layer_name);

    }
}
