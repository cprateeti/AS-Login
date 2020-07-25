package com.example.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Db extends SQLiteOpenHelper {
    SQLiteDatabase sq;
    ArrayList a1;
    public Db(Context context) {
        super(context, "info.db",null, 1);
        sq = getWritableDatabase();
        a1=new ArrayList();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(Name text,Password text,ConfirmPassword text,Mobile text,ssn text,aadhar text,nationality text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void savedata(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        ContentValues cv = new ContentValues();
        cv.put("Name",s1);
        cv.put("Password",s2);
        cv.put("ConfirmPassword",s3);
        cv.put("Mobile",s4);
        cv.put("ssn",s5);
        cv.put("aadhar",s6);
        cv.put("nationality",s7);
        sq.insert("users",null,cv);
    }

    public ArrayList myname(String r) {
        Cursor c;
        c=sq.query("users",null,"Name=?",new String[]{r},null,null,null);
        c.moveToFirst();
        if(c.getCount()<1){
            a1.clear();
            a1.add("Not exist");
            return a1;
        }
        else {
            a1.clear();
            a1.add(c.getString(c.getColumnIndex("Name")));
            a1.add(c.getString(c.getColumnIndex("Password")));
            a1.add(c.getString(c.getColumnIndex("ConfirmPassword")));
            a1.add(c.getString(c.getColumnIndex("Mobile")));
            a1.add(c.getString(c.getColumnIndex("ssn")));
            a1.add(c.getString(c.getColumnIndex("aadhar")));
            a1.add(c.getString(c.getColumnIndex("nationality")));


            return a1;
        }
    }
}
