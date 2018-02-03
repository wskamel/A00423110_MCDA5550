package com.example.walee.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;


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
        EditText result =(EditText) findViewById(R.id.txtBMI);

        // new DecimalFormat("$#.00").format(Calc);

        result.setText(String.format( "Value of BMI: %.2f", Calc ) );


    }



}
