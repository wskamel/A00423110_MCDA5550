package com.example.walee.bmi;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by walee on 2/17/2018.
 */

public class BMIListAdapter extends ArrayAdapter<BMIResult> {

    public BMIListAdapter( Context context, ArrayList<BMIResult> BMIResults){super(context, 0, BMIResults);}




    @Override
    public View getView(int position,  View convertView,  ViewGroup parent){
      //  System.out.println("BMIResults  empty  " +BMIResults.is);
        System.out.println("position is  " +position);
        BMIResult BMIresult = getItem(position);
        if(convertView == null)  {convertView = LayoutInflater.from(getContext()).inflate(R.layout.bmilistlayout, parent, false);}

        TextView RecordDate = (TextView) convertView.findViewById(R.id.txtDateInList);
        TextView RecordHeight = (TextView) convertView.findViewById(R.id.txtHeightInList);
        TextView RecordWeight = (TextView) convertView.findViewById(R.id.txtweightInList);
        TextView RecordBMI = (TextView) convertView.findViewById(R.id.txtBMIInList);

        RecordDate.setText(BMIresult.getDate());
        RecordHeight.setText(String.valueOf(BMIresult.getHeight()));
        RecordWeight.setText(String.valueOf(BMIresult.getWeight()));
        RecordBMI.setText(String.valueOf(BMIresult.getbmi()));

        return convertView;

    }

}




