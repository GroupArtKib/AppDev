package com.example.sqliite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Databasehelper db;
    EditText idno,studname,course;
    Button button1;
    Button button4;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new Databasehelper(this);

        studname = findViewById(R.id.studname);
        idno = findViewById(R.id.idno);
        course= findViewById(R.id.course);
        button1 = findViewById(R.id.button1);
        button4 = findViewById(R.id.button4);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        Add();
        viewAll();
        UpdateData();
        DeleteData();
    }
    public  void  DeleteData() {
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = db.deleteData(idno.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void UpdateData () {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = db.updateData(idno.getText().toString(),studname.getText().toString(),course.getText().toString());
                if (isUpdated == true)
                    Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                    else
                    Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

            }
        });
    }
    //Adding data in the table
    public void Add(){
        button1.setOnClickListener(
                v -> {
                    boolean isInserted = db.insertData(idno.getText().toString(),studname.getText().toString(),course.getText().toString());
                    if (isInserted = true)
                        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                }
        );


    }
    public void viewAll() {
        button4.setOnClickListener(
                v -> {
                   Cursor res = db.getAllData();
                   if (res.getCount() == 0) {
                       //show message
                       showMessage("Error","No Data Found");
                       return;
                   }
                   StringBuilder buffer = new StringBuilder();
                   while (res.moveToNext()) {
                       buffer.append("ID :").append(res.getString(0)).append("\n");
                       buffer.append("Student Name: ").append(res.getString(1)).append("\n");
                       buffer.append("Address:").append(res.getString(2)).append("\n\n");

                   }
                   //show all data
                    showMessage("Data",buffer.toString());
                }
        );
    }
    public  void  showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}