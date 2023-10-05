package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Item;
import java.util.List;

public class ItemDAO {

    private List<Item> itens;

    public boolean salvar(Item item) {
        return itens.add(item);
    }

}
