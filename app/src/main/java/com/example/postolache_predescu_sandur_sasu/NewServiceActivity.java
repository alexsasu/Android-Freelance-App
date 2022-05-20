package com.example.postolache_predescu_sandur_sasu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        EditText description = (EditText) findViewById(R.id.description);
        EditText price = (EditText) findViewById(R.id.price);
        EditText experience_years = (EditText) findViewById(R.id.experience_years);
        EditText work_schedule = (EditText) findViewById(R.id.work_schedule);

        Button add_service_button = (Button) findViewById(R.id.add_service_info);

        add_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean okPass = true;

                if (description.getText().toString().length() == 0) {
                    description.setError("Insert a description");
                    okPass = false;
                }

                if (price.getText().toString().length() == 0) {
                    price.setError("Insert a price");
                    okPass = false;
                }

                if (experience_years.getText().toString().length() == 0) {
                    experience_years.setError("Insert experience years for the service");
                    okPass = false;
                }

                if (work_schedule.getText().toString().length() == 0) {
                    work_schedule.setError("Insert a work schedule");
                    okPass = false;
                }

                if (okPass) {
                    Intent intent = new Intent(NewServiceActivity.this, SellerServicesActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}