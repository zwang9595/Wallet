package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.test1.MainActivity;
import com.example.test1.R;
import com.example.test1.data.mySQLite.MydbHelper;
import com.example.test1.ui.login.LoginTest;
/**
 * Main activity for user
 * Zhao Wang
 * April 08, 2020
 */
public class User_main extends AppCompatActivity {

    private TextView username;
    private static int dbopened = 0;
    public static MydbHelper dbHelper;;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        final ImageButton profile_button = (ImageButton) findViewById(R.id.profile);
        profile_button.bringToFront();

        final Button button1 = (Button) findViewById(R.id.button1);
        final ImageButton wallet = (ImageButton) findViewById(R.id.wallet);
        final ImageButton favorite = (ImageButton) findViewById(R.id.favorite);
        final ImageButton account = (ImageButton) findViewById(R.id.acc);
        final ImageButton notifi = (ImageButton) findViewById(R.id.not);
        final ImageButton help = (ImageButton) findViewById(R.id.help);
        final ImageButton about = (ImageButton) findViewById(R.id.about);
        final Button logoutButton = (Button) findViewById(R.id.signout);

        if(dbopened == 0) {
            dbopened = 1;
            dbHelper = new MydbHelper(this, "Cards.db", null, 1, "Cards");
            db = dbHelper.getWritableDatabase();
        }

        username = (TextView) findViewById(R.id.username);

        username.setText(LoginTest.username);

        if(LoginTest.loggedin != true) {
            logoutButton.setText("Sign in");
            logoutButton.setTextColor(Color.BLACK);
        }

        Cursor cursor = db.rawQuery("SELECT * FROM Cards WHERE name = '" + LoginTest.username + "';", null);
        if(cursor.getCount() < 1) {
            db.execSQL("INSERT INTO Cards(name,card1,card2,card3,card4) values('" + LoginTest.username + "', 0, 0, 0, 0);");
            Wallet.card1 = 0;
            Wallet.card2 = 0;
            Wallet.card3 = 0;
            Wallet.card4 = 0;
        } else {
            cursor.moveToFirst();
            Wallet.card1 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("card1")));
            Wallet.card2 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("card2")));
            Wallet.card3 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("card3")));
            Wallet.card4 = Integer.parseInt(cursor.getString(cursor.getColumnIndex("card4")));
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfileEdit();
            }
        });

        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWallet();
            }
        });

        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFavo();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAcc();
            }
        });

        notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNoti();
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHelp();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAbout();
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(LoginTest.loggedin != true) {
                    signin();
                }
                else {
                    signout();
                }
            }
        });
    }

    private void goToProfileEdit() {
        Intent intent = new Intent(this, StillWorking.class);
        startActivity(intent);
    }

    private void goToWallet() {
        Intent intent = new Intent(this, Wallet.class);
        startActivity(intent);
    }

    private void goToFavo() {
        Intent intent = new Intent(this, StillWorking.class);
        startActivity(intent);
    }

    private void goToAcc() {
        Intent intent = new Intent(this, Account.class);
        startActivity(intent);
        finish();
    }

    private void goToNoti() {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    private void goToHelp() {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    private void goToAbout() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    private void signin() {
        Intent intent = new Intent(this, LoginTest.class);
        startActivity(intent);
    }

    private void signout() {
        LoginTest.loggedin = false;
        LoginTest.username = "Guest";
        MainActivity.user_pressed = false;
        onBackPressed();
        finish();
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        //LoginTest.db.close();
        //LoginTest.dbHelper.close();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}