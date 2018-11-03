package br.uam.pi.client;

import br.uam.pi.db.Produto;
import java.io.Serializable;
import java.util.List;

public class DadosRetornados implements Serializable{
    private String nome;
    private String resultado;
    private List<Produto> produtos;

    public DadosRetornados(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.produtos = produtos;
    }

    public DadosRetornados(List<Produto> produtos, String resultado) {
        this.produtos = produtos;
        this.resultado = resultado;
    }

    public DadosRetornados(String resultado) {
        this.resultado = resultado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getResultado() {
        return resultado;
    }
}
