package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test1.R;
import com.example.test1.ui.login.LoginTest;

public class Email extends AppCompatActivity {

    private EditText bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_cc);

        bar = (EditText)findViewById(R.id.newemail);
        final Button button = (Button)findViewById(R.id.emaile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    private void goBack() {
        if(LoginTest.loggedin) {
            LoginTest.db.execSQL("Update Users set email = '" + bar.getText() + "' where name = '" + LoginTest.username + "';");
        } else {
            Account.email = bar.getText().toString();
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
