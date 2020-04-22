package com.example.bmiapp;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Class which will control and run the main activity (starting screen). Will handle the functionalities including reading
 * user input and creating bmi object to get bmi data for user.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class BMIActivity extends AppCompatActivity {

    //constants used for some of the following procedures:
    private final String TWO_DECIMAL_PLACES_FORMATTER = "%.2f";

    //fields for calculation and info storage purposes:
    private double userWeight;
    private double userHeight;
    private boolean isMetric;
    private BMI userBMIData;

    //declarations for elements responsible for input
    private RadioGroup unitButtons;
    private EditText weightField;
    private EditText heightField;
    private TextView bmiOutput;
    private RadioButton metricButton;

    /**
     * the functionalities that run as soon as the page starts; includes setting default values as well as providing this
     * controller with references to elements on screen responsible for obtaining input.
     * @param savedInstanceState previous saved state(if exists)
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        initializeElements(); //sets the declared values to their respective elements
        initializeDefaultValues();//initialize the declared elements with their on-screen counterparts

    }


    /**
     * Called by onCreate to set the declared global variables to their on-screen counterparts
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void initializeElements(){
        unitButtons = (RadioGroup) findViewById(R.id.unitsGroup);
        weightField = (EditText) findViewById(R.id.enterWeightField);
        heightField = (EditText) findViewById(R.id.enterHeightField);
        bmiOutput = (TextView) findViewById(R.id.bmiView);
        metricButton = (RadioButton) findViewById(R.id.metricUnits);
    }


    /**
     * Called by onCreate to set initial values for input fields (if necessary)
     * @author Rizwan Chowdhury
     */
    private void initializeDefaultValues(){
        hintSetter(); //sets the hints for the input text fields at program's start
        setDefaultBMIReading();

    }


    /**
     * Sets the edit text hints based on the currently selected option for units of measurement. The selected units of
     * measurement is obtained from the selection of one of the two radio buttons.
     * @author Rizwan Chowdhury
     */
    private void hintSetter(){
        int selectedId = unitButtons.getCheckedRadioButtonId();
        if(selectedId == R.id.metricUnits){
            weightField.setHint(R.string.WEIGHT_METRIC_HINT);
            heightField.setHint(R.string.HEIGHT_METRIC_HINT);
        }
        else{
            weightField.setHint(R.string.WEIGHT_ENGLISH_HINT);
            heightField.setHint(R.string.HEIGHT_ENGLISH_HINT);
        }

    }


    /**
     * Sets the initial text value of the bmi output field to 0.00 at the start of the program or
     * when needed.
     * @author Tin Fung
     */
    private void setDefaultBMIReading(){
        float defVal = 0;
        CharSequence bmiOutputText = String.format(TWO_DECIMAL_PLACES_FORMATTER,String.valueOf(defVal));
        bmiOutput.setText(bmiOutputText);
    }


    /**
     * provides the user with BMI value when BMI button pressed. Will also conduct checks for proper input through
     * validInputFields() method.
     * @param view instance of the bmi activity that calls this method thru button press
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    public void getBmiButtonClick(View view){
        this.isMetric = areUnitsMetric();

        if(!validInputFields()){ //input is not valid: do nothing except for sending error message
            // !!! NEEDS TO BE COMPLETED: USE TOAST CLASS TO SEND ERROR MESSAGE TO USER

            return;
        }

        this.userBMIData = new BMI(this.userWeight,this.userHeight,this.isMetric);
    }


    /**
     * Sets the isMetric field of object based on radio button selection.
     * @return true if kg/cm radio button is selected; false otherwise
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private boolean areUnitsMetric(){
        return metricButton.isSelected();
    }


    /**
     * Checks for valid input. Valid input includes having any input at all and having numeric input.
     * @return true if the input is valid; false otherwise
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private boolean validInputFields(){
        //get contents of the input field
        String weightFieldContent = this.weightField.getText().toString();
        String heightFieldContent = this.heightField.getText().toString();

        //check if the input fields have been filled
        if( (weightFieldContent.equals("")) || (heightFieldContent.equals("")) ){//no input at all
            return false;
        }

        //check if inputs are in proper numeric format
        try{
            validNumericFormat(weightFieldContent,heightFieldContent);
        }catch (NumberFormatException e){ //means input is not valid, hence false is returned for valid input
            return false;
        }

        return true; //at this point input is valid
    }


    /**
     * Verifies whether the input has proper numeric format. If there is proper numeric format the method will
     * set the associated class variables with those values.
     * @param weightContent string form of the weight input received from the user
     * @param heightContent string form of the height input received from the user
     * @throws NumberFormatException exception if the input is not in proper numeric format
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void validNumericFormat(String weightContent, String heightContent) throws NumberFormatException{
        this.userWeight = Double.parseDouble(weightContent);
        this.userHeight = Double.parseDouble(heightContent);
    }
}
