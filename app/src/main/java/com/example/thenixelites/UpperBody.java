package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UpperBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_upper_body);
    }

    public void upperbody_beginner(View view) {startActivity(new Intent(UpperBody.this, UpperBody_Beginner.class));
    }

    public void upperbody_intermediate(View view) {startActivity(new Intent(UpperBody.this, UpperBody_Intermediate.class));
    }

    public void upperbody_advanced(View view) {startActivity(new Intent(UpperBody.this, UpperBody_Advanced.class));
    }
}