package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test1.R;
import com.example.test1.ui.login.LoginTest;
import com.example.test1.ui.login.LoginViewModel;

public class Password extends AppCompatActivity {

    private EditText bar;
    private String password_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        final Button button = (Button)findViewById(R.id.passworde);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        bar = (EditText)findViewById(R.id.newpassword);

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                password_temp = bar.getText().toString();
                button.setEnabled(LoginViewModel.isPasswordValid(password_temp));
                if(!LoginViewModel.isPasswordValid(password_temp)) {
                    bar.setError("Password must be >5 characters");
                    button.setTextColor(Color.GRAY);
                } else {
                    button.setTextColor(Color.BLACK);
                }
            }
        };
        bar.addTextChangedListener(afterTextChangedListener);
    }

    private void goBack() {
        if(LoginTest.loggedin) {
            LoginTest.db.execSQL("Update Users set password = '" + bar.getText().toString() + "' where name = '" + LoginTest.username + "';");
        }
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
        finish();
    }
}
