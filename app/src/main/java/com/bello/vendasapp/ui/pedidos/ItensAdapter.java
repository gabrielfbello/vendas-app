package com.bello.vendasapp.ui.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bello.vendasapp.R;
import com.bello.vendasapp.modelo.Item;

import java.util.List;

public class ItensAdapter extends RecyclerView.Adapter<ItensAdapter.ItensViewHolder> {

    private final List<Item> itemList;

    public ItensAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItensViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItensViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItensViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.textViewItemName.setText(item.getDescricao());
        holder.textViewItemValue.setText(String.valueOf(item.getValorUnit()));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    static class ItensViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItemName;
        TextView textViewItemValue;

        public ItensViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewItemName = itemView.findViewById(R.id.textViewItemName);
            textViewItemValue = itemView.findViewById(R.id.textViewItemValue);
        }
    }
}
