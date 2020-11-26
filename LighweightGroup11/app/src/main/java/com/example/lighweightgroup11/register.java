package com.example.lighweightgroup11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class register extends AppCompatActivity {
    EditText name, email, passw;
    Button reg;

    String rName;
    String rEmail;
    String rPass;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private static final String field_name="Name";
    private static final String field_pass="Password";
    private static final String field_email="Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.EditName);
        email=findViewById(R.id.EditEmail);
        passw=findViewById(R.id.EditPass);
        reg=findViewById(R.id.ButtonReg);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MyPref", MODE_PRIVATE);
                rName=name.getText().toString();
                rEmail=email.getText().toString();
                rPass=passw.getText().toString();

                SharedPreferences.Editor editor=preferences.edit();
                editor.putString(rEmail + rPass + "data", rName + "\n" + rEmail);
                editor.commit();

                Intent intent=new Intent(register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        }
}