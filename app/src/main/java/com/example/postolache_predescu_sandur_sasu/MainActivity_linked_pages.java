package com.example.postolache_predescu_sandur_sasu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.postolache_predescu_sandur_sasu.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public SharedPreferences sharedPreferences_settings;

    private  Button services ;
    // ca seller, vad serviciile proprii si pot sa inserez / sterg / modific
    // ca buyer / guest, vad serviciile tuturor si pot sa le accesez
    private Button cart;
    private Button history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sharedPreferences_settings = getSharedPreferences("settings", MODE_PRIVATE);
        services = (Button) findViewById(R.id.services);
        cart = (Button) findViewById(R.id.cart);
        history = (Button) findViewById(R.id.history);


        Toast.makeText(getApplicationContext(), sharedPreferences.getString("role","").toString(), Toast.LENGTH_LONG).show();

        if(sharedPreferences.getBoolean("logged", true)){ // este logat

            if(sharedPreferences.getString("role", "").equals("buyer")) {

                cart.setVisibility(View.VISIBLE);
                history.setVisibility(View.VISIBLE);

                cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                });

                history.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(intent);
                    }
                });
            }
            if(sharedPreferences.getString("role", "").equals("seller")){
                services.setVisibility(View.INVISIBLE);
            }

            }
            else{  // nu este logat

                cart.setVisibility(View.INVISIBLE);
                history.setVisibility(View.INVISIBLE);
                services.setVisibility(View.VISIBLE);

                services.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Clicked on services!!!!!!".toString(), Toast.LENGTH_LONG).show();
    //                        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
    //                        startActivity(intent);
                    }
                });

            }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if(sharedPreferences.getBoolean("logged", false)){   // este logat
            Toast.makeText(getApplicationContext(), "logged", Toast.LENGTH_LONG).show();

            MenuItem itemLogout = menu.findItem(R.id.logout);
            itemLogout.setVisible(true);
            MenuItem itemReg = menu.findItem(R.id.register);
            itemReg.setVisible(false);
            MenuItem itemLogin = menu.findItem(R.id.login);
            itemLogin.setVisible(false);
            MenuItem itemProfile = menu.findItem(R.id.my_profile);
            itemProfile.setVisible(true);
        }
        else{  // nu este logat
            MenuItem itemLogout = menu.findItem(R.id.logout);
            itemLogout.setVisible(false);
            MenuItem itemReg = menu.findItem(R.id.register);
            itemReg.setVisible(true);
            MenuItem itemLogin = menu.findItem(R.id.login);
            itemLogin.setVisible(true);
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

        if (id == R.id.login) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        if (id == R.id.register) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }

        //mai am de scris la ultimele 2
        if (id == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            sharedPreferences.edit().putBoolean("logged", false).apply();
            startActivity(intent);
        }
        // profilul propriu : poate fi modificat
        if (id == R.id.my_profile) {
//            Intent intent = new Intent(this, SettingsActivity.class);
//            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

}