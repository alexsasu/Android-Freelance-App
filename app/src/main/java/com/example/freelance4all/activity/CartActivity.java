package com.example.freelance4all.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.adapter.CartAdapter;
import com.example.freelance4all.classModels.CartModel;
import com.example.freelance4all.model.CartAndHistory;
import com.example.freelance4all.model.ViewCartAndHistory;
import com.example.freelance4all.model.ViewJob;
import com.example.freelance4all.model.ViewService;
import com.example.freelance4all.model.ViewUser;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity{

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    public SharedPreferences sharedPreferences;
    public String sp_email;
    private List<CartModel> cart;
    private ListView lv;
    private Button submit_button;
    private TextView message_no_items;
    private ViewCartAndHistory viewCartAndHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cart );
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewCartAndHistory = ViewModelProviders.of(this).get(ViewCartAndHistory.class);  // link to view
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sp_email = sharedPreferences.getString("email", "");  // select the email
        lv = findViewById ( R.id.serviceCartList );
        submit_button = findViewById(R.id.submit_cart);
        message_no_items = findViewById(R.id.message_no_items);

        ViewUser viewUser =  ViewModelProviders.of(this).get(ViewUser.class);
        ViewService viewService =  ViewModelProviders.of(this).get(ViewService.class);
        ViewJob viewJob =  ViewModelProviders.of(this).get(ViewJob.class);

        List<CartAndHistory> cartForUser = viewCartAndHistory.getCartsByIdUser(viewUser.getUserByEmail(sp_email).getIdUser());

        //TODO: take all the services from cart for a given email (type list of CartModel)
        cart = new ArrayList<>();
        for(CartAndHistory cartAndHistory : cartForUser) {
            cart.add(
                    new CartModel(
                            cartAndHistory.getIdUtility(),
                            viewUser.getUserById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_User()).getFirstName() +
                                    " " + viewUser.getUserById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_User()).getLastName(),

                            viewJob.getJobById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_Job()).getDomainOfWork(),
                            viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getPrice().toString() + " €"
                    )
            );
        }

        if(!cart.isEmpty()) {
            submit_button.setVisibility(View.VISIBLE);
            message_no_items.setVisibility(View.INVISIBLE);
        }
        else{
            submit_button.setVisibility(View.INVISIBLE);
            message_no_items.setVisibility(View.VISIBLE);
        }
        //create a method
        displayRetrofitData();

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO: take all the services from the cart and submit them (buy)
                // the cart is empty
                for(int i = 0; i < cart.size(); i++)
                    viewCartAndHistory.moveFromCartToHistory(cart.get(i).getIdCart());

                addNotification(); // displays notification

                cart = new ArrayList<>();
                submit_button.setVisibility(View.INVISIBLE);
                message_no_items.setVisibility(View.VISIBLE);

                displayRetrofitData();
            }
        });
    }

    private void displayRetrofitData() {
        for (int i=0;i<cart.size ();i++);
        //create adapter
        CartAdapter adapter=new CartAdapter(cart,CartActivity.this, R.layout.list_item_cart, submit_button, message_no_items, viewCartAndHistory);
        lv.setAdapter(adapter);
    }

    // Creates and displays a notification
    private void addNotification() {
        // Builds your notification
        NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext() , "default" );
        mBuilder.setContentTitle( "Notification Freelance4ALL" );
        mBuilder.setContentText( "The sellers of your purchased services have been notified! Stay tuned!" );
        mBuilder.setTicker( "Notification Listener" );
        mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground );
        mBuilder.setAutoCancel( true );
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance);
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID );
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build());
    }
}