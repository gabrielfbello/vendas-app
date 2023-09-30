package com.bello.vendasapp.dao;

import com.bello.vendasapp.modelo.Pedido;
import java.util.List;

public class PedidoDAO {

    // Aqui você pode utilizar uma lista para simular um banco de dados, por exemplo.
    private List<Pedido> pedidos;

    public boolean salvar(Pedido pedido) {
        // Aqui você deve implementar a lógica para salvar o Pedido, por exemplo, inserindo em uma base de dados.
        return pedidos.add(pedido);
    }

    // Você pode adicionar mais métodos conforme necessário, por exemplo, para atualizar, deletar, buscar, etc.
}
