package com.example.test.DbHelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.test.R;

public class DatabaseHelper1 extends SQLiteOpenHelper {

    public static final String Database_Name = "EXPENSE.db";
    public static final String Table_Name = "EXPENSE_TABLE";
    public static final String Col_1 = "ID";
    public static final String COl_2 = "SOURCES";
    public static final String Col_3 = "VALUE";
    public static final String Col_4 ="PRIO";
    public DatabaseHelper1(Context context) {
        super(context, Database_Name, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db1) {
        db1.execSQL("create table " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,SOURCES TEXT,VALUE DOUBLE,PRIO INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(R.string.drop_table + Table_Name);
        onCreate(db);
    }

    public Boolean insertData(String source, double values,int prios)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COl_2, source);

        contentValues.put(Col_3,values);
        contentValues.put(Col_4,prios);

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

    public Boolean updateData(String id,String name, double values,int prios)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(COl_2,name);
        contentValues.put(Col_3,values);
        contentValues.put(Col_4,prios);


        db.update(Table_Name,contentValues,"ID = ?",new String[] { id });
        return true;
    }
    public Integer DeleteData(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name,"ID = ?",new String[] { id });
    }
    
     final DatabaseHandler db = new DatabaseHandler(this);
 
        Button but1 = (Button) findViewById(R.id.insert);
 
        but1.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // Inserting known Languages
                Log.d("Insert: ", "Inserting ..");
                db.add(new values("value1"));
                db.add(new values("value2"));
                db.add(new values("value3"));
                db.add(new values("value4"));
                Log.d("Insert", "DataBase Successfully Updated");
            }
        });
 
        Button but2 = (Button) findViewById(R.id.Read);
 
        but2.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
     
                Log.d("Reading: ", "Reading all data..");
                List<values> val = db.getAllvalues();
 
                for (values cn : val) {
                    String log = "Id: " + cn.getId() + " ,values: "
                            + cn.getValue();
                    Log.d("value: ", log);
                }
            }
        });
}
