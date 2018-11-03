package br.uam.pi.client;

import br.uam.pi.db.Produto;
import br.uam.pi.server.TipoOperacaoEnum;
import java.io.Serializable;

public class DadosEnviados implements Serializable{
    private String usuario;
    private String senha;
    private Produto produto;
    private TipoOperacaoEnum operacao;

    public DadosEnviados(String usuario, String senha, Produto produto, TipoOperacaoEnum operacao) {
        this.usuario = usuario;
        this.senha = senha;
        this.operacao = operacao;
        this.produto = produto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoOperacaoEnum getOperacao() {
        return operacao;
    }

    public void setOperacao(TipoOperacaoEnum operacao) {
        this.operacao = operacao;
    }
    
}
