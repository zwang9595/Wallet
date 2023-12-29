package com.example.test1.data;

import com.example.test1.data.model.LoggedInUser;
import com.example.test1.ui.login.LoginTest;

import java.io.IOException;
import android.database.Cursor;
import android.util.Log;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication\
            if (!isAdded(username)) {
                LoginTest.db.execSQL("INSERT INTO Users(name,password,phone,email) values('" + username + "', '" + password + "', 'NA0', 'NA0');");
                return new Result.Success<>(new LoggedInUser(java.util.UUID.randomUUID().toString(), username));
            } else {
                Cursor cursor = LoginTest.db.rawQuery("SELECT * FROM Users where name = '" + username + "';", null);
                cursor.moveToFirst();
                String passwordt = cursor.getString(cursor.getColumnIndex("password"));
                Log.d("gg",passwordt);
                cursor.close();
                if (password.equals(passwordt)) {
                    return new Result.Success<>(new LoggedInUser(java.util.UUID.randomUUID().toString(), username));
                } else {
                    return new Result.Error(new IOException("Password is wrong."));
                }
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    private boolean isAdded(String username) {
        Cursor count = LoginTest.db.rawQuery("SELECT count(*) FROM Users;", null);
        count.moveToFirst();
        if(count.getInt(0) == 0) {
            count.close();
            return false;
        } else {
            count.close();
            Cursor cursor = LoginTest.db.rawQuery("SELECT name FROM Users;", null);
            String namet = "";
            while(cursor.moveToNext()) {
                namet = cursor.getString(cursor.getColumnIndex("name"));
                if(namet.equals(username)) {
                    cursor.close();
                    return true;
                }
            }
            cursor.close();
        }
        return false;
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
