package com.example.postolache_predescu_sandur_sasu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;

public class NewJobActivity extends AppCompatActivity {

    private EditText jobNameEdt;
    private Button jobBtn;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_JOB_NAME = "com.example.postolache_predescu_sandur_sasu.EXTRA_JOB_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_job);
        
        jobNameEdt = findViewById(R.id.idEdtJobName);
        jobBtn = findViewById(R.id.idBtnSaveJob);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            jobNameEdt.setText(intent.getStringExtra(EXTRA_JOB_NAME));
        }

        jobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jobName = jobNameEdt.getText().toString();
                if (jobName.isEmpty()) {
                    Toast.makeText(NewJobActivity.this, "Please enter the valid job name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveJob(jobName);
            }
        });
    }

    private void saveJob(String jobName) {
        Intent data = new Intent();
        data.putExtra(EXTRA_JOB_NAME, jobName);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {

            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        Toast.makeText(this, "Job has been saved successfully. ", Toast.LENGTH_SHORT).show();
    }
}
