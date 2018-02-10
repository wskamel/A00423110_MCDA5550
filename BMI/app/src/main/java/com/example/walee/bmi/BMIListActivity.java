package com.example.walee.bmi;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;

public class BMIListActivity extends ListActivity {

    //Create dummy data until database is ready .. Add to activity
//    BMIResult[] results = {new BMIResult(5.5,100), new BMIResult(4.3,156)};

    ArrayList<BMIResult> results = new ArrayList<BMIResult>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   setContentView(R.layout.activity_bmilist);   // List activity does this

        BMIDATABASE helper = new BMIDATABASE(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query(BMIDATABASE.Tbl_BMIRecords, new String[]
                {"height", "weight", "bmi", "DATE"}, null, null, null, null, null);


        //Add to "onCreate" to initialise the list
        ListView listBMIResults = getListView();

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

        ArrayAdapter<BMIResult> listAdapter = new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,  //layout param for ListActivity
                results);
        listBMIResults.setAdapter(listAdapter);

    }

    //Add to Activity to do something on click
    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id) {
        Toast.makeText(getApplicationContext(), "Clicked on" + results.get(position).toString(), Toast.LENGTH_LONG).show();

    }

}
