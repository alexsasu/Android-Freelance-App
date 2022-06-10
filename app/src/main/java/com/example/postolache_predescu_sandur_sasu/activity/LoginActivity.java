package com.example.postolache_predescu_sandur_sasu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;


public class LoginActivity extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
//    private ActivityLoginBinding binding;

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

//        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_login);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);



//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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
                    String role = "seller";
                    sharedPreferences.edit().putString("role", role).apply();


                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_login);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}