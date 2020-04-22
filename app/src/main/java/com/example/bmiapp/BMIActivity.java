package com.example.bmiapp;

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

    //declarations for elements reponsible for input
    private RadioGroup unitButtons;
    private EditText weightField;
    private EditText heightField;
    private TextView bmiOutput;

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
}
