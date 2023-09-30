package com.bello.vendasapp.ui.pedidos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bello.vendasapp.databinding.FragmentPedidosBinding;
import com.bello.vendasapp.modelo.Cliente;
import com.bello.vendasapp.modelo.Item;
import com.bello.vendasapp.ui.shared.SharedViewModel;
import java.util.ArrayList;
import java.util.List;

public class PedidoFragment extends Fragment {
    private FragmentPedidosBinding binding;
    private SharedViewModel sharedViewModel;
    private List<Item> itensAdicionados = new ArrayList<>();
    private double valorTotal = 0.0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding = FragmentPedidosBinding.inflate(inflater, container, false);

        Spinner spinnerClientes = binding.spinnerClientes;
        Spinner spinnerItems = binding.spinnerItems;
        androidx.recyclerview.widget.RecyclerView recyclerViewItens = binding.recyclerViewItens;
        Button buttonAdicionarItem = binding.btnAdicionarItem;
        Button buttonConcluirPedido = binding.btnConcluirPedido;

        ArrayAdapter<Cliente> clientesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new ArrayList<>());
        spinnerClientes.setAdapter(clientesAdapter);

        ArrayAdapter<Item> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new ArrayList<>());
        spinnerItems.setAdapter(itemsAdapter);

        recyclerViewItens.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewItens.setAdapter(new ItensAdapter(new ArrayList<>()));

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sharedViewModel.getClientes().observe(getViewLifecycleOwner(), clientes -> {
            if (clientes != null && !clientes.isEmpty()) {
                ArrayAdapter<Cliente> clientesAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, clientes);
                binding.spinnerClientes.setAdapter(clientesAdapter);
            }
        });

        sharedViewModel.getItens().observe(getViewLifecycleOwner(), itens -> {
            if (itens != null && !itens.isEmpty()) {
                ArrayAdapter<Item> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, itens);
                binding.spinnerItems.setAdapter(itemsAdapter);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}