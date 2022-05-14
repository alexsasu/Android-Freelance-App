package com.example.postolache_predescu_sandur_sasu.model;

//public class ServiceRVAAdapter {
//}

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postolache_predescu_sandur_sasu.R;

public class ServiceRVAAdapter extends ListAdapter<Service, ServiceRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;
    ServiceRVAAdapter() {
        super(DIFF_CALLBACK);
    }
    private static final DiffUtil.ItemCallback<Service> DIFF_CALLBACK = new DiffUtil.ItemCallback<Service>() {
        @Override
        public boolean areItemsTheSame(Service oldItem, Service newItem) {
            return oldItem.getIdService() == newItem.getIdService();
        }

        @Override
        public boolean areContentsTheSame(Service oldItem, Service newItem) {
            return oldItem.getId_Fk_User().equals(newItem.getId_Fk_User()) &&
                    oldItem.getId_Fk_Job().equals(newItem.getId_Fk_Job()) &&
                    oldItem.getId_Fk_City().equals(newItem.getId_Fk_City()) &&
                    oldItem.getExperienceYears().equals(newItem.getExperienceYears()) &&
                    oldItem.getWorkSchedule().equals(newItem.getWorkSchedule());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service model = getServiceAt(position);
        holder.SellerIdTV.setText(model.getId_Fk_User());
        holder.JobIdTV.setText(model.getId_Fk_Job());
        holder.CityIdTV.setText(model.getId_Fk_City());
        holder.ExperienceYearsTV.setText(model.getExperienceYears());
        holder.WorkScheduleTV.setText(model.getWorkSchedule());
    }

    public Service getServiceAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView SellerIdTV,JobIdTV,CityIdTV,ExperienceYearsTV,WorkScheduleTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            SellerIdTV = itemView.findViewById(R.id.idTVSellerId);
            JobIdTV = itemView.findViewById(R.id.idTVJobId);
            CityIdTV = itemView.findViewById(R.id.idTVCityId);
            ExperienceYearsTV = itemView.findViewById(R.id.idTVExperienceYears);
            WorkScheduleTV = itemView.findViewById(R.id.idTVWorkSchedule);

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
        void onItemClick(Service model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}