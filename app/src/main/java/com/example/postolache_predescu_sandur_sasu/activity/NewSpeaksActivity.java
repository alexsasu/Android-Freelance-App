package com.example.postolache_predescu_sandur_sasu.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;

public class NewSpeaksActivity extends AppCompatActivity {

    private EditText speaksIdEdit;
    private Button speaksButton;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_USER_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_USER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_language);

        speaksIdEdit = findViewById(R.id.idEdtUserId);
        speaksButton = findViewById(R.id.idBtnSaveSpeaks);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            speaksIdEdit.setText(intent.getStringExtra(EXTRA_USER_ID));
        }

        speaksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userIdFK = speaksIdEdit.getText().toString();

                if (userIdFK.isEmpty()) {
                    Toast.makeText(NewSpeaksActivity.this,
                            "Enter a valid id for the compound key", Toast.LENGTH_SHORT).show();
                    return;
                }
                saveLanguage(userIdFK);
            }
        });
    }
    private void saveLanguage(String userIdFK) {
        Intent data = new Intent();
        data.putExtra(EXTRA_USER_ID, userIdFK);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }
        setResult(RESULT_OK, data);
        Toast.makeText(this, "The changes are saved. ", Toast.LENGTH_SHORT).show();
    }
}