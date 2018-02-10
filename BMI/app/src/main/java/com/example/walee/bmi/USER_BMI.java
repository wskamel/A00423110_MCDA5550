package com.example.walee.bmi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.Date;
import android.content.Context;
import android.content.ContentValues;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.walee.bmi.BMIDATABASE.TABLE_NAME;
import static com.example.walee.bmi.BMIDATABASE.Tbl_BMIRecords;


public class USER_BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__bmi);

    }

    public void  CalcBMI(View view) {

        //get the height
        EditText height = (EditText) findViewById(R.id.textHeight);
        String heightvalue = height.getText().toString();
        Double heightAsint = Double.parseDouble(heightvalue);
        System.out.println("Here is the height " +heightAsint);

        //get the weight

        EditText weight = (EditText) findViewById(R.id.textWeight);
        String weightValue = weight.getText().toString();
        Double weightAsInt = Double.parseDouble(weightValue);
        System.out.println("Here is the weight " +weightAsInt);

        Double Calc = (weightAsInt/(heightAsint*heightAsint));
        System.out.println("Here is the BMI " +Calc);
        EditText result =(EditText) findViewById(R.id.txtBMI);

        // new DecimalFormat("$#.00").format(Calc);

        result.setText(String.format( "Value of BMI: %.2f", Calc ) );

        EditText recordDate = (EditText) findViewById(R.id.RecordDate);
        String recordDateValue = recordDate.getText().toString();
        System.out.println("Here is the Date " +recordDateValue);

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        helper.StoreBMIRecord(heightAsint,weightAsInt, Calc,recordDateValue);


    }



}
