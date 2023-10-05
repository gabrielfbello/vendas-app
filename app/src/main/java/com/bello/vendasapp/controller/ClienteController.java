package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.ClienteDAO;
import com.bello.vendasapp.modelo.Cliente;

public class ClienteController {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    public boolean adicionarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getCpf() == null || cliente.getDataNasc() == null) return false;

        return clienteDAO.salvar(cliente);
    }

}
