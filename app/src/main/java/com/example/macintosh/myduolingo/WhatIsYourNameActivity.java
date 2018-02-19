package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WhatIsYourNameActivity extends AppCompatActivity {
    private Button btnContinue;
    private ImageButton btnClose;
    private Intent navIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is_your_name);

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
                navIntent = new Intent(WhatIsYourNameActivity.this, WhatIsYourEmailActivity.class);
                startActivity(navIntent);
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
