package com.bello.vendasapp.ui.pedidos;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bello.vendasapp.R;
import com.bello.vendasapp.databinding.FragmentPedidosBinding;
import com.bello.vendasapp.modelo.Cliente;
import com.bello.vendasapp.modelo.Endereco;
import com.bello.vendasapp.modelo.Item;
import com.bello.vendasapp.modelo.ItemPedido;
import com.bello.vendasapp.ui.shared.SharedViewModel;
import java.util.ArrayList;
import java.util.List;

public class PedidoFragment extends Fragment {
    private FragmentPedidosBinding binding;
    private SharedViewModel sharedViewModel;
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    private ArrayAdapter<Endereco> enderecoAdapter;

    private double valorTotal = 0.0;
    private double valorFinalPedido = 0.0;
    private static final double DESCONTO_A_VISTA = 0.05;
    private static final double ACRESCIMO_A_PRAZO = 0.05;
    private static final double VALOR_FRETE_CIDADE_DIFERENTE = 20.00;
    private static final double VALOR_FRETE_ESTADO_DIFERENTE = 50.00;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding = FragmentPedidosBinding.inflate(inflater, container, false);

        enderecoAdapter = new EnderecoAdapter(getContext(), new ArrayList<>());
        binding.spinnerEnderecos.setAdapter(enderecoAdapter);

        ClienteAdapter clientesAdapter = new ClienteAdapter(getContext(), new ArrayList<>());
        binding.spinnerClientes.setAdapter(clientesAdapter);

        ArrayAdapter<Item> itemsAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, new ArrayList<>());
        binding.spinnerItems.setAdapter(itemsAdapter);

        binding.recyclerViewItens.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewItens.setAdapter(new ItensAdapter(new ArrayList<>()));

        binding.spinnerClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Cliente clienteSelecionado = (Cliente) binding.spinnerClientes.getSelectedItem();
                atualizarEnderecos(clienteSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        binding.spinnerEnderecos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                updateFinalValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        binding.btnAdicionarItem.setOnClickListener(v -> {
            Item itemSelecionado = (Item) binding.spinnerItems.getSelectedItem();
            String quantidadeStr = binding.edtQuantidade.getText().toString();

            if(itemSelecionado != null && !quantidadeStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(quantidadeStr);
                    valorTotal += itemSelecionado.getValorUnit() * quantidade;
                    binding.txtValorTotal.setText(String.format("Valor Total: R$%.2f", valorTotal));

                    ItemPedido novoItemPedido = new ItemPedido(itemSelecionado, quantidade);
                    itensPedidos.add(novoItemPedido);

                    binding.txtTotalItens.setText("Total de Itens: " + itensPedidos.size());
                    binding.edtQuantidade.setText("");

                    PedidoItensAdapter adapter = new PedidoItensAdapter(itensPedidos);
                    binding.recyclerViewItens.setAdapter(adapter);

                    updateFinalValue();
                } catch (NumberFormatException e) {
                    Toast.makeText(getContext(), "Quantidade inválida", Toast.LENGTH_SHORT).show();
                }
            }
            updateFinalValue();
        });

        binding.radioGroupPagamento.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioButtonAPrazo) {
                binding.edtParcelas.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.radioButtonAVista) {
                binding.edtParcelas.setVisibility(View.GONE);
                binding.edtParcelas.setText("");
                binding.listViewParcelas.setVisibility(View.GONE);
            }
            updateFinalValue();
        });


        binding.edtParcelas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int parcelas = Integer.parseInt(s.toString());
                    if (parcelas > 5) {
                        binding.edtParcelas.setText("5");
                        Toast.makeText(getContext(), "No máximo 5 parcelas são permitidas", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                }
                updateFinalValue();
            }

        });

        binding.btnConcluirPedido.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Pedido de venda cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        });

        return binding.getRoot();
    }

    private void atualizarEnderecos(Cliente cliente) {
        if (cliente != null) {
            enderecoAdapter.clear();
            enderecoAdapter.addAll(cliente.getEnderecos());
        }
    }

    private void updateFinalValue() {
        valorFinalPedido = valorTotal;

        Endereco enderecoSelecionado = (Endereco) binding.spinnerEnderecos.getSelectedItem();
        if (enderecoSelecionado != null) {
            if (!"Toledo-PR".equals(enderecoSelecionado.getCidade())) {
                valorFinalPedido += VALOR_FRETE_CIDADE_DIFERENTE;
            }
            if (!"PR".equals(enderecoSelecionado.getUf())) {
                valorFinalPedido += VALOR_FRETE_ESTADO_DIFERENTE;
            }
        }

        if (binding.radioButtonAVista.isChecked()) {
            valorFinalPedido = valorTotal * (1 - DESCONTO_A_VISTA);
        } else if (binding.radioButtonAPrazo.isChecked()) {
            valorFinalPedido = valorTotal * (1 + ACRESCIMO_A_PRAZO);
        }

        binding.txtValorTotalPedido.setText(String.format("Valor Total do Pedido: R$%.2f", valorFinalPedido));

        if (binding.radioButtonAPrazo.isChecked() && !binding.edtParcelas.getText().toString().isEmpty()) {
            int numeroParcelas = Integer.parseInt(binding.edtParcelas.getText().toString());
            double valorParcela = valorFinalPedido / numeroParcelas;
            updateParcelValue(valorParcela, numeroParcelas);
        }
    }

    private void updateParcelValue(double valorParcela, int numeroParcelas) {
        binding.listViewParcelas.setVisibility(View.VISIBLE);
        String textParcela = String.format("%d x R$%.2f", numeroParcelas, valorParcela);
        binding.listViewParcelas.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, new String[]{textParcela}));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        sharedViewModel.getClientes().observe(getViewLifecycleOwner(), clientes -> {
            if (clientes != null && !clientes.isEmpty()) {
                ClienteAdapter clientesAdapter = new ClienteAdapter(getContext(), clientes);
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

    private static class EnderecoAdapter extends ArrayAdapter<Endereco> {
        public EnderecoAdapter(@NonNull Context context, @NonNull List<Endereco> enderecos) {
            super(context, android.R.layout.simple_spinner_item, enderecos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            Endereco endereco = getItem(position);
            TextView textView = view.findViewById(android.R.id.text1);
            if (endereco != null) {
                textView.setText(endereco.getLogradouro() + ", " + endereco.getNumero() + " - " + endereco.getCidade() + "/" + endereco.getUf());
            }
            return view;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getDropDownView(position, convertView, parent);
            Endereco endereco = getItem(position);
            TextView textView = view.findViewById(android.R.id.text1);
            if (endereco != null) {
                textView.setText(endereco.getLogradouro() + ", " + endereco.getNumero() + " - " + endereco.getCidade() + "/" + endereco.getUf());
            }
            return view;
        }
    }


    private static class ClienteAdapter extends ArrayAdapter<Cliente> {
        public ClienteAdapter(@NonNull Context context, @NonNull List<Cliente> clientes) {
            super(context, android.R.layout.simple_spinner_item, clientes);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            Cliente cliente = getItem(position);
            TextView textView = view.findViewById(android.R.id.text1);
            if(cliente != null) textView.setText(cliente.getNome() + " - " + cliente.getCpf());
            return view;
        }
    }
}
