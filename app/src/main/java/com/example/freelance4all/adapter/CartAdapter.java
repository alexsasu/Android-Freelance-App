package com.example.freelance4all.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.freelance4all.R;
import com.example.freelance4all.classModels.CartModel;
import com.example.freelance4all.model.ViewCartAndHistory;

import java.util.List;

public class CartAdapter extends BaseAdapter {

    private final List<CartModel> cart;
    private final Context context;
    private final int layout;
    private final Button submit_button;
    private final TextView message_no_items;
    private final ViewCartAndHistory viewCartAndHistory;

    //generate constructor
    public CartAdapter(List<CartModel> cart, Context context, int layout, Button submit_button, TextView message_no_items, ViewCartAndHistory viewCartAndHistory) {
        this.cart = cart;
        this.context = context;
        this.layout = layout;
        this.submit_button = submit_button;
        this.message_no_items = message_no_items;
        this.viewCartAndHistory = viewCartAndHistory;
    }

    @Override
    public int getCount() {
        return cart.size();
    }

    @Override
    public Object getItem(int position) {
        return cart.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //create view holder innter class
    private class ViewHolder{
        TextView job, person, price;
        ImageButton imageButton;
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
        viewHolder.price = convertView.findViewById ( R.id.price );
        viewHolder.imageButton = convertView.findViewById(R.id.deleteButton);

        //set position
        CartModel model = cart.get ( position );
        viewHolder.person.setText ("Seller: " + model.getPerson() +"\n" );
        viewHolder.job.setText ("Job: " + model.getJob() + "\n");
        viewHolder.price.setText("Price: " + model.getPrice() + "\n");
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewCartAndHistory.deleteCartAndHistory(cart.get(position).getIdCart());  //delete the element from database
                cart.remove(position); //delete the element from local list

                notifyDataSetChanged();

                if(getCount() == 0) {
                    submit_button.setVisibility(View.INVISIBLE);
                    message_no_items.setVisibility(View.VISIBLE);
                }
            }
        });
        return convertView;
    }
}