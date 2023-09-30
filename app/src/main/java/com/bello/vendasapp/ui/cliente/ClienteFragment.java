package com.bello.vendasapp.ui.cliente;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bello.vendasapp.databinding.FragmentClienteBinding;
import com.bello.vendasapp.modelo.Cliente;
import com.bello.vendasapp.modelo.Item;
import com.bello.vendasapp.ui.shared.SharedViewModel;

import java.util.List;

public class ClienteFragment extends Fragment {

    private FragmentClienteBinding binding;
    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding = FragmentClienteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonAdicionarCliente.setOnClickListener(v -> adicionarCliente());
        return root;
    }

    private void adicionarCliente() {
        String nome = binding.editTextNome.getText().toString();
        String cpf = binding.editTextCPF.getText().toString();
        String dataNasc = binding.editTextDataNasc.getText().toString();

        if(nome.isEmpty() || cpf.isEmpty() || dataNasc.isEmpty()) {
            Toast.makeText(getContext(), "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Adiciona cliente ao ViewModel compartilhado.
        Cliente novoCliente = new Cliente(nome, cpf, dataNasc); // Supondo que você tem um construtor adequado em seu modelo Cliente.
        sharedViewModel.adicionarCliente(novoCliente);

        // Limpa os campos após a adição
        binding.editTextNome.setText("");
        binding.editTextCPF.setText("");
        binding.editTextDataNasc.setText("");

        // Log e Toast para confirmar a ação
        Toast.makeText(getContext(), "Cliente adicionado com sucesso!", Toast.LENGTH_SHORT).show();

        System.out.println("Cliente adicionado: " + novoCliente);

        List<Cliente> clientes = sharedViewModel.getClientes().getValue();
        if (clientes != null) {
            System.out.println("Clientes: ");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}