package com.example.checklogin.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Member";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "member";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_ROLE = "role";


    public dbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_FULLNAME + " TEXT, " +
                COLUMN_ROLE + " TEXT)");
        String INSERT_DATA1= "INSERT INTO member(username,password,fullname,role) VALUES('user1','user1','USER ONE', 'USER')";
        db.execSQL(INSERT_DATA1);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

    public void addMember(String username, String password, String fullname, String role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_FULLNAME, fullname);
        contentValues.put(COLUMN_ROLE, role);

        db.insert(TABLE_NAME, null, contentValues);
    }
}
