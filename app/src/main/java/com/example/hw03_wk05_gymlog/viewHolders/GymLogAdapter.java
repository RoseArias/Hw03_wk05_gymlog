package com.example.hw03_wk05_gymlog.viewHolders;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.hw03_wk05_gymlog.database.entities.GymLog;

/**
 * Name: Rose Arias-Aceves Date: 12/2/25 Explanation: What is this class?
 */
public class GymLogAdapter extends ListAdapter<GymLog, GymLogViewHolder> {

  public GymLogAdapter(@NonNull DiffUtil.ItemCallback<GymLog> diffCallback) {
    super(diffCallback);
  }

  //creates the recycler widget and binds it to the main activity
  @NonNull
  @Override
  public GymLogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return GymLogViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(@NonNull GymLogViewHolder holder, int position) {
    GymLog current = getItem(position);
    holder.bind(current.toString());
  }

  public static class GymLogDiff extends DiffUtil.ItemCallback<GymLog> {

    @Override
    public boolean areItemsTheSame(@NonNull GymLog oldItem, @NonNull GymLog newItem) {
      return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull GymLog oldItem, @NonNull GymLog newItem) {
      return oldItem.equals(newItem);
    }
  }

}
