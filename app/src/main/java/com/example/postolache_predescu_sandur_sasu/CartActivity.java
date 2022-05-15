package com.example.postolache_predescu_sandur_sasu;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.postolache_predescu_sandur_sasu.data.CartModel;
import com.example.postolache_predescu_sandur_sasu.model.City;
import com.example.postolache_predescu_sandur_sasu.model.Job;
import com.example.postolache_predescu_sandur_sasu.model.Service;
import com.example.postolache_predescu_sandur_sasu.model.User;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity{

    public SharedPreferences sharedPreferences;
    private ArrayList<CartModel> cart;
    private ListView lv;
    private Button submit_button;
    private TextView message_no_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_cart );
        lv = findViewById ( R.id.serviceCartList );
        cart = new ArrayList<> ();
        submit_button = findViewById(R.id.submit_cart);
        message_no_items = findViewById(R.id.message_no_items);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        // TEST DATA
        CartModel c1 = new CartModel("Service Cart 1", "Jane Doe 1");
        CartModel c2 = new CartModel("Service Cart 2", "Jane Doe 2");
        CartModel c3 = new CartModel("Service Cart 3", "Jane Doe 3");

        cart.add(c1);
        cart.add(c2);
        cart.add(c3);

        if(cart.size() != 0){
            submit_button.setVisibility(View.VISIBLE);
            message_no_items.setVisibility(View.INVISIBLE);
        }
        else{
            submit_button.setVisibility(View.INVISIBLE);
            message_no_items.setVisibility(View.VISIBLE);
        }
//        Toast.makeText(getApplicationContext(), sharedPreferences.getString("username", "").toString(), Toast.LENGTH_LONG).show();

        //create a method
        displayRetrofitData();


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on submit button!!!!!!".toString(), Toast.LENGTH_LONG).show();

                // TODO: functie care ia toate serviciite din cart si le submite (le seteaza ca efectuate/cumparate)
                // cartul ramane gol
                cart = new ArrayList<>();
                submit_button.setVisibility(View.INVISIBLE);
                message_no_items.setVisibility(View.VISIBLE);
                // TREBUIE MODIFICAT

                displayRetrofitData();
            }
        });
    }

    private void displayRetrofitData(){
        //TODO: iau data din functie -> lista de servicii (tip CartModel)

        for (int i=0;i<cart.size ();i++);
        //create adapter
        CartAdapter custom=new CartAdapter(cart,CartActivity.this,R.layout.list_item_cart, submit_button, message_no_items);
        lv.setAdapter ( custom );

    }


}

