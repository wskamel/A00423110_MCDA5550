package com.example.walee.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class User_Data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__data);
    }

    public void  onClickEvent2(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
