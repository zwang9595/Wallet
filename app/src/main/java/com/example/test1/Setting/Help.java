package com.example.test1.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.test1.R;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        final Button contact = (Button) findViewById(R.id.ct);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToContactUs();
            }
        });

        final Button qa = (Button)findViewById(R.id.qa);
        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToQA();
            }
        });
    }

    private void goToContactUs() {
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    private void goToQA() {
        Intent intent = new Intent(this, StillWorking.class);
        startActivity(intent);
    }
}
