package com.example.test1.Setting;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test1.R;
import com.example.test1.Setting.Cards.Card1;
import com.example.test1.Setting.Cards.Card2;
import com.example.test1.Setting.Cards.Card3;
import com.example.test1.Setting.Cards.Card4;
/**
 * Wallet, add 4 card now
 * Zhao Wang
 * April 08, 2020
 */
public class Wallet extends AppCompatActivity {

    public static int card1, card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        final Button b_card1 = (Button)findViewById(R.id.card1);
        if(card1 == 0) {
            b_card1.setBackgroundResource(R.drawable.card_rect);
        } else {
            b_card1.setBackgroundResource(R.drawable.card_rect_red);
        }

        final Button b_card2 = (Button)findViewById(R.id.card2);
        if(card2 == 0) {
            b_card2.setBackgroundResource(R.drawable.card_rect);
        } else {
            b_card2.setBackgroundResource(R.drawable.card_rect_blue);
        }

        final Button b_card3 = (Button)findViewById(R.id.card3);
        if(card3 == 0) {
            b_card3.setBackgroundResource(R.drawable.card_rect);
        } else {
            b_card3.setBackgroundResource(R.drawable.card_rect_green);
        }

        final Button b_card4 = (Button)findViewById(R.id.card4);
        if(card4 == 0) {
            b_card4.setBackgroundResource(R.drawable.card_rect);
        } else {
            b_card4.setBackgroundResource(R.drawable.card_rect_yellow);
        }

        b_card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCard1();
            }
        });
        b_card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCard2();
            }
        });
        b_card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCard3();
            }
        });
        b_card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCard4();
            }
        });
    }

    private void goToCard1() {
        Intent intent = new Intent(this, Card1.class);
        startActivity(intent);
        finish();
    }

    private void goToCard2() {
        Intent intent = new Intent(this, Card2.class);
        startActivity(intent);
        finish();
    }

    private void goToCard3() {
        Intent intent = new Intent(this, Card3.class);
        startActivity(intent);
        finish();
    }

    private void goToCard4() {
        Intent intent = new Intent(this, Card4.class);
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
