package com.example.sharedprefs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context){
        super(context,"studentdb",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table student (id integer primary key autoincrement ,name text, address text , faculty text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertData(DatabaseModel data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",data.getName());
        cv.put("address",data.getAddress());
        cv.put("faculty",data.getFaculty());

        db.insert("student",null,cv);
    }
}

