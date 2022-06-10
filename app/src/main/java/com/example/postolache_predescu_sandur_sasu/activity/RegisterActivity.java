package com.example.postolache_predescu_sandur_sasu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityRegisterBinding binding;


    public boolean isValidPassword(String password){

        String passwordRegex = "^[a-zA-Z0-9@#$%^&\\-+=()*_/]{8,20}+$";
        return password.matches(passwordRegex);
    }

    public boolean isValidEmail(String email){

        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    public boolean isValidPhoneNumber(String phone){

        String phoneNumberRegex = "^[0-9]{10}+$";
        return phone.matches(phoneNumberRegex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        setContentView(R.layout.activity_register);

//        final EditText firstnameEditText = binding.firstname;
//        final EditText lastnameEditText = binding.lastname;
//        final EditText emailEditText = binding.email;
//        final EditText passwordEditText = binding.password;
//        final EditText phoneNumberEditText = binding.phoneNumber;
//        final EditText descriptionEditText = binding.description;
//        final Button registerButton = binding.register;

//        System.out.println(firstnameEditText);
//        System.out.println(passwordEditText);

//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_register);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });




        Button register_submit_button = (Button) findViewById(R.id.register);
        register_submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean okPass = true;
                EditText register_firstname = (EditText)  findViewById(R.id.firstname);
                EditText register_lastname = (EditText)  findViewById(R.id.lastname);
                EditText register_email = (EditText)  findViewById(R.id.email);
                EditText register_password = (EditText)  findViewById(R.id.password);
                EditText register_phoneNumber = (EditText)  findViewById(R.id.phoneNumber);
                EditText register_description = (EditText)  findViewById(R.id.description);


                if(register_firstname.getText().toString().length() == 0) {
                    register_firstname.setError("Insert a firstname");
                    okPass = false;
                }

                if(register_lastname.getText().toString().length() == 0) {
                    register_lastname.setError("Insert a lastname");
                    okPass = false;
                }

                if(register_email.getText().toString().length() == 0) {
                    register_email.setError("Insert a mail");
                    okPass = false;
                }

                if(register_password.getText().toString().length() == 0) {
                    register_password.setError("Insert a password");
                    okPass = false;
                }

                if(!isValidEmail(register_email.getText().toString())){
                    register_email.setError("Invalid email");
                    okPass = false;
                }


                if(!isValidPassword(register_password.getText().toString())){
                    register_password.setError("Password must contain lower characters, upper characters, numbers and special characaters. Password must gave a length between 8 and 20");
                    okPass = false;
                }


                if(register_phoneNumber.getVisibility() == View.VISIBLE){
                    if(!isValidPhoneNumber(register_phoneNumber.getText().toString())){
                        register_phoneNumber.setError("Phone number must contain 10 numbers");
                        okPass = false;
                    }
                    if(register_description.getText().toString().length() == 0) {
                        register_description.setError("Insert a password");
                        okPass = false;
                    }
                }

                Toast.makeText(getApplicationContext(), register_password.getText().toString(), Toast.LENGTH_LONG).show();

                if(okPass) {
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);

                    // EXEMPLE
                    // exemplu de pus cod in baza de date
 //                    i.putExtra("username",register_username.getText().toString());
//                    i.putExtra("password",register_password.getText().toString());
//                    i.putExtra("role", role);
//                    i.putExtra("method", "Register");

                    startActivity(i);
                }
            }
        });
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_register);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        View description = findViewById(R.id.description);
        View phone = findViewById(R.id.phoneNumber);


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.buyer:
                if (checked) {
                    // Pirates are the best
                    description.setVisibility(View.INVISIBLE);
                    phone.setVisibility(View.INVISIBLE);
                    break;
                }

            case R.id.seller:
                if (checked){
                    // Ninjas rule
                    description.setVisibility(View.VISIBLE);
                    phone.setVisibility(View.VISIBLE);
                    break;
                }
        }
    }

}