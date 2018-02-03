package com.example.walee.bmi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class User_Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__data);

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(BMIDATABASE.TABLE_NAME,new String[]
                {"NAME","PASSWORD","DATE"},null,null,null,null,null);



        if (cursor.moveToFirst())  {
            String name = cursor.getString(0);

            EditText result =(EditText) findViewById(R.id.FirstName);
            result.setText(name);
        }
    }

    public void  onClickEvent2(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void  onClickEvent3(View view) {
        Intent intent = new Intent(this,USER_BMI.class);
        startActivity(intent);
    }




}
