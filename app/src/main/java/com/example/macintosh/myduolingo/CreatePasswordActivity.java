package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;
import com.example.macintosh.myduolingo.storage.LanguageToLearnData;

public class CreatePasswordActivity extends AppCompatActivity {
    private Button btnContinue;
    private ImageButton btnClose;
    private Intent navIntent;
    private LanguageToLearnEntity languageToLearnObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        ui();
    }

    public void ui() {
        this.btnContinue = findViewById(R.id.btn_continue);
        this.btnClose = findViewById(R.id.btn_back);
        initEventsForm();
    }

    public void initEventsForm() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageToLearnObj  = new LanguageToLearnData().getStudiedLanguage();
                navIntent = new Intent(CreatePasswordActivity.this, UserSessionDashboard.class);
                navIntent.putExtra("STUDIED_LANGUAGE", languageToLearnObj);
                startActivity(navIntent);
                finish();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
