package com.bello.vendasapp.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bello.vendasapp.R;
import com.bello.vendasapp.controller.EnderecoController;
import com.bello.vendasapp.modelo.Endereco;

public class EnderecoActivity extends AppCompatActivity {

    private EnderecoController enderecoController = new EnderecoController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);

        // Aqui, você pode inicializar os componentes da sua view,
        // e configurar os listeners para os botões, etc.
    }

    // Supondo que você tenha um método para adicionar um novo endereço.
    private void adicionarEndereco() {
        // Exemplo de criação e adição de um novo endereço.
        Endereco novoEndereco = new Endereco(1, "Rua das Flores", "123", "Centro", "São Paulo", "SP");
        enderecoController.adicionarEndereco(novoEndereco);
    }
}
