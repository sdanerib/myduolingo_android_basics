package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

import com.example.macintosh.myduolingo.ui.OnFragmentInteractionListener;
import com.example.macintosh.myduolingo.ui.adapters.IntroSectionsPagerAdapter;

public class IntroActivity extends AppCompatActivity implements OnFragmentInteractionListener {

    IntroSectionsPagerAdapter introSectionsPagerAdapter;
    private ViewPager viewPager;
    private Button getStartedBtn;
    private Button iAlreadyHaveAccBtn;
    private Intent goToLearningChoice;
    private Intent loginActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setupWindowAnimations();
        setContentView(R.layout.activity_intro);
        ui(savedInstanceState);
        setupViewPager(viewPager);

    }

    private void setupWindowAnimations() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        getWindow().setExitTransition(slide);

        Fade fade = new Fade();
        fade.setDuration(2000);
        getWindow().setReturnTransition(fade);

    }

    private void ui(Bundle savedInstanceState) {
        viewPager = findViewById(R.id.viewPager);
        getStartedBtn = findViewById(R.id.getStartedBtn);
        iAlreadyHaveAccBtn = findViewById(R.id.iAlreadyHaveAccBtn);



        getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLearningChoice = new Intent(getBaseContext(),LanguageToLearnChoiceActivity.class);
                startActivity(goToLearningChoice);
            }
        });

        iAlreadyHaveAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginActivity = new Intent(getBaseContext(),LoginActivity.class);
                startActivity(loginActivity);
            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        introSectionsPagerAdapter = new IntroSectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(introSectionsPagerAdapter);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        onBackPressed();
    }


}
