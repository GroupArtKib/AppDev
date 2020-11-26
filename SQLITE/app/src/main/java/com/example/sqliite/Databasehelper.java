package com.example.sqliite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="student.db";
    public static final String TABLE_NAME = "student_record";
    public static final String STUDENTS ="ID";
    public static final String STUDENT ="studentname";
    public static final String COURSE_YR ="courseyr";

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, 4);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY, studentname TEXT, courseyr TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String ID, String studentname, String courseyr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENTS,ID);
        contentValues.put(STUDENT,studentname);
        contentValues.put(COURSE_YR,courseyr);
       long result = db.insert(TABLE_NAME,null,contentValues);
        return result != -1;

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from "+TABLE_NAME,null);

    }
    public boolean updateData(String ID, String studentname, String courseyr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENTS,ID);
        contentValues.put(STUDENT,studentname);
        contentValues.put(COURSE_YR,courseyr);
        db.update("student_record",contentValues,"ID = ?",new String[] {ID});
        return true;


    }
    public Integer deleteData (String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {ID});


    }
}
