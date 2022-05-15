package com.example.postolache_predescu_sandur_sasu;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.postolache_predescu_sandur_sasu.data.HistoryModel;
import com.example.postolache_predescu_sandur_sasu.model.City;
import com.example.postolache_predescu_sandur_sasu.model.Job;
import com.example.postolache_predescu_sandur_sasu.model.Service;
import com.example.postolache_predescu_sandur_sasu.model.User;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
//    private ArrayList<Service> services;
    private ArrayList<HistoryModel> services;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        lv = findViewById (R.id.serviceHistoryList);
        services = new ArrayList<> ();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        sharedPreferences.edit().putInt("type_cartAndHistory", 1).apply();

//        User user = new User(1, "email", "password", "f", "l", "d", "0");
//        User user1 = new User(1, "email", "password", "f", "baHCvaKl", "d", "0");
//        Job job = new Job("job");
//        Job job1 = new Job("job1");
//        City city = new City("city");
//
//
//        Service service = new Service(job,city,user,12, "shadj");
//        services.add(service);
//        Service service1 = new Service(job1,city,user1,12, "shadj");
//        services.add(service1);

        HistoryModel m1 = new HistoryModel("Service 1", "John Doe 1", 1.5f,  new Date());
        services.add(m1);

        HistoryModel m2 = new HistoryModel("Service 2", "John Doe 2", 2.5f,  new Date());
        services.add(m2);

        HistoryModel m3 = new HistoryModel("Service 3", "John Doe 3", 5.0f,  new Date());
        services.add(m3);

        HistoryModel m4 = new HistoryModel("Service 4", "John Doe 4", 3.0f,  new Date());
        services.add(m4);

        HistoryModel m5 = new HistoryModel("Service 5", "John Doe 5", 0.5f,  new Date());
        services.add(m5);

        //create a method
        displayRetrofitData();
    }

    private void displayRetrofitData(){
        //TODO: iau data din functie -> lista de servicii

        for (int i=0;i<services.size ();i++);
        //create adapter
        HistoryAdapter custom=new HistoryAdapter(services,HistoryActivity.this,R.layout.list_item_history);
        lv.setAdapter ( custom );
    }

}

