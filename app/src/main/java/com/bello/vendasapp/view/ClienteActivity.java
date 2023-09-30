package com.bello.vendasapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bello.vendasapp.R;
import com.bello.vendasapp.controller.ClienteController;
import com.bello.vendasapp.modelo.Cliente;

public class ClienteActivity extends AppCompatActivity {

    private ClienteController clienteController = new ClienteController();
    private EditText editTextNome;
    private EditText editTextCPF;
    private EditText editTextDataNasc;
    private Button buttonAdicionarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        editTextNome = findViewById(R.id.editTextNome);
        editTextCPF = findViewById(R.id.editTextCPF);
        editTextDataNasc = findViewById(R.id.editTextDataNasc);
        buttonAdicionarCliente = findViewById(R.id.buttonAdicionarCliente);

        buttonAdicionarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Salvando cliente...");
                String nome = editTextNome.getText().toString();
                String cpf = editTextCPF.getText().toString();
                String dataNasc = editTextDataNasc.getText().toString();
                if (nome.isEmpty() || cpf.isEmpty() || dataNasc.isEmpty()) {
                    Toast.makeText(ClienteActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Cliente novoCliente = new Cliente(nome, cpf, dataNasc);

                try {
                    System.out.println("Adicionando cliente...");
                    if (clienteController.adicionarCliente(novoCliente)) {
                        System.out.println("Cliente adicionado com sucesso!");
                        Toast.makeText(ClienteActivity.this, "Cliente adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println("Erro ao adicionar cliente!");
                        Toast.makeText(ClienteActivity.this, "Erro ao adicionar cliente!", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao adicionar cliente!" + e.getMessage());
                    Toast.makeText(ClienteActivity.this, "Erro ao adicionar cliente!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
