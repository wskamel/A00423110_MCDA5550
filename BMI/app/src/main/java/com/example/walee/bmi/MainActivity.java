package com.example.walee.bmi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(BMIDATABASE.TABLE_NAME,new String[]
                {"NAME","PASSWORD"},null,null,null,null,null);



        if (cursor.moveToFirst())  {
            String name = cursor.getString(0);
            Password= cursor.getString(1);

            EditText result =(EditText) findViewById(R.id.UserName);
            result.setText(name);
        }


    }

    public void  onClickEvent(View view) {

        EditText weight = (EditText) findViewById(R.id.textPassword);
        String PasswordValue = weight.getText().toString();

        if ( PasswordValue.equals(Password) ) {
            Intent intent = new Intent(this,User_Data.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Password Incorrect!", Toast.LENGTH_SHORT).show();

        }
    }
}
