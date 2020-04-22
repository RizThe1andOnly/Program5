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
    private float userWeight;
    private float userHeight;
    private boolean isMetric;
    private float BMI;
    private int adviceStringID;
    private int adviceImageID;

    //constant required for calculations:
    private float WEIGHT_ADJUSTMENT_FOR_POUNDS = 703;

    //the advice and image paths that will be used for the programs:
      ///  !!! NEEDS TO BE DONE (add in the proper strings and paths as constants)

    /**
     * Constructor for class which will create a BMI object by taking user weight and height as arguments.
     * This method will only store the value in fields, to get BMI values or advice the
     * @param weight weight of the user either in pounds or kilograms
     * @param height height of the user either in inches or centimeters
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public BMI(float weight, float height, boolean isMetric){
        this.userWeight = weight;
        this.userHeight = height;
        this.isMetric = isMetric;
    }


    /**
     * Will calculate and return the BMI of the user.
     * @return user's BMI as a float
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public float getBMI(){
        float adjustedWeight = this.userWeight;
        if(!this.isMetric){
            adjustedWeight = adjustedWeight * WEIGHT_ADJUSTMENT_FOR_POUNDS;
        }

        float bmiVal = adjustedWeight/(this.userHeight*this.userHeight);

        //set the advice items
        setAdvice(bmiVal);
        setAdviceImage(bmiVal);

        return bmiVal;
    }


    /**
     * Will set the advice field of this class based on the bmi
     * @param bmi user's bmi value
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void setAdvice(float bmi){
        // !!! NEEDS TO BE COMPLETED
    }


    /**
     * Will set the advice image field of this object based on the bmi
     * @param bmi user's bmi value
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void setAdviceImage(float bmi){
        // !!! NEEDS TO BE COMPLETED
    }


    /**
     * Will return the string id of the appropriate advice based on user's bmi
     * @return id of the advice for the user
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public int getAdviceID(){
        return this.adviceStringID;
    }


    /**
     * Will return the image id (in resources) of the image that corresponds to the advice the user
     * is receiving
     * @return resource id of the image
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public int getAdviceImageID(){
        return this.adviceImageID;
    }
}
