package com.example.postolache_predescu_sandur_sasu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        String sharedRole = ((String) sharedPreferences.getString("role", "")).equals("seller") ? "Seller" : "Buyer";
        String sharedEmail = (String) sharedPreferences.getString("email", "");

        TextView userType = (TextView)  findViewById(R.id.user_type_content);
        TextView email = (TextView)  findViewById(R.id.profile_email_content);
        EditText firstName = (EditText)  findViewById(R.id.profile_first_name);
        EditText lastName = (EditText)  findViewById(R.id.profile_last_name);
        EditText description = (EditText)  findViewById(R.id.profile_description);
        EditText phoneNumber = (EditText)  findViewById(R.id.profile_phone_number);

        if (sharedRole.equals("Seller")) {
            description.setVisibility(View.VISIBLE);
            phoneNumber.setVisibility(View.VISIBLE);
        }

        userType.setText(sharedRole, TextView.BufferType.EDITABLE);
        email.setText(sharedEmail, TextView.BufferType.EDITABLE);

        Button save_profile_info_button = (Button) findViewById(R.id.save_profile_info);
        Button delete_profile_button = (Button) findViewById(R.id.delete_profile);

        save_profile_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if(firstName.getText().toString().length() == 0) {
                    firstName.setError("Insert a first name");
                    okPass = false;
                }

                if(lastName.getText().toString().length() == 0) {
                    lastName.setError("Insert a last name");
                    okPass = false;
                }

                if (sharedRole.equals("Seller")) {
                    if(description.getText().toString().length() == 0) {
                        description.setError("Insert a profile description");
                        okPass = false;
                    }

                    if(phoneNumber.getText().toString().length() == 0) {
                        phoneNumber.setError("Insert a phone no.");
                        okPass = false;
                    }
                }

                if(okPass) {
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        delete_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putBoolean("logged", false).apply();

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}