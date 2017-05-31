package org.dado.weardev.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.dado.entity.ViewUser;
import org.dado.weardev.R;

import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>{

    List<ViewUser> mViewUsers;

    public ItemsAdapter(List<ViewUser> viewUsers) {
        mViewUsers = viewUsers;
    }

    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_entry, parent, false);
        return new ItemsAdapter.ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ItemViewHolder holder, int position) {
        holder.mTextView.setText(mViewUsers.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mViewUsers.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_entry);
        }
    }

    public List<ViewUser> getViewUsers() {
        return mViewUsers;
    }

    public void setViewUsers(List<ViewUser> viewUsers) {
        mViewUsers = viewUsers;
    }
}
