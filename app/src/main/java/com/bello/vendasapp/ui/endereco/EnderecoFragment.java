package com.bello.vendasapp.ui.endereco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.bello.vendasapp.modelo.Endereco;
import com.bello.vendasapp.ui.shared.SharedViewModel;
import com.bello.vendasapp.databinding.FragmentEnderecoBinding;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.bello.vendasapp.modelo.Cliente;

import java.util.ArrayList;

public class EnderecoFragment extends Fragment {
    private FragmentEnderecoBinding binding;
    private ArrayAdapter<Cliente> clienteAdapter;
    private SharedViewModel sharedViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEnderecoBinding.inflate(inflater, container, false);
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);


        clienteAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, new ArrayList<>());
        binding.spinnerClientes.setAdapter(clienteAdapter);

        binding.btnSalvarEndereco.setOnClickListener(v -> {
            Cliente clienteSelecionado = (Cliente) binding.spinnerClientes.getSelectedItem();
            if (clienteSelecionado == null) {
                Toast.makeText(getContext(), "Selecione um cliente", Toast.LENGTH_SHORT).show();
                return;
            }

            String logradouro = binding.edtLogradouro.getText().toString().trim();
            String numero = binding.edtNumero.getText().toString().trim();
            String bairro = binding.edtBairro.getText().toString().trim();
            String cidade = binding.edtCidade.getText().toString().trim();
            String uf = binding.edtUF.getText().toString().trim();

            if (!logradouro.isEmpty() && !numero.isEmpty() && !bairro.isEmpty() && !cidade.isEmpty() && !uf.isEmpty()) {
                Endereco novoEndereco = new Endereco(logradouro, numero, bairro, cidade, uf);
                clienteSelecionado.adicionarEndereco(novoEndereco);

                System.out.println("Endereço adicionado: " + novoEndereco.toString());
                System.out.println("Cliente: " + clienteSelecionado.toString());
                Toast.makeText(getContext(), "Endereço salvo com sucesso!", Toast.LENGTH_SHORT).show();
                limparCampos();
            } else {
                Toast.makeText(getContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            }
        });


        sharedViewModel.getClientes().observe(getViewLifecycleOwner(), clientes -> {
            clienteAdapter.clear();
            clienteAdapter.addAll(clientes);
        });

        return binding.getRoot();
    }

    private void limparCampos() {
        binding.edtLogradouro.setText("");
        binding.edtNumero.setText("");
        binding.edtBairro.setText("");
        binding.edtCidade.setText("");
        binding.edtUF.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
