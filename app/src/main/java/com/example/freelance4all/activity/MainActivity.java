package com.example.freelance4all.activity;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProviders;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.freelance4all.R;
import com.example.freelance4all.model.CartAndHistory;
import com.example.freelance4all.model.ViewCartAndHistory;
import com.example.freelance4all.model.ViewUser;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private SharedPreferences sharedPreferences;
    private Button services;
    private Button cart;
    private Button history;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        services = findViewById(R.id.services);
        cart = findViewById(R.id.cart);
        history = findViewById(R.id.history);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        if(sharedPreferences.getBoolean("logged", true)) { // is logged
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

                services.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    }
                });
            }
            if(sharedPreferences.getString("role", "").equals("seller")) {
                services.setText("MY SERVICES");
                services.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, SellerServicesActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }
        else { // is not logged
            services.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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

        if(sharedPreferences.getBoolean("logged", false)) { // the user is logged
            MenuItem itemProfile = menu.findItem(R.id.my_profile);
            itemProfile.setVisible(true);
            MenuItem itemLogout = menu.findItem(R.id.logout);
            itemLogout.setVisible(true);

            MenuItem itemReg = menu.findItem(R.id.register);
            itemReg.setVisible(false);
            MenuItem itemLogin = menu.findItem(R.id.login);
            itemLogin.setVisible(false);
        } else { // the user is not logged
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

            if(sharedPreferences.getString("role", "").equals("buyer")) {
                ViewCartAndHistory viewCartAndHistory =  ViewModelProviders.of(this).get(ViewCartAndHistory.class);
                ViewUser viewUser =  ViewModelProviders.of(this).get(ViewUser.class);

                List<CartAndHistory> cartForUser = viewCartAndHistory.getCartsByIdUser(viewUser.getUserByEmail(sharedPreferences.getString("email", "")).getIdUser());
                createNotification(cartForUser.size());
            }

            sharedPreferences.edit().putBoolean("logged", false).apply();
            startActivity(intent);
        }

        if (id == R.id.my_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // Creates and displays a notification
    private void createNotification(Integer numberServices) {
        if(numberServices > 0) {
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "default");
            mBuilder.setContentTitle("Notification Freelance4ALL");
            mBuilder.setContentText("Don't forget you have " + numberServices + " service(s) in your cart!");
            mBuilder.setTicker("Notification Listener");
            mBuilder.setSmallIcon(R.drawable.ic_launcher_foreground);
            mBuilder.setAutoCancel(true);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(notificationChannel);
            }
            assert mNotificationManager != null;
            mNotificationManager.notify(0, mBuilder.build());
        }
    }
}
