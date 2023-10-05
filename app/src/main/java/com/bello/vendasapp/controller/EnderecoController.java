package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.EnderecoDAO;
import com.bello.vendasapp.modelo.Endereco;

public class EnderecoController {

    private final EnderecoDAO enderecoDAO = new EnderecoDAO();

    public boolean adicionarEndereco(Endereco endereco) {
        if (endereco.getLogradouro() == null || endereco.getNumero() == null) return false;

        return enderecoDAO.salvar(endereco);
    }

}
