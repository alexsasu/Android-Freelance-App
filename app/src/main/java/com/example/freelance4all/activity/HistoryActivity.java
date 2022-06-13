package com.example.freelance4all.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.example.freelance4all.R;
import com.example.freelance4all.adapter.HistoryAdapter;
import com.example.freelance4all.classModels.HistoryModel;
import com.example.freelance4all.model.CartAndHistory;
import com.example.freelance4all.model.ViewCartAndHistory;
import com.example.freelance4all.model.ViewJob;
import com.example.freelance4all.model.ViewService;
import com.example.freelance4all.model.ViewUser;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    public SharedPreferences sharedPreferences;
    public String sp_email;
    private List<HistoryModel> history;
    private ListView lv;
    private ViewCartAndHistory viewCartAndHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv = findViewById (R.id.serviceHistoryList);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        sp_email = sharedPreferences.getString("email", "");
        viewCartAndHistory = ViewModelProviders.of(this).get(ViewCartAndHistory.class);

        //TODO: take all the services from history for a given email (type list of HistoryModel)->done
//        history = viewCartAndHistory.getHistoryByEmail(sp_email);

        ViewUser viewUser =  ViewModelProviders.of(this).get(ViewUser.class);
        ViewService viewService =  ViewModelProviders.of(this).get(ViewService.class);
        ViewJob viewJob =  ViewModelProviders.of(this).get(ViewJob.class);

        List<CartAndHistory> historyForUser = viewCartAndHistory.getHistoryByIdUser(viewUser.getUserByEmail(sp_email).getIdUser());

        history = new ArrayList<>();
        for(CartAndHistory cartAndHistory : historyForUser) {
            history.add(
                    new HistoryModel(
                            cartAndHistory.getIdUtility(),
                            viewJob.getJobById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_Job()).getDomainOfWork(),
                            viewUser.getUserById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_User()).getFirstName() +
                                    " " + viewUser.getUserById(viewService.getServiceById(cartAndHistory.getId_Fk_Service()).getId_Fk_User()).getLastName(),
                            Float.parseFloat(cartAndHistory.getFeedback()),
                            (new Date((new java.util.Date()).getTime())).toString()
                    )
            );
        }

        for(HistoryModel cartAndHistory : history)
            System.out.println(cartAndHistory.toString());

        //create a method
        displayRetrofitData();
    }

    private void displayRetrofitData() {
        for (int i=0;i<history.size();i++);
        //create adapter
        HistoryAdapter adapter=new HistoryAdapter(history,HistoryActivity.this, R.layout.list_item_history, viewCartAndHistory);
        lv.setAdapter(adapter);
    }
}