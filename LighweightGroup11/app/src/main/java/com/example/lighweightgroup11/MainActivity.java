package com.example.lighweightgroup11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText user, pass;

    String sUser;
    String sPass;
    String userDets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.EditUserShared);
        pass = findViewById(R.id.EditPassShared);

    }

    public void clickLogShared(View view) {
        sUser = user.getText().toString();
        sPass = pass.getText().toString();

        SharedPreferences preferences = getSharedPreferences("MyPref", MODE_PRIVATE);


        userDets = preferences.getString(sUser + sPass + "data", "Email or Password is incorrect");
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("display", userDets);
        editor.commit();

        Intent intent = new Intent(MainActivity.this, Welcome.class);
        startActivity(intent);
    }


        public void clickRegShared(View view){
            startActivity(new Intent(this, register.class));
        }
}