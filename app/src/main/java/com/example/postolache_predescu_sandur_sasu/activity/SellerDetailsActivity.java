package com.example.postolache_predescu_sandur_sasu.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.data.SellerDetails;

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