package com.example.macintosh.myduolingo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DailyGoalActivity extends AppCompatActivity {
    private Button btnContinue;
    private Intent navIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dayli_goal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        ui();
    }

    public void ui(){
        this.btnContinue = findViewById(R.id.btn_continue);
        initEventsForm();
    }

    public void initEventsForm() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navIntent = new Intent(DailyGoalActivity.this, RequestProfileInfoActivity.class);
                startActivity(navIntent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
