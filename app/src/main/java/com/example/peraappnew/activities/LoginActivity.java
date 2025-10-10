package com.example.peraappnew.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.peraappnew.R;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button buttonIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.password);
        Button buttonIngresar = findViewById(R.id.buttonLogin);
        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shredPreferencesLogin(etEmail, etPassword);
            }
        });

        TextView resetPasswordText = findViewById(R.id.resetpassword);
        resetPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resetIntent = new Intent(LoginActivity.this, ResetActivity.class);
                startActivity(resetIntent);
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
    private void shredPreferencesLogin(EditText etEmail, EditText etPassword) {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.isEmpty()) {
            etEmail.setError("El correo es obligatorio");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("La contraseña es obligatoria");
            etPassword.requestFocus();
            return;
        }

        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");

        if (email.equals(savedEmail) && password.equals(savedPassword)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }

}
