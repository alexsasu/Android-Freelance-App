package com.example.freelance4all.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.freelance4all.R;
import com.example.freelance4all.classModels.ServiceCard;
import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.myViewHolder> {

    Context mContext;
    List<ServiceCard> mData;
    public ServiceAdapter(Context mContext, List<ServiceCard> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ServiceAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.activity_service_card, parent, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.myViewHolder holder, int position) {
        holder.tv_description.setText(mData.get(position).getDescription());
        holder.tv_price.setText(mData.get(position).getPrice());
        holder.tv_seller.setText(mData.get(position).getSeller());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView tv_description, tv_price, tv_seller;
        public myViewHolder(View itemView) {
            super(itemView);
            tv_description = itemView.findViewById(R.id.service_description);
            tv_price = itemView.findViewById(R.id.service_price);
            tv_seller = itemView.findViewById(R.id.service_seller);
        }
    }
}