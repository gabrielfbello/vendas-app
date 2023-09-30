package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Endereco;
import java.util.List;

public class EnderecoDAO {

    // Aqui você pode utilizar uma lista para simular um banco de dados, por exemplo.
    private List<Endereco> enderecos;

    public boolean salvar(Endereco endereco) {
        // Aqui você deve implementar a lógica para salvar o Endereco, por exemplo, inserindo em uma base de dados.
        return enderecos.add(endereco);
    }

    // Você pode adicionar mais métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
