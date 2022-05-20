package com.example.postolache_predescu_sandur_sasu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SellerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_details);

        SellerDetails obj = (SellerDetails) getIntent().getSerializableExtra("OBJECT");

        TextView email = (TextView)  findViewById(R.id.seller_email_content);
        TextView description = (TextView)  findViewById(R.id.seller_description_content);
        TextView phoneNumber = (TextView)  findViewById(R.id.seller_phone_number_content);

        email.setText(obj.getEmail(), TextView.BufferType.EDITABLE);
        description.setText(obj.getDescription(), TextView.BufferType.EDITABLE);
        phoneNumber.setText(obj.getPhoneNumber(), TextView.BufferType.EDITABLE);

    }
}