package org.dado.weardev.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.dado.entity.ViewUser;
import org.dado.weardev.R;

import java.util.List;

/**
 * Created by dado on 23.05.17.
 */
public class ListRecyclerAdapterWear extends WearableRecyclerView.Adapter<ListRecyclerAdapterWear.ViewHolder> {

    private List<ViewUser> mItems;

    public ListRecyclerAdapterWear(List<ViewUser> items) {
        mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_entry, parent, false);
        return new ListRecyclerAdapterWear.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mItems.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_entry);
        }
    }

    public List<ViewUser> getItems() {
        return mItems;
    }

    public void setItems(List<ViewUser> items) {
        mItems = items;
    }
}
