package com.bello.vendasapp.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bello.vendasapp.R;
import com.bello.vendasapp.controller.PedidoController;
import com.bello.vendasapp.modelo.Pedido;

public class PedidoActivity extends AppCompatActivity {

    private PedidoController pedidoController = new PedidoController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        // Aqui, você pode inicializar os componentes da sua view,
        // e configurar os listeners para os botões, etc.
    }

    // Supondo que você tenha um método para adicionar um novo pedido.
    private void adicionarPedido() {
        // Exemplo de criação e adição de um novo pedido.
        // Observe que esta é uma
    }

}