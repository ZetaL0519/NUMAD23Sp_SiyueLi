package edu.northeastern.numad23sp_siyueli;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RviewAdapter extends RecyclerView.Adapter<RViewHolder> {
    private final ArrayList<ItemCard> itemList;

    public RviewAdapter(ArrayList<ItemCard> itemList) {
        this.itemList = itemList;
    }

    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        ItemCard currentItem = itemList.get(position);

        holder.urlName.setText(currentItem.getUrlName());
        holder.url.setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
