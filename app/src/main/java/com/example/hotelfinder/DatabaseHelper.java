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

    public static final String DESCRIPTION = "description";
    public static final String DES_col1 = "room_type";
    public static final String DES_col2 = "no_of_beds";
    public static final String DES_col3 = "no_of_washrooms";
    public static final String DES_col4 = "service_charge";
    public static final String DES_col5 = "wifi";



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

    public boolean add_data_for_roomdescription(String type,int beds,int washrooms,int service,String wifi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DES_col1, type);
        contentValues.put(DES_col2, beds);
        contentValues.put(DES_col3, washrooms);
        contentValues.put(DES_col4, service);
        contentValues.put(DES_col5, wifi);
        long result = db.insert(DESCRIPTION, null, contentValues);
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
