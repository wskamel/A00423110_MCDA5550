package com.example.walee.bmi; /**
 * Created by walee on 2/3/2018.
 */


import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.widget.EditText;

import java.util.Date;

 class BMIDATABASE extends SQLiteOpenHelper{
  private static final String DB_NAME = "inclass";
  private static final int DB_VERSION = 1;
  public static final String TABLE_NAME = "PERSON";
  public BMIDATABASE(Context context){
      super(context,DB_NAME,null,DB_VERSION);
  }
  @Override
     public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"NAME TXT,"
                +"PASSWORD TEXT,"
                +"HEALTH_CARD_NUMB TEXT,"
                +"DATE INTEGER);");

        Date today = new Date();
      ContentValues personValues = new ContentValues();
      personValues.put("NAME","Waleed Moursy");
      personValues.put("PASSWORD","Super Secret");
      personValues.put("HEALTH_CARD_NUMB","1234");
      personValues.put("DATE", today.getTime());

      db.insert(TABLE_NAME,null,personValues);

  }

     @Override
     public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

     }

 }
