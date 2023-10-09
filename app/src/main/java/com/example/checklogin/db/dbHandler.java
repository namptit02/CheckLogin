package com.example.checklogin.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.checklogin.model.Member;

public class dbHandler {
    private com.example.checklogin.db.dbHelper dbHelper;

    public dbHandler(Context context) {
        dbHelper = new dbHelper(context);
    }

    public void addUser(Member member) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Username", member.getUsername());
        values.put("Password", member.getPassword());
        values.put("FullName", member.getFullName());
        values.put("Role", member.getRole());

        db.insert("Member", null, values);
        db.close();
    }

    public Member checkLogin(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Member member = null;

        String[] columns = {"ID", "Username", "Password", "FullName", "Role"};
        String selection = "Username=? AND Password=?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("Member", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            member = new Member();
            member.setID(cursor.getInt(0));
            member.setUsername(cursor.getString(1));
            member.setPassword(cursor.getString(2));
            member.setFullName(cursor.getString(3));
            member.setRole(cursor.getString(4));
        }

        cursor.close();
        db.close();

        return member;
    }
}
