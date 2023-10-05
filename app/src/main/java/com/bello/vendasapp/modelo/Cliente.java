package com.bello.vendasapp.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int codigo;
    private String nome;
    private String cpf;
    private String dataNasc;
    private float codigoEndereco;
    List<Endereco> enderecos = new ArrayList<>();

    // Construtor
    public Cliente(String nome, String cpf, String dataNasc) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.codigoEndereco = codigoEndereco;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getDataNasc() { return dataNasc; }
    public void setDataNasc(String dataNasc) { this.dataNasc = dataNasc; }
    public float getCodigoEndereco() { return codigoEndereco; }
    public void setCodigoEndereco(int codigoEndereco) { this.codigoEndereco = codigoEndereco; }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco) {
        this.enderecos.remove(endereco);
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf;
    }
}
