/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote_Principal;

import MassaMobile.Tela_Mobile;
import conexao.conectar;
import static conexao.conectar.loginLiberado;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author henrique.rodrigues
 */
public class LoginBanco extends javax.swing.JFrame {

    public static String nomeBancoConectado = "", host = "", banco = "", porta = "", hostWA = "", bancoWA = "", portaWA = "", nomeMobile;
    public static String caminhoRedeLogin = "\\\\srv-arq-02.intra_sp_spread\\Fabrica_de_Testes\\Fábrica de Teste Spread\\Automacao_mobile";
    //  public static String caminhoRedeLogin = "\\\\srv-arq-02.intra_sp_spread\\Fabrica_de_Testes\\Fábrica de Teste Spread\\PADUN\\Paulo.Bonelli\\Automacao_mobile";
// caminho para o paulo
    //  public static String caminhoRedeLogin = "C:\\Automacao_Mobile";

    /**
     * Creates new form LoginBanco
     */
    public LoginBanco() {
        initComponents();

        telaLogin.setImagem(new File(caminhoRedeLogin + "\\Imagem\\Tela_Principal2.jpg"));
        //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());

        //---------Alterando o OptionPane            
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI Semibold", Font.PLAIN, 15)));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaLogin = new componentes.UJPanelImagem();
        jLabel2 = new javax.swing.JLabel();
        listaNomeBanco = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conectar ao Banco");

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Logar:");

        listaNomeBanco.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        listaNomeBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "MOBILE 01", "MOBILE 02", "MOBILE 03", "MOBILE 04", "MOBILE 05", "MOBILE 06", "MOBILE 07", "MOBILE 08", "MOBILE 09", "MOBILE 10", "MOBILE 11", "MOBILE 12" }));
        listaNomeBanco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        listaNomeBanco.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listaNomeBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaNomeBancoActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe Print", 0, 11)); // NOI18N
        jButton1.setText("CONECTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LOCALHOST", "BRUX0802" }));

        javax.swing.GroupLayout telaLoginLayout = new javax.swing.GroupLayout(telaLogin);
        telaLogin.setLayout(telaLoginLayout);
        telaLoginLayout.setHorizontalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaLoginLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listaNomeBanco, 0, 211, Short.MAX_VALUE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLoginLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, telaLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        telaLoginLayout.setVerticalGroup(
            telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaLoginLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(telaLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listaNomeBanco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(telaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(telaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (listaNomeBanco.getSelectedItem() == "SELECIONE") {
            JOptionPane.showMessageDialog(null, "Selecione um Banco ", "Mensagem", JOptionPane.ERROR_MESSAGE);
            listaNomeBanco.setBackground(new Color(255, 106, 106));
            return;
        }

        System.out.println("Configurando o Bando na Tela login \n");

        String auxHost = "", auxBanco = "", auxPorta = "", auxNome = "", auxlink = "";
        String auxHostWA = "", auxBancoWA = "", auxPortaWA = "", auxNomeWA = "";

        if (listaNomeBanco.isFocusable() == true) {
            listaNomeBanco.removeItem("SELECIONE");
        }
        String local = jComboBox1.getSelectedItem().toString();
        int auxnome = listaNomeBanco.getSelectedIndex();
        switch (auxnome) {
            case 0:
                auxHost = "brux0040";
                auxBanco = "T01MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 01";
                auxlink = "http://" + local + ":20010/docroot/customerWizard/newCstMain.jsp#";

                auxHostWA = "brux0548";
                auxBancoWA = "T01DB11";
                auxPortaWA = "1521";
                auxNomeWA = "MOBILE 01";

                break;
            case 1:
                auxHost = "brux0040";
                auxBanco = "T02MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 02";
                auxlink = "http://" + local + ":20020/docroot/customerWizard/newCstMain.jsp#";

                auxHostWA = "brux0432";
                auxBancoWA = "T02DB11C";
                auxPortaWA = "1521";
                auxNomeWA = "MOBILE 02";

                break;
            case 2:
                auxHost = "brux0040";
                auxBanco = "T03MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 03";
                auxlink = "http://" + local + ":20030/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 3:
                auxHost = "localhost";
                auxBanco = "T04MB11";
                auxPorta = "0209";
                //      auxPorta ="10209";
                auxNome = "MOBILE 04";

                auxHostWA = "brux0548";
                auxBancoWA = "T04DB11";
                auxPortaWA = "1521";
                auxNomeWA = "MOBILE 04";
                auxlink = "http://" + local + ":20040/docroot/customerWizard/newCstMain.jsp#";

                break;
            case 4:
                auxHost = "brux0040";
                auxBanco = "T05MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 05";

                auxHostWA = "brux0548";
                auxBancoWA = "T05DB11";
                auxPortaWA = "1521";
                auxNomeWA = "MOBILE 05";
                auxlink = "http://" + local + ":20050/docroot/customerWizard/newCstMain.jsp#";

                break;
            case 5:
                auxHost = "localhost";
                auxBanco = "T06MB11";
                auxPorta = "0209";
                //      auxPorta ="10209";
                auxNome = "MOBILE 06";
                auxlink = "http://" + local + ":20060/docroot/customerWizard/newCstMain.jsp#";

                auxHostWA = "brux0432";
                auxBancoWA = "T06DB11C";
                auxPortaWA = "1522";
                auxNomeWA = "MOBILE 06";

                break;
            case 6:
                auxHost = "brux0040";
                auxBanco = "T07MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 07";
                auxlink = "http://" + local + ":20070/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 7:
                auxHost = "localhost";
                auxBanco = "T08MB11";
                auxPorta = "0209";
                //           auxPorta ="10209";
                auxNome = "MOBILE 08";
                auxlink = "http://" + local + ":20080/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 8:
                auxHost = "localhost";
                auxBanco = "T09MB11";
                auxPorta = "0209";
                //        auxPorta ="10209";
                auxNome = "MOBILE 09";
                auxlink = "http://" + local + ":20090/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 9:
                auxHost = "localhost";
                auxBanco = "T10MB11";
                auxPorta = "0209";
                //          auxPorta ="10209";
                auxNome = "MOBILE 10";
                auxlink = "http://" + local + ":20100/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 10:
                auxHost = "localhost";
                auxBanco = "T11MB11";
                auxPorta = "0209";
                //          auxPorta ="10209";
                auxNome = "MOBILE 11";
                auxlink = "http://" + local + ":20110/docroot/customerWizard/newCstMain.jsp#";
                break;
            case 11:
                auxHost = "brux0040";
                auxBanco = "T12MOB11";
                auxPorta = "1521";
                auxNome = "MOBILE 12";
                auxlink = "http://" + local + ":20120/docroot/customerWizard/newCstMain.jsp#";
                break;
        }

        //Pegando o nome do usuario
        String NomeUsuario = System.getProperty("user.name");
        if (NomeUsuario == "Paulo.Bonelli") {
            if (auxPorta == "0209") {
                auxPorta = "10209";
            }
        }

        host = auxHost;
        banco = auxBanco;
        porta = auxPorta;
        Transfers.setLink(auxlink);
        nomeMobile = auxNome;
        hostWA = auxHostWA;
        bancoWA = auxBancoWA;
        portaWA = auxPortaWA;

        nomeBancoConectado = ("Conectado: " + auxNome);

        System.out.println("Banco selecionando: " + auxNome);

        conectar con = new conectar();

        try {
            con.conexao();

            if (loginLiberado == false) {
                System.out.println("Problema em conectar ao Banco ");
                JOptionPane.showMessageDialog(null, "Não foi possivel conectar ao banco", "Mensagem", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (ClassNotFoundException ex) {

            System.out.println("Problema em conectar ao Banco");

            // Logger.getLogger(conector.class.getName()).log(Level.SEVERE, null, ex);
        }

////=================================================================================================       
////     =======================   conexão com o putty   ============================================       
//        String servidor = "200.169.114.141";//ipServidor do brux0802
//        // String servidor = "rjux0081";
//        ControleUsuario.setServer(servidor.trim());
//        ControleUsuario.setPassword("Unix11!");
//        ControleUsuario.setUser("mtawrk2");
//        
//        try {
//            Connection conn = new Connection(ControleUsuario.getServer());
//            conn.connect();
//            boolean autenticado;
//             autenticado = conn.autenticadoComSenha(ControleUsuario.getUser(), ControleUsuario.getPassword());         
//          
//             Session sess = conn.openSession();
//            sess.requestPTY("vt220");       
//            sess.startShell();
//            sess=conn.openSession();  
//            sess.execCommand("pwd ");   
//            
////=================================================================================================       
////=================================================================================================  
//            
        //    new SystemOut().setVisible(true);
        new Principal().setVisible(true);

        dispose();
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void listaNomeBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaNomeBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaNomeBancoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(LoginBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginBanco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginBanco().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> listaNomeBanco;
    private componentes.UJPanelImagem telaLogin;
    // End of variables declaration//GEN-END:variables
}
