/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaCRM;


import Pacote_Principal.Processando;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author henrique.rodrigues
 */
public class Automacao extends javax.swing.JFrame {

    
public static WebDriver navegador;
public static boolean liberado , Parar = false  , clienteOK, contaOK,organizaOK,assinanteOK;
public static  int contadorMassa = 0, contador=0;
private int QMassa=0,a_completo=0, a_cliente= 0,somaCustomer=0,somaCpf=0, a_conta=0, a_oferta=0, a_assinante=0;
public static  String  msgFinalizacao ="",customerLista = "", imgCliente,imgConta,imgOrganiza,imgAssinante;
public static ArrayList<String> evidenciaMassa = new ArrayList<String> ();
public static	ArrayList<String> ListaCustomer = new ArrayList<String> ();
public boolean resposta = false; 

    
    /**
     * Creates new form Automacao
     */
    public Automacao() throws InterruptedException, ClassNotFoundException, IOException, BiffException, ParseException, AWTException, UnsupportedFlavorException   {
        initComponents();
       
   
       
        planilha_Xml Lerxml = new planilha_Xml();
        EscreverXml  EditarXml = new EscreverXml();
       
        //inserindo imagem no fundo
        int contador = 0;
        //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());
        //---------Alterando o OptionPane
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI Semibold",Font.PLAIN,15)));
        
            // Processando auto =new Processando();
         //    auto.setVisible(true);
        // Processando.contador.setText(contadorMassa +" / "+Tela_Mobil.contadorQuantidade);
        
//	do {
//	    liberado = Tela_Mobile.liberarAutomacao;
//	   System.out.println("Aguardando a Configuracao");
//
//	 } while (liberado == false );
//
//    Processando auto =new Processando();
//  auto.setVisible(true);



            // criando a pasta de evidencia evidencias       
            criarEvidencia ();
            System.out.println("Pasta de Evidencia Criada com Sucesso");
   
            //Lendo a Planilha
            if (Lerxml.leituraXml(resposta)) {
                System.out.println("Dados Localizados com sucesso\n");
                System.out.println("CPF: "+ planilha_Xml.Cpf);
                System.out.println("NOME: "+ planilha_Xml.Nome);
                System.out.println("DATA_NASCIMENTO: "+ planilha_Xml.Nascimento);
                System.out.println("STATUS: "+ planilha_Xml.Status);           
            } else {System.out.println("Erro ao Localizar Dados da Planilha");}
                
           //chamando a classe do Robo
            ProcessoCRM crm= new ProcessoCRM();
            crm.Bollean();
            
             // Setando o Status '1' da planilha       
            if (EditarXml.EscreverXml(resposta)) {        
                System.out.println("Linha: "+planilha_Xml.linhaPlanilha+" Alterada com Sucesso");                 
            }  else { System.out.println("Erro em Alterar Dados da Planilha"); } 
            
            
            
            System.exit(0);





//
//
//
//
//    // chamando a classe do txt a cada nova massa
//       GravandoTxt("");
//
//    //Criando um array para coletar evidencias   
//      evidenciaMassa.add("");
//    
//      System.out.println("\n--------------   Customer  -----------------------------------------------------------------------------------------------------------------");
//	  System.out.println("");
//	  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
//
//	  
//    //Chamando a classe para Print
//	System.out.println("Chamando a classe para Print");
//	 Object dataPrint = getDateTime();
//	 String nomePrint = (dataPrint+".jpeg") ;//
//	 takeSnapShot  (navegador , nomePrint );
//
//
//         //Setando o contado de Massa
//         contadorMassa ++;
//         Processando.contador.setText(contadorMassa +" / "+contador);
//         processando.repaint();
//
//    //Trocando imagem após a conclusao 
//    clienteOK = false;
//    contaOK = false;
//    organizaOK = false;   
//    assinanteOK = false;
//
//
//
//
//
//
//
//
//	
//           JOptionPane.showMessageDialog(null,"Massa Criada com Sucesso!","Mensagem", JOptionPane.INFORMATION_MESSAGE);
//           System.out.println("\n\n");
//           System.out.println("            -------------------------------------------------------");
//           System.out.println("            -          Fim do processo de automacao de Massa      -");
//           System.out.println("            -------------------------------------------------------");
//	    
//           //Setando para parar o while do processando
//           
//           Parar = true;
//           navegador.quit();
//	   processando.dispose();
//           //retomando a tela principal
//           new Principal().setVisible(true);
  
}
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Automacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Automacao().setVisible(false);
                } catch (Exception ex) {
                    Logger.getLogger(Automacao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


//Clasee de Print
	private void takeSnapShot(WebDriver navegador, String nomePrint) {
		
	// Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) navegador); 
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String NomeUsuario = System.getProperty("user.name");      
        String imageFileDir = "C:\\Documents and Settings\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa";
        String nomeDoArquivoImagem = nomePrint;
		try {
			FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
        
	
	//Classe de criacao da pasta de Evidencia
	public void criarEvidencia() {
        try {
            String NomeUsuario = System.getProperty("user.name");
            File diretorio = new File("C:\\Documents and Settings\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa ");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio Pasta de evidencia");
            System.out.println(ex);
        }
    }
	
	// adicionando customer a cada criacao
	public void  GravandoTxt(String CustomerId) {
	
		String NomeUsuario = System.getProperty("user.name");
		String path = "C:\\Documents and Settings\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa\\Lista Customers.txt"; 			
	    FileWriter arq = null;
	
					BufferedWriter bw = null;
			        try {
			            bw = new BufferedWriter(new FileWriter(path, true));
			            bw.newLine();
			            bw.write(CustomerId);
			          //  bw.newLine();
			            bw.flush();
			        } catch (IOException ioe) {
			            ioe.printStackTrace();
			        } finally { // always close the file
			            if (bw != null) {
			                try {
			                    bw.close();
			                } catch (IOException ioe2) {
			                    // just ignore it
			                }} }
			      //  }//eslse
			            
			  System.out.printf("Lista de customers criado com sucesso 'TXT'");      				
				
	}
		

	//Capturando a data do sistema
	private Object getDateTime() {	
        DateFormat dataFormatada = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
        Date data1 = new Date();
        return dataFormatada.format(data1);
		
		
	}





















}
