package com.example.freelance4all.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.model.User;
import com.example.freelance4all.model.ViewUser;

public class RegisterActivity extends AppCompatActivity {

    private ViewUser viewUser;
    public Button register_submit_button;
    private boolean okPass;
    private EditText register_firstname;
    private EditText register_lastname;
    private EditText register_email;
    private EditText register_password;
    private EditText register_phoneNumber;
    private EditText register_description;

    public boolean isValidPassword(String password) {
        String passwordRegex = "^[a-zA-Z0-9@#$%^&!\\-+=()*_/]{8,20}+$";
        return password.matches(passwordRegex);
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String phone) {
        String phoneNumberRegex = "^[0-9]{3,}$";
        return phone.matches(phoneNumberRegex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewUser = ViewModelProviders.of(this).get(ViewUser.class);
        register_submit_button = findViewById(R.id.register);

        register_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                okPass = true;
                register_firstname = findViewById(R.id.firstname);
                register_lastname = findViewById(R.id.lastname);
                register_email = findViewById(R.id.email);
                register_password = findViewById(R.id.password);
                register_phoneNumber = findViewById(R.id.phoneNumber);
                register_description = findViewById(R.id.description);

                if(register_firstname.getText().toString().length() == 0) {
                    register_firstname.setError("Insert a first name.");
                    okPass = false;
                }

                if(register_lastname.getText().toString().length() == 0) {
                    register_lastname.setError("Insert a last name.");
                    okPass = false;
                }

                if(register_email.getText().toString().length() == 0) {
                    register_email.setError("Insert an e-mail address.");
                    okPass = false;
                }

                if(register_password.getText().toString().length() == 0) {
                    register_password.setError("Insert a valid password.");
                    okPass = false;
                }

                if(!isValidEmail(register_email.getText().toString())) {
                    register_email.setError("Invalid e-mail address.");
                    okPass = false;
                }

                if(!isValidPassword(register_password.getText().toString())) {
                    register_password.setError("Password must contain lowercase characters, uppercase characters, numbers, and special characaters (valid special characters: @, #, $, %, ^, &, !, \\, -, +, =, (, ), *, _, /). Password must have a length between 8 and 20 characters.");
                    okPass = false;
                }

                if(register_phoneNumber.getVisibility() == View.VISIBLE) {
                    if(!isValidPhoneNumber(register_phoneNumber.getText().toString())) {
                        register_phoneNumber.setError("Invalid phone number.");
                        okPass = false;
                    }

                    if(register_description.getText().toString().length() == 0) {
                        register_description.setError("Insert a seller description.");
                        okPass = false;
                    }
                }

                if(okPass) {
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);

                    String type;
                    if(register_phoneNumber.getVisibility() == View.VISIBLE) {
                        type = "seller";
                    } else {
                        type = "buyer";
                    }

                    User new_register = new User(
                            type,
                            register_email.getText().toString(),
                            register_password.getText().toString(),
                            register_firstname.getText().toString(),
                            register_lastname.getText().toString(),
                            register_description.getText().toString(),
                            register_phoneNumber.getText().toString()
                    );

                    // BUG: Can be inserted the same email multiple times; solution: create a function that return
                    // if the email is already in database (it is = 1; it's not = 0)

                    // TODO: verify if the email is already in the database - DONE
                    if(!viewUser.isEmailInDatabase(register_email.getText().toString())) {  // if it's not in database (returns false) => insert
                        viewUser.insert(new_register);
                    } else {
                        okPass = false;
                        Toast.makeText(getApplicationContext(),"Email already in use, please enter another e-mail address.", Toast.LENGTH_LONG).show();
                    }

                    if (okPass) {
                        startActivity(i);
                    }
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        View description = findViewById(R.id.description);
        View phone = findViewById(R.id.phoneNumber);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.buyer:
                if (checked) {
                    // is buyer
                    description.setVisibility(View.INVISIBLE);
                    phone.setVisibility(View.INVISIBLE);
                    break;
                }

            case R.id.seller:
                if (checked) {
                    // is seller
                    description.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);
                    break;
                }
        }
    }

}