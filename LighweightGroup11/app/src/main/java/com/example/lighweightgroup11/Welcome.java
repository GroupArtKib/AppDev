package com.example.lighweightgroup11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        SharedPreferences preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        String display = preferences.getString("display", "");

        disp=findViewById(R.id.Tdisp);
        disp.setText(display);

    }
}