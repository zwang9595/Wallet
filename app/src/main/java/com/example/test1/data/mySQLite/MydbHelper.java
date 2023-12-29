package com.example.test1.data.mySQLite;
/**
 * Customized database helper
 * Zhao Wang
 * April 08, 2020
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MydbHelper extends SQLiteOpenHelper {
    private String TB_NAME;
    public MydbHelper(Context context, String name, CursorFactory factory, int version, String TB_NAME) {
        super(context, name, factory, version);
        this.TB_NAME = TB_NAME;
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if(TB_NAME.equals("Users")) {
            db.execSQL("CREATE TABLE IF NOT EXISTS Users (_id integer primary key autoincrement, name varchar, password varchar, phone varchar, email varchar);");
        } else if(TB_NAME.equals("Cards")) {
            db.execSQL("CREATE TABLE IF NOT EXISTS Cards (_id integer primary key autoincrement, name varchar, card1 integer, card2 integer, card3 integer, card4 integer);");
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        switch (oldVersion) {
            case 1:
                if(TB_NAME.equals("Users")) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS Users (_id integer primary key autoincrement, name varchar, password varchar, phone varchar, email varchar);");
                } else if(TB_NAME.equals("Cards")) {
                    db.execSQL("CREATE TABLE IF NOT EXISTS Cards (_id integer primary key autoincrement, name varchar, card1 integer, card2 integer, card3 integer, card4 integer);");
                }
            default:
        }
    }
}
