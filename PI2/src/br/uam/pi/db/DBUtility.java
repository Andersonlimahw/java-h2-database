package br.uam.pi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.h2.tools.DeleteDbFiles;

public class DBUtility {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    private static String db_connection = "jdbc:h2:~/";
    private static String schema = "BANCO_SD";

   
    public DBUtility() throws SQLException {
        criarTabelas();
    }

    private static Connection obterConexao() {
        Connection dbConnection = null;
        try {
            // carrega driver de conexao banco H2
            Class.forName(DB_DRIVER);
        } catch (final ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            // conecta como banco local
            dbConnection = DriverManager.getConnection(db_connection + schema, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (final SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private void criarTabelas() throws SQLException {
        System.out.println("criar tabelas");

        // recupa a conexao
        final Connection connection = obterConexao();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();

            stmt.execute("CREATE TABLE IF NOT EXISTS USUARIOS (id IDENTITY PRIMARY KEY, nome VARCHAR(50), usuario VARCHAR(50), senha VARCHAR(50))");
            stmt.execute("CREATE TABLE IF NOT EXISTS PRODUTOS (codigo IDENTITY PRIMARY KEY, nome VARCHAR(50), descricao VARCHAR(200), preco DOUBLE, quantidade INT)");

            // inserimento do usuario 
            String nome = verificarUsuario("stark", "123");
            if (nome == null) {
                System.out.println("inserir usuario");
                stmt.execute("INSERT INTO USUARIOS(nome, usuario, senha) VALUES ('Tony Stark ', 'stark', '123')");
            } else {
                System.out.println("usuario encontrado");
            }

            stmt.close();
        } catch (final SQLException e) {
            System.out.println("Exception " + e.getMessage());
        } catch (final Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        } finally {
            connection.close();
        }

        System.out.println("FIM criar tabelas");
    }

    public String verificarUsuario(String usuario, String senha) throws Exception {
        System.out.println("verificar usuario " + usuario);
        final Connection connection = obterConexao();
        String nome = null;
        try {

            Statement stmt = connection.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT id, nome FROM USUARIOS WHERE usuario = '" + usuario + "' AND senha= '" + senha + "'");
            if (rs.next()) {
                int id = rs.getInt("id");
                nome = rs.getString("nome");
                System.out.println("usuario " + id + " (" + nome + ") entrou no sistema");
            } else {
                System.out.println("falha na autenticacao");
            }
            stmt.close();
        } catch (final Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }

        System.out.println("FIM verificar usuario");
        return nome;
    }

    public void inserirProduto(Produto produto) throws SQLException {
        System.out.println("inserir produto " + produto.getNome());
        final Connection connection = obterConexao();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO PRODUTOS(nome, descricao, preco, quantidade) VALUES ('" + produto.getNome() + "', '" + produto.getDescricao() + "', " + produto.getPreco() + ", " + produto.getQuantidade() + ")");

            stmt.close();
        } catch (final Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }
        System.out.println("FIM insert produto");
    }

    public List<Produto> selecionarProdutos() throws SQLException {
        System.out.println("selecionar produtos ");
        final Connection connection = obterConexao();
        List<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        try {

            Statement stmt = connection.createStatement();
            final ResultSet rs = stmt.executeQuery("SELECT codigo, nome, descricao, preco, quantidade  FROM PRODUTOS ");
            while (rs.next()) {
                produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                System.out.println(produto.toString());
                produtos.add(produto);
            }
            stmt.close();
            connection.commit();
        } catch (final Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }

        System.out.println("FIM selecionar produtos");
        return produtos;
    }

    public void atualizarProduto(int codigoProduto, int quantidade) throws SQLException {
        System.out.println("atualizar produto  " + codigoProduto + " quantidade atualizada = " + quantidade + " )");
        final Connection connection = obterConexao();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            stmt.execute("UPDATE PRODUTOS SET quantidade = " + quantidade + " WHERE codigo = " + codigoProduto);

            stmt.close();
        } catch (final Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }
        System.out.println("FIM atualizar produto ");
    }

    public void cancelarProduto(int codigoProduto) throws SQLException {
        System.out.println("cancelar produto  " + codigoProduto);
        final Connection connection = obterConexao();
        Statement stmt = null;

        try {
            stmt = connection.createStatement();
            stmt.execute("DELETE PRODUTOS WHERE codigo = " + codigoProduto);

            stmt.close();
        } catch (final Exception e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } finally {
            connection.close();
        }
        System.out.println("FIM cancelaUsuario ");
    }
   
    public static void main(final String[] args) throws Exception {
        System.out.println(" !!!!  ATENCAO !!!!!!\n   ESSE MAIN SERVE APENAS PARA TESTAR AS FUNCIONALIDADES DO BANCO" );
        System.out.println("\n limpando o banco (caso exista)" );
        DeleteDbFiles.execute("~", schema, true);
        
        DBUtility db = new DBUtility();
        System.out.println(" \n    ###   Test login ok  ###  " );
        db.verificarUsuario("stark", "123");
        System.out.println(" \n    ###   Test login falha  ###  " );
        db.verificarUsuario("stark", "456");

        System.out.println("\n    ###   Test inserirProduto  ###  ");
        Produto produto = new Produto(null, 10, "test1", 55.5d, "descricao 1 test");
        db.inserirProduto(produto);
        produto = new Produto(null, 22, "test2", 22.2d, "desc 2 test");
        db.inserirProduto(produto);

        System.out.println("\n    ###   Test selecionarProdutos  ###  ");
        List<Produto> produtos = db.selecionarProdutos();

        System.out.println("\n    ###   Test atualizarProduto  ###  ");
        db.atualizarProduto(1, 4);

        System.out.println("\n    ###   Test selecionarProdutos  ###  ");
        produtos = db.selecionarProdutos();

        System.out.println("\n    ###   Test cancelarProduto  ###  ");
        db.cancelarProduto(1);

        System.out.println("\n    ###   Test selecionarProdutos  ###  ");
        produtos = db.selecionarProdutos();
    }
}
