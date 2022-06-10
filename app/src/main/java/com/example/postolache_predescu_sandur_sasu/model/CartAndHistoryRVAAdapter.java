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

public class CartAndHistoryRVAAdapter extends ListAdapter<CartAndHistory , CartAndHistoryRVAAdapter.ViewHolder> {

    private OnItemClickListener listener;

    public CartAndHistoryRVAAdapter() { super(DIFF_CALLBACK); }

    private static final DiffUtil.ItemCallback<CartAndHistory > DIFF_CALLBACK = new DiffUtil.ItemCallback<CartAndHistory >() {
        @Override
        public boolean areItemsTheSame(CartAndHistory  oldItem, CartAndHistory  newItem) {
            return oldItem.getIdUtility() == newItem.getIdUtility();
        }

        @Override
        public boolean areContentsTheSame(CartAndHistory  oldItem, CartAndHistory  newItem) {
            return oldItem.getFeedback().equals(newItem.getFeedback())
                    && oldItem.getId_FK_User().equals(newItem.getId_FK_User())
                    && oldItem.getId_Fk_Service().equals(newItem.getId_Fk_Service())
                    && oldItem.getType().equals(newItem.getType())
                    && oldItem.getDate().equals(newItem.getDate());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_and_history_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartAndHistory  model = getCartAndHistoryAt(position);
        holder.cartAndHistoryFeedbackTV.setText(model.getFeedback());
        holder.cartAndHistoryIdUserTV.setText(model.getId_FK_User());
        holder.cartAndHistoryIdUtilityTV.setText(model.getId_Fk_Service());
        holder.cartAndHistoryIdServiceTV.setText(model.getId_Fk_Service());
        holder.cartAndHistoryTypeTV.setText(model.getType());
        holder.cartAndHistoryDateTV.setText((CharSequence) model.getDate());
    }

    public CartAndHistory  getCartAndHistoryAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cartAndHistoryFeedbackTV;
        TextView cartAndHistoryIdUtilityTV;
        TextView cartAndHistoryIdUserTV;
        TextView cartAndHistoryIdServiceTV;
        TextView cartAndHistoryTypeTV;
        TextView cartAndHistoryDateTV;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cartAndHistoryFeedbackTV = itemView.findViewById(R.id.idTVCartAndHistoryFeedback);
            cartAndHistoryIdUserTV = itemView.findViewById(R.id.idTVCartAndHistoryIdBuyer);
            cartAndHistoryIdServiceTV = itemView.findViewById(R.id.idTVCartAndHistoryIdService);
            cartAndHistoryTypeTV = itemView.findViewById(R.id.idTVCartAndHistoryType);
            cartAndHistoryDateTV = itemView.findViewById(R.id.idTVCartAndHistoryDate);
            cartAndHistoryIdUtilityTV = itemView.findViewById(R.id.idTVCartAndHistoryIdUtility);


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
        void onItemClick(CartAndHistory  model);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
