package com.example.postolache_predescu_sandur_sasu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewLanguageActivity extends AppCompatActivity {

    private EditText languageNameEdit;
    private Button languageButton;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_LANGUAGE_NAME = "com.example.postolache_predescu_sandur_sasu.EXTRA_LANGUAGE_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_language);

        languageNameEdit = findViewById(R.id.idEdtLanguageName);
        languageButton = findViewById(R.id.idBtnSaveLanguage);

        //we get data with an intent
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {//now we have the object and we can edit the field
            languageNameEdit.setText(intent.getStringExtra(EXTRA_LANGUAGE_NAME));
        }

        languageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validate the field if it is empty and save
                String languageName = languageNameEdit.getText().toString();

                if (languageName.isEmpty()) {
                    Toast.makeText(NewLanguageActivity.this,
                            "Enter valid language name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                // save the changes
                saveLanguage(languageName);
            }
        });
    }

    private void saveLanguage(String languageName) {
        Intent data = new Intent();
        data.putExtra(EXTRA_LANGUAGE_NAME, languageName);//pass the new name
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);//pass new id
        }

        setResult(RESULT_OK, data);//set the result

        Toast.makeText(this, "The changes are saved. ", Toast.LENGTH_SHORT).show();
    }
}