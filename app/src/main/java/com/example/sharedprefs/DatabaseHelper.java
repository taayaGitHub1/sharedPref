package com.example.sharedprefs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, "studentdb", null, 1);
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
        cv.put("name", data.getName());
        cv.put("address", data.getAddress());
        cv.put("faculty", data.getFaculty());

        db.insert("student", null, cv);
    }

    public ArrayList<DatabaseModel> readData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<DatabaseModel> data = new ArrayList<>();
        Cursor c = db.rawQuery("select * from student", null);
        if (c.moveToFirst()) {
            do {
                DatabaseModel firstread = new DatabaseModel();
                firstread.setId(c.getInt(c.getColumnIndexOrThrow("id")));
                firstread.setName(c.getString(c.getColumnIndexOrThrow("name")));
                firstread.setAddress(c.getString(c.getColumnIndexOrThrow("address")));
                firstread.setFaculty(c.getString(c.getColumnIndexOrThrow("faculty")));
                data.add(firstread);
            } while (c.moveToNext());
        }
        return data;
    }
}

