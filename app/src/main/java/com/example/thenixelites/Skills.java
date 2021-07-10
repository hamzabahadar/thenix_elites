package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Skills extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_skills);
    }

    public void handstand(View view) {
        startActivity(new Intent(Skills.this, Handstand.class));
    }

    public void frontlever(View view) { startActivity(new Intent(Skills.this, FrontLever.class));
    }

    public void lsit(View view) { startActivity(new Intent(Skills.this, LSit.class));
    }

    public void backlever(View view) {startActivity(new Intent(Skills.this, BackLever.class));
    }

    public void fullPlanche(View view) {startActivity(new Intent(Skills.this, Planche.class));
    }

    public void humanflag(View view) {startActivity(new Intent(Skills.this, HumanFlag.class));
    }

    public void muscleUp(View view) {startActivity(new Intent(Skills.this, MuscleUp.class));
    }
}