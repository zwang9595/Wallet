package com.example.test1.data.mySQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.test1.R;
import com.example.test1.ui.login.LoginTest;
/**
 * database test, not used
 * Zhao Wang
 * April 08, 2020
 */
public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        String path = Environment.getExternalStorageState();
        System.out.println(path);

        MydbHelper db = new MydbHelper(this, "Card.db", null, 1, "Cards");

        SQLiteDatabase dd = db.getWritableDatabase();
        dd.beginTransaction();
        String username = "Adams";
        dd.execSQL("INSERT INTO Cards(card, added) values('Adams',1);");
        Cursor cursor = LoginTest.db.rawQuery("SELECT * FROM Cards where card = '" + username + "';", null);
        cursor.moveToFirst();
        System.out.println(cursor.getString(cursor.getColumnIndex("card")));
    }
}
