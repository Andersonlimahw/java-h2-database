package br.uam.pi.client;

import br.uam.pi.db.Produto;
import br.uam.pi.server.Server;
import br.uam.pi.server.TipoOperacaoEnum;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ClienteChat extends javax.swing.JFrame {

    static Socket sc = null;
    Escuta escuta;

    public ClienteChat() {
        initComponents();
        escuta = new Escuta(sc, areaSaida, lblNome, jBtnLogin, jTxtSenha, jTxtUsuario);
        escuta.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areaSaida = new javax.swing.JTextArea();
        lblNome = new javax.swing.JLabel();
        jTxtUsuario = new javax.swing.JTextField();
        jBtnLogin = new javax.swing.JButton();
        jBtnAdd = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jTxtSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de produtos");
        setBackground(new java.awt.Color(222, 222, 222));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        areaSaida.setColumns(20);
        areaSaida.setRows(5);
        jScrollPane1.setViewportView(areaSaida);

        lblNome.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N

        jBtnLogin.setBackground(new java.awt.Color(102, 102, 102));
        jBtnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnLogin.setForeground(new java.awt.Color(255, 255, 255));
        jBtnLogin.setText("LOGIN");
        jBtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnLoginActionPerformed(evt);
            }
        });

        jBtnAdd.setBackground(new java.awt.Color(102, 102, 102));
        jBtnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnAdd.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd.setText("incluir");
        jBtnAdd.setToolTipText("");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnEdit.setBackground(new java.awt.Color(102, 102, 102));
        jBtnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnEdit.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit.setText("atualizar");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnDelete.setBackground(new java.awt.Color(102, 102, 102));
        jBtnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnDelete.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete.setText("deletar");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Gerenciador de produtos - Lemon Tech -  &copy - 2018");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Histórico de operações");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("v 1.0.0.0 27/10/2018");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Senha");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Login");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Usuário: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Operações de produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jBtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jBtnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnLogin))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnDelete)
                            .addComponent(jBtnEdit))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        PrintStream enviar;
        escuta.parar();

    }//GEN-LAST:event_formWindowClosing

    private void jBtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLoginActionPerformed
        try {
            DadosEnviados msg = new DadosEnviados(jTxtUsuario.getText(), new String(jTxtSenha.getPassword()).trim(), null, TipoOperacaoEnum.LOGIN);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(msg);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        }
    }//GEN-LAST:event_jBtnLoginActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        try {
            String codigo = JOptionPane.showInputDialog("digite o codigo do produto que sera deletado");
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(codigo));
            DadosEnviados msg = new DadosEnviados(jTxtUsuario.getText(), new String(jTxtSenha.getPassword()).trim(), p, TipoOperacaoEnum.DELETE);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(msg);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        }
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        try {
            String codigo = JOptionPane.showInputDialog("digite o codigo do produto que sera editado");
            String quantidade = JOptionPane.showInputDialog("digite a nova quantidade ");
            Produto p = new Produto();
            p.setCodigo(Integer.parseInt(codigo));
            p.setQuantidade(Integer.parseInt(quantidade));
            DadosEnviados msg = new DadosEnviados(jTxtUsuario.getText(), new String(jTxtSenha.getPassword()).trim(), p, TipoOperacaoEnum.UPDATE);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(msg);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        }
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        try {
            String nome = JOptionPane.showInputDialog("digite o nome do produto");
            String descricao = JOptionPane.showInputDialog("digite a descricao do produto");
            String preco = JOptionPane.showInputDialog("digite o preco do produto");
            String quantidade = JOptionPane.showInputDialog("digite a  quantidade ");
            Produto p = new Produto();
            p.setNome(nome);
            p.setDescricao(descricao);
            p.setPreco(Double.parseDouble(preco));
            p.setQuantidade(Integer.parseInt(quantidade));
            DadosEnviados msg = new DadosEnviados(jTxtUsuario.getText(), new String(jTxtSenha.getPassword()).trim(), p, TipoOperacaoEnum.INSERT);
            ObjectOutputStream out = new ObjectOutputStream(sc.getOutputStream());
            out.writeObject(msg);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        }
    }//GEN-LAST:event_jBtnAddActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            sc = new Socket("127.0.0.1", Server.PORT);
        } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Ocorreu um erro ao executar a operação, por favor tente novamente.");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteChat().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea areaSaida;
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField jTxtSenha;
    private javax.swing.JTextField jTxtUsuario;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables
}
