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
import com.example.test1.ui.login.LoginFormState;
import com.example.test1.ui.login.LoginTest;
import com.example.test1.ui.login.LoginViewModel;
/**
 * Username edit activity
 * Zhao Wang
 * April 08, 2020
 */
public class UsernameEditor extends AppCompatActivity {

    private EditText bar;
    private String username_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username_editor);

        final Button button = (Button)findViewById(R.id.usernamee);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        bar = (EditText)findViewById(R.id.newusername);

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
                username_temp = bar.getText().toString();
                button.setEnabled(LoginViewModel.isUserNameValid(username_temp));
                if(!LoginViewModel.isUserNameValid(username_temp)) {
                    bar.setError("Username must between 1-12 characters");
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
            LoginTest.db.execSQL("Update Users set name = '" + bar.getText().toString() + "' where name = '" + LoginTest.username + "';");
        }
        LoginTest.username = bar.getText().toString();
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
