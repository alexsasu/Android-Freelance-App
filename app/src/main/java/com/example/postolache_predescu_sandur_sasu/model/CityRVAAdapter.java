package com.example.postolache_predescu_sandur_sasu.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postolache_predescu_sandur_sasu.R;

public class CityRVAAdapter extends ListAdapter<City, CityRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public CityRVAAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<City> DIFF_CALLBACK = new DiffUtil.ItemCallback<City>() {
        @Override
        public boolean areItemsTheSame(City oldItem, City newItem) {
            return oldItem.getIdCity() == newItem.getIdCity();
        }

        @Override
        public boolean areContentsTheSame(City oldItem, City newItem) {
            // below line is to check the course name, description and course duration.
            return oldItem.getName().equals(newItem.getName());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        City model = getCityAt(position);
        holder.cityNameTV.setText(model.getName());
    }

    public City getCityAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cityNameTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            cityNameTV = itemView.findViewById(R.id.idTVCityName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(City model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
