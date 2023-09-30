package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Item;
import java.util.List;

public class ItemDAO {

    // Aqui você pode utilizar uma lista para simular um banco de dados, por exemplo.
    private List<Item> itens;

    public boolean salvar(Item item) {
        // Aqui você deve implementar a lógica para salvar o Item, por exemplo, inserindo em uma base de dados.
        return itens.add(item);
    }

    // Você pode adicionar mais métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
