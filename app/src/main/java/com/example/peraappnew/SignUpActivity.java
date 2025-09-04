package com.example.peraappnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View; // Import View
import android.widget.Button; // Import Button
import android.widget.CheckBox; // Import CheckBox
import android.widget.EditText; // Import EditText
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText etName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etPhone;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private CheckBox cbTerms;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        etName = findViewById(R.id.nameText);
        etLastName = findViewById(R.id.lastname);
        etEmail = findViewById(R.id.emailText);
        etPhone = findViewById(R.id.phone);
        etPassword = findViewById(R.id.passwordsignup);
        etConfirmPassword = findViewById(R.id.confirmpassword);
        cbTerms = findViewById(R.id.termconditions);
        btnSignUp = findViewById(R.id.buttonSignup);

        setupOnclickListeners();
    }

    private void setupOnclickListeners() {
        if (btnSignUp != null) {
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = etName.getText().toString().trim();
                    String lastName = etLastName.getText().toString().trim();
                    String email = etEmail.getText().toString().trim();
                    String phone = etPhone.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();
                    String confirmPassword = etConfirmPassword.getText().toString().trim();
                    boolean termsAccepted = cbTerms.isChecked();

                    if (validateFields(name, lastName, email, phone, password, confirmPassword, termsAccepted)) {
                        keepData(name, lastName, email, phone, password, confirmPassword);

                        Toast.makeText(SignUpActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }

    private boolean validateFields(String name, String lastName, String email, String phone, String password, String confirmPassword, boolean termsAccepted) {
        if (name.isEmpty()) {
            etName.setError("El nombre es requerido");
            etName.requestFocus();
            Toast.makeText(this, "El nombre es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastName.isEmpty()) {
            etLastName.setError("El apellido es requerido");
            etLastName.requestFocus();
            Toast.makeText(this, "El apellido es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (email.isEmpty()) {
            etEmail.setError("El email es requerido");
            etEmail.requestFocus();
            Toast.makeText(this, "El email es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (phone.isEmpty()) {
            etPhone.setError("El teléfono es requerido");
            etPhone.requestFocus();
            Toast.makeText(this, "El teléfono es requerido", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            etPassword.setError("La contraseña es requerida");
            etPassword.requestFocus();
            Toast.makeText(this, "La contraseña es requerida", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirmPassword.isEmpty()) {
            etConfirmPassword.setError("La confirmación de contraseña es requerida");
            etConfirmPassword.requestFocus();
            Toast.makeText(this, "La confirmación de contraseña es requerida", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!termsAccepted) {
            Toast.makeText(this, "Debe aceptar los términos y condiciones", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
    private void keepData(String name, String lastName, String email, String phone, String password, String confirmPassword) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("lastName", lastName);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("password", password);
    }
}