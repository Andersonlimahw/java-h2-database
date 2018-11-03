package br.uam.pi.client;

import br.uam.pi.db.Produto;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Escuta extends Thread {

    Socket cli;
    JTextArea saida;
    JLabel lblNome;
    JButton jBtnLogin;
    JPasswordField jTxtSenha;
    JTextField jTxtUsuario;
    String nome = null;
    boolean fim;

    public Escuta(Socket cli, JTextArea saida, JLabel lblNome, JButton jBtnLogin, JPasswordField jTxtSenha,
            JTextField jTxtUsuario) {
        this.cli = cli;
        this.saida = saida;
        this.lblNome = lblNome;
        this.jBtnLogin = jBtnLogin;
        this.jTxtUsuario = jTxtUsuario;
        this.jTxtSenha = jTxtSenha;
        fim = false;
    }

    public void run() {
        try {

            while (!fim) {
                ObjectInputStream in = new ObjectInputStream(cli.getInputStream());
                DadosRetornados resp = (DadosRetornados) in.readObject();

                // login ainda nao efetuado
                if (nome == null) {
                    nome = resp.getNome();
                    if (nome == null) {
                        saida.setText(resp.getResultado());
                    } else {
                        lblNome.setText(nome);
                        jBtnLogin.setEnabled(false);
                        jTxtSenha.setEditable(false);
                        jTxtUsuario.setEditable(false);
                        List<Produto> produtos = resp.getProdutos();
                        String listaProd = "";
                        for (Produto p : produtos) {
                            listaProd = listaProd + p.getCodigo() + ": " + p.getNome() + " = " + p.getDescricao() + " ( quant " + p.getQuantidade() + "), preço " + p.getPreco() + "\n";
                        }
                        saida.setText(listaProd);
                    }
                } else {
                    // login efetuado
                    List<Produto> produtos = resp.getProdutos();
                    String listaProd = "";
                    for (Produto p : produtos) {
                        listaProd = listaProd + p.getCodigo() + ": " + p.getNome() + " = " + p.getDescricao() + " ( quant " + p.getQuantidade() + "), preço " + p.getPreco() + "\n";
                    }
                    saida.setText(listaProd);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void parar() {
        fim = true;
    }
}
