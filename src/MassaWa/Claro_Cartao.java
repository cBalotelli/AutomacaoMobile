/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaWa;

import Geradores.GeradorCPF;
import Geradores.GeradorNome;
import Geradores.GeradorNomeMae;
import Geradores.GeradorRg;
import Geradores.GeradorSobrenome;
import static MassaWa.ClienteWA.cpfBackup;
import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author henrique.rodrigues
 */
public class Claro_Cartao {
    
    public static String cpfGerado , rgGerado ;

    public boolean ClaroCartao(boolean sucesso, WebDriver navegador) throws Exception {
        sucesso = false;

        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        String winHandleBefore = navegador.getWindowHandle();

        Random numeroAleatorio = new Random();
        int nomeAleatorioEndereco = numeroAleatorio.nextInt(500);
        int telefoneContato = numeroAleatorio.nextInt(9);
        int time = 100, time2 = 1000, diferenciarIccd = 0, TplanoN = Tela_WA.TplanoN, repetidor = 0;
        String NEndereco = Integer.toString(nomeAleatorioEndereco);
        String Tplano = Tela_WA.T_Cliente;
        String rgBackup = "", cpfBackup = "", codigoAutorizacao = "", misidnTitula = "", Nprotocolo = "", IccdWA = "";
        System.out.println("Tipo de plano : " + Tplano);

        //Inserindo o iccd
        //  GerarIccdWA gerarIccd = new GerarIccdWA();
//         IccdWA = gerarIccd.geraiccd();
        // Chamando classe de gerados de cpf , Rg�s e Cnpj�s              
        GeradorCPF geradorCPF = new GeradorCPF();
        GeradorRg geradorRg = new GeradorRg();
        GeradorNome geradorNome = new GeradorNome();
        GeradorNomeMae gerarNomeMae = new GeradorNomeMae();
        GeradorSobrenome gerarSobrenome = new GeradorSobrenome();

        String sobrenome = gerarSobrenome.GerarNome();
        String nome = geradorNome.GerarNome() + " " + sobrenome;
        String mae = gerarNomeMae.GerarNome() + " " + sobrenome;

        String telefone = "119" + telefoneContato + telefoneContato + telefoneContato + telefoneContato
                + telefoneContato + telefoneContato + telefoneContato + telefoneContato;
        String nascimento = "01011999";
        String emissao = "01012010";
        String cep = "01310923";
        String dd = "11";
        String ssp = "SSP";
        String senha = "1234";

        int loop = 0;
           while (loop == 0) {
        try {

            TplanoN = (TplanoN + 1);
            //Selecionando tipo de plano
            //  navegador.findElement(By.xpath("//*[@id=\"tab-page-1_1\"]/table/tbody/tr[9]/td[2]/table/tbody/tr[" + TplanoN + "]/td/input")).click();
            do {
                try {
                    //  System.out.println("CLICANDO ");    
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-page-1_1\"]/table/tbody/tr[9]/td[2]/table/tbody/tr[" + TplanoN + "]/td/input"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {

                    //selecionando 3G
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-page-1_1\"]/table/tbody/tr[10]/td[2]/table/tbody/tr/td[2]/input"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            do {
                try {

                    //Seleciionando Venda de Chip Avulso NP
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trProductType\"]/td[2]/table/tbody/tr[4]/td/input"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {

                    //Trocando de aba 
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dados"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            //cpf
            try {
                cpfBackup = geradorCPF.mostraResultado();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

//            habilitando o campo cpf  | desbilitado automaticamente pelo chrome               
                        JavascriptExecutor js = (JavascriptExecutor) navegador;
                        WebElement element = navegador.findElement(By.id("cpfRow1"));
                        js.executeScript("arguments[0].setAttribute('style', 'display: true;')", element);
            Thread.sleep(time);

            // mudando para outra janela
            for (String winHandle_3 : navegador.getWindowHandles()) {
                navegador.switchTo().window(winHandle_3);
            }

            do {
                try {

                    //    navegador.findElement(By.name("cpf")).sendKeys(cpfBackup);
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("cpf"))).sendKeys(cpfBackup);
                    cpfGerado = (cpfBackup);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {

                    //Adicionando cep                     
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"preAnaliseCreditoCEP\"]/td[2]/input"))).sendKeys("01310923");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {
// colocar o robot na digitacao no WA
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("birthday"))).sendKeys("10102000");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {

                    //Adicionando o DD
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dddRow1\"]/td[2]/input"))).sendKeys(dd);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            do {
                try {

                    //Botao simulacao
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("btnSimulate"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            Thread.sleep(time);

            // mudando para outra janela
            for (String winHandle_1 : navegador.getWindowHandles()) {
                navegador.switchTo().window(winHandle_1);
            }

            Thread.sleep(time);
            do {
                try {
                    Thread.sleep(time);
                    WebElement comboboxElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pricePlanId\"]")));
                    Select combobox2 = new Select(comboboxElement2);
                    combobox2.selectByValue("9056");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            Thread.sleep(time);

            do {
                try {

                    //selecionando opcao simcard
                    WebElement comboboxElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.name("tipoSimcard")));
                    Select combobox3 = new Select(comboboxElement3);
                    combobox3.selectByValue("SIMCARD");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            Thread.sleep(time);
            do {
                try {

                    //selecionando a promocao
                    WebElement comboboxElement4 = wait.until(ExpectedConditions.elementToBeClickable(By.name("promotionId")));
                    Select combobox4 = new Select(comboboxElement4);
                    combobox4.selectByValue("30279");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
//                        Thread.sleep(time2);
//                        //selecionando a promocao
//                        WebElement comboboxElement5 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("codeSimcardCampaignLevel1")));
//                        Select combobox5 = new Select(comboboxElement5);
//                        combobox5.selectByValue("SIM");

            //botao proceguir
            //habilitando o campo cpf  | desbilitado automaticamente pelo chrome               
                        WebElement element1 = navegador.findElement(By.name("btnNext"));
                        js.executeScript("arguments[0].removeAttribute('disabled', 'disabled')", element1);
            do {
                try {

                    Thread.sleep(time);
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            //Voltando a tela principal
            navegador.switchTo().window(winHandleBefore);

            do {
//                            IccdWA = gerarIccd.geraiccd();
//                              Tela_WA.iccd100.get(0);
                Thread.sleep(time);
                try {
                    // IccdWA = gerarIccd.geraiccd();
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("iccid"))).clear();
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("iccid"))).sendKeys(Tela_WA.iccd100.get(0));
                    wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext"))).click();

                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tab-pane-0']//h2[2]"))).click();
                    Tela_WA.iccd100.remove(0);
                    break;

                } catch (Exception A) {
                    Tela_WA.iccd100.remove(0);
                    Alert alert = navegador.switchTo().alert();
                    alert.accept();

//                                
//                                
//                                
//                      switch (diferenciarIccd) {
//                            case 0:
//                                IccdWA = iccdCompare;
//                                break;
//                            case 1:
//                                iccdCompare1 = iccdCompare;
//                                IccdWA = iccdCompare1;
//                                break;
//                            case 2:
//                                iccdCompare2 = iccdCompare;
//                                IccdWA = iccdCompare2;
//                                break;
//                            case 3:
//                                iccdCompare3 = iccdCompare;
//                                IccdWA = iccdCompare3;
//
//                                break;
//                            case 4:
//                                iccdCompare4 = iccdCompare;
//                                IccdWA = iccdCompare4;
//                                break;
//                            case 5:
//                                iccdCompare5 = iccdCompare;
//                                IccdWA = iccdCompare5;
//                                break;
//                            case 6:
//                                iccdCompare5 = iccdCompare;
//                                IccdWA = iccdCompare5;
//                                break;
//                            case 7:
//                                iccdCompare7 = iccdCompare;
//                                IccdWA = iccdCompare7;
//                                break;
//                            case 8:
//                                iccdCompare8 = iccdCompare;
//                                IccdWA = iccdCompare8;
//                                break;
//                            case 9:
//                                iccdCompare9 = iccdCompare;
//                                IccdWA = iccdCompare9;
//                                break;
//                            case 10:
//                                iccdCompare10 = iccdCompare;
//                                IccdWA = iccdCompare10;
//                                break;
//                            default:
//                                IccdWA = iccdCompare;
//                        }
//                        diferenciarIccd++;             
//                      
//                         
//          
//                                
//                                
                    continue;
                }
            } while (repetidor == 0);

            
            
////////////////////////////////////////////////////  ETAPA 2 /////////////////////////////////
                     Thread.sleep(time);
            do {
                try {
                    
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("customerName"))).sendKeys(nome);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
             
            do {
                try {

                    //selecionandonome da mae
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("customerMotherName"))).sendKeys(mae);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);

            do {
                try {

                    //data de nascimento
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("birthday"))).sendKeys("10102000");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
            
            do {
                try {

                    //selecionando o sexo
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("gender"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
            
           
             do {
                try {
                    //numero de  telefone 

                    wait.until(ExpectedConditions.elementToBeClickable(By.name("contactPhone01"))).sendKeys(telefone);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
        
             
//=================================================================================================
//===================================    APARELHO    ==============================================
             
             
             
            do {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Aparelho"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
             
            do {
                try {
                    // setando o botao pesquisar do msysdn
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[2]//input[2]"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            //aguardando o recalut
            Thread.sleep(time);

            // mudando para outra janela
            for (String winHandle_2 : navegador.getWindowHandles()) {
                navegador.switchTo().window(winHandle_2);
            }
 Thread.sleep(time);
            //selecionando a promocao
            //    WebElement comboboxElement6 = navegador.findElement(By.name("selectMsisdn"));
            //  Select combobox6 = new Select(comboboxElement6); combobox6.selectByIndex(1);;
            do {
                try {
                    WebElement comboboxElement7 = wait.until(ExpectedConditions.elementToBeClickable(By.name("selectMsisdn")));
                    Select combobox7 = new Select(comboboxElement7);
                    combobox7.selectByIndex(0);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
            Thread.sleep(time);
            
            do {
                try {
                    //botao proceguir
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            //Voltando a tela principal
            navegador.switchTo().window(winHandleBefore);

            Thread.sleep(time);
            
            do {
                try {
                    //botao proceguir
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            ////////////////////////////////////////////////////ETAPA 3 /////////////////////////////////

            Thread.sleep(time);
            
            //Logadouro
            do {
                try {
                    WebElement Element8 = wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialStreetPrefix")));
                    Select combobox8 = new Select(Element8);
                    combobox8.selectByValue("21");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
             
            Thread.sleep(time);
             
            do {
                try {
                    //numero casa
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialNumber"))).sendKeys(NEndereco);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
             
    
            do {
                try {
                    //alterandoa aba
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Info.Pes."))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            //RG
            try {
                rgBackup = geradorRg.mostraResultado();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
             Thread.sleep(time);
             
            do {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("rg"))).sendKeys(rgBackup);
                    rgGerado = (rgBackup);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);
             

            do {
                try {
                    //DATA DE EMISSAO
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("rgExpeditionDate"))).sendKeys(emissao);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);
             
            do {
                try {
                    // SSP
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("rgExpeditor"))).sendKeys(ssp);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

             Thread.sleep(time);
             
            do {
                try {
                    //ESTADO DO RG
                    WebElement Element9 = wait.until(ExpectedConditions.elementToBeClickable(By.name("rgUf")));
                    Select combobox9 = new Select(Element9);
                    combobox9.selectByValue("SP");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);
             
            do {
                try {
                    // SENHA DE RG
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("accountPassword"))).sendKeys(senha);
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);

            do {
                try {
                    // ESTADO CIVIL
                    WebElement Element10 = wait.until(ExpectedConditions.elementToBeClickable(By.name("maritalStatus")));
                    Select combobox10 = new Select(Element10);
                    combobox10.selectByValue("1");
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);
            
             Thread.sleep(time);
             
            do {
                try {
                    //botao proceguir
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();
                    break;
                } catch (NoSuchElementException B) {
                    System.out.println("AMBIENTE INSTAVEL ");
                    continue;
                }
            } while (repetidor == 0);

            sucesso = true;

            //PEGANDO O NUMEROS PARA ARMAZENAMENTO
            //codigoAutorizacao= "",misidnTitula="", Nprotocolo;
        }//Fim do if PRIMEIRO PLANO//Fim do if PRIMEIRO PLANO
        catch (Exception ex) {
           // Logger.getLogger(ClienteWA.class.getName()).log(Level.SEVERE, null, ex);
           
           navegador.get("http://trairi:6141/ativacao/ActivationStep00.do");
           continue;
          
        }

           }
        return sucesso;
    }

}
