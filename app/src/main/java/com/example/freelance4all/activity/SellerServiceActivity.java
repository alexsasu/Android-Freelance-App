package com.example.freelance4all.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.freelance4all.R;
import com.example.freelance4all.model.Service;
import com.example.freelance4all.model.ViewCity;
import com.example.freelance4all.model.ViewJob;
import com.example.freelance4all.model.ViewService;

public class SellerServiceActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_service);

        ViewService viewService = ViewModelProviders.of(this).get(ViewService.class);
        ViewCity viewCity = ViewModelProviders.of(this).get(ViewCity.class);
        ViewJob viewJob = ViewModelProviders.of(this).get(ViewJob.class);

        Integer idService = (Integer) getIntent().getSerializableExtra("ID_SERVICE");
        Integer idCity = (Integer) getIntent().getSerializableExtra("ID_CITY");
        Integer idJob = (Integer) getIntent().getSerializableExtra("ID_JOB");

        EditText description = (EditText)  findViewById(R.id.seller_service_description);
        EditText price = (EditText)  findViewById(R.id.seller_service_price);
        EditText experience_years = (EditText)  findViewById(R.id.seller_service_experience_years);
        EditText work_schedule = (EditText)  findViewById(R.id.seller_service_work_schedule);
        EditText city_availability = (EditText)  findViewById(R.id.seller_service_city_availability);
        EditText job_name = (EditText)  findViewById(R.id.seller_service_job_name);

        Service sellerService = viewService.getServiceById(idService);

        description.setText(sellerService.getDescription());
        price.setText(sellerService.getPrice().toString());
        experience_years.setText(sellerService.getExperienceYears().toString());
        work_schedule.setText(sellerService.getWorkSchedule());
        city_availability.setText(viewCity.getCityById(idCity).getName());
        job_name.setText(viewJob.getJobById(idJob).getDomainOfWork());

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
                    work_schedule.setError("Insert a work schedule for the service");
                    okPass = false;
                }

                if(city_availability.getText().toString().length() == 0) {
                    city_availability.setError("Insert an available city for the service");
                    okPass = false;
                }

                if(job_name.getText().toString().length() == 0) {
                    job_name.setError("Insert a job for the service");
                    okPass = false;
                }

                if(okPass) {
                    viewService.updateServiceByIdService(idService, description.getText().toString(), Double.parseDouble(price.getText().toString()), Integer.parseInt(experience_years.getText().toString()), work_schedule.getText().toString(), city_availability.getText().toString(), job_name.getText().toString());

                    Intent intent = new Intent(SellerServiceActivity.this, SellerServicesActivity.class);
                    startActivity(intent);
                }
            }
        });

        delete_service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewService.deleteServiceById(idService, true);

                Intent intent = new Intent(SellerServiceActivity.this, SellerServicesActivity.class);
                startActivity(intent);
            }
        });
    }
}