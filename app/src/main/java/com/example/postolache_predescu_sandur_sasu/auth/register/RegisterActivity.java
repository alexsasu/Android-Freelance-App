package com.example.postolache_predescu_sandur_sasu.auth.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.postolache_predescu_sandur_sasu.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    ImageView backBtn;
    Button next, login;
    TextView titleText, slideText;

    TextInputLayout email, password, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_register);

        backBtn = findViewById(R.id.register_back_button);
        next = findViewById(R.id.register_next_button);
        login = findViewById(R.id.register_login_button);
        titleText = findViewById(R.id.register_title_text);
        slideText = findViewById(R.id.register_slide_text);

        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        phoneNumber = findViewById(R.id.register_phoneNumber);
    }

//    public void callNextRegisterScreen(View view) {
//        if (!validateEmail() | !validatePassword() | !validatePhoneNumber()) {
//            return;
//        }
//
//        Intent intent = new Intent(getApplicationContext(), );
//
//        Pair[] pairs = new Pair[5];
//        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
//        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
//        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
//        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");
//        pairs[4] = new Pair<View, String>(slideText, "transition_slide_text");
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register.this, pairs);
//            startActivity(intent, options.toBundle());
//        } else {
//            startActivity(intent);
//        }
//    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "^[A-Za-z0-9+_.-]+@(.+)$";

        if (val.isEmpty()) {
            email.setError("Field can not be empty.");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Please enter a valid e-mail address.");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^[a-zA-Z0-9@#$%^&\\-+=()*_/]{8,}+$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty.");
            return false;
        } else if (!val.matches(checkPassword)) {
            password.setError("Password should contain between 8 and 20 characters (available characters: A-Z, a-z, @, #, $, %, ^, &, -, +, =, (, ), *, _).");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        String checkPhoneNumber = "^[0-9]{10}+$";

        if (val.isEmpty()) {
            phoneNumber.setError("Field can not be empty.");
            return false;
        } else if (!val.matches(checkPhoneNumber)) {
            phoneNumber.setError("Please enter a valid phone number.");
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }
}

//String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // SI PENTRU PUNCT
//String passwordRegex = "^[a-zA-Z0-9@#$%^&\\-+=()*_/]{8,20}+$";
//String phoneNumberRegex = "^[0-9]{10}+$";