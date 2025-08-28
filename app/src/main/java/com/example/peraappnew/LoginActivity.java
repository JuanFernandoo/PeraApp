package com.example.peraappnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button buttonIngresar = findViewById(R.id.buttonSignup);
        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateIntent = new Intent(LoginActivity.this, UpdateUserActivity.class);
                startActivity(updateIntent);
            }
        });

        TextView resetPasswordText = findViewById(R.id.resetpassword);
        resetPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resetIntent = new Intent(LoginActivity.this, ResetActivity.class);                startActivity(resetIntent);
            }
        });

        TextView signupText = findViewById(R.id.signup);
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signupIntent);
            }
        });
    }
}
