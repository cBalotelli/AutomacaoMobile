/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaMobile;

import Pacote_Principal.LoginBanco;
import Pacote_Principal.Transfers;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique.rodrigues
 */

public class SelecaoOferta extends javax.swing.JFrame {

      Transfers dados = new Transfers();
    
	public static String TipoOfertaTexto = "",TipoOfertaSelect, TxpathTitulo,Txpathplano , boxSelect; 
	String titulo, plano;
    
    
    
    
    /**
     * Creates new form SelecaoOferta2
     */
    public SelecaoOferta() {
        initComponents();
        
        
         //inserindo imagem no fundo 
        TelaOferta.setImagem(new File(LoginBanco.caminhoRedeLogin+"\\Imagem\\Tela_Principal2.jpg"));
        
             //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());
    
        
        
        ofertaDefault1.setVisible(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaOferta = new componentes.UJPanelImagem();
        jLabel1 = new javax.swing.JLabel();
        TClienteNome = new javax.swing.JLabel();
        nomeOferta = new javax.swing.JTextField();
        procurar = new javax.swing.JButton();
        ofertaDefault1 = new javax.swing.JRadioButton();
        ofertaDefault2 = new javax.swing.JRadioButton();
        ofertaDefault3 = new javax.swing.JRadioButton();
        ofertaDefault4 = new javax.swing.JRadioButton();
        TClienteNome1 = new javax.swing.JLabel();
        procurar1 = new javax.swing.JButton();
        ofertaDefault5 = new javax.swing.JRadioButton();
        ofertaDefault6 = new javax.swing.JRadioButton();
        ofertaDefault7 = new javax.swing.JRadioButton();
        ofertaDefault8 = new javax.swing.JRadioButton();
        ofertaDefault9 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Oferta Nivel Contrato");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OFERTAS NIVEL CONTRATO");

        TClienteNome.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClienteNome.setForeground(new java.awt.Color(255, 255, 255));
        TClienteNome.setText("Oferta:");

        nomeOferta.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N

        procurar.setBackground(new java.awt.Color(255, 153, 51));
        procurar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        procurar.setText("IR para Pagina");
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });

        ofertaDefault1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault1.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault1.setText("Plano Claro Online - Claro Online 2GB + 100 min + Torpedos + DDD        R$ 252,89");
        ofertaDefault1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault1ActionPerformed(evt);
            }
        });

        ofertaDefault2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault2.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault2.setText("Plano -                                       Claro Família 500                                             R$ 417,72");
        ofertaDefault2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault2ActionPerformed(evt);
            }
        });

        ofertaDefault3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault3.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault3.setText("Claro Pós Mais  Claro Pós Mais 100GB + Minutos Ilimitados - Combo        R$ 459,99");
        ofertaDefault3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault3ActionPerformed(evt);
            }
        });

        ofertaDefault4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault4.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault4.setText("Claro Internet Mais       Claro Internet Mais 80GB - Individual                       R$ 149,99");
        ofertaDefault4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault4ActionPerformed(evt);
            }
        });

        TClienteNome1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClienteNome1.setForeground(new java.awt.Color(255, 255, 255));
        TClienteNome1.setText("( Plano default )");

        procurar1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        procurar1.setText("OK");
        procurar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurar1ActionPerformed(evt);
            }
        });

        ofertaDefault5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault5.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault5.setText(" Plano (GD . EMPRESA)   Plano Internet Corp Ilimitado 10GB                       R$  199,90");
        ofertaDefault5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault5ActionPerformed(evt);
            }
        });

        ofertaDefault6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault6.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault6.setText(" Claro Online Turbo                Claro Max 20GB                                     \t             R$ 679,43");
        ofertaDefault6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault6ActionPerformed(evt);
            }
        });

        ofertaDefault7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault7.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault7.setText(" Claro Online Turbo               500MB + 30min                        \t                       R$ 83,19");
        ofertaDefault7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault7ActionPerformed(evt);
            }
        });

        ofertaDefault8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault8.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault8.setText("Claro Controle Mais     Claro Controle Mais 2GB + 100min                            R$  00,0");
        ofertaDefault8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault8ActionPerformed(evt);
            }
        });

        ofertaDefault9.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ofertaDefault9.setForeground(new java.awt.Color(255, 255, 255));
        ofertaDefault9.setText(" Claro Controle Mais     Claro Controle Mais 4GB + Ilimitado                          R$  00,0");
        ofertaDefault9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaDefault9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TelaOfertaLayout = new javax.swing.GroupLayout(TelaOferta);
        TelaOferta.setLayout(TelaOfertaLayout);
        TelaOfertaLayout.setHorizontalGroup(
            TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaOfertaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(TelaOfertaLayout.createSequentialGroup()
                .addGroup(TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaOfertaLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(TelaOfertaLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(TClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TelaOfertaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ofertaDefault1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault3, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault5, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault6, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault7, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault8, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofertaDefault9, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(TelaOfertaLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(TClienteNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaOfertaLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(procurar1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        TelaOfertaLayout.setVerticalGroup(
            TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaOfertaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(procurar)
                .addGap(18, 18, 18)
                .addGroup(TelaOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TClienteNome)
                    .addComponent(nomeOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(ofertaDefault1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ofertaDefault8)
                .addGap(7, 7, 7)
                .addComponent(ofertaDefault9)
                .addGap(18, 18, 18)
                .addComponent(TClienteNome1)
                .addGap(18, 18, 18)
                .addComponent(procurar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ofertaDefault2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault2ActionPerformed

        
                                ofertaDefault1.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
                                       titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
        
        
				if(ofertaDefault2.isSelected()==true) {
				nomeOferta.setText("");
				boxSelect = "oferta 2";
				Transfers.setPlanoPreSelecionado(2);
				titulo = "//*[@id=\"groupHeader_380455396\"]/td[1]/img";
			    plano =  "//*[@id=\"groupId_380455396_27\"]/td[1]/input";
			         
			}else {
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);
			}



        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault2ActionPerformed

    private void ofertaDefault3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault3ActionPerformed

        		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false); 
                                ofertaDefault4.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);
                                
                                
				if(ofertaDefault3.isSelected()==true) {
				nomeOferta.setText("");
				boxSelect = "oferta 3";
				Transfers.setPlanoPreSelecionado(3);
				titulo = "//*[@id=\"groupHeader_414289844\"]/td[1]/img";
			    plano =  "//*[@id=\"groupId_414289844_0\"]/td[1]/input";
			         
			}else {
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);
			}



        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault3ActionPerformed

    private void ofertaDefault4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault4ActionPerformed

        		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);			
                                
                                
				if(ofertaDefault4.isSelected()==true) {
				nomeOferta.setText("");
				boxSelect = "oferta 4";
				Transfers.setPlanoPreSelecionado(4);
			    titulo = "//*[@id=\"groupHeader_414311123\"]/td[1]/img";
			    plano =  "//*[@id=\"groupId_414311123_15\"]/td[1]/input";
			         
			}else {
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);
			}




        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault4ActionPerformed

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
    try {
       if (Tela_Mobile.massaCompleta.isSelected() == true){
        if(Tela_Mobile.boxClienteS.isVisible() == false){
            JOptionPane.showMessageDialog(null, "Primeiro Selecione o Tipo de Cliente!");
            return;
        }     
        
        
        if(Tela_Mobile.massaCompleta.isSelected() == false){
            Transfers.setPlanoPreSelecionado(0);
      
        }    
        
        
		Transfers.setPlanoPreSelecionado(99);
	
            
            if (Tela_Mobile.boxClienteS.getSelectedItem() == "Normal" ){
                Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\individual.html\"");
            }                                            
             
            if (Tela_Mobile.boxClienteS.getSelectedItem() == "Grandes contas" ){
		Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\GRANDES_EMPRESAS - Oferta disponível.html");
            }
                
            if (Tela_Mobile.boxClienteS.getSelectedItem() == "Peq&media empresa" ){
		Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\PEQ_EMPRESA - Oferta disponível.html");
            }  
            
            }  
        if(Tela_Mobile.boxClienteS.isVisible() == false && Tela_Mobile.massaCompleta.isSelected() == false )
       
          if(Tela_Mobile.boxClienteSOferta.getSelectedItem() == "Normal" ){
                Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\individual.html\"");
            }                                            
             
            if(Tela_Mobile.boxClienteSOferta.getSelectedItem() == "Grandes contas" ){
		Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\GRANDES_EMPRESAS - Oferta disponível.html");
            }
                
            if(Tela_Mobile.boxClienteSOferta.getSelectedItem() == "Peq&media empresa" ){
		Runtime.getRuntime().exec("cmd.exe /c start chrome.exe \"\\\\srv-arq-02.intra_sp_spread\\\\Fabrica_de_Testes\\\\Fábrica de Teste Spread\\\\Automacao_mobile\\\\Ofertas_offline\\\\PEQ_EMPRESA - Oferta disponível.html");
            }  
       
                
	} catch (IOException e1) {					
			e1.printStackTrace();
	}

        // TODO add your handling code here:
    }//GEN-LAST:event_procurarActionPerformed

    private void ofertaDefault1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault1ActionPerformed

                                            		       
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);   
        
        
                                        titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
     			
				if(ofertaDefault1.isSelected()==true) {
				nomeOferta.setText("");
				ofertaDefault2.setSelected(false);
				titulo = "//*[@id=\"groupHeader_380780288\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_380780288_7\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(1);
				boxSelect = "oferta 1";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
				}




        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault1ActionPerformed

    private void procurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurar1ActionPerformed


				String oF = nomeOferta.getText();
//				if (oF != null) {
//					if (ofertaDefault.isSelected() == true ) {
//			JOptionPane.showMessageDialog(null, "Selecione Apenas 1 tipo de oferta");return;}
//				}
				
					 
				
				
				if (nomeOferta.getText().equals("") && ofertaDefault1.isSelected() == false && ofertaDefault2.isSelected() == false && ofertaDefault3.isSelected() == false
			           && ofertaDefault4.isSelected() == false && ofertaDefault5.isSelected() == false && ofertaDefault6.isSelected() == false && ofertaDefault7.isSelected() == false
                                        && ofertaDefault8.isSelected() == false && ofertaDefault9.isSelected() == false) {
					JOptionPane.showMessageDialog(null, "Selecione 1 tipo de oferta");return;}
				
				
				
				
				TipoOfertaTexto= nomeOferta.getText();
				
                                if(TipoOfertaTexto == ""){
                                    Transfers.setPlanoPreSelecionado(0);
                                     
                                }
                                
                                Transfers.setOfertaContratoNome(nomeOferta.getText());
                               
				if (ofertaDefault1.isSelected() == true ) {
					System.out.print("Oferta 1  Ativa \n");					
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault1.getText());
				}
				if (ofertaDefault2.isSelected() == true) {
					System.out.print("Oferta 2  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault2.getText());
				}
			
				if (ofertaDefault3.isSelected() == true) {
					System.out.print("Oferta 3  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault3.getText());
				}
				if (ofertaDefault4.isSelected() == true) {
					System.out.print("Oferta 4  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault4.getText());
				}
                                if (ofertaDefault5.isSelected() == true) {
					System.out.print("Oferta 5  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault5.getText());
				}
                                if (ofertaDefault6.isSelected() == true) {
					System.out.print("Oferta 6  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault6.getText());
				}
				
                                if (ofertaDefault7.isSelected() == true) {
					System.out.print("Oferta 7  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault7.getText());
				}   
                                if (ofertaDefault8.isSelected() == true) {
					System.out.print("Oferta 8  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault8.getText());
				} 
                                if (ofertaDefault9.isSelected() == true) {
					System.out.print("Oferta 9  Ativa \n");
					TxpathTitulo = titulo;
					Txpathplano = plano;
                                        Transfers.setOfertaContrato("S");
                                        Transfers.setOfertaContratoNome(ofertaDefault9.getText());
				} 
				
		             dispose();




        // TODO add your handling code here:
    }//GEN-LAST:event_procurar1ActionPerformed

    private void ofertaDefault5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault5ActionPerformed

        		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
				titulo = "";
				plano  = "";
				Transfers.setPlanoPreSelecionado(0);
                                
                                
        
				if(ofertaDefault5.isSelected()==true) {
				nomeOferta.setText("");				
				titulo = "//*[@id=\"groupHeader_380455396\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_380455396_34\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(5);
				boxSelect = "oferta 5";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
				}



        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault5ActionPerformed

    private void ofertaDefault6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault6ActionPerformed


        		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);  
                                ofertaDefault5.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
                                titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
        
        
				if(ofertaDefault6.isSelected()==true) {
				nomeOferta.setText("");			
				titulo = "//*[@id=\"groupHeader_394692736\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_394692736_23\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(6);
				boxSelect = "oferta 6";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
                                }
                               







        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault6ActionPerformed

    private void ofertaDefault7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault7ActionPerformed

                                
               		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);  
                                ofertaDefault5.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                ofertaDefault9.setSelected(false);
                                
                                        titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
         
                                if(ofertaDefault7.isSelected()==true) {
				nomeOferta.setText("");			
				titulo = "//*[@id=\"groupHeader_394692736\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_394692736_35\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(7);
				boxSelect = "oferta 7";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
				}





        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault7ActionPerformed

    private void ofertaDefault8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault8ActionPerformed

                                
               		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);  
                                ofertaDefault5.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault9.setSelected(false);
                                        titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
         
                                if(ofertaDefault8.isSelected()==true) {
				nomeOferta.setText("");			
				titulo = "//*[@id=\"groupHeader_414302387\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_414302387_0\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(8);
				boxSelect = "oferta 8";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
				}





        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault8ActionPerformed

    private void ofertaDefault9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaDefault9ActionPerformed


                                   
               		        ofertaDefault1.setSelected(false);
				ofertaDefault2.setSelected(false);
				ofertaDefault3.setSelected(false);  
                                ofertaDefault4.setSelected(false);  
                                ofertaDefault5.setSelected(false);
                                ofertaDefault6.setSelected(false);
                                ofertaDefault7.setSelected(false);
                                ofertaDefault8.setSelected(false);
                                        titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
         
                                if(ofertaDefault9.isSelected()==true) {
				nomeOferta.setText("");			
				titulo = "//*[@id=\"groupHeader_414302387\"]/td[1]/img";
				plano  = "//*[@id=\"groupId_414302387_3\"]/td[1]/input";
				Transfers.setPlanoPreSelecionado(9);
				boxSelect = "oferta 9";
				}else {
					titulo = "";
					plano = "";
					Transfers.setPlanoPreSelecionado(0);
				}








        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaDefault9ActionPerformed

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
            java.util.logging.Logger.getLogger(SelecaoOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecaoOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecaoOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecaoOferta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecaoOferta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TClienteNome;
    private javax.swing.JLabel TClienteNome1;
    private componentes.UJPanelImagem TelaOferta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nomeOferta;
    private javax.swing.JRadioButton ofertaDefault1;
    private javax.swing.JRadioButton ofertaDefault2;
    private javax.swing.JRadioButton ofertaDefault3;
    private javax.swing.JRadioButton ofertaDefault4;
    private javax.swing.JRadioButton ofertaDefault5;
    private javax.swing.JRadioButton ofertaDefault6;
    private javax.swing.JRadioButton ofertaDefault7;
    private javax.swing.JRadioButton ofertaDefault8;
    private javax.swing.JRadioButton ofertaDefault9;
    private javax.swing.JButton procurar;
    private javax.swing.JButton procurar1;
    // End of variables declaration//GEN-END:variables
}