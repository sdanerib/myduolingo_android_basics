package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;
import com.example.macintosh.myduolingo.storage.LanguageToLearnData;
import com.example.macintosh.myduolingo.ui.ClickListener;
import com.example.macintosh.myduolingo.ui.RecyclerTouchListener;
import com.example.macintosh.myduolingo.ui.adapters.DuolingoBehaviourInterface;
import com.example.macintosh.myduolingo.ui.adapters.LanguageCoursesAdapter;

import java.io.Serializable;
import java.util.List;

public class LanguageToLearnChoiceActivity extends AppCompatActivity implements DuolingoBehaviourInterface{

    private Intent navIntent;
    private RecyclerView recyclerViewLanguagesToLearn;
    private RecyclerView.LayoutManager recyclerLayoutManager;

    private LanguageToLearnData dataEntry;
    private List<LanguageToLearnEntity> languageToLearnEntityList;
    private LanguageCoursesAdapter languageCoursesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setupWindowAnimations();
        setContentView(R.layout.activity_language_to_learn_choice);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ui();
        loadLanguageCourses();

    }

    private void loadLanguageCourses() {
        dataEntry = new LanguageToLearnData();
        languageToLearnEntityList = dataEntry.generateLanguagesList();
        dataEntry.logAllArrayElements(languageToLearnEntityList);

        renderLanguageCoursesList();
    }

    private void renderLanguageCoursesList() {
        dataEntry.logAllArrayElements(languageToLearnEntityList);
        languageCoursesAdapter = new LanguageCoursesAdapter(languageToLearnEntityList, this, this);
        recyclerViewLanguagesToLearn.setAdapter(languageCoursesAdapter);
    }

    private void ui() {
        recyclerViewLanguagesToLearn = findViewById(R.id.recyclerViewLanguages);

        recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerViewLanguagesToLearn.setLayoutManager(recyclerLayoutManager);

        recyclerViewLanguagesToLearn.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewLanguagesToLearn, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                try{

                   LanguageToLearnEntity languageToLearn = languageToLearnEntityList.get(position);
                   goToDailyGoalSettings(languageToLearn);

                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void goToDailyGoalSettings(LanguageToLearnEntity chosenLanguageToLearn) {
        navIntent = new Intent(this, DailyGoalActivity.class);
        navIntent.putExtra("CHOSEN_LANG_TO_LEARN", (Serializable) chosenLanguageToLearn);

        startActivity(navIntent);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void chooseLanguageToLearn(int languageDescPosition, String languageName) {

    }

    /*private void setupWindowAnimations() {
//        Slide slideTransition = new Slide();
//        slideTransition.setSlideEdge(Gravity.LEFT);
//        slideTransition.setDuration(1000);
//        getWindow().setReenterTransition(slideTransition);
//        getWindow().setExitTransition(slideTransition);

*//*
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        slide.setDuration(2000);
        getWindow().setReturnTransition(slide);
*//*

    }*/
}
