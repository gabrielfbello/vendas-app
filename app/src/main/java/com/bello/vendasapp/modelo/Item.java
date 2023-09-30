package com.bello.vendasapp.modelo;

public class Item {
    private int codigo;
    private String descricao;
    private Double valorUnit;
    private String unidadeMedida;

    public Item(String descricao, Double valorUnit) {
        this.codigo = 0;
        this.descricao = descricao;
        this.valorUnit = valorUnit;
        this.unidadeMedida = "un";
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValorUnit() { return valorUnit; }
    public void setValorUnit(double valorUnit) { this.valorUnit = valorUnit; }
    public String getUnidadeMedida() { return unidadeMedida; }
    public void setUnidadeMedida(String unidadeMedida) { this.unidadeMedida = unidadeMedida; }

    @Override
    public String toString() {
        return descricao + " - Estoque: " + valorUnit;
    }
}
