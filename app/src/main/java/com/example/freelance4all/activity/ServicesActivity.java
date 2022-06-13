package com.example.freelance4all.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelance4all.R;
import com.example.freelance4all.adapter.ServiceAdapter;
import com.example.freelance4all.adapter.RecyclerItemClickListener;
import com.example.freelance4all.classModels.ServiceCard;
import com.example.freelance4all.model.Service;
import com.example.freelance4all.model.ViewService;
import com.example.freelance4all.model.ViewUser;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewService viewService = ViewModelProviders.of(this).get(ViewService.class);
        ViewUser viewUser = ViewModelProviders.of(this).get(ViewUser.class);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.rv_services);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        List<Service> services = viewService.getAllServices().stream().
                filter(serv -> !serv.getDeleted()).
                collect(Collectors.toList());
        List<ServiceCard> serviceCards = services.stream().
                map(serv -> new ServiceCard(serv.getDescription(), serv.getPrice().toString() + " €", (viewUser.getUserById(serv.getId_Fk_User())).getEmail(), serv.getId_Fk_User(), serv.getIdService())).
                collect(Collectors.toList());

        ServiceAdapter adapter = new ServiceAdapter(this, serviceCards);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(ServicesActivity.this, ServiceActivity.class);
                        intent.putExtra("ID_SELLER", services.get(position).getId_Fk_User());
                        intent.putExtra("ID_SERVICE", services.get(position).getIdService());
                        intent.putExtra("ID_CITY", services.get(position).getId_Fk_City());
                        intent.putExtra("ID_JOB", services.get(position).getId_Fk_Job());
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do nothing
                    }
                })
        );
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ServicesActivity.this, MainActivity.class);
        startActivity(intent);
    }
}