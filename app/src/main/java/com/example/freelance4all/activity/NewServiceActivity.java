package com.example.freelance4all.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.ViewService;


public class NewServiceActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service_alex);

        ViewService viewService = ViewModelProviders.of(this).get(ViewService.class);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        EditText description = (EditText) findViewById(R.id.new_service_description);
        EditText price = (EditText) findViewById(R.id.new_service_price);
        EditText experience_years = (EditText) findViewById(R.id.new_service_experience_years);
        EditText work_schedule = (EditText) findViewById(R.id.new_service_work_schedule);
        EditText city_availability = (EditText) findViewById(R.id.new_service_city_availability);
        EditText job_name = (EditText) findViewById(R.id.new_service_job_name);

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
                    work_schedule.setError("Insert a work schedule for the service");
                    okPass = false;
                }

                if (city_availability.getText().toString().length() == 0) {
                    city_availability.setError("Insert an available city for the service");
                    okPass = false;
                }

                if (job_name.getText().toString().length() == 0) {
                    job_name.setError("Insert a job for the service");
                    okPass = false;
                }

                if (okPass) {
                    viewService.addService(sharedPreferences.getString("email", ""), job_name.getText().toString(), city_availability.getText().toString(), Double.parseDouble(price.getText().toString()), description.getText().toString(), Integer.parseInt(experience_years.getText().toString()), work_schedule.getText().toString());

                    Intent intent = new Intent(NewServiceActivity.this, SellerServicesActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}