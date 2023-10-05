package com.bello.vendasapp.ui.endereco;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bello.vendasapp.databinding.FragmentEnderecoBinding;

public class EnderecoFragment extends Fragment {
    private FragmentEnderecoBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentEnderecoBinding.inflate(inflater, container, false);

        binding.btnSalvarEndereco.setOnClickListener(v -> {
            String logradouro = binding.edtLogradouro.getText().toString().trim();
            String numero = binding.edtNumero.getText().toString().trim();
            String bairro = binding.edtBairro.getText().toString().trim();
            String cidade = binding.edtCidade.getText().toString().trim();
            String uf = binding.edtUF.getText().toString().trim();

            if (!logradouro.isEmpty() && !numero.isEmpty() && !bairro.isEmpty() && !cidade.isEmpty() && !uf.isEmpty()) {

                Toast.makeText(getContext(), "Endereço salvo com sucesso!", Toast.LENGTH_SHORT).show();

                limparCampos();

            } else {
                Toast.makeText(getContext(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            }
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
