package com.example.thenixelites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText login_email, login_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, Home.class));
            finish();
        }


        setContentView(R.layout.activity_main);

        login_email = (EditText)findViewById(R.id.login_email);
        login_password = (EditText)findViewById(R.id.login_password);



    }


    public void signUp(View view) {

        Intent intent = new Intent(MainActivity.this, SignUp.class);

        startActivity(intent);

    }

    public void login(View view) {

        String email = login_email.getText().toString().trim();
        String password = login_password.getText().toString().trim();

        if (email.isEmpty()){
            login_email.setError("Email is Required");
            login_password.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            login_email.setError("Please Provide Valid Email");
            login_email.requestFocus();
            return;
        }
        if (password.isEmpty()){
            login_password.setError("Password is Required");
            login_password.requestFocus();
            return;
        }
        if (password.length() < 6){
            login_password.setError("Minimum Password Length Should be 6 Characters");
            login_password.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                            if (user.isEmailVerified()){
                                startActivity(new Intent(MainActivity.this, Home.class));
                            }else {
                                user.sendEmailVerification();
                                Toast.makeText(MainActivity.this, "Check Your Email to Verify Your Account", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }


                    }
                });








    }

    public void forgot(View view) {startActivity(new Intent(MainActivity.this, ForgotPassword.class));
    }
}