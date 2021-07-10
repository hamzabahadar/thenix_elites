package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    EditText bmi_height, bmi_weight;
    TextView bmi_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        bmi_height = (EditText)findViewById(R.id.bmi_height);
        bmi_weight = (EditText)findViewById(R.id.bmi_weight);
        bmi_textView = (TextView)findViewById(R.id.bmi_result);





    }

    public void bmiCalculate(View view) {
        String heightString = bmi_height.getText().toString().trim();
        String weightString = bmi_weight.getText().toString().trim();

        if (heightString.isEmpty()){
            bmi_height.setError("Height is Required");
            bmi_height.requestFocus();
            return;
        }


        if (weightString.isEmpty()){
            bmi_weight.setError("Weight is Required");
            bmi_weight.requestFocus();
            return;
        }


        try {
            double heightDouble = Double.parseDouble(heightString);
            double heightInMeter = heightDouble/(double) 100;
            double weightDouble = Double.parseDouble(weightString);

            double calculateBMI = weightDouble / (heightInMeter * heightInMeter);


                int scale = (int) Math.pow(10, 1);
            double finalValue = (double) Math.round(calculateBMI * scale) / scale;


            if (calculateBMI <= 18.5){
                bmi_textView.setText("Your BMI: " + finalValue+ "\n\nYou are Underweight");
            }
            else if(calculateBMI > 18.5 && calculateBMI <= 24.9 ){
                bmi_textView.setText("Your BMI: " + finalValue+ "\n\nYou are Normal");
            }
            else if(calculateBMI >= 25 && calculateBMI <= 29.9 ){
                bmi_textView.setText("Your BMI: " + finalValue+ "\n\nYou are Overweight");
            }
            else if(calculateBMI >= 30 ){
                bmi_textView.setText("Your BMI: " + finalValue+ "\n\nYou are Obese");
            }


        }
        catch (NumberFormatException ex){
            Toast.makeText(this, "Please Provide Correct Data", Toast.LENGTH_SHORT).show();
        }
    }
}