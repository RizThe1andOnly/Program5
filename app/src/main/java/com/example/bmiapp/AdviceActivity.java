package com.example.bmiapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Class to control the advice activity screen. Will be responsible for presenting the advice and image associated
 * with the current user's bmi.
 *
 * @author Rizwan Chowdhury
 * @author Tin Fung
 */
public class AdviceActivity extends AppCompatActivity {

    //constants necessary for functionalities:
    private final String USER_BMI_CLASSIFICATION = "BMIClass";
    private final String NORMAL_WEIGHT = "normal";
    private final String UNDER_WEIGHT = "Under Weight";
    private final String OVER_WEIGHT = "Over Weight";
    private final String OBESE = "obese";

    //declaration of view elements that will be used by this class:
    private ImageView adviceImageView;
    private TextView adviceTextView;
    private TextView bmiClassTextView;

    /**
     * Called when this activity is created, will obtain intent and intent data from parent and disply
     * appropriate message and image afterwards.
     * @param savedInstanceState instance state of the calling activity
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advicescreen);
        Intent adviceIntentReceived = getIntent();

        //initialize view and data elements to be used for advice presentation:
        adviceImageView = findViewById(R.id.adviceImage);
        adviceTextView = findViewById(R.id.adviceText);
        bmiClassTextView = findViewById(R.id.classView);
        String bmiClass = adviceIntentReceived.getStringExtra(USER_BMI_CLASSIFICATION);

        //method call to display required data:
        presentAdviceNImage(bmiClass);
    }


    /**
     * Will call display the image and the advice associated with the bmi class received from intent.
     * @param bmiClass string representing the bmi classification of the current user
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void presentAdviceNImage(String bmiClass){
        bmiClassTextView.setText(bmiClass);

        if(bmiClass.equals(NORMAL_WEIGHT)){
            adviceTextView.setText(R.string.NORMALWEIGHT_ADVICE);
            adviceImageView.setImageResource(R.drawable.normal);
            return;
        }

        if(bmiClass.equals(UNDER_WEIGHT)){
            adviceTextView.setText(R.string.UNDERWEIGHT_ADVICE);
            adviceImageView.setImageResource(R.drawable.underweight);
            return;
        }

        if(bmiClass.equals(OVER_WEIGHT)){
            adviceTextView.setText(R.string.OVERWEIGHT_ADVICE);
            adviceImageView.setImageResource(R.drawable.overweight);
            return;
        }

        if(bmiClass.equals(OBESE)){
            adviceTextView.setText(R.string.OBESE_ADVICE);
            adviceImageView.setImageResource(R.drawable.obese);
            return;
        }
    }

}
