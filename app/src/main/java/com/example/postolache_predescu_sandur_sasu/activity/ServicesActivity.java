package com.example.postolache_predescu_sandur_sasu.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.adapter.ServiceAdapter;
import com.example.postolache_predescu_sandur_sasu.adapter.RecyclerItemClickListener;
import com.example.postolache_predescu_sandur_sasu.data.ServiceCard;

import java.util.ArrayList;
import java.util.List;

public class ServicesActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView = findViewById(R.id.rv_services);
        List<ServiceCard> mlist = new ArrayList<>();
//        mlist.add(new ServiceCard("I'll build a cheap site for you.", "15.73 €", "Seller 1", 1));
//        mlist.add(new ServiceCard("I'll build an expensive site for you.", "65.33 €", "Seller 2", 2));
        ServiceAdapter adapter = new ServiceAdapter(this, mlist);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(ServicesActivity.this, ServiceActivity.class);
                        intent.putExtra("OBJECT", mlist.get(position));
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
}