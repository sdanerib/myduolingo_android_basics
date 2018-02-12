package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UserSessionDashboard extends AppCompatActivity {

    Intent navIntent;
    //private LanguageToLearnEntity languageToLearnObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session_dashboard);
        getUserSessionInfo();
        ui();
    }

    private void getUserSessionInfo() {
        navIntent = getIntent();
        //languageToLearnObj = (LanguageToLearnEntity) navIntent.getSerializableExtra("STUDIED_LANGUAGE");
    }

    private void ui() {
        Toolbar myToolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(myToolbar);

        TextView tviLangToBeLearned = findViewById(R.id.tviToolBarTitle);
        //tviLangToBeLearned.setText(languageToLearnObj.getLangName());
        tviLangToBeLearned.setText("Inglés");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.language_progress_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.closeSession:
                Log.d("MENU", "CLOSE SESSION");
                navIntent = new Intent(this, LoginActivity.class);
                startActivity(navIntent);
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
