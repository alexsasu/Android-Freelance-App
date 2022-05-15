package com.example.postolache_predescu_sandur_sasu;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.postolache_predescu_sandur_sasu.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        EditText login_email = (EditText)  findViewById(R.id.email);
        EditText login_password = (EditText)  findViewById(R.id.password);
        Button login_submit_button = (Button) findViewById(R.id.login);
        
        login_submit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if(login_email.getText().toString().length() == 0) {
                    login_email.setError("Insert mail");
                    okPass = false;
                }

                if(login_password.getText().toString().length() == 0) {
                    login_password.setError("Insert password");
                    okPass = false;
                }


               // TODO: verificare daca mailul exista in baza de date

                if(okPass) {

                    sharedPreferences.edit().putBoolean("logged", true).apply();
                    sharedPreferences.edit().putString("username", login_email.getText().toString()).apply();

                    // TODO: aplic functie de luat rolul
                    String role = "buyer";
                    sharedPreferences.edit().putString("role", role).apply();

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

