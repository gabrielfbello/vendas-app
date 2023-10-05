package com.bello.vendasapp.ui.pedidos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bello.vendasapp.modelo.Item;
import com.bello.vendasapp.modelo.ItemPedido;

import java.util.List;

public class PedidoItensAdapter extends RecyclerView.Adapter<PedidoItensAdapter.ItemPedidoViewHolder> {

    private final List<ItemPedido> itemPedidos;

    public PedidoItensAdapter(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    @NonNull
    @Override
    public ItemPedidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ItemPedidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPedidoViewHolder holder, int position) {
        ItemPedido itemPedido = itemPedidos.get(position);
        holder.textView1.setText(itemPedido.getItem().getDescricao() + " - R$" + itemPedido.getItem().getValorUnit());
        holder.textView2.setText("Quantidade: " + itemPedido.getQuantidade());
    }

    @Override
    public int getItemCount() {
        return itemPedidos.size();
    }

    public static class ItemPedidoViewHolder extends RecyclerView.ViewHolder {

        public final TextView textView1;
        public final TextView textView2;

        public ItemPedidoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(android.R.id.text1);
            textView2 = itemView.findViewById(android.R.id.text2);
        }
    }
}


