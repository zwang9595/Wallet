package com.example.test1.Setting.Cards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test1.R;
import com.example.test1.Setting.User_main;
import com.example.test1.Setting.Wallet;
import com.example.test1.ui.login.LoginTest;

public class Card3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card3);

        final Button add = (Button)findViewById(R.id.add);
        final Button remove = (Button)findViewById(R.id.remove);
        if(Wallet.card3 == 0) {
            remove.setEnabled(false);
            remove.setBackgroundResource(R.drawable.card_rect);
        } else {
            add.setEnabled(false);
            add.setBackgroundResource(R.drawable.card_rect);
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remove();
            }
        });
    }

    private void Add() {
        Wallet.card3 = 1;
        if(LoginTest.loggedin) {
            User_main.db.execSQL("Update Cards set card3 = 1 where name = '" + LoginTest.username + "';");
        }
        onBackPressed();
    }

    private void Remove() {
        Wallet.card3 = 0;
        if(LoginTest.loggedin) {
            User_main.db.execSQL("Update Cards set card3 = 0 where name = '" + LoginTest.username + "';");
        }
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Wallet.class);
        startActivity(intent);
        finish();
    }
}
