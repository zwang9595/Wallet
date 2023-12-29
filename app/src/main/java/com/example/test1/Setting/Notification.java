package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.test1.R;

import java.util.Set;

public class Notification extends AppCompatActivity {

    private static int opened = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        final Switch nt = (Switch)findViewById(R.id.switch1);
        if(opened == 0) {
            nt.setChecked(false);
        } else {
            nt.setChecked(true);
        }

        nt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    if(p()) {
                        ask();
                    }
                    opened = 1;
                } else {
                    opened = 0;
                }
            }
        });
    }

    private boolean p() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY) != PackageManager.PERMISSION_GRANTED;
    }

    private void ask() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NOTIFICATION_POLICY},1);
            }
        }
    }
}
