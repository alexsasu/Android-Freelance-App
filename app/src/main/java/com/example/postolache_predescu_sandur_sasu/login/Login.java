//package com.example.postolache_predescu_sandur_sasu.login;
//
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Login extends AppCompatActivity {
//
//    Button register, login;
//    EditText editUsername, editPassword;
//
//    private StudentViewModel studentViewModel;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        editUsername = findViewById(R.id.username_input);
//        editPassword = findViewById(R.id.password_input);
//        login = findViewById(R.id.btnl_login);
//        register = findViewById(R.id.btnl_register);
//        login.setOnClickListener(v -> {
//            String username = editUsername.getText().toString();
//            String password = editPassword.getText().toString();
//            if(username.isEmpty() || password.isEmpty()){
//                Toast.makeText(getApplicationContext(),"Enter both username and password for login",Toast.LENGTH_SHORT).show();
//            }
//            else
//            {
//                new Thread(() -> {
//                    studentViewModel = new StudentViewModel(this.getApplication());
//                    Student student = studentViewModel.getStudentByUsernameAndPassword(username, password);
//                    if( student == null)
//                    {
//                        runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show());
//                    }
//                    else
//                    {
//                        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
//                        intent.putExtra("studentName", student.getUsername());
//                        startActivity(intent);
//                    }
//                }).start();
//            }
//        });
//        register.setOnClickListener(v -> {
//            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//            startActivity(intent);
//        });
//    }
//}
