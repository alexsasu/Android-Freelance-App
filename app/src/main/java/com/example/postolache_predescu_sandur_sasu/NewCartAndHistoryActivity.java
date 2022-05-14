package com.example.postolache_predescu_sandur_sasu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewCartAndHistoryActivity extends AppCompatActivity {

    private EditText FeedbackEdt;
    private Button feedbackBtn;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_FEEDBACK = "com.example.postolache_predescu_sandur_sasu.EXTRA_FEEDBACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cart_and_history);

        FeedbackEdt = findViewById(R.id.idEdtCartAndHistoryFeedback);
        feedbackBtn = findViewById(R.id.idBtnSaveFeedback);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            FeedbackEdt.setText(intent.getStringExtra(EXTRA_FEEDBACK));
        }

        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedback = FeedbackEdt.getText().toString();
                if (feedback.isEmpty()) {
                    Toast.makeText(NewCartAndHistoryActivity.this, "Please provide the feedback", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveFeedback(feedback);
            }
        });
    }

    private void saveFeedback(String feedback) {
        Intent data = new Intent();
        data.putExtra(EXTRA_FEEDBACK, feedback);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {

            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        Toast.makeText(this, "Feedback has been saved successfully. ", Toast.LENGTH_SHORT).show();
    }
}
