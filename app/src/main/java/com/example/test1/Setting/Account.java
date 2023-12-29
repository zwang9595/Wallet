package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.test1.R;
import com.example.test1.ui.login.LoginTest;

public class Account extends AppCompatActivity {

    public static String email = "#NA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        final TextView emailS = (TextView)findViewById(R.id.emailS);
        final TextView username = (TextView)findViewById(R.id.usernameS);

        username.setText(LoginTest.username);
        if(LoginTest.loggedin) {
            Cursor cursor = LoginTest.db.rawQuery("SELECT * FROM Users where name = '" + LoginTest.username + "';", null);
            cursor.moveToFirst();
            String email = cursor.getString(cursor.getColumnIndex("email"));
            cursor.close();
            if(!email.equals("NA0")) {
                emailS.setText(email);
            }
        } else {
            emailS.setText(this.email);
        }

        final ImageButton email_button = (ImageButton)findViewById(R.id.emailb);
        final ImageButton password_button = (ImageButton)findViewById(R.id.passwordb);
        final ImageButton username_button = (ImageButton)findViewById(R.id.usernameb);

        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEmail();
            }
        });
        username_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUsername();
            }
        });
        password_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPassword();
            }
        });
    }

    private void goToEmail() {
        Intent intent = new Intent(this, Email.class);
        startActivity(intent);
        finish();
    }

    private void goToUsername() {
        Intent intent = new Intent(this, UsernameEditor.class);
        startActivity(intent);
        finish();
    }

    private void goToPassword() {
        Intent intent = new Intent(this, Password.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, User_main.class);
        startActivity(intent);
        finish();
    }
}
