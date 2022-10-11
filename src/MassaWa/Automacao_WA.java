package MassaWa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Pacote_Principal.Principal;
import QueryS.PrimeiroIccd;
import QueryS.Validar_cd_FASE;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automacao_WA {

    public WebDriver navegador;
    String Nmassa = "";
    private int QMassa = Integer.parseInt(Tela_WA.TQuantidadeMassa) , repetidor =0 ;
    public static String iccds = "", validarCDFASE="",msgFinalizacao = "", cod_Autorizacao = "", misidn_Titula = "", N_protocolo = "", RG = "", CPF = "";
    public static ArrayList<String> evidenciaMassa = new ArrayList<String>();
    
    public void test() throws Exception {
        
boolean sucesso = false;
        // criando a pasta de evidencia evidencias 
        criarEvidencia();
        System.out.println("Pasta de Evidencia Criada com Sucesso");

        navegador = Navegadores_WA.navegadores(navegador);
         navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 15);

        //Chamando a classe login
        System.out.println("Chamando a classe login");
        Login_WA login = new Login_WA();
        login.login(navegador);

    
        
        
        
        
        while (QMassa >= 1) {
            
            
            
            
//                            new Thread() {
//                            @Override
//                            public void run() {
//                                try {
//                                    new PrimeiroIccd().primeiroIccd();
//                                } catch (Exception ex) {
//                                    Logger.getLogger(Automacao_WA.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                            }
//                        }.start();
                    
            
            
            

            //Chamando a classe Criar Cliente
            System.out.println("Chamando a classe Criar Cliente");
            Claro_Cartao cliente = new Claro_Cartao();
            cliente.ClaroCartao(sucesso , navegador);
            System.out.println("Cliente Criado com Sucesso");

            //Tempo para captura 
            try {
                Thread.sleep(500);

                //Chamando a classe para Print
                System.out.println("Chamando a classe para Print");
                Object dataPrint = getDateTime();
                String nomePrint = (dataPrint + ".jpeg");//
                takeSnapShot(navegador, nomePrint);

                Thread.sleep(2000);
                int ContadorSubSub = 0;
                
                do{
                    try{
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form//input[@name='button'][1]")));
                        break;
                             } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
                
                
                Thread.sleep(1000);
                List<WebElement> auxiliar = navegador.findElement(By.name("actForm")).findElements(By.className("label"));
                for (WebElement title : auxiliar) {
                    ContadorSubSub++;
                    if (ContadorSubSub == 2) {
                        N_protocolo = title.getText();
                    }
                    if (ContadorSubSub == 3) {
                        cod_Autorizacao = title.getText();
                    }
                    if (ContadorSubSub == 4) {
                        misidn_Titula = title.getText();
                    }
                }

                //PEGANDO O NUMEROS PARA ARMAZENAMENTO
                RG = Claro_Cartao.rgGerado;
                CPF = Claro_Cartao.cpfGerado;
                Nmassa = Integer.toString(QMassa);

               

                //retornandoa tela principal
                Thread.sleep(1000);
                ContadorSubSub = 0;
                List<WebElement> auxiliar2 = navegador.findElements(By.name("button"));
                for (WebElement title3 : auxiliar2) {
                    ContadorSubSub++;
                    if (ContadorSubSub == 3) {
                        title3.click();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
           System.out.println("\n--------------Validando CD_FASE---------------");
           cod_Autorizacao = cod_Autorizacao.replaceAll("Código de Autorização:", "").replaceAll(" ","");
           validarCDFASE = cod_Autorizacao;
           Validar_cd_FASE fase = new Validar_cd_FASE();
           validarCDFASE = Integer.toString(fase.gerarCDFASE());

           
           
            System.out.println("\n--------------   Msisdn   ------------------------------------------");
            System.out.println("Codigo de autorizacao: " + cod_Autorizacao);
            System.out.println("Msisdns: " + misidn_Titula);
            System.out.println("N.Protocolo: " + N_protocolo);
            System.out.println("-------------------------------------------------------------------\n");
                    
           // chamando a classe do txt a cada nova massa   
           GravandoTxt(cod_Autorizacao, misidn_Titula, N_protocolo, RG, CPF, Nmassa,validarCDFASE);
            
            
            QMassa = QMassa - 1;
            navegador.get("http://trairi:6141/ativacao/ActivationStep00.do");
        }//fim  do while
        
        
        

        JOptionPane.showMessageDialog(null, "Massa Criada com Sucesso");
        System.out.println("\n");
        System.out.println("            -------------------------------------------------------");
        System.out.println("            -          Fim do processo de automacao de Massa      -");
        System.out.println("            -------------------------------------------------------");

        navegador.close();
        navegador.quit();

        //retomando a tela principal
        new Principal().setVisible(true);

    }// Fim da classe main

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
    public void GravandoTxt(String cod_Autorizacao, String misidn_Titula, String N_protocolo, String CPF, String RG, String Nmassa, String validarCDFASE) {

        String NomeUsuario = System.getProperty("user.name");
        String path = "C:\\Documents and Settings\\" + NomeUsuario + "\\Desktop\\Evidencias de Massa\\Lista Customers.txt";
        FileWriter arq = null;
        Object dataPrint = getDateTime();

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            bw.newLine();
            bw.write("------------------    MASSA " + Nmassa + "    -----------------");
            bw.newLine();
            bw.newLine();
            bw.write("CPF: " + CPF);
            bw.newLine();
            bw.write("RG: " + RG);
            bw.newLine();         
            bw.write("cod_Autorizacao: "+ cod_Autorizacao);
            bw.newLine();
            bw.write(misidn_Titula);
            bw.newLine();
            bw.write(N_protocolo);
            bw.newLine();
            bw.write("CD-FASE: "+validarCDFASE);
            bw.newLine();
            bw.write("Data de Criacao: " + dataPrint);
            bw.newLine();
            bw.write("------------------  FIM DA MASSA " + Nmassa + " -----------------");
            bw.newLine();
            bw.newLine();

            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally { // always close the file
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }

        System.out.printf("Lista de customers criado com sucesso 'TXT'\n");
    }

    //Capturando a data do sistema
    private Object getDateTime() {
        DateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date data1 = new Date();
        return dataFormatada.format(data1);

    }

}
