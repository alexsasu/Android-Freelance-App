package com.example.postolache_predescu_sandur_sasu.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;

public class NewCityActivity extends AppCompatActivity {

    private EditText cityNameEdt;
    private Button cityBtn;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_CITY_NAME = "com.example.postolache_predescu_sandur_sasu.EXTRA_CITY_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_city);

        cityNameEdt = findViewById(R.id.idEdtCityName);

        cityBtn = findViewById(R.id.idBtnSaveCity);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {

            cityNameEdt.setText(intent.getStringExtra(EXTRA_CITY_NAME));

        }
        cityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cityName = cityNameEdt.getText().toString();
                if (cityName.isEmpty()) {
                    Toast.makeText(NewCityActivity.this, "Please enter the valid city name.", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveCity(cityName);
            }
        });
    }

    private void saveCity(String cityName) {

        Intent data = new Intent();

        data.putExtra(EXTRA_CITY_NAME, cityName);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);

        Toast.makeText(this, "city has been saved successfully. ", Toast.LENGTH_SHORT).show();
    }
}

