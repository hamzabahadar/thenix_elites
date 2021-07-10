package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FullBody extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_full_body);
    }

    public void fullBody_beginner(View view) { startActivity(new Intent(FullBody.this, FullBody_Beginner.class));
    }

    public void fullBody_intermediate(View view) { startActivity(new Intent(FullBody.this, FullBody_Intermediate.class));
    }

    public void fullBody_advanced(View view) { startActivity(new Intent(FullBody.this, FullBody_Advanced.class));
    }
}