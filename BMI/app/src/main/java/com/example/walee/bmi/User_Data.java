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
                {"NAME","EMAIL","PASSWORD","HEALTH_CARD_NUMB","DOB"},null,null,null,null,null);



   //     if (cursor.moveToFirst())  {

        try {
            while (cursor.moveToNext()) {
            String name = cursor.getString(0);
            EditText Username =(EditText) findViewById(R.id.txtName);
            Username.setText(name);

            String email = cursor.getString(1);
            EditText UserEmail =(EditText) findViewById(R.id.txtEmail);
                UserEmail.setText(email);

            String password = cursor.getString(2);
            EditText userPassword =(EditText) findViewById(R.id.textUserPassword);
            userPassword.setText(password);

            //HCN is HEALTH_CARD_NUMB
            String HCN = cursor.getString(3);
            EditText userHCN =(EditText) findViewById(R.id.txtHCN);
                userHCN.setText(HCN);

            //DOB is Date Of Birth
            String DOB = cursor.getString(4);
            EditText userDOB =(EditText) findViewById(R.id.txtDateOfBirth);
                userDOB.setText(DOB);


        }} finally {}
    }

    public void  onClickEvent2(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void  onClickEvent3(View view) {
        Intent intent = new Intent(this,USER_BMI.class);
        startActivity(intent);
    }

    public void  onClickNavToBMIList(View view) {
        Intent intent = new Intent(this,BMIListActivity.class);
        startActivity(intent);
    }



}
