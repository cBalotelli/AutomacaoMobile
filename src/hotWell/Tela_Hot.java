/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotWell;

import MassaMobile.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author henrique.rodrigues
 */
public class Tela_Hot extends javax.swing.JFrame {

    
    public static int r_completo=0,TQuantidadeMassa=0,Tmsysdn = 0,somaContrato=0,somaCPF=0,somaCustomer=0,r_cliente= 0, r_conta=0, r_oferta=0, r_assinante=0,TnumeroEmpresa , ofertaAtiva=0 ;
    public static String tipoNavegador = "",numeroEmpresa = "",getCliente="",auxCliente= "", getSubTipo="" , habilitadoNavegador ="",T_Cliente,TipoNomeSubTipo, Tcyclo, Tlink, TnumeroCyclo, TCustomerNumero, Tcontrato ;
    public static Boolean liberarAutomacao= false;
    private Color oldColor = null;
    public static ArrayList<String> iccd100 = new ArrayList<String> ();
    public static ArrayList<String> ListaCustomer = new ArrayList<String> ();
    public static ArrayList<String> ListaCPF = new ArrayList<String> ();
    public static ArrayList<String> ListaContrato = new ArrayList<String> ();
    	
	public static Boolean liberadoInciar= false;
	public static	ArrayList<String> msysdn = new ArrayList<String> ();
    /**
     * Creates new form Tela_Mobile
     */
    public Tela_Hot() {
        initComponents();
        
        
         //inserindo imagem no fundo 
        TelaPrincipal.setImagem(new File("C:\\Automacao_Mobile\\Imagem\\Tela_Principal2.jpg"));
        //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());
    
        //---------Alterando o OptionPane            
     UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI Semibold",Font.PLAIN,15)));
        
        
        
        
        
        
        
        
        
          msysdns.setDocument(new Numeric(1000));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaPrincipal = new componentes.UJPanelImagem();
        jLabel1 = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        Link = new javax.swing.JTextField();
        iE = new javax.swing.JRadioButton();
        painelList = new javax.swing.JPanel();
        scrolCustumer = new javax.swing.JScrollPane();
        msysdns = new javax.swing.JTextArea();
        TChrome = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Massa Mobile");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REMOVER  HOT_WELLCOME");

        iniciar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        iniciar.setText("INICIAR");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LINK DO MOBILE:");

        iE.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        iE.setForeground(new java.awt.Color(255, 255, 255));
        iE.setText("INTERNET EXPLORER");

        scrolCustumer.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        msysdns.setColumns(9);
        msysdns.setRows(5);
        msysdns.setTabSize(5);
        msysdns.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione Msisdn", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrolCustumer.setViewportView(msysdns);

        javax.swing.GroupLayout painelListLayout = new javax.swing.GroupLayout(painelList);
        painelList.setLayout(painelListLayout);
        painelListLayout.setHorizontalGroup(
            painelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrolCustumer, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        painelListLayout.setVerticalGroup(
            painelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrolCustumer, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        TChrome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TChrome.setForeground(new java.awt.Color(255, 255, 255));
        TChrome.setText("CHROME");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Removendo :  WELLCOME HOTLINE");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DE TODOS OS MISSIDN??S");

        javax.swing.GroupLayout TelaPrincipalLayout = new javax.swing.GroupLayout(TelaPrincipal);
        TelaPrincipal.setLayout(TelaPrincipalLayout);
        TelaPrincipalLayout.setHorizontalGroup(
            TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TelaPrincipalLayout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(TChrome, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(iE, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TelaPrincipalLayout.createSequentialGroup()
                            .addGap(183, 183, 183)
                            .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(TelaPrincipalLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(TelaPrincipalLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Link, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TelaPrincipalLayout.createSequentialGroup()
                                        .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel4))
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(painelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 24, 24))
        );
        TelaPrincipalLayout.setVerticalGroup(
            TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Link, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 23, Short.MAX_VALUE)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TChrome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(iniciar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        
        //Verificando a link da pagina
        if (Link.getText().equals("") || Link.getText().equals(null) ){
            JOptionPane.showMessageDialog(null,"Link Mobile Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
            Link.setBackground(new Color(255 ,106, 106));
            return;}else {Link.setBackground(oldColor);
        }    
            //Verificando o ciclo
        if (msysdns.getText().equals("") || msysdns.getText().equals(null) || msysdns.getText().equals("00") || msysdns.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Msisdn Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
            msysdns.setBackground(new Color(255 ,106, 106));
            return;}else {msysdns.setBackground(oldColor);
        }  
        
        if (habilitadoNavegador != "habilitado") {JOptionPane.showMessageDialog(null,"Selecione um Navegador"); 
            iE.setBackground(new Color(255 ,106, 106));TChrome.setBackground(new Color(255 ,106, 106));return;}
        else {TChrome.setBackground(oldColor);iE.setBackground(oldColor);}
	               
        
                   //Pegando iccds no Textarea
				 if(msysdns.getText().equals("")) {JOptionPane.showMessageDialog(null,"Insira os Msysdn??s"); msysdns.setBackground(Color.CYAN);return;
				 }else {msysdns.setBackground(Color.WHITE);}
				   String texto = msysdns.getText() ;				    
					StringTokenizer st = new StringTokenizer(texto,"\n") ;		
				    while (st.hasMoreTokens()) 
				    {
				        String line = st.nextToken();
				        msysdn.add(line);	
				        System.out.println("icdds da tela "+ msysdn);
				        TQuantidadeMassa++; 
				       
				    }
						if (msysdns.getText() != "") {
							Tmsysdn = 1; 
						}
				//Peagndo o link
				    Tlink = Link.getText();
				
				liberadoInciar=true;
				
				Automacao_Hot auto =new Automacao_Hot();
				auto.test();
							
		
               //  dispose();    

        // TODO add your handling code here:
    }//GEN-LAST:event_iniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Hot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Hot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Hot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Hot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Hot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Link;
    private javax.swing.JRadioButton TChrome;
    private componentes.UJPanelImagem TelaPrincipal;
    private javax.swing.JRadioButton iE;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea msysdns;
    private javax.swing.JPanel painelList;
    private javax.swing.JScrollPane scrolCustumer;
    // End of variables declaration//GEN-END:variables

    
    
}
     
   

