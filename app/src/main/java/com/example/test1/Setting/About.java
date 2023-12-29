package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test1.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        final Button v10 = (Button)findViewById(R.id.u1_1);
        v10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTov10();
            }
        });
    }

    private void goTov10() {
        Intent intent = new Intent(this, Version10.class);
        startActivity(intent);
    }
}
