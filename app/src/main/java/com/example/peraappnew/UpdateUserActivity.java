package com.example.peraappnew;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateUserActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText etName, etLastName, etEmail, etPhone;
    private Button btnUpdate;
    private TextView upNameUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateuser);

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);

        etName = findViewById(R.id.editnamelabel);
        etLastName = findViewById(R.id.editnamelabel5);
        etEmail = findViewById(R.id.editnamelabel3);
        etPhone = findViewById(R.id.editnamelabel6);
        btnUpdate = findViewById(R.id.buttonUpdate);
        upNameUser = findViewById(R.id.nameuser);

        etName.setText(sharedPreferences.getString("name", ""));
        etLastName.setText(sharedPreferences.getString("lastName", ""));
        etEmail.setText(sharedPreferences.getString("email", ""));
        etPhone.setText(sharedPreferences.getString("phone", ""));

        upNameUser.setText(etName.getText().toString() + " " + etLastName.getText().toString());

        btnUpdate.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String lastName = etLastName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (validateFields(name, lastName, email, phone)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("lastName", lastName);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.apply();

                upNameUser.setText(name + " " + lastName);

                Toast.makeText(this, "Datos actualizados", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private boolean validateFields(String name, String lastName, String email, String phone){
        if (name.isEmpty()) {
            etName.setError("El nombre es requerido");
            etName.requestFocus();
            return false;
        }

        if (lastName.isEmpty()) {
            etLastName.setError("Los apellidos son requeridos");
            etLastName.requestFocus();
            return false;
        }

        if (email.isEmpty()) {
            etEmail.setError("El email es requerido");
            etEmail.requestFocus();
            return false;
        }

        if (phone.isEmpty()) {
            etPhone.setError("El telefono es reuqrido");
            etPhone.requestFocus();
            return false;
        }
        return  true;
    }
}
