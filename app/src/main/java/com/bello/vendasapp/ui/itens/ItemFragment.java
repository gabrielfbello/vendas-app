package com.bello.vendasapp.ui.itens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bello.vendasapp.R;
import com.bello.vendasapp.modelo.Item;
import com.bello.vendasapp.ui.shared.SharedViewModel;

import java.util.List;

public class ItemFragment extends Fragment {

    private EditText editTextDescricao;
    private EditText editTextValorUnit;
    private Button buttonAdicionarItem;
    private SharedViewModel sharedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_itens, container, false);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        editTextDescricao = root.findViewById(R.id.editTextDescricao);
        editTextValorUnit = root.findViewById(R.id.editTextValorUnit);
        buttonAdicionarItem = root.findViewById(R.id.buttonAdicionarItem);

        buttonAdicionarItem.setOnClickListener(v -> {
            String descricao = editTextDescricao.getText().toString();
            String valorUnitStr = editTextValorUnit.getText().toString();

            if (descricao.isEmpty() || valorUnitStr.isEmpty()) {
                Toast.makeText(getContext(), "Ambos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double valorUnit = Double.parseDouble(valorUnitStr);
                if(valorUnit <= 0) {
                    Toast.makeText(getContext(), "O valor unitário deve ser maior que zero", Toast.LENGTH_SHORT).show();
                    return;
                }

                Item novoItem = new Item(descricao, valorUnit);
                sharedViewModel.adicionarItem(novoItem);

                // Limpar os campos após adicionar o item
                editTextDescricao.setText("");
                editTextValorUnit.setText("");

                Toast.makeText(getContext(), "Item adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                System.out.println("Item adicionado: " + novoItem);

                List<Item> itens = sharedViewModel.getItens().getValue();
                if (itens != null) {
                    System.out.println("Itens: ");
                    for (Item item : itens) {
                        System.out.println(item);
                    }
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "O valor unitário deve ser um número válido", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}