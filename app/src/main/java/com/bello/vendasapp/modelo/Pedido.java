package com.bello.vendasapp.modelo;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private int codigo;
    private int codigoCliente;

    private List<Item> itens;
    private BigDecimal valorTotal;
    private String condicaoPagamento;
    private int numeroParcelas;
    private BigDecimal valorParcela;
    private List<Endereco> enderecoEntrega;

    public Pedido(int codigo, int codigoCliente, List<Item> itens, BigDecimal valorTotal, String condicaoPagamento,
                  int numeroParcelas, BigDecimal valorParcela, List<Endereco> enderecoEntrega) {
        this.codigo = codigo;
        this.codigoCliente = codigoCliente;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.condicaoPagamento = condicaoPagamento;
        this.numeroParcelas = numeroParcelas;
        this.valorParcela = valorParcela;
        this.enderecoEntrega = enderecoEntrega;
    }

    // Getters e Setters
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getCodigoCliente() { return codigoCliente; }
    public void setCodigoCliente(int codigoCliente) { this.codigoCliente = codigoCliente; }
    public List<Item> getItens() { return itens; }
    public void setItens(List<Item> itens) { this.itens = itens; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public String getCondicaoPagamento() { return condicaoPagamento; }
    public void setCondicaoPagamento(String condicaoPagamento) { this.condicaoPagamento = condicaoPagamento; }
    public int getNumeroParcelas() { return numeroParcelas; }
    public void setNumeroParcelas(int numeroParcelas) { this.numeroParcelas = numeroParcelas; }
    public BigDecimal getValorParcela() { return valorParcela; }
    public void setValorParcela(BigDecimal valorParcela) { this.valorParcela = valorParcela; }
    public List<Endereco> getEnderecoEntrega() { return enderecoEntrega; }
    public void setEnderecoEntrega(List<Endereco> enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
}
