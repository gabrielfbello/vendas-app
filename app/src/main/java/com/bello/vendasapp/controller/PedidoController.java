package com.bello.vendasapp.controller;

import com.bello.vendasapp.dao.PedidoDAO;
import com.bello.vendasapp.modelo.Pedido;

public class PedidoController {

    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public boolean adicionarPedido(Pedido pedido) {
        // Você pode adicionar validações adicionais aqui
        if (pedido.getItens() == null || pedido.getItens().isEmpty() || pedido.getValorTotal() == null) return false;

        return pedidoDAO.salvar(pedido);
    }

    // Implemente outros métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
