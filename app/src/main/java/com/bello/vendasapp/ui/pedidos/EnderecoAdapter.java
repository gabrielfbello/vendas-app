package com.bello.vendasapp.ui.pedidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bello.vendasapp.modelo.Endereco;

import java.util.List;

public class EnderecoAdapter extends ArrayAdapter<Endereco> {
    public EnderecoAdapter(Context context, List<Endereco> enderecos) {
        super(context, 0, enderecos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Endereco endereco = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(endereco.getLogradouro() + ", " + endereco.getNumero() + " - " + endereco.getCidade() + "/" + endereco.getUf());


        return convertView;
    }
}
