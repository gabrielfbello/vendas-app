package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    public boolean salvar(Cliente cliente) {
        // Aqui você deve implementar a lógica para salvar o Cliente, por exemplo, inserindo em uma base de dados.
        return clientes.add(cliente);
    }

    // Você pode adicionar mais métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
