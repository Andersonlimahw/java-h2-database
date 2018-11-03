package br.uam.pi.server;

import br.uam.pi.client.DadosEnviados;
import br.uam.pi.db.DBUtility;
import br.uam.pi.db.Produto;
import br.uam.pi.client.DadosRetornados;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Atende extends Thread {

    private Socket cli;
    private DBUtility banco;

    public Atende(Socket cli, DBUtility banco) {
        this.cli = cli;
        this.banco = banco;
    }

    @Override
    public void run() {
        ObjectInputStream in;
        ObjectOutputStream out;
        DadosEnviados msg;
        DadosRetornados resp;
        while (true) {
            try {

                in = new ObjectInputStream(cli.getInputStream());
                msg = (DadosEnviados) in.readObject();
                Produto produto = msg.getProduto();

                if (TipoOperacaoEnum.LOGIN.equals(msg.getOperacao())) {

                    String nome = banco.verificarUsuario(msg.getUsuario(), msg.getSenha());
                    if (nome != null) {
                        List<Produto> produtos = banco.selecionarProdutos();
                        resp = new DadosRetornados(nome, produtos);
                    } else {
                        resp = new DadosRetornados("usuario nao encontrado");
                    }

                } else if (TipoOperacaoEnum.INSERT.equals(msg.getOperacao())) {

                    banco.inserirProduto(produto);
                    List<Produto> produtos = banco.selecionarProdutos();
                    resp = new DadosRetornados(produtos, "produto " + produto.getNome() + " inserido");

                } else if (TipoOperacaoEnum.UPDATE.equals(msg.getOperacao())) {

                    banco.atualizarProduto(produto.getCodigo(), produto.getQuantidade());
                    List<Produto> produtos = banco.selecionarProdutos();
                    resp = new DadosRetornados(produtos, "produto codigo " + produto.getCodigo() + " atualizado");

                } else if (TipoOperacaoEnum.DELETE.equals(msg.getOperacao())) {

                    banco.cancelarProduto(msg.getProduto().getCodigo());
                    List<Produto> produtos = banco.selecionarProdutos();
                    resp = new DadosRetornados(produtos, "produto codigo " + produto.getCodigo() + " removido");

                } else {
                    resp = new DadosRetornados("operacao nao encontrada");
                }

                out = new ObjectOutputStream(cli.getOutputStream());
                out.writeObject(resp);
                out.flush();
            } catch (Exception e) {
                System.out.println("Erro  responde :" + e.getMessage());
            }
        }
    }

}
