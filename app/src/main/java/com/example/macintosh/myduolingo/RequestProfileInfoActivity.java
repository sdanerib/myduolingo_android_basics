package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class RequestProfileInfoActivity extends AppCompatActivity {
    private Button btnContinue;
    private Intent navIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_profile_info);

        ui();
    }

    public void ui(){
        this.btnContinue = findViewById(R.id.btn_create_profile);
        initEventsForm();
    }

    public void initEventsForm() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navIntent = new Intent(RequestProfileInfoActivity.this, WhatIsYourNameActivity.class);
                startActivity(navIntent);
            }
        });
    }

}
