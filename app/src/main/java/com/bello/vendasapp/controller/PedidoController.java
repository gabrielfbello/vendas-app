package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.PedidoDAO;
import com.bello.vendasapp.modelo.Pedido;

public class PedidoController {

    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public boolean adicionarPedido(Pedido pedido) {
        if (pedido.getItens() == null || pedido.getItens().isEmpty() || pedido.getValorTotal() == null) return false;

        return pedidoDAO.salvar(pedido);
    }

}
