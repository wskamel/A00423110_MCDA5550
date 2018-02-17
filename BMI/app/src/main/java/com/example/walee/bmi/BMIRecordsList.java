package com.example.walee.bmi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.walee.bmi.BMIDATABASE.TABLE_NAME;
import static com.example.walee.bmi.BMIDATABASE.Tbl_BMIRecords;

public class BMIRecordsList extends AppCompatActivity {

    ArrayList<BMIResult> results = new ArrayList<BMIResult>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmirecords_list);

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(BMIDATABASE.Tbl_BMIRecords, new String[]
                {"height", "weight", "bmi", "DATE"}, null, null, null, null, null);


        try {
            while (cursor.moveToNext()) {
                String heightvalue = cursor.getString(0);
                Double heightAsint = Double.parseDouble(heightvalue);

                System.out.println("Here is the height " +heightAsint);

                String weightvalue = cursor.getString(1);
                Double weightAsint = Double.parseDouble(weightvalue);
                String bmivalue = cursor.getString(2);
                Double bmiAsint = Double.parseDouble(bmivalue);

                String datevalue = cursor.getString(3);
                Log.d("Result", datevalue);
                results.add(new BMIResult(heightAsint,weightAsint,bmiAsint,datevalue));


            }
        } finally {

        }


        Log.d("Results empty", ""+results.isEmpty() );
        BMIListAdapter adapter = new BMIListAdapter(this, results);
        ListView listView = (ListView) findViewById(R.id.layoutBMIList);
        listView.setAdapter(adapter);


    }

    //Add to Activity to do something on click


    public void  clickDeleteRecords(View view) {

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from "+ Tbl_BMIRecords);

        Intent intent = new Intent(this,BMIRecordsList.class);
        startActivity(intent);

        Toast.makeText(this, "Records deleted", Toast.LENGTH_SHORT).show();
    }

    public void  clickReturnToMenu(View view) {
        Intent intent = new Intent(this,Menu.class);
        startActivity(intent);
    }

}
