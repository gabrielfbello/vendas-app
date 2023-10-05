package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Endereco;
import java.util.List;

public class EnderecoDAO {

    private List<Endereco> enderecos;

    public boolean salvar(Endereco endereco) {
        return enderecos.add(endereco);
    }

}
