package br.uam.pi.server;

import br.uam.pi.db.DBUtility;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    
    public static int PORT = 9700;
    private static DBUtility banco;
    public static void main(String[] args) throws SQLException {
        ServerSocket server;
        Socket cli;
        System.out.println("Server central ativo");
        banco = new DBUtility();
        
        try { 
            server = new ServerSocket(PORT);
            while(true){
                cli = server.accept();
                System.out.println("Conectado com "+
                        cli.getInetAddress().getHostAddress());
                Atende at = new Atende(cli, banco);
                at.start();
            }
        } catch (IOException e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
