package com.example.postolache_predescu_sandur_sasu.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.data.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    private ArrayList<HistoryModel> services;
    private Context context;
    private int layout;
//generqate constructor

    public HistoryAdapter(ArrayList<HistoryModel> services, Context context, int layout) {
        this.services = services;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return services.size();
    }

    @Override
    public Object getItem(int position) {
        return services.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //create view holder innter class
    private class ViewHolder{
        TextView service,person, date;
        RatingBar ratingBar;
    }
    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convertView is a RecycleView

        ViewHolder viewHolder=new ViewHolder();
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        convertView=layoutInflater.inflate ( layout,null );
        //id type casting
        viewHolder.service=convertView.findViewById ( R.id.service );
        viewHolder.person=convertView.findViewById ( R.id.person );
        viewHolder.ratingBar=convertView.findViewById ( R.id.ratingBar );
        viewHolder.date=convertView.findViewById ( R.id.date );


        //set position
        HistoryModel model=services.get ( position );
        viewHolder.service.setText ("Service: "+ model.getService ()+ "\n");
        viewHolder.person.setText ("Person: "+ model.getPerson ()+"\n" );
        viewHolder.date.setText ("Date: "+ model.getDate()+"\n" );
        viewHolder.ratingBar.setRating(model.getFeedback());
        viewHolder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                Toast.makeText(context.getApplicationContext(), String.valueOf(rating), Toast.LENGTH_LONG).show();

                // TODO: functie sa modifice feedbackul pentru un anumit elem din history, dupa email, serviciu, id, data idk
            }
        });


        return convertView;
    }


}
