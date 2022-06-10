package com.example.postolache_predescu_sandur_sasu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.data.SellerDetails;
import com.example.postolache_predescu_sandur_sasu.data.ServiceCard;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    protected void sendEmail(String buyer, String seller) {
        final String username = "sasualex1@gmail.com"; // e-mail address of sender
        final String password = ""; // password for e-mail account of sender
        String messageToSend = buyer + " bought one of your services!";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(seller));
            message.setSubject("Freel4ncers' Hub - Someone bought your service!");
            message.setText(messageToSend);
            Transport.send(message);
            Toast.makeText(getApplicationContext(), "email sent successfully", Toast.LENGTH_SHORT).show();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        ServiceCard obj = (ServiceCard) getIntent().getSerializableExtra("OBJECT");

        TextView description = (TextView)  findViewById(R.id.description_content);
        TextView price = (TextView)  findViewById(R.id.price_content);
        TextView experience_years = (TextView)  findViewById(R.id.experience_years_content);
        TextView work_schedule = (TextView)  findViewById(R.id.work_schedule_content);

        Button add_to_cart_button = (Button) findViewById(R.id.add_to_cart);
        Button seller_details_button = (Button) findViewById(R.id.seller_details);

        description.setText(obj.getDescription(), TextView.BufferType.EDITABLE);
        price.setText(obj.getPrice(), TextView.BufferType.EDITABLE);

        if(sharedPreferences.getBoolean("logged", true)) { // este logat
            if (sharedPreferences.getString("role", "").equals("buyer")) {
                add_to_cart_button.setVisibility(View.VISIBLE);

                add_to_cart_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sendEmail(sharedPreferences.getString("email", ""), sharedPreferences.getString("email", ""));
                        Intent intent = new Intent(ServiceActivity.this, ServicesActivity.class);
                        startActivity(intent);
                    }
                });
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
        }

        seller_details_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(ServiceActivity.this, SellerDetailsActivity.class);
                 SellerDetails sellerDetails = new SellerDetails("sellerEmail1@gmail.com", "seller description 1", "0123456789");
                 intent.putExtra("OBJECT", sellerDetails);
                 startActivity(intent);
             }
        });
    }
}