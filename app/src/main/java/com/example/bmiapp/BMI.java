package com.example.bmiapp;

/**
 * Class calculates and holds BMI data. Upon construction will receive necessary information to calculate value
 * of user's bmi and will do so. Will also store the advice for each of the bmi classes. Will hold the bmi value and
 * advice pertaining to user in fields that will be accessed by other classes.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class BMI {

    //fields to hold user-specific data:
    private double userWeight;
    private double userHeight;
    private boolean isMetric;
    private double BMI;

    //constant required for calculations:
    private final int WEIGHT_ADJUSTMENT_FOR_POUNDS = 703;
    private final double NORMAL_WEIGHT_BMI = 18.5;
    private final double OVERWEIGHT_BMI = 25;
    private final double OBESE_BMI = 30;

    //constants for classification:
    private final String NORMAL_WEIGHT = "Normal";
    private final String UNDER_WEIGHT = "Under Weight";
    private final String OVER_WEIGHT = "Over Weight";
    private final String OBESE = "Obese";

    /**
     * Constructor for class which will create a BMI object by taking user weight and height as arguments.
     * This method will only store the value in fields, to get BMI values or advice the
     * @param weight weight of the user either in pounds or kilograms
     * @param height height of the user either in inches or centimeters
     * @param isMetric are the given units in metric units or not (english units)
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public BMI(double weight, double height, boolean isMetric){
        this.userWeight = weight;
        this.userHeight = height;
        this.isMetric = isMetric;
    }


    /**
     * Will calculate and return the BMI of the user.
     * @return user's BMI as a double
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public double getBMI(){
        double adjustedWeight = this.userWeight;
        if(!this.isMetric){
            adjustedWeight = adjustedWeight * WEIGHT_ADJUSTMENT_FOR_POUNDS;
        }

        double bmiVal = adjustedWeight/(this.userHeight*this.userHeight);

        //sets the bmi value of class
        this.BMI = bmiVal;
        return bmiVal;
    }


    /**
     * Will set the advice  of this class based on the bmi
     * @return string indicating the class of bmi user belongs to
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public String getAdvice(){
        if(this.BMI<NORMAL_WEIGHT_BMI){
            return UNDER_WEIGHT;
        }
        else if(this.BMI<OVERWEIGHT_BMI){
            return NORMAL_WEIGHT;
        }
        else if(this.BMI<OBESE_BMI){
            return OVER_WEIGHT;
        }
        else{
            return OBESE;
        }
    }

}
