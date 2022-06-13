package com.example.freelance4all.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.User;
import com.example.freelance4all.model.ViewUser;

public class ProfileActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    public boolean isValidPhoneNumber(String phone) {
        String phoneNumberRegex = "^[0-9]{3,}$";
        return phone.matches(phoneNumberRegex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ViewUser viewUser = ViewModelProviders.of(this).get(ViewUser.class);

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

        User user = viewUser.getUserByEmail(sharedPreferences.getString("email", ""));

        userType.setText(sharedRole, TextView.BufferType.EDITABLE);
        email.setText(sharedEmail, TextView.BufferType.EDITABLE);
        firstName.setText(user.getFirstName(), TextView.BufferType.EDITABLE);
        lastName.setText(user.getLastName(), TextView.BufferType.EDITABLE);

        if (sharedRole.equals("Seller")) {
            description.setText(user.getDescription(), TextView.BufferType.EDITABLE);
            phoneNumber.setText(user.getPhoneNumber(), TextView.BufferType.EDITABLE);
        }

        Button save_profile_info_button = (Button) findViewById(R.id.save_profile_info);
        Button delete_profile_button = (Button) findViewById(R.id.delete_profile);

        save_profile_info_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if(firstName.getText().toString().length() == 0) {
                    firstName.setError("Insert a first name.");
                    okPass = false;
                }

                if(lastName.getText().toString().length() == 0) {
                    lastName.setError("Insert a last name.");
                    okPass = false;
                }

                if (sharedRole.equals("Seller")) {
                    if(description.getText().toString().length() == 0) {
                        description.setError("Insert a seller description.");
                        okPass = false;
                    }

                    if(!isValidPhoneNumber(phoneNumber.getText().toString())) {
                        phoneNumber.setError("Invalid phone number.");
                        okPass = false;
                    }
                }

                if(okPass) {
                    viewUser.updateUserByEmail(firstName.getText().toString(), lastName.getText().toString(), description.getText().toString(), phoneNumber.getText().toString(), sharedEmail);

                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        delete_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewUser.deleteUserByEmail(sharedEmail, true);
                sharedPreferences.edit().putBoolean("logged", false).apply();

                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}