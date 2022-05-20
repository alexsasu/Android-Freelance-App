package com.example.postolache_predescu_sandur_sasu;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.postolache_predescu_sandur_sasu.databinding.ActivityCartBinding;

import java.text.DateFormatSymbols;

public class CartActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public SharedPreferences sharedPreferences;
    private Integer type_cartAndHistory;
    // Object-reference of our ListView
    private ListView lvService;
    // String array to store the months that we'll generate programmatically
    private String[] services = {"Serviciul 1", "Serviciul 2", "Serviciul 3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

//        Toast.makeText(getApplicationContext(), sharedPreferences.getString("username", "").toString(), Toast.LENGTH_LONG).show();

        // TODO: afisare a cartului (ca lista presupun idk) dupa email si type


        // Create the object by calling findViewById() which returns a reference to our ListView
        lvService = findViewById(R.id.lvService);
        // Populate months

        // Next, create the ArrayAdapter instance having the month list
        // To customize the appearance of the ListView, create a new XML file and use that in ArrayAdapter
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(this, R.layout.list_item_service, services);

        // Example of ArrayAdapter without custom XML file
        //ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);

        // To display items in the list, call setAdapter() to associate an adapter with the list
        lvService.setAdapter(monthAdapter);
        // To set OnItemClickListener, simply write
        lvService.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Here, parent	is the AdapterView where the click happened.
        // view	is the view within the AdapterView that was clicked. This will be a view provided by the adapter.
        // position	is the position of the view in the adapter.
        // id is the database row id of the item that was clicked.
        String service = parent.getItemAtPosition(position).toString();
        //String month = months[position];
        //String month = ((TextView) view).getText().toString();
        //String month = lvMonth.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), "Clicked: " + service, Toast.LENGTH_SHORT).show();


//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cart2);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cart2);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}