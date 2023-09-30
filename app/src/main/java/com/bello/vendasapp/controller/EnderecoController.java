package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.EnderecoDAO;
import com.bello.vendasapp.modelo.Endereco;

public class EnderecoController {

    private final EnderecoDAO enderecoDAO = new EnderecoDAO();

    public boolean adicionarEndereco(Endereco endereco) {
        // Você pode adicionar validações adicionais aqui
        if (endereco.getLogradouro() == null || endereco.getNumero() == null) return false;

        return enderecoDAO.salvar(endereco);
    }

    // Implemente outros métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
