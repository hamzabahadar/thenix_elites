package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BMR extends AppCompatActivity {

    private EditText age, height, weight;
    private TextView result;
    private RadioGroup radioGroup;
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_bmr);

        age = (EditText)findViewById(R.id.tv_age);
        height = (EditText)findViewById(R.id.bmi_height);
        weight = (EditText)findViewById(R.id.bmi_weight);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        male = (RadioButton) findViewById(R.id.rb_male);
        female = (RadioButton) findViewById(R.id.rb_female);
        result = (TextView) findViewById(R.id.bmi_result);

    }

    public void calculateBtn(View view) {

        String ageString = age.getText().toString().trim();
        String heightString = height.getText().toString().trim();
        String weightString = weight.getText().toString().trim();

        if (ageString.isEmpty()){
            age.setError("Age is Required");
            age.requestFocus();
            return;
        }
        if (radioGroup.getCheckedRadioButtonId() == -1){
            female.setError("Select Gender");
            female.requestFocus();
            return;
        }
        if (heightString.isEmpty()){
            height.setError("Password is Required");
            height.requestFocus();
            return;
        }
        if (weightString.isEmpty()){
            weight.setError("Password is Required");
            weight.requestFocus();
            return;
        }

        try {
            double ageInt = Double.parseDouble(ageString);
            double heightInt = Double.parseDouble(heightString);
            double weightInt = Double.parseDouble(weightString);

            if (radioGroup.getCheckedRadioButtonId() == findViewById(R.id.rb_male).getId()){
                double bmrMale = 88.362 + (13.397 * weightInt) + (4.799 * heightInt)- (5.677 * ageInt);
                double bmrMaleDeficit = bmrMale * 1.2;
                double bmrMaleMaintenance = bmrMale * 1.5;
                double bmrMaleSurplus = bmrMale * 1.7;

                result.setText("Lose Weight: "+ (int)bmrMaleDeficit+
                        "\n\nMaintain Weight: "+ (int)bmrMaleMaintenance+"" +
                        "\n\nGain Weight: "+(int)bmrMaleSurplus);

            }
            else if(radioGroup.getCheckedRadioButtonId() == findViewById(R.id.rb_female).getId()){
                double bmrFemale = 447.593 + (9.247 * weightInt) + (3.098 * heightInt) - (4.330 * ageInt);
                double femaleDeficit = bmrFemale * 1.2;
                double femaleMaintenance = bmrFemale * 1.5;
                double femaleSurplus = bmrFemale * 1.7;

                result.setText("Lose Weight: "+ (int)femaleDeficit+
                        "\n\nMaintain Weight: "+ (int)femaleMaintenance+"" +
                        "\n\nGain Weight: "+(int)femaleSurplus);

            }
        }
        catch (NumberFormatException ex){
            Toast.makeText(this, "Please Provide Correct Data", Toast.LENGTH_SHORT).show();
        }







    }
}