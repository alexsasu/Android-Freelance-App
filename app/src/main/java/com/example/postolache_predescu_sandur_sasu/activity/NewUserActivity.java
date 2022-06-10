package com.example.postolache_predescu_sandur_sasu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.postolache_predescu_sandur_sasu.R;

public class NewUserActivity extends AppCompatActivity {

    private EditText userDescriptionEdt, userPhoneNumberEdt;
    private Button userBtn;

    public static final String EXTRA_ID = "com.example.postolache_predescu_sandur_sasu.EXTRA_ID";
    public static final String EXTRA_DESCRIPTION = "com.example.postolache_predescu_sandur_sasu.EXTRA_DESCRIPTION";
    public static final String EXTRA_PHONE_NUMBER = "com.example.postolache_predescu_sandur_sasu.EXTRA_PHONE_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        userDescriptionEdt = findViewById(R.id.idEdtUserDescription);
        userPhoneNumberEdt = findViewById(R.id.idEdtUserPhoneNumber);
        userBtn = findViewById(R.id.idBtnSaveUser);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {

            userDescriptionEdt.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            userPhoneNumberEdt.setText(intent.getStringExtra(EXTRA_PHONE_NUMBER));
           
        }

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userDescription = userDescriptionEdt.getText().toString();
                String userPhoneNumber = userPhoneNumberEdt.getText().toString();
                
                if (userDescription.isEmpty() || userPhoneNumber.isEmpty() ) {
                    Toast.makeText(NewUserActivity.this, "Enter the valid user details.", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveUser(userDescription, userPhoneNumber);
            }
        });
    }

    private void saveUser(String userDescription, String userPhoneNumber) {

        Intent data = new Intent();
        
        data.putExtra(EXTRA_DESCRIPTION, userDescription);
        data.putExtra(EXTRA_PHONE_NUMBER, userPhoneNumber);
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {

            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        
        Toast.makeText(this, "User has been saved.", Toast.LENGTH_SHORT).show();
    }
}
