/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaMobile;

import Impressao.Impressao_docx;
import Impressao.PrintTela;
import Pacote_Principal.Processando;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pacote_Principal.Transfers;
import QueryS.PrimeiroIccd;

/**
 *
 * @author henrique.rodrigues
 */
public class Automacao extends javax.swing.JFrame {

    Processando processando = new Processando();

    public static WebDriver navegador;
    public static boolean liberado, Parar = false, clienteOK, contaOK, organizaOK, assinanteOK;
    public static int contadorMassa = 0, contador = 0;
    private int QMassa = 0, a_completo = 0, a_cliente = 0, somaCustomer = 0, somaCpf = 0, a_conta = 0, a_oferta = 0, a_assinante = 0;
    public static String msgFinalizacao = "", customerLista = "", imgCliente, imgConta, imgOrganiza, imgAssinante, MsgErro = "";

    public static ArrayList<String> ListaCliente = new ArrayList<String>();
    public static ArrayList<String> ListaNomeCliente = new ArrayList<String>();
    public static ArrayList<String> ListaAssinante = new ArrayList<String>();
    public static ArrayList<String> ListaConta = new ArrayList<String>();
    public static ArrayList<String> ListaCpf = new ArrayList<String>();
    public static ArrayList<String> ListaCustomer = new ArrayList<String>();
//public static String cpfGerado= "";

    PrintTela print = new PrintTela();

    /**
     * Creates new form Automacao
     */
    public Automacao() throws Exception {
        initComponents();

        Transfers dados = new Transfers();
//      Impressao_docx  impressao_docx = new Impressao_docx();

        boolean retorno = false;

        //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());

        //---------Alterando o OptionPane            
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI Semibold", Font.PLAIN, 15)));

        a_completo = Tela_Mobile.r_completo;
        a_cliente = Tela_Mobile.r_cliente;
        a_conta = Tela_Mobile.r_conta;
        a_oferta = Tela_Mobile.r_oferta;
        a_assinante = Tela_Mobile.r_assinante;

        do {
            liberado = Tela_Mobile.liberarAutomacao;
            System.out.println("Aguardando a Configuracao");

        } while (liberado == false);

        Processando auto = new Processando();
        auto.setVisible(true);
        auto.repaint();

        criarEvidencia();
        System.out.println("Pasta de Evidencia Criada com Sucesso");

// navegador = Navegadores.navegadores(navegador); 
        if (Navegadores.navegadores(retorno)) {
            navegador = Navegadores.navegador;
            System.out.println("---------------------  Login com sucesso -------------------\n");

            QMassa = Integer.parseInt(Tela_Mobile.TQuantidadeMassa);
            somaCustomer = Tela_Mobile.somaCustomer;
            ListaCustomer.addAll(Tela_Mobile.ListaCustomer);
            somaCpf = Tela_Mobile.somaCPF;

            //Chamando a classe login
            System.out.println("Chamando a classe login");
            Login login = new Login();
            if (login.login(retorno, navegador)) {

                System.out.println("---------------------Configuracao realizado com Sucesso-------------------\n");

                if (somaCpf == 0) {
                    if (QMassa > somaCustomer) {
                        contador = QMassa;
                    } else {
                        contador = somaCustomer;
                    }
                } else {
                    contador = somaCpf;
                }

                for (int i = 0; i < contador; i++) {

                    if (Tela_Mobile.GerarIccd.isSelected() == true) {
//            Executa do Primeiro Iccd..
                            new Thread() {
                            @Override
                            public void run() {
                                try {
                                    new PrimeiroIccd().primeiroIccd();
                                } catch (Exception ex) {
                                    Logger.getLogger(Tela_Mobile.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }.start();
                    }

                    //Caminho para print All    
                    Transfers.setContadorMassa(i + 1);
                    print.criarEvidencia();

                    //Trocando imagem após a conclusao 
                    Processando.contador.setText(contadorMassa + " / " + contador);
                    Processando.imgAssinantee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/assinante.gif")));
                    Processando.imgClientee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente.gif")));
                    Processando.imgOrganizaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Uni.organiza.gif")));
                    Processando.imgContaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/conta.gif")));
                    processando.repaint();

                    if (a_cliente == 1) {
                  //       Processando.log.setText("PROCESSO DE CRIACAO DE CLIENTE INICIADO! \n AGUARDE...");
                  //          processando.repaint();
                        //Chamando a classe Criar Cliente
                        System.out.println("Chamando a classe Criar Cliente");
                        Cliente cliente = new Cliente();
                        if (cliente.cliente(retorno, navegador)) {
//        cliente.cliente(navegador);
                            clienteOK = true;
                            Processando.imgClientee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cliente_A.gif")));
                      //      Processando.log.setText("CLIENTE CRIADO COM SUCESSO");
                            processando.repaint();
                            System.out.println("--------------------- Cliente Criado com Sucesso -------------------\n");
                            MsgErro = "N";
                        } else {
                            MsgErro = "S";
                         //   Processando.log.setText("CLIENTE CRIADO COM ERRO");
                            System.out.println("--------------------- Cliente Criado com Erro -------------------\n");
                            break;

                        }
                    }

//        diminiur o box da principal tela;
                    if (a_conta == 1) {
                  //      Processando.log.setText("PROCESSO DE CRIACAO DE CONTA INICIADO! \n AGUARDE...");
                  //          processando.repaint();
                        if (a_completo == 0) {
                            customerLista = dados.getListaCustumer().get(i);
                            //Buscando Cliente ja Cadastro
                            System.out.println("Buscando Cliente ja Cadastro");
                            BuscarCliente buscarCliente = new BuscarCliente();
                            buscarCliente.buscarCliente(navegador);

                        }
                        //Adicionando a conta para o Cliente 
                        System.out.println("Adicionando a conta para o Cliente \n");
                        Conta conta = new Conta();
                        if (conta.conta(retorno, navegador)) {
//                            if (Tela_Mobile.AtivarLista == true) {
//                                ListaCustomer.remove(0);
//                            }
                            Processando.imgContaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/conta_A.gif")));
                          //  Processando.log.setText("CONTA CRIADO COM SUCESSO");
                            processando.repaint();
                            System.out.println("--------------------Conta Criado com Sucesso------------------------\n");
                            MsgErro = "N";
                        } else {
                            MsgErro = "S";
                         //   Processando.log.setText("CONTA CRIADO COM ERRO");
                            System.out.println("--------------------- Conta Criado com Erro -------------------\n");
                            break;

                        }
                    }

                    if (a_oferta == 1) {
                   //     Processando.log.setText("PROCESSO DE CRIACAO DE OFERTA INICIADO! \n AGUARDE...");
                   //         processando.repaint();
                        if (a_completo == 0) {
                            //passando os customer para string 			
                            customerLista = dados.getListaCustumer().get(i);
                            //Buscando Cliente ja Cadastro
                            System.out.println("Buscando Cliente ja Cadastro");
                            BuscarCliente buscarCliente = new BuscarCliente();
                            buscarCliente.buscarCliente(navegador);
                        }
                        //Adicionando a Oferta
                        System.out.println("Adicionando a Oferta \n");
                        Oferta_1 oferta = new Oferta_1();
//                        Oferta oferta = new Oferta();
                        if (oferta.oferta(retorno, navegador)) {
//                            if (Tela_Mobile.AtivarLista == true) {
//                                ListaCustomer.remove(0);
//                            }
                            Processando.imgOrganizaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/organiza_A.gif")));
                      //      Processando.log.setText("OFERTA CRIADO COM SUCESSO");
                            processando.repaint();
                            System.out.println("----------------------Oferta Criado com Sucesso----------------------\n");
                            MsgErro = "N";
                        } else {
                            MsgErro = "S";
                       //     Processando.log.setText("OFERTA CRIADO COM ERRO");
                            System.out.println("--------------------- Oferta Criado com Erro -------------------\n");
                            break;

                        }

                    }

                    if (a_assinante == 1) {
                   //     Processando.log.setText("PROCESSO DE CRIACAO DE ASSINANTE INICIADO! \n AGUARDE...");
                    //        processando.repaint();
                            

                    }   
                            
                            

                        if (a_completo == 0) {
                            System.out.println(dados.getListaCustumer().size());
                            customerLista = dados.getListaCustumer().get(i);
                            //Buscando Cliente ja Cadastro
                            System.out.println("Buscando Cliente ja Cadastro");
                            BuscarCliente buscarCliente = new BuscarCliente();
                            buscarCliente.buscarCliente(navegador);
                        }
                        //Adicionando Assinante  11991290045
                        System.out.println("Adicionando Assinante");
                        Assinante assinante = new Assinante();
                        if (assinante.assinante(retorno, navegador)) {

//                            if (Tela_Mobile.AtivarLista == true) {
//
//                                JOptionPane.showMessageDialog(null, ListaCustomer.get(0) + ListaCustomer.size());
//                                ListaCustomer.remove(0);
//                            }

                            Processando.imgAssinantee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/assinante_A.gif")));
                        //    Processando.log.setText("ASSINANTE CRIADO COM SUCESSO");
                            processando.repaint();
                            System.out.println("---------------Assinante Criado com Sucesso-------------\n");
                            MsgErro = "N";
                        } else {
                            MsgErro = "S";
                      //      Processando.log.setText("ASSINANTE CRIADO COM ERRO");
                            System.out.println("--------------------- Assinante Criado com Erro -------------------\n");
                            break;

                        }
                    

                    //Pegando o nome do custumer
//    List<WebElement> auxiliarCustomerr = navegador.findElements(By.className("contextBold")); 
//    for (WebElement titleCustomerr : auxiliarCustomerr) {
//      ContadorSubSubb++;
//      if (ContadorSubSubb == 2) {
//          
//// Distribuidor
//    	WebElement customerN = navegador.findElement(By.className("contextBold"));
//        
//    	   CustomerNome = customerN.getText();
//           CustomerNome = Transfers.getNomeCliente()+"         | "+CustomerNome+" | CPF/CNPJ - "+Cliente.cpfGerado+"  ";}  } 
                    String CustomerNome = "";
                    int ContadorSubSubb = 0;

                    WebElement Customer = navegador.findElement(By.xpath("//table//tr[3]//a[1]"));
                    WebElement Unig_org = navegador.findElement(By.xpath("//table//tr[3]//a[2]"));
                    WebElement Conta = navegador.findElement(By.xpath("//table//tr[3]//a[4]"));
                    WebElement AssinanteElement = navegador.findElement(By.xpath("//table//tr[3]//a[3]"));

                    CustomerNome = Transfers.getNomeCliente() + "           |   " + Customer.getText() + "  |  " + Conta.getText() + "  |  " + AssinanteElement.getText() + "  |  " + Cliente.cpfGerado;

                    // chamando a classe do txt a cada nova massa
                    GravandoTxt(CustomerNome);

                    //Criando um array para coletar evidencias   
                    String A = "";
                    A = Customer.getText();
                    A = A.replaceAll("Cliente -", "");
                    ListaCliente.add(A);

                    A = AssinanteElement.getText();
                    A = A.replaceAll("Assinante -", "");
                    ListaAssinante.add(A);

                    A = Conta.getText();
                    A = A.replaceAll("Conta -", "");
                    ListaConta.add(A);

                    ListaNomeCliente.add(Transfers.getNomeCliente());

                    //Adicionando o cpf ou cnpj
                    if (Tela_Mobile.TCliente.isSelected() == true) {
                        if (Cliente.cpfGerado == "") {
                            ListaCpf.add(Cliente.CnpjGerado);
                        } else {
                            ListaCpf.add(Cliente.cpfGerado);
                        }
                    }
                    if (Tela_Mobile.TOferta.isSelected() == true && Tela_Mobile.massaCompleta.isSelected() == false) {
                        ListaCpf.add("--");
                    }
                    if (Tela_Mobile.TAssinante.isSelected() == true && Tela_Mobile.massaCompleta.isSelected() == false) {
                        ListaCpf.add(Assinante.CpfGerado);
                    }

                    if (Tela_Mobile.TCliente.isSelected() == true) {
                        Transfers.setSubTipo(Tela_Mobile.boxClienteS.getSelectedItem().toString());
                    }
                    if (Tela_Mobile.TOferta.isSelected() == true && Tela_Mobile.TCliente.isSelected() == false) {
                        Transfers.setSubTipo(Tela_Mobile.boxClienteSOferta.getSelectedItem().toString());
                    }

                    System.out.println("\n--------------   Customer  ---------------------------------------------------------------------------------------------------------------");
                    System.out.println(CustomerNome);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
                    Transfers.setCustomerNomeCompleto(CustomerNome);

                    String auxq = CustomerNome.substring(0, 20);
                    Transfers.setCustomerNome(auxq);

                    //Chamando a classe para Print
                    System.out.println("Chamando a classe para Print");
                    Object dataPrint = getDateTime();
                    String nomePrint = (Transfers.getNomeCliente() + " " + dataPrint + ".jpeg");//
                    takeSnapShot(navegador, nomePrint);

                    //Retornando para tela inicila de cadastro de cliente para loop de massas
                    if (contador > 1) {
                        List<WebElement> auxiliarCiclo = navegador.findElements(By.tagName("img"));
                        ContadorSubSubb = 0;
                        for (WebElement titleCiclo : auxiliarCiclo) {
                            ContadorSubSubb++;
                            if (ContadorSubSubb == 17) {
                                titleCiclo.click();
                            }
                        }
                    }

                    //Setando o contado de Massa
                    contadorMassa++;
                    Processando.contador.setText(contadorMassa + " / " + contador);
                    processando.repaint();

//Chamando a classe do Word
                    //   impressao_docx.impressao_docx((String)dataPrint);
                    clienteOK = false;
                    contaOK = false;
                    organizaOK = false;
                    assinanteOK = false;

                }// fechamento do While
            } else {
                MsgErro = "S";
                Processando.log.setText("LOGIN COM ERRO");
                System.out.println("--------------------- Login com Erro -------------------\n");
            }

        } else {
            MsgErro = "S";
            Processando.log.setText("LOGIN COM ERRO");
            System.out.println("--------------------- Login com Erro -------------------\n");
        }

        System.out.println("\n\n");
        System.out.println("            -------------------------------------------------------");
        System.out.println("            -          Fim do processo de automacao de Massa      -");
        System.out.println("            -------------------------------------------------------");

        Parar = true;
        navegador.quit();

        if (Parar == true) {
            processando.jButton1.setText("FINALIZADO");
            if (MsgErro == "N") {
                processando.icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sucesso.png")));
                
            } else {
                processando.icone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/erro.gif")));
            }
            processando.repaint();
        } else {
            processando.jButton1.setText("PARAR");
        }

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
                    new Automacao().setVisible(true);
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
        // TODO Auto-generated method stub
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) navegador);

        // Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        String NomeUsuario = System.getProperty("user.name");
        // imageFileDir = System.getProperty("java.io.tmpdir");
        String imageFileDir = "C:\\Documents and Settings\\" + NomeUsuario + "\\Desktop\\Evidencias de Massa";
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
            File diretorio = new File("C:\\Documents and Settings\\" + NomeUsuario + "\\Desktop\\Evidencias de Massa ");
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio Pasta de evidencia");
            System.out.println(ex);
        }
    }

    // adicionando customer a cada criacao
    public void GravandoTxt(String CustomerId) {

        String NomeUsuario = System.getProperty("user.name");
        String path = "C:\\Documents and Settings\\" + NomeUsuario + "\\Desktop\\Evidencias de Massa\\Lista Customers.txt";
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
                }
            }
        }
        //  }//eslse

        System.out.printf("Lista de customers criado com sucesso 'TXT'");

    }

    //Capturando a data do sistema
    private Object getDateTime() {
        //  DateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        DateFormat dataFormatada = new SimpleDateFormat("dd_MM_yyyy hh-mm-ss");
        Date data1 = new Date();

        return dataFormatada.format(data1);

    }

}
