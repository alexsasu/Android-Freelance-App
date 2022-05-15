package com.example.postolache_predescu_sandur_sasu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.postolache_predescu_sandur_sasu.R;
import com.example.postolache_predescu_sandur_sasu.data.CartModel;
import com.example.postolache_predescu_sandur_sasu.model.Service;

import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    private ArrayList<CartModel> cart;
    private Context context;
    private int layout;
    private Button submit_button;
    private TextView message_no_items;
//generqate constructor

    public CartAdapter(ArrayList<CartModel> cart, Context context, int layout, Button submit_button, TextView message_no_items) {

        this.cart = cart;
        this.context = context;
        this.layout = layout;
        this.submit_button = submit_button;
        this.message_no_items = message_no_items;

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
        TextView service,person;
        ImageButton imageButton;
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
        viewHolder.imageButton=convertView.findViewById(R.id.deleteButton);


        //set position
        CartModel model=cart.get ( position );
        viewHolder.service.setText ("Service: "+ model.getService()+ "\n");
        viewHolder.person.setText ("Title: "+ model.getPerson ()+"\n" );
        viewHolder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart.remove(position);
                notifyDataSetChanged();

                if(getCount() == 0){
                    submit_button.setVisibility(View.INVISIBLE);
                    message_no_items.setVisibility(View.VISIBLE);
                }

            }
        });
        return convertView;
    }


}