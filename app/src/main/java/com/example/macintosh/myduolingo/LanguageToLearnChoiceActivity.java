package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;

import com.example.macintosh.myduolingo.ui.ClickListener;
import com.example.macintosh.myduolingo.ui.RecyclerTouchListener;

public class LanguageToLearnChoiceActivity extends AppCompatActivity {

    private Intent navIntent;
    private RecyclerView recyclerViewLanguagesToLearn;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowAnimations();
        setContentView(R.layout.activity_language_to_learn_choice);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ui();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void ui() {
        recyclerViewLanguagesToLearn = findViewById(R.id.recyclerViewLanguages);
        recyclerLayoutManager = new LinearLayoutManager(this);

        recyclerViewLanguagesToLearn.setLayoutManager(recyclerLayoutManager);
        recyclerViewLanguagesToLearn.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewLanguagesToLearn, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void setupWindowAnimations() {
//        Slide slideTransition = new Slide();
//        slideTransition.setSlideEdge(Gravity.LEFT);
//        slideTransition.setDuration(1000);
//        getWindow().setReenterTransition(slideTransition);
//        getWindow().setExitTransition(slideTransition);

        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        slide.setDuration(2000);
        getWindow().setReturnTransition(slide);


    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        navIntent = new Intent(getApplicationContext(), IntroActivity.class);
//        startActivityForResult(navIntent,0);
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
