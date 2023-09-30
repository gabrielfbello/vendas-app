package com.bello.vendasapp.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bello.vendasapp.R;
import com.bello.vendasapp.controller.ItemController;
import com.bello.vendasapp.modelo.Item;

import java.math.BigDecimal;

public class ItemActivity extends AppCompatActivity {

    private ItemController itemController = new ItemController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // Aqui, você pode inicializar os componentes da sua view,
        // e configurar os listeners para os botões, etc.
    }

    // Supondo que você tenha um método para adicionar um novo item.
    private void adicionarItem() {
        Item novoItem = new Item("Produto X", 10.00); // Não é necessário usar new Double("10.00"), apenas 10.00 é suficiente
        itemController.adicionarItem(novoItem);
    }
}
