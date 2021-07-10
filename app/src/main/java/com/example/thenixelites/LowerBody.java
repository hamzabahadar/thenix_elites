package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LowerBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_lower_body);
    }

    public void lowerbody_beginner(View view) {startActivity(new Intent(LowerBody.this, LowerBody_Beginner.class));
    }

    public void lowerbody_intermediate(View view) {startActivity(new Intent(LowerBody.this, LowerBody_Intermediate.class));
    }

    public void lowerbody_advanced(View view) {startActivity(new Intent(LowerBody.this, LowerBody_Advanced.class));
    }
}