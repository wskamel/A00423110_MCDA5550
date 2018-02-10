package com.example.walee.bmi;

/**
 * Created by walee on 2/10/2018.
 */

public class BMIResult {
    private double height=1;
    private double weight=1;
    //TODO also add date

    public BMIResult(double height, double weight){
        this.height = height;
        this.weight =weight;

    }

    public double getHeight(){return height;}
    public void setHeight(double height){this.height = height;}
    public double getWeight(){return weight;}
    public void setWeight(){this.weight =weight;}
    public double getResult(){return weight/(height*height);}

    public String toString(){return String.valueOf(getResult());}
}
