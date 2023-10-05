package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Pedido;
import java.util.List;

public class PedidoDAO {

    private List<Pedido> pedidos;

    public boolean salvar(Pedido pedido) {
        return pedidos.add(pedido);
    }
}
