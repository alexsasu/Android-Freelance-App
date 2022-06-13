package com.example.freelance4all.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.User;
import com.example.freelance4all.model.ViewUser;


public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText login_email;
    private EditText login_password;
    private Button login_submit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        login_email = findViewById(R.id.email);
        login_password = findViewById(R.id.password);
        login_submit_button = findViewById(R.id.login);

        ViewUser viewUser = ViewModelProviders.of(this).get(ViewUser.class);

        login_submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if(login_email.getText().toString().length() == 0) {
                    login_email.setError("Insert an e-mail address.");
                    okPass = false;
                }

                if(login_password.getText().toString().length() == 0) {
                    login_password.setError("Insert a password.");
                    okPass = false;
                }

//                 TODO: verificare daca mailul exista in baza de date - done
                if(!viewUser.checkEmailPass(login_email.getText().toString(), login_password.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "This is not a valid account, try to reenter your credentials or register.", Toast.LENGTH_LONG).show();
                    okPass = false;
                } else {
                    User user = viewUser.getUserByEmail(login_email.getText().toString());
                    if (user.getDeleted()) {
                        Toast.makeText(getApplicationContext(), "This is not a valid account, try to reenter your credentials or register.", Toast.LENGTH_LONG).show();
                        okPass = false;
                    }
                }

                if(okPass) {
                    sharedPreferences.edit().putBoolean("logged", true).apply();
                    sharedPreferences.edit().putString("email", login_email.getText().toString()).apply();

                    // TODO: aplic functie de luat rolul - done
                    String role = viewUser.getTypeByEmail(login_email.getText().toString());

                    sharedPreferences.edit().putString("role", role).apply();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}