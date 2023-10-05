package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    public boolean salvar(Cliente cliente) {
        return clientes.add(cliente);
    }

}
