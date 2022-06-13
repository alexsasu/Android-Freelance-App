package com.example.freelance4all.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.User;
import com.example.freelance4all.model.ViewUser;

public class SellerDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_details);

        ViewUser viewUser = ViewModelProviders.of(this).get(ViewUser.class);

        Integer idSeller = (Integer) getIntent().getSerializableExtra("ID_SELLER");

        TextView email = (TextView)  findViewById(R.id.seller_email_content);
        TextView description = (TextView)  findViewById(R.id.seller_description_content);
        TextView phoneNumber = (TextView)  findViewById(R.id.seller_phone_number_content);

        User seller = viewUser.getUserById(idSeller);
        email.setText(seller.getEmail(), TextView.BufferType.EDITABLE);
        description.setText(seller.getDescription(), TextView.BufferType.EDITABLE);
        phoneNumber.setText(seller.getPhoneNumber(), TextView.BufferType.EDITABLE);
    }
}