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

public class LanguageRVAdapter extends
        ListAdapter<Language, LanguageRVAdapter.ViewHolder> {

    private OnItemClickListener listener;

    // constructor
    public LanguageRVAdapter() {
        super(DIFF_CALLBACK);
    }

    // creating call back
    private static final DiffUtil.ItemCallback<Language> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Language>() {
                @Override
                public boolean areItemsTheSame(Language oldItem, Language newItem) {
                    return oldItem.getIdLanguage() == newItem.getIdLanguage();
                }

                @Override
                public boolean areContentsTheSame(Language oldItem, Language newItem) {
                    return oldItem.getLanguageName().equals(newItem.getLanguageName());
                }
            };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.language_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Language langModel = getLanguageAt(position);
        holder.languageNameTV.setText(langModel.getLanguageName());

    }

    public Language getLanguageAt(int position) {
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // view holder class to create a variable for each view.
        TextView languageNameTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            languageNameTV = itemView.findViewById(R.id.idLLLanguage);

            // the name is add on click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition(); //the position for listner
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Language langModel);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}