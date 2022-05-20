package com.example.postolache_predescu_sandur_sasu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public SharedPreferences sharedPreferences_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sharedPreferences_settings = getSharedPreferences("settings", MODE_PRIVATE);

        Button sellerServices = (Button) findViewById(R.id.sellerServices);
        Button services = (Button) findViewById(R.id.services);
        Button cart = (Button) findViewById(R.id.cart);
        Button history = (Button) findViewById(R.id.history);

        if(sharedPreferences.getBoolean("logged", true)){ // este logat
            if(sharedPreferences.getString("role", "").equals("buyer")) {
                Toast.makeText(getApplicationContext(), sharedPreferences.getString("role","").toString(), Toast.LENGTH_LONG).show();

                services.setVisibility(View.VISIBLE);
                cart.setVisibility(View.VISIBLE);
                history.setVisibility(View.VISIBLE);

                cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked on cart".toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                });

                history.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked on history".toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intent);
                    }
                });

                services.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked on services as buyer".toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    }
                });
            }

            if(sharedPreferences.getString("role", "").equals("seller")){
                Toast.makeText(getApplicationContext(), sharedPreferences.getString("role","").toString(), Toast.LENGTH_LONG).show();

                sellerServices.setVisibility(View.VISIBLE);

                sellerServices.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked on seller services".toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, SellerServicesActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
        else { // nu este logat
            services.setVisibility(View.VISIBLE);

            services.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Clicked on services as guest".toString(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(sharedPreferences.getBoolean("logged", false)){ // este logat
            Toast.makeText(getApplicationContext(), "logged", Toast.LENGTH_LONG).show();

            MenuItem itemProfile = menu.findItem(R.id.my_profile);
            itemProfile.setVisible(true);
            MenuItem itemLogout = menu.findItem(R.id.logout);
            itemLogout.setVisible(true);

            MenuItem itemReg = menu.findItem(R.id.register);
            itemReg.setVisible(false);
            MenuItem itemLogin = menu.findItem(R.id.login);
            itemLogin.setVisible(false);
        } else { // nu este logat
            MenuItem itemReg = menu.findItem(R.id.register);
            itemReg.setVisible(true);
            MenuItem itemLogin = menu.findItem(R.id.login);
            itemLogin.setVisible(true);

            MenuItem itemLogout = menu.findItem(R.id.logout);
            itemLogout.setVisible(false);
            MenuItem itemProfile = menu.findItem(R.id.my_profile);
            itemProfile.setVisible(false);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }

        if (id == R.id.login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        if (id == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            sharedPreferences.edit().putBoolean("logged", false).apply();
            startActivity(intent);
        }

        // profilul propriu : poate fi modificat
        if (id == R.id.my_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
//            intent.putExtra("USER_TYPE", sharedPreferences.getString("role", ""));
//            intent.putExtra("EMAIL", sharedPreferences.getString("email", ""));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}