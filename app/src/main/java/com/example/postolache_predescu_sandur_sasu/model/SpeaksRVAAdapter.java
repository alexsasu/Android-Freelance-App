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

public class SpeaksRVAAdapter extends ListAdapter<Speaks , SpeaksRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public SpeaksRVAAdapter() { super(DIFF_CALLBACK); }

    private static final DiffUtil.ItemCallback<Speaks > DIFF_CALLBACK = new DiffUtil.ItemCallback<Speaks >() {
        @Override
        public boolean areItemsTheSame(Speaks  oldItem, Speaks  newItem) {
            return oldItem.getId_fK_User() == newItem.getId_fK_User() && oldItem.getId_fK_Language() == newItem.getId_fK_Language();
        }

        @Override
        public boolean areContentsTheSame(Speaks  oldItem, Speaks  newItem) {
            return true;
            //oldItem.getId_fK_Language().equals(newItem.getId_fK_Language());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speaks_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Speaks  model = getSpeaksAt(position);
        holder.userIdTV.setText(model.getId_fK_User());
    }

    public Speaks  getSpeaksAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userIdTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTV = itemView.findViewById(R.id.idTVUserId);

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
        void onItemClick(Speaks  model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

