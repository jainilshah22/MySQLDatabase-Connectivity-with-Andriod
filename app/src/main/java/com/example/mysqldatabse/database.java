package com.example.mysqldatabse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    private static  final String database_name = "student.db";
    private static  final int db_version = 1;
    private static  final String table_name = "Student_data";
    private static  final String s_name = "Student_name";
    private static  final String s_branch = "Student_branch";
    private static  final String create_query = "Create table "+table_name + "("+ s_name+" text,"+s_branch+" text"+")";


    public database(@Nullable Context context) {
        super(context, database_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + table_name);
        onCreate(db);

    }

    public void add_student(String name, String branch){

        SQLiteDatabase sqldb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(s_name,name);
        cv.put(s_branch,branch);
        sqldb.insert(table_name,null,cv);
    }

    public ArrayList<String> get_student(){
        ArrayList<String> a1 = new ArrayList<String>();
        SQLiteDatabase sq1 = this.getReadableDatabase();
        Cursor c = sq1.rawQuery("select * from "+ table_name,null);
        c.getString(0);
        return a1;

    }
}
