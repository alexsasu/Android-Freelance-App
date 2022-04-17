
////
////import android.widget.Button;
////import android.widget.EditText;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////public class Login extends AppCompatActivity {
////
////    Button register, login;
////    EditText editUsername, editPassword;
////
////    private StudentViewModel studentViewModel;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_login);
////        editUsername = findViewById(R.id.username_input);
////        editPassword = findViewById(R.id.password_input);
////        login = findViewById(R.id.btnl_login);
////        register = findViewById(R.id.btnl_register);
////        login.setOnClickListener(v -> {
////            String username = editUsername.getText().toString();
////            String password = editPassword.getText().toString();
////            if(username.isEmpty() || password.isEmpty()){
////                Toast.makeText(getApplicationContext(),"Enter both username and password for login",Toast.LENGTH_SHORT).show();
////            }
////            else
////            {
////                new Thread(() -> {
////                    studentViewModel = new StudentViewModel(this.getApplication());
////                    Student student = studentViewModel.getStudentByUsernameAndPassword(username, password);
////                    if( student == null)
////                    {
////                        runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show());
////                    }
////                    else
////                    {
////                        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
////                        intent.putExtra("studentName", student.getUsername());
////                        startActivity(intent);
////                    }
////                }).start();
////            }
////        });
////        register.setOnClickListener(v -> {
////            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
////            startActivity(intent);
////        });
////    }
////}
//
//package com.example.postolache_predescu_sandur_sasu.login;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//import com.example.postolache_predescu_sandur_sasu.R;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Login extends AppCompatActivity implements View.OnClickListener {
//    private TextView register;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        register = (TextView) findViewById(R.id.register);
//        register.setOnClickListener(this);
//    }
//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.register:
//                    startActivity(new Intent(this, UserRegister.class));
//                    break;
//            }
//    }
//}
//package com.example.postolache_predescu_sandur_sasu.login;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Patterns;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import com.example.postolache_predescu_sandur_sasu.R;
//public class Login extends AppCompatActivity {
//    EditText username;
//    EditText password;
//    Button register;
//    Button login;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        setupUI();
//        setupListeners();
//    }
//
//    private void setupUI() {
//        username = findViewById(R.id.username);
//        password = findViewById(R.id.password);
//        register = findViewById(R.id.register);
//        login = findViewById(R.id.login);
//    }
//
//    private void setupListeners() {
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkUsername();
//            }
//        });
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
//                //startActivity(i);
//            }
//        });
//    }
//
//    void checkUsername() {
//        boolean isValid = true;
//        if (isEmpty(username)) {
//            username.setError("You must enter username to login!");
//            isValid = false;
//        } else {
//            if (!isEmail(username)) {
//                username.setError("Enter valid email!");
//                isValid = false;
//            }
//        }
//
//        if (isEmpty(password)) {
//            password.setError("You must enter password to login!");
//            isValid = false;
//        } else {
//            if (password.getText().toString().length() < 4) {
//                password.setError("Password must be at least 4 chars long!");
//                isValid = false;
//            }
//        }
//
//        //check email and password
//        //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
//        //For example simple check is cool
//        if (isValid) {
//            String usernameValue = username.getText().toString();
//            String passwordValue = password.getText().toString();
//            if (usernameValue.equals("test@test.com") && passwordValue.equals("password1234")) {
//                //everything checked we open new activity
//                Intent i = new Intent(Login.this, FirstActivity.class);
//                startActivity(i);
//                //we close this activity
//                this.finish();
//            } else {
//                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
//                t.show();
//            }
//        }
//    }
//    boolean isEmail(EditText text) {
//        CharSequence email = text.getText().toString();
//        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
//    }
//
//    boolean isEmpty(EditText text) {
//        CharSequence str = text.getText().toString();
//        return TextUtils.isEmpty(str);
//    }
//}

package com.example.postolache_predescu_sandur_sasu.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    ImageView backBtn;
    Button next, register;
    TextView titleText, slideText;

    TextInputLayout email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_login);

        backBtn = findViewById(R.id.register_back_button);
        next = findViewById(R.id.register_next_button);
        register = findViewById(R.id.register_login_button);
        titleText = findViewById(R.id.register_title_text);
        slideText = findViewById(R.id.register_slide_text);

        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
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
}

//String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // SI PENTRU PUNCT
//String passwordRegex = "^[a-zA-Z0-9@#$%^&\\-+=()*_/]{8,20}+$";
//String phoneNumberRegex = "^[0-9]{10}+$";

