package com.example.freelance4all.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.freelance4all.R;
import com.example.freelance4all.classModels.HistoryModel;
import com.example.freelance4all.model.ViewCartAndHistory;

import java.util.List;

public class HistoryAdapter extends BaseAdapter {
    private final List<HistoryModel> history;
    private final Context context;
    private final int layout;
    private final ViewCartAndHistory viewCartAndHistory;

    //generate constructor
    public HistoryAdapter(List<HistoryModel> history, Context context, int layout, ViewCartAndHistory viewCartAndHistory) {
        this.history = history;
        this.context = context;
        this.layout = layout;
        this.viewCartAndHistory = viewCartAndHistory;
    }

    @Override
    public int getCount() {
        return history.size();
    }

    @Override
    public Object getItem(int position) {
        return history.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //create view holder innter class
    private class ViewHolder{
        TextView job, person, date;
        RatingBar ratingBar;
    }
    @SuppressLint({"ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // convertView is a RecycleView
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService ( Context.LAYOUT_INFLATER_SERVICE );
        convertView = layoutInflater.inflate ( layout,null );
        //id type casting
        viewHolder.job = convertView.findViewById ( R.id.job );
        viewHolder.person = convertView.findViewById ( R.id.person );
        viewHolder.ratingBar = convertView.findViewById ( R.id.ratingBar );
        viewHolder.date = convertView.findViewById ( R.id.date );

        //set position
        HistoryModel model = history.get(position );
        viewHolder.job.setText ("Job: "+ model.getJob()+ "\n");
        viewHolder.person.setText ("Seller: "+ model.getPerson()+"\n" );
        viewHolder.date.setText ("Submit date: "+ model.getDate()+"\n" );
        viewHolder.ratingBar.setRating(model.getFeedback());
        viewHolder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                // TODO: knowing the new feedback and the id of the utility, create a function that updates
                //  the feedback in database for the element with that id

                Integer id = history.get(position).getIdUtility();
                history.get(position).setFeedback(rating);

                viewCartAndHistory.updateHistoryFeedback(String.valueOf(rating), id);
            }
        });
        return convertView;
    }
}