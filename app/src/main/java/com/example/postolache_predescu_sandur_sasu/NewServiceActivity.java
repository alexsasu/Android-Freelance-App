package com.example.postolache_predescu_sandur_sasu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewServiceActivity extends AppCompatActivity {
    private EditText cityIdEdt, experienceEdt, workScheduleEdt;
    private Button serviceBtn;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_CITY_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_CITY_ID";
    public static final String EXTRA_EXPERIENCE = "com.example.postolache_predescu_sandur_sasu.EXTRA_EXPERIENCE";
    public static final String EXTRA_WORK_SCHEDULE = "com.example.postolache_predescu_sandur_sasu.EXTRA_WORK_SCHEDULE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_service);

        cityIdEdt = findViewById(R.id.idEdtCityId);
        experienceEdt = findViewById(R.id.idEdtExperienceYears);
        workScheduleEdt = findViewById(R.id.idEdtWorkSchedule);
        serviceBtn = findViewById(R.id.idBtnSaveService);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            cityIdEdt.setText(intent.getStringExtra(EXTRA_CITY_ID));
            experienceEdt.setText(intent.getStringExtra(EXTRA_EXPERIENCE));
            workScheduleEdt.setText(intent.getStringExtra(EXTRA_WORK_SCHEDULE));
        }
        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cityId = cityIdEdt.getText().toString();
                String experience = experienceEdt.getText().toString();
                String workSchedule = workScheduleEdt.getText().toString();
                if (cityId.isEmpty() || experience.isEmpty() || workSchedule.isEmpty()) {
                    Toast.makeText(NewServiceActivity.this, "Enter the valid service details.", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveService(cityId, experience, workSchedule);
            }
        });
    }

    private void saveService(String cityId, String experience, String workSchedule) {
        Intent data = new Intent();
        data.putExtra(EXTRA_CITY_ID, cityId);
        data.putExtra(EXTRA_EXPERIENCE, experience);
        data.putExtra(EXTRA_WORK_SCHEDULE, workSchedule);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK, data);
        Toast.makeText(this, "Service has been saved to Database. ", Toast.LENGTH_SHORT).show();
    }
}