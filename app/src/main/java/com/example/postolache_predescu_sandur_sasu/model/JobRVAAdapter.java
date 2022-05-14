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

public class JobRVAAdapter extends ListAdapter<Job , JobRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;
    
    public JobRVAAdapter() { super(DIFF_CALLBACK); }
    
    private static final DiffUtil.ItemCallback<Job > DIFF_CALLBACK = new DiffUtil.ItemCallback<Job >() {
        @Override
        public boolean areItemsTheSame(Job  oldItem, Job  newItem) {
            return oldItem.getIdJob() == newItem.getIdJob();
        }

        @Override
        public boolean areContentsTheSame(Job  oldItem, Job  newItem) {
            return oldItem.getDomainOfWork().equals(newItem.getDomainOfWork());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Job  model = getJobAt(position);
        holder.jobNameTV.setText(model.getDomainOfWork());
    }
    
    public Job  getJobAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jobNameTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            jobNameTV = itemView.findViewById(R.id.idTVJobName);

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
        void onItemClick(Job  model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}