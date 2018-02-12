package com.example.macintosh.myduolingo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.macintosh.myduolingo.models.LanguageToLearnEntity;
import com.example.macintosh.myduolingo.storage.LanguageToLearnData;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    private String ACCESS_LOGIN = "DUOLINGO";
    private LanguageToLearnEntity languageToLearnObj;
    private Intent navIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);

        ui();
    }

    public void ui() {
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);

        initEventsForm();
    }

    public void initEventsForm() {
        txtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isFormValid();
            }
        });

        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                isFormValid();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                if (isFormValid()) {
                    if (txtUsername.getText().toString().equals(ACCESS_LOGIN) && txtPassword.getText().toString().equals(ACCESS_LOGIN)){
                        //clearForm();
                        //Toast.makeText(LoginActivity.this, getString(R.string.txt_login_successful), Toast.LENGTH_SHORT).show();
                        languageToLearnObj  = new LanguageToLearnData().getStudiedLanguage();
                        navIntent = new Intent(LoginActivity.this, UserSessionDashboard.class);
                        navIntent.putExtra("STUDIED_LANGUAGE", languageToLearnObj);
                        startActivity(navIntent);
                        finish();

                    }else{
                        txtPassword.setError(getString(R.string.txt_wrong_username_or_password));
                    }
                }
            }
        });
    }

    public Boolean isFormValid() {
        String username = txtUsername.getText().toString().trim();
        if (username.isEmpty()) {
            setEnabledBtnLogin(false);
            return false;
        }

        String password = txtPassword.getText().toString().trim();
        if (password.length() < 6) {
            setEnabledBtnLogin(false);
            return false;
        }

        setEnabledBtnLogin(true);
        return true;
    }

    public void setEnabledBtnLogin(Boolean enabled){
        btnLogin.setTextColor( enabled ? getColor(R.color.creme) : getColor(R.color.btnDisabled));
        btnLogin.setEnabled(enabled);
    }

    public void clearForm(){
        txtPassword.setText("");
        txtUsername.setText("");
        setEnabledBtnLogin(false);
    }

    private void hideKeyboard() {
        ((InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE))
                .toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
