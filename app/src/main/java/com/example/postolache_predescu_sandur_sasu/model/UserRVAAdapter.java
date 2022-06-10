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

public class UserRVAAdapter extends ListAdapter<User, UserRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public UserRVAAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<User> DIFF_CALLBACK = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(User oldItem, User newItem) {
            return oldItem.getIdUser()== newItem.getIdUser();
        }

        @Override
        public boolean areContentsTheSame(User oldItem, User newItem) {

            return oldItem.getType().equals(newItem.getType()) &&
                    oldItem.getEmail().equals(newItem.getEmail()) &&
                    oldItem.getPassword().equals(newItem.getPassword()) &&
                    oldItem.getFirstName().equals(newItem.getFirstName())&&
                    oldItem.getLastName().equals(newItem.getLastName())&&
                    oldItem.getDescription().equals(newItem.getDescription())&&
                    oldItem.getPhoneNumber().equals(newItem.getPhoneNumber());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User model = getUserAt(position);
        holder.userTypeTV.setText(model.getType());
        holder.userEmailTV.setText(model.getEmail());
        holder.userPasswordTV.setText(model.getPassword());
        holder.userFirstNameTV.setText(model.getFirstName());
        holder.userLastNameTV.setText(model.getLastName());
        holder.userDescriptionTV.setText(model.getDescription());
        holder.userPhoneNumberTV.setText(model.getPhoneNumber());
    }

    public User getUserAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userTypeTV, userEmailTV, userPasswordTV, userFirstNameTV,
                 userLastNameTV, userDescriptionTV, userPhoneNumberTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            userTypeTV = itemView.findViewById(R.id.idTVUserType);
            userEmailTV = itemView.findViewById(R.id.idTVUserEmail);
            userPasswordTV = itemView.findViewById(R.id.idTVUserPassword);
            userFirstNameTV = itemView.findViewById(R.id.idTVUserFirstName);
            userLastNameTV = itemView.findViewById(R.id.idTVUserLastName);
            userDescriptionTV = itemView.findViewById(R.id.idTVUserDescription);
            userPhoneNumberTV = itemView.findViewById(R.id.idTVUserPhoneNumber);

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
        void onItemClick(User model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}

