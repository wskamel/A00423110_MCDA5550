package com.example.walee.bmi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
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

    public void  clickLogout(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    public void  clickConfirmUserData(View view) {
        boolean invalidData = false;

        EditText name = (EditText) findViewById(R.id.txtName);
        String nameValue = name.getText().toString();

        EditText email = (EditText) findViewById(R.id.txtEmail);
        String emailValue = email.getText().toString();

        EditText dob = (EditText) findViewById(R.id.txtDateOfBirth);
        String dobValue = dob.getText().toString();

        EditText hcn = (EditText) findViewById(R.id.txtHCN);
        String hcnValue = hcn.getText().toString();

        EditText password = (EditText) findViewById(R.id.textUserPassword);
        String passwordValue = password.getText().toString();


        if (nameValue.length()==0 ) {
            name.setError("Name is empty!");
            invalidData = true;     }

        if (emailValue.length()==0 ) {
            email.setError("Email is empty!");
            invalidData = true;     }

        if( emailValue.length()>0 && !emailValue.contains("@") || !emailValue.contains("."))  {
            email.setError("Invalid Email format!");
            invalidData = true;     }

        if (hcnValue.length()==0 ) {
            hcn.setError("Health Card Number is empty!");
            invalidData = true;     }

        if (passwordValue.length()==0 ) {
            password.setError("Password is empty!");
            invalidData = true;     }

        if (passwordValue.length() > 0  && passwordValue.length() < 4 ) {
            password.setError("Password is too short!");
            invalidData = true;     }

            // Date check
        if (dobValue.length()==0 ) {
            dob.setError("Date of Birth is empty!");
            invalidData = true;     }

        if(dobValue.length()>0) {
            if ( TextUtils.isDigitsOnly(dobValue.substring(1,2)) && TextUtils.isDigitsOnly(dobValue.substring(4,5)) && TextUtils.isDigitsOnly(dobValue.substring(7,10))  )

            {   Integer month = Integer.parseInt(dobValue.substring(1,2));
                Integer day = Integer.parseInt(dobValue.substring(4,5));
                Integer year = Integer.parseInt(dobValue.substring(7,10));

            //    if  ( month <1 || month >12  ||  )


            } else  {  dob.setError("Inavlid format for Date of Birth !");
                        invalidData = true;}


        }


        if(!invalidData){

        Intent intent = new Intent(this,USER_BMI.class);
        startActivity(intent); }
    }




}
