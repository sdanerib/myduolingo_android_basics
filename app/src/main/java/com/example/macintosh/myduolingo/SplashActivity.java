package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME = 3000;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showSplashByTime(SPLASH_TIME);
    }

    private void showSplashByTime(int splashTime){
        timer  = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                goToIntroSection();
            }
        };

        timer.schedule(timerTask, SPLASH_TIME);

    }

    private void goToIntroSection() {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
        finish();

    }

}
