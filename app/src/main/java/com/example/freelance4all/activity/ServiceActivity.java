package com.example.freelance4all.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.CartAndHistory;
import com.example.freelance4all.model.Service;
import com.example.freelance4all.model.ViewCartAndHistory;
import com.example.freelance4all.model.ViewCity;
import com.example.freelance4all.model.ViewJob;
import com.example.freelance4all.model.ViewService;
import com.example.freelance4all.model.ViewUser;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        ViewService viewService = ViewModelProviders.of(this).get(ViewService.class);
        ViewCity viewCity = ViewModelProviders.of(this).get(ViewCity.class);
        ViewJob viewJob = ViewModelProviders.of(this).get(ViewJob.class);
        ViewUser viewUser = ViewModelProviders.of(this).get(ViewUser.class);
        ViewCartAndHistory viewCartAndHistory = ViewModelProviders.of(this).get(ViewCartAndHistory.class);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        Integer idSeller = (Integer) getIntent().getSerializableExtra("ID_SELLER");
        Integer idService = (Integer) getIntent().getSerializableExtra("ID_SERVICE");
        Integer idCity = (Integer) getIntent().getSerializableExtra("ID_CITY");
        Integer idJob = (Integer) getIntent().getSerializableExtra("ID_JOB");

        TextView description = (TextView)  findViewById(R.id.service_description_content);
        TextView price = (TextView)  findViewById(R.id.price_content);
        TextView experience_years = (TextView)  findViewById(R.id.experience_years_content);
        TextView work_schedule = (TextView)  findViewById(R.id.work_schedule_content);
        TextView city_availability = (TextView)  findViewById(R.id.city_availability_content);
        TextView job_name = (TextView)  findViewById(R.id.job_name_content);

        Service service = viewService.getServiceById(idService);

        description.setText(service.getDescription());
        price.setText(service.getPrice().toString());
        experience_years.setText(service.getExperienceYears().toString());
        work_schedule.setText(service.getWorkSchedule());
        city_availability.setText(viewCity.getCityById(idCity).getName());
        job_name.setText(viewJob.getJobById(idJob).getDomainOfWork());

        Button add_to_cart_button = (Button) findViewById(R.id.add_to_cart);
        Button seller_details_button = (Button) findViewById(R.id.seller_details);

        if(sharedPreferences.getBoolean("logged", true)) { // este logat
            if (sharedPreferences.getString("role", "").equals("buyer")) {
                add_to_cart_button.setVisibility(View.VISIBLE);

                add_to_cart_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CartAndHistory new_cart = new CartAndHistory(
                                viewUser.getUserByEmail(sharedPreferences.getString("email", "")).getIdUser(),
                                idService,
                                1,
                                "date",
                                "0"
                        );

                        viewCartAndHistory.insert(new_cart);
                        Intent intent = new Intent(ServiceActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }

        seller_details_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceActivity.this, SellerDetailsActivity.class);
                intent.putExtra("ID_SELLER", idSeller);
                startActivity(intent);
            }
        });
    }
}