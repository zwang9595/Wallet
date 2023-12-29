package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test1.Setting.User_main;
import com.example.test1.ui.login.LoginTest;
/**
 * Main activity for UI test
 * Zhao Wang
 * April 08, 2020
 */
public class MainActivity extends AppCompatActivity {

    public static boolean user_pressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUserMain();
            }
        });
    }

    private void goToUserMain()
    {
        if(LoginTest.loggedin == false && user_pressed == false) {
            Intent intent = new Intent(this, LoginTest.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, User_main.class);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        //super.onBackPressed();  // optional depending on your needs
        moveTaskToBack(true);
    }
}
