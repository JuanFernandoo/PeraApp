package com.example.peraappnew.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.peraappnew.R;

public class UpdateUserFragment extends Fragment {

    private SharedPreferences sharedPreferences;
    private EditText etName, etLastName, etEmail, etPhone;
    private Button btnUpdate;
    private TextView upNameUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.updateuser, container, false);

        sharedPreferences = requireActivity().getSharedPreferences("UserData", Context.MODE_PRIVATE);

        etName = view.findViewById(R.id.editnamelabel);
        etLastName = view.findViewById(R.id.editnamelabel5);
        etEmail = view.findViewById(R.id.editnamelabel3);
        etPhone = view.findViewById(R.id.editnamelabel6);
        btnUpdate = view.findViewById(R.id.buttonUpdate);
        upNameUser = view.findViewById(R.id.nameuser);

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

            if (validateFields(name, lastName, email, phone)) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name);
                editor.putString("lastName", lastName);
                editor.putString("email", email);
                editor.putString("phone", phone);
                editor.apply();

                upNameUser.setText(name + " " + lastName);

                Toast.makeText(requireContext(), "Datos actualizados", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private boolean validateFields(String name, String lastName, String email, String phone) {
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
            etPhone.setError("El teléfono es requerido");
            etPhone.requestFocus();
            return false;
        }
        return true;
    }
}