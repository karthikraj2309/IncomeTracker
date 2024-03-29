package com.example.test.DbHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.xml.transform.Source;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "INCOME.db";
    public static final String Table_Name = "INCOME_TABLE";
    public static final String Col_1 = "ID";
    public static final String COl_2 = "SOURCES";
    public static final String Col_3 = "VALUE";


    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,SOURCES TEXT,VALUE DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + Table_Name);
        onCreate(db);
    }

    public Boolean insertData(String source, double values)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2, source);

        contentValues.put(Col_3,values);
        long result = db.insert(Table_Name, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+Table_Name,null);
        return res;
    }


    public Boolean updateData(String id,String name, double values)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(COl_2,name);
        contentValues.put(Col_3,values);

        db.update(Table_Name,contentValues,"ID = ?",new String[] { id });
        return true;
    }

    public Integer DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name,"ID = ?",new String[] { id });
    }
    
    private static final int DATABASE_VERSION = 1;
 
    private static final String DATABASE_NAME = "Value";
 
    private static final String TABLE_Languages = "Values";
 
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "value";
 
    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE;
 
        CREATE_CONTACTS_TABLE = "create table " + TABLE_Languages + "("
                + KEY_ID + " integer primary key autoincrement, " + KEY_NAME
                + " text not null);";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Languages);
        onCreate(db);
    }
 
    public void add(Values lang) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, lang.getValue());
 
        db.insert(TABLE_Languages, null, values);
        db.close(); // Closing database connection
    }
 
    // Updating single record
    public int update(Values value) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, value.getValue());
 
    
        return db.update(TABLE_Languages, values, KEY_ID + " = ?",
                new String[] { String.valueOf(value.getId()) });
    }
}
