package com.example.postolache_predescu_sandur_sasu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class SellerServiceActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_service);

        ServiceCard obj = (ServiceCard) getIntent().getSerializableExtra("OBJECT");

        EditText description = (EditText)  findViewById(R.id.description);
        EditText price = (EditText)  findViewById(R.id.price);
        EditText experience_years = (EditText)  findViewById(R.id.experience_years);
        EditText work_schedule = (EditText)  findViewById(R.id.work_schedule);

        description.setText(obj.getDescription());
        price.setText(obj.getPrice());

        Button save_service_button = (Button) findViewById(R.id.save_service_info);
        Button delete_service_button = (Button) findViewById(R.id.delete_service);

        save_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if(description.getText().toString().length() == 0) {
                    description.setError("Insert a description");
                    okPass = false;
                }

                if(price.getText().toString().length() == 0) {
                    price.setError("Insert a price");
                    okPass = false;
                }

                if(experience_years.getText().toString().length() == 0) {
                    experience_years.setError("Insert experience years for the service");
                    okPass = false;
                }

                if(work_schedule.getText().toString().length() == 0) {
                    work_schedule.setError("Insert a work schedule");
                    okPass = false;
                }

                if(okPass) {
                    Intent intent = new Intent(SellerServiceActivity.this, SellerServicesActivity.class);
                    startActivity(intent);
                }
            }
        });

        delete_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerServiceActivity.this, SellerServicesActivity.class);
                startActivity(intent);
            }
        });
    }
}