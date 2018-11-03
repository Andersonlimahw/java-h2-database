package br.uam.pi.db;

import java.io.Serializable;

public class Produto implements Serializable{

    private Integer codigo, quantidade;
    private String nome, descricao;
    private double preco;

    public Produto() {
    }

    public Produto(Integer codigo, Integer quantidade, String nome, double preco, String descricao) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
    
}
