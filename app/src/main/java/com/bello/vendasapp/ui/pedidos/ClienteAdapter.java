package com.bello.vendasapp.ui.pedidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bello.vendasapp.modelo.Cliente;
import java.util.List;

public class ClienteAdapter extends ArrayAdapter<Cliente> {
    public ClienteAdapter(Context context, List<Cliente> clientes) {
        super(context, 0, clientes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cliente cliente = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(cliente.getNome() + " - " + cliente.getCpf());

        return convertView;
    }
}
