package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class LanguageToLearnChoiceActivity extends AppCompatActivity {

    private Intent navIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_to_learn_choice);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        navIntent = new Intent(getApplicationContext(), IntroActivity.class);
        startActivityForResult(navIntent,0);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
