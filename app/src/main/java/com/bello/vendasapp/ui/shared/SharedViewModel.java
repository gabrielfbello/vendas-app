    package com.bello.vendasapp.ui.shared;

    import android.util.Log;

    import androidx.lifecycle.MutableLiveData;
    import androidx.lifecycle.ViewModel;

    import com.bello.vendasapp.modelo.Cliente;
    import com.bello.vendasapp.modelo.Endereco;
    import com.bello.vendasapp.modelo.Item;

    import java.util.ArrayList;
    import java.util.List;

    public class SharedViewModel extends ViewModel {
        public SharedViewModel() {
            Endereco enderecoJoao = new Endereco("Rua A", "123", "Bairro Central", "São Paulo", "SP");
            Endereco enderecoMaria = new Endereco("Rua B", "456", "Bairro Leste", "Rio de Janeiro", "RJ");

            List<Cliente> clientesMock = new ArrayList<>();

            Cliente joao = new Cliente("João", "123.456.789-10", "01/01/1990");
            joao.adicionarEndereco(enderecoJoao);
            clientesMock.add(joao);

            Cliente maria = new Cliente("Maria", "987.654.321-01", "02/02/1992");
            maria.adicionarEndereco(enderecoMaria);
            clientesMock.add(maria);

            clientes.setValue(clientesMock);

            List<Item> itensMock = new ArrayList<>();
            itensMock.add(new Item("Item A", 10.0));
            itensMock.add(new Item("Item B", 20.0));
            itens.setValue(itensMock);
        }

        private final MutableLiveData<List<Cliente>> clientes = new MutableLiveData<>(new ArrayList<>());
        private final MutableLiveData<List<Item>> itens = new MutableLiveData<>(new ArrayList<>());


        public MutableLiveData<List<Item>> getItens() {
            return itens;
        }

        public MutableLiveData<List<Cliente>> getClientes() {
            return clientes;
        }

        public void adicionarItem(Item item) {
            List<Item> currentList = itens.getValue();
            currentList.add(item);
            itens.setValue(currentList);
        }

        public void removerItem(Item item) {
            List<Item> currentList = itens.getValue();
            currentList.remove(item);
            itens.setValue(currentList);
        }

        public void adicionarCliente(Cliente cliente) {
            List<Cliente> currentList = clientes.getValue();
            currentList.add(cliente);
            clientes.setValue(currentList);
        }

        public void removerCliente(Cliente cliente) {
            List<Cliente> currentList = clientes.getValue();
            currentList.remove(cliente);
            clientes.setValue(currentList);
        }
    }
