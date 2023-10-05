package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.ItemDAO;
import com.bello.vendasapp.modelo.Item;

public class ItemController {

    private final ItemDAO itemDAO = new ItemDAO();

    public boolean adicionarItem(Item item) {
        if (item.getDescricao() == null || item.getValorUnit() == null || item.getUnidadeMedida() == null) return false;

        return itemDAO.salvar(item);
    }

}
