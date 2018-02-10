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
  private static final String DB_NAME = "bmiclass";
  private static final int DB_VERSION = 1;
  public static final String TABLE_NAME = "PERSON";
  public static final String Tbl_BMIRecords = "BMIRecords";
  public BMIDATABASE(Context context){
      super(context,DB_NAME,null,DB_VERSION);
  }
  @Override
     public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"NAME TEXT,"
                +"EMAIL TEXT,"
                +"PASSWORD TEXT,"
                +"HEALTH_CARD_NUMB TEXT,"
                +"DOB TEXT);");
      System.out.println("Database Created");

        db.execSQL("CREATE TABLE "+Tbl_BMIRecords+"("
              +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
              +"height DOUBLE,"
              +"weight DOUBLE,"
              +"bmi DOUBLE,"
              +"DATE TEXT);");


        Date today = new Date();
      ContentValues personValues = new ContentValues();
      personValues.put("NAME","Waleed Moursy");
      personValues.put("EMAIL","Waleed.Moursy@SMU.CA");
      personValues.put("PASSWORD","Super Secret");
      personValues.put("HEALTH_CARD_NUMB","1234");
      personValues.put("DOB", "5/11/2018");

      db.insert(TABLE_NAME,null,personValues);



  }

     public void StoreBMIRecord(double height,double weight, double bmi, String date){
         ContentValues BMIRecord = new ContentValues();
         BMIRecord.put("height",height);
         BMIRecord.put("weight",weight);
         BMIRecord.put("bmi",bmi);
         BMIRecord.put("DATE", date);
         SQLiteDatabase db = this.getWritableDatabase();
         db.insert(Tbl_BMIRecords,null,BMIRecord

         );     }


     @Override
     public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){

     }

 }
