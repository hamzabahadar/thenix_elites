package com.example.thenixelites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home);



    }



    public void show_menu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.main_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.logout){
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(Home.this, MainActivity.class));
                }
//                else if(item.getItemId() == R.id.bmrCalculator){
//                    startActivity(new Intent(Home.this, BMR.class));
//                }
//                else if(item.getItemId() == R.id.bmiCalculator){
//                    startActivity(new Intent(Home.this, BMI.class));
//                }
                return true;
            }
        });
    }


    public void fullBody(View view) {
        startActivity(new Intent(Home.this, FullBody.class));
    }

    public void skills_page(View view) {startActivity(new Intent(Home.this, Skills.class));
    }

    public void lowerbody(View view) {startActivity(new Intent(Home.this, LowerBody.class));
    }

    public void upperbody(View view) { startActivity(new Intent(Home.this, UpperBody.class));
    }

    public void bmi(View view) { startActivity(new Intent(Home.this, BMI.class));
    }

    public void bmr(View view) {startActivity(new Intent(Home.this, BMR.class));
    }
}