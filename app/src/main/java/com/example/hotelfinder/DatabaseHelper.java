package com.example.hotelfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "hotels.db";
    public static final String TABLE_NAME = "room_table";
    public static final String COL_1 = "room_id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "type";
    public static final String COL_4 = "location";
    public static final String COL_5 = "status";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(room_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, location TEXT, status TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String type, String location, String status) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, type);
        contentValues.put(COL_4, location);
        contentValues.put(COL_5, status);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;


    }

    public void DropTable(String table){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Drop table if exists" + table);
    }
}
