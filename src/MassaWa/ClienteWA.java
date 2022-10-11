package MassaWa;

import Geradores.GeradorCPF;
import Geradores.GeradorNome;
import Geradores.GeradorNomeMae;
import Geradores.GeradorRg;
import Geradores.GeradorSobrenome;
import QueryS.GerarIccd;
import QueryS.GerarIccdWA;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClienteWA {

    public static String rgBackup = "", cpfBackup = "", codigoAutorizacao = "", misidnTitula = "", Nprotocolo = "",IccdWA = "";
  public static String iccdCompare = " ", iccdCompare1 = " ", iccdCompare2 = " ", iccdCompare3 = " ",
            iccdCompare4 = " ", iccdCompare5 = " ", iccdCompare6 = " ", iccdCompare7 = " ", iccdCompare8 = " ", iccdCompare9 = " ", iccdCompare10 = " ", CpfGerado = "";
   
    public void cliente(WebDriver navegador) throws Exception {

        String winHandleBefore = navegador.getWindowHandle();
        String TipoCliente = "", TipoOfertaConta = SelecaoOferta.TipoOfertaSelect, vencimentoFatura = Tela_WA.TVencimento;
        String Tplano = Tela_WA.T_Cliente;
        int TTipoDliente = Tela_WA.boxCliente.getSelectedIndex();
        String TprecoPlano = "";
        
        int ContadorSubSub = 0, loopValidador = 0, TplanoN , repetidor = 0 ;

        TplanoN = Tela_WA.TplanoN;

        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 20);
        winHandleBefore = navegador.getWindowHandle();
        Robot robo = new Robot();

        Random numeroAleatorio = new Random();
        int nomeAleatorioEndereco = numeroAleatorio.nextInt(500);
        int telefoneContato = numeroAleatorio.nextInt(9);
        int time = 100 ,time2 = 1000, diferenciarIccd = 0;
        String NEndereco = Integer.toString(nomeAleatorioEndereco);

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
        String nome = geradorNome.GerarNome() + " "+ sobrenome;        
        String mae = gerarNomeMae.GerarNome() + " "+ sobrenome;
        
        
       
        
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
               wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-page-1_1\"]/table/tbody/tr[9]/td[2]/table/tbody/tr[" + TplanoN + "]/td/input"))).click();
                //selecionando 3G
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-page-1_1\"]/table/tbody/tr[10]/td[2]/table/tbody/tr/td[2]/input"))).click();

                //Seleciionando Venda de Chip Avulso NP
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trProductType\"]/td[2]/table/tbody/tr[4]/td/input"))).click();

                //Trocando de aba 
               wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Dados"))).click();

                if (TplanoN == 1) {
                    try {

                        //cpf
                        try {
                            cpfBackup = geradorCPF.mostraResultado();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                                       

                        //habilitando o campo cpf  | desbilitado automaticamente pelo chrome               
                        JavascriptExecutor js = (JavascriptExecutor) navegador;
                        WebElement element = navegador.findElement(By.id("cpfRow1"));
                        js.executeScript("arguments[0].setAttribute('style', 'display: true;')", element);

                        Thread.sleep(time);

                        //    navegador.findElement(By.name("cpf")).sendKeys(cpfBackup);
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("cpf"))).sendKeys(cpfBackup);
                        // colocar o robot na digitacao no WA


                        //Adicionando cep
                        // navegador.findElement(By.xpath("//*[@id=\"preAnaliseCreditoCEP\"]/td[2]/input")).sendKeys("01310923");
                         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"preAnaliseCreditoCEP\"]/td[2]/input"))).sendKeys("01310923");
                        // colocar o robot na digitacao no WA


                        //Adicionando o DD
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dddRow1\"]/td[2]/input"))).sendKeys(dd);
                        // colocar o robot na digitacao no WA

                        
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("birthday"))).sendKeys("10102010");
                        
                        
                        //Botao simulacao
                         wait.until(ExpectedConditions.elementToBeClickable(By.name("btnSimulate"))).click();

                        Thread.sleep(1000);

                        // mudando para outra janela
                        for (String winHandle_1 : navegador.getWindowHandles()) {
                            navegador.switchTo().window(winHandle_1);
                        }

                        Thread.sleep(time);

                        WebElement comboboxElement2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pricePlanId\"]")));
                        Select combobox2 = new Select(comboboxElement2);
                        combobox2.selectByValue("9056");

                        Thread.sleep(time);
                        //selecionando opcao simcard
                        WebElement comboboxElement3 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("tipoSimcard")));
                        Select combobox3 = new Select(comboboxElement3);
                        combobox3.selectByValue("SIMCARD");

                        Thread.sleep(time);
                        //selecionando a promocao
                        WebElement comboboxElement4 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("promotionId")));
                        Select combobox4 = new Select(comboboxElement4);
                        combobox4.selectByValue("30279");

//                        Thread.sleep(time2);
//                        //selecionando a promocao
//                        WebElement comboboxElement5 =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("codeSimcardCampaignLevel1")));
//                        Select combobox5 = new Select(comboboxElement5);
//                        combobox5.selectByValue("SIM");

                        //botao proceguir
                        //habilitando o campo cpf  | desbilitado automaticamente pelo chrome               
                      
                        WebElement element1 = navegador.findElement(By.name("btnNext"));
                        js.executeScript("arguments[0].removeAttribute('disabled', 'disabled')", element1);

                        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();

                        //Voltando a tela principal
                        navegador.switchTo().window(winHandleBefore);

                        
                        do{ 
//                            IccdWA = gerarIccd.geraiccd();
//                              Tela_WA.iccd100.get(0);
                              Thread.sleep(1000);
                            try{
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
                        }while(repetidor ==0);
                        
                        
////////////////////////////////////////////////////  ETAPA 2 /////////////////////////////////
                   // wait.until(ExpectedConditions.elementToBeClickable(By.name("customerName"))).sendKeys(nome);
           

                        //selecionandonome da mae
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("customerMotherName"))).sendKeys(mae);
                        // colocar o robot na digitacao no WA
      
                        //data de nascimento
                       // navegador.findElement(By.name("birthday")).click();
                        // colocar o robot na digitacao no WA
                     wait.until(ExpectedConditions.elementToBeClickable(By.name("birthday"))).sendKeys("10102010");
                        
                        
                      

                        //selecionando o sexo
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("gender"))).click();

                        //numero de  telefone 
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("contactPhone01"))).sendKeys(telefone);
                        
          
                       wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Aparelho"))).click();
                        // setando o botao pesquisar do msysdn
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnSearch"))).click();

                        //aguardando o recalut
                        Thread.sleep(3000);

                        // mudando para outra janela
                        for (String winHandle_2 : navegador.getWindowHandles()) {
                            navegador.switchTo().window(winHandle_2);
                        }

                        //selecionando a promocao
                        //    WebElement comboboxElement6 = navegador.findElement(By.name("selectMsisdn"));
                        //  Select combobox6 = new Select(comboboxElement6); combobox6.selectByIndex(1);;
                        WebElement comboboxElement7 = wait.until(ExpectedConditions.elementToBeClickable(By.name("selectMsisdn")));
                        Select combobox7 = new Select(comboboxElement7);
                        combobox7.selectByIndex(0);

                        //botao proceguir
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();

                        //Voltando a tela principal
                        navegador.switchTo().window(winHandleBefore);

                        //botao proceguir
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();

                        ////////////////////////////////////////////////////ETAPA 3 /////////////////////////////////
                        Thread.sleep(500);
                        //Logadouro
                        WebElement Element8 = wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialStreetPrefix")));
                        Select combobox8 = new Select(Element8);
                        combobox8.selectByValue("21");

                        //numero casa
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialNumber"))).sendKeys(NEndereco);
                        // colocar o robot na digitacao no WA
         

                        //   criar numero depois rondomico
                        //alterandoa aba
                         wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Info.Pes."))).click();

                        //RG
                        try {
                            rgBackup = geradorRg.mostraResultado();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                         wait.until(ExpectedConditions.elementToBeClickable(By.name("rg"))).sendKeys(rgBackup);
                        // colocar o robot na digitacao no WA
           

                        //DATA DE EMISSAO
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("rgExpeditionDate"))).sendKeys(emissao);
                        // colocar o robot na digitacao no WA
         
                        // SSP
                       wait.until(ExpectedConditions.elementToBeClickable(By.name("rgExpeditor"))).sendKeys(ssp);
                        // colocar o robot na digitacao no WA
           

                        //ESTADO DO RG
                        WebElement Element9 =  wait.until(ExpectedConditions.elementToBeClickable(By.name("rgUf")));
                        Select combobox9 = new Select(Element9);
                        combobox9.selectByValue("SP");

                        // SENHA DE RG
                         wait.until(ExpectedConditions.elementToBeClickable(By.name("accountPassword"))).sendKeys(senha);
                        // colocar o robot na digitacao no WA
                
                        // ESTADO CIVIL
                        WebElement Element10 = wait.until(ExpectedConditions.elementToBeClickable(By.name("maritalStatus")));
                        Select combobox10 = new Select(Element10);
                        combobox10.selectByValue("1");

                        //botao proceguir
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnNext"))).click();
                      

                        //PEGANDO O NUMEROS PARA ARMAZENAMENTO
                        //codigoAutorizacao= "",misidnTitula="", Nprotocolo;
                    }//Fim do if PRIMEIRO PLANO
                    catch (Exception ex) {
                        Logger.getLogger(ClienteWA.class.getName()).log(Level.SEVERE, null, ex);
                       
                    }
                }

//  ###############################################################################################################
//  ####################                       FIM DA PAGINA               ####################################
//  ###############################################################################################################	  				               
                if (TplanoN == 2) {

                    //pegando a tela principal
                    winHandleBefore = navegador.getWindowHandle();

             
                    
                    //nome
                    //    navegador.findElement(By.name("txtNome")).sendKeys(nome);
                    navegador.findElement(By.name("txtNome")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : nome.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    
                    Thread.sleep(500);

                    
                    //cpf
                    try {
                        cpfBackup = geradorCPF.mostraResultado();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    //habilitando o campo cpf  | desbilitado automaticamente pelo chrome               
                    JavascriptExecutor js = (JavascriptExecutor) navegador;
                    WebElement element = navegador.findElement(By.id("cpfRow1"));
                    js.executeScript("arguments[0].setAttribute('style', 'display: true;')", element);

                    //  navegador.findElement(By.name("cpf")).sendKeys(cpfBackup);
                    navegador.findElement(By.name("cpf")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : cpfBackup.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //Adicionando cep
                    navegador.findElement(By.xpath("//*[@id=\"preAnaliseCreditoCEP\"]/td[2]/input")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : cep.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);
                    //data de nascimento
                    navegador.findElement(By.name("birthday")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : nascimento.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //selecionando o sexo
                    navegador.findElement(By.name("gender")).click();
                    
                    
                      //selecionandonome da mae
                    robo.keyPress(KeyEvent.VK_TAB);
                    robo.keyRelease(KeyEvent.VK_TAB);
                     robo.delay(200); 
                     
                    
                  //  WebElement Element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"preAnaliseCreditoNomeMae\"]/td[2]/input")));
                 //   Element1.clear();
                //    Element1.click();
                    // colocar o robot na digitacao no WA
                    for (char character : mae.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100); 


                    //selecionando estado civil
                    WebElement comboboxElement = navegador.findElement(By.name("maritalStatus"));
                    Select combobox = new Select(comboboxElement);
                    combobox.selectByValue("1");

                    //selecionando profissao
                    WebElement comboboxElement2 = navegador.findElement(By.name("occupation"));
                    Select combobox2 = new Select(comboboxElement2);
                    combobox2.selectByValue("1");

                    //selecionando salario
                    WebElement comboboxElement3 = navegador.findElement(By.name("wageRange"));
                    Select combobox3 = new Select(comboboxElement3);
                    combobox3.selectByValue("6");

                    //Adicionando o DD
                    navegador.findElement(By.xpath("//*[@id=\"dddRow1\"]/td[2]/input")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : dd.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(500);

                    //pegando a tela principal
                    winHandleBefore = navegador.getWindowHandle();

                    //Simulacao
                    navegador.findElement(By.name("btnSimulateDK")).click();

                    Thread.sleep(3000);

                    // mudando para outra janela para processguir fechando automatico 	 	         
//                    for (String winHandle_7 : navegador.getWindowHandles()) {
//                        navegador.switchTo().window(winHandle_7);
//                       
//                        
////                    }
//                     Thread.sleep(3000);
                     
                  // mudando para outra janela para processguir fechando automatico 	 	         
                    for (String winHandle_7 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_7);
                        if (!winHandle_7.equals(winHandleBefore)) {
                            navegador.switchTo().window(winHandle_7);
                            navegador.findElement(By.name("btnClose")).click();

                        }
                    }
//                    robo.keyRelease(KeyEvent.VK_TAB);
//                    robo.keyRelease(KeyEvent.VK_ENTER);                
//                    robo.delay(200); 
                           

                    Thread.sleep(3000);
                    

                    // mudando para outra janela    
                    for (String winHandle_8 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_8);
                    }

                    Thread.sleep(3000);

                    //plano preco
                    
                    TprecoPlano = Tela_WA.planoPreco.getSelectedItem().toString();
                    
                    WebElement Element9 = wait.until(ExpectedConditions.elementToBeClickable(By.name("pricePlanId")));
                    Select combobox9 = new Select(Element9);
                    combobox9.selectByVisibleText(TprecoPlano);

                    Thread.sleep(3000);
                   
                    //selecionando opcao simcard
                    WebElement comboboxElement10 = wait.until(ExpectedConditions.elementToBeClickable(By.name("tipoSimcard")));
                    Select combobox10 = new Select(comboboxElement10);
                    combobox10.selectByValue("SIMCARD");

                    Thread.sleep(3000);
                    //Passando a informação de cada oferta
                    //cliente Controle
                    if (TTipoDliente == 1){
                   //selecionando opcao ofertas promocionais
                    WebElement comboboxElement11 = wait.until(ExpectedConditions.elementToBeClickable(By.name("promotionId")));
                    Select combobox11 = new Select(comboboxElement11);
                    combobox11.selectByValue("34044");   
                    }
                    //cliente Conta
                     if (TTipoDliente == 2){
                    //selecionando opcao ofertas promocionais
                    WebElement comboboxElement11 = wait.until(ExpectedConditions.elementToBeClickable(By.name("promotionId")));
                    Select combobox11 = new Select(comboboxElement11);
                    combobox11.selectByValue("34509");
                  } 
                    Thread.sleep(3000);

                    //selecionando opcao simcard capanha de chip
                    WebElement comboboxElement12 =  wait.until(ExpectedConditions.elementToBeClickable(By.id("codeSimcardCampaignLevel1")));
                    Select combobox12 = new Select(comboboxElement12);                
                    combobox12.selectByVisibleText("SIMCARD");

                    Thread.sleep(3000);
                    
                    // calculando carencia
                    navegador.findElement(By.name("btnCalcCarencia")).click();

                    Thread.sleep(3000);

                    //botao proximo
                    navegador.findElement(By.name("btnNext")).click();

                    Thread.sleep(3000);

                    // mudando para outra janela para processguir fechando automatico 	 	         
                    for (String winHandle_8 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_8);
                    }

                    Thread.sleep(3000);

                   navegador.findElement(By.xpath("//*[@id=\"boxMensagem\"]/table/tbody/tr[9]/td/input[2]")).click();
                   
                                     //fechando a primeira pagina
//                    robo.keyRelease(KeyEvent.VK_TAB);
//                    robo.keyRelease(KeyEvent.VK_TAB);
//                    robo.keyRelease(KeyEvent.VK_ENTER);                
//                    robo.delay(200); 

                    //Voltando a tela principal
                    navegador.switchTo().window(winHandleBefore);

                    //Inserindo o iccd
                    try {
                       
                        navegador.findElement(By.name("iccid")).click();
                        // colocar o robot na digitacao no WA
                        for (char character : IccdWA.toCharArray()) {
                            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                        }
                        robo.delay(100);

                    } catch (Exception ex) {
                        System.out.println("Erro ao inserir iccd");
                    }

                    //botao proceguir
                    WebElement Element10 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
                    Element10.click();

                    Thread.sleep(3000);

////////////////////////////////////////////////////ETAPA 2 /////////////////////////////////		
                    //Mudundo de aba
                    WebElement Element11 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Aparelho")));
                    Element11.click();

                    // setando o botao pesquisar do msysdn           
                    navegador.findElement(By.name("btnSearch")).click();

                    //aguardando o recalut
                    Thread.sleep(3000);

                    // mudando para outra janela
                    for (String winHandle_2 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_2);
                    }

                    //aguardando o recalut
                    Thread.sleep(3000);

                    // Selecionando o msisdn
                    WebElement comboboxElement7 = wait.until(ExpectedConditions.elementToBeClickable(By.name("selectMsisdn")));
                    Select combobox7 = new Select(comboboxElement7);
                    combobox7.selectByIndex(0);

                    //botao proceguir
                    navegador.findElement(By.name("btnNext")).click();

                    //Voltando a tela principal
                    navegador.switchTo().window(winHandleBefore);

                    //botao proceguir
                    navegador.findElement(By.name("btnNext")).click();

////////////////////////////////////////////////////ETAPA 3 /////////////////////////////////		
                    //logadouro 
                    WebElement Element12 = wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialStreetPrefix")));
                    Select combobox12_1 = new Select(Element12);
                    combobox12_1.selectByValue("21");

                    navegador.findElement(By.name("residentialNumber")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : NEndereco.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    // validando o endereco					 	     
                    navegador.findElement(By.name("btnValidarEnderecoCrivo")).click();

                    //aguardando o recalut
                    Thread.sleep(2000);

                    //Confirmando o Window Confirm
                    Alert alert2 = navegador.switchTo().alert();
                    alert2.accept();

                    //alterandoa aba
                    navegador.findElement(By.linkText("Info.Pes.")).click();

                    //RG
                    try {
                        rgBackup = geradorRg.mostraResultado();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    navegador.findElement(By.name("rg")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : rgBackup.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //DATA DE EMISSAO
                    navegador.findElement(By.name("rgExpeditionDate")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : emissao.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    // SSP
                    navegador.findElement(By.name("rgExpeditor")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : ssp.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //ESTADO DO RG
                    WebElement Element8 = navegador.findElement(By.name("rgUf"));
                    Select combobox8 = new Select(Element8);
                    combobox8.selectByValue("SP");

                    // SENHA DE RG
                    navegador.findElement(By.name("accountPassword")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : senha.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //alterandoa aba
                    navegador.findElement(By.linkText("Fatura")).click();

                    // escolhendo o dia da fatura  		 
                    WebElement comboboxElement13 = navegador.findElement(By.name("cycleCodeAndPaymentDueDate"));
                    Select combobox13 = new Select(comboboxElement13);
                    combobox13.selectByVisibleText(vencimentoFatura);
                    // Adicionando email
//                    navegador.findElement(By.name("emailText")).sendKeys("meuEmail@email.com");
//                                       // colocar o robot na digitacao no WA
//                    for (char character : rgBackup.toCharArray()) {
//                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
//                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
//                        
//                    }robo.delay(100);

                    // confirmando envio pelo correio
                    ContadorSubSub = 0;
                    List<WebElement> auxiliar1 = navegador.findElements(By.name("paymentReceipt"));
                    for (WebElement title : auxiliar1) {
                        ContadorSubSub++;
                        if (ContadorSubSub == 2) {
                            title.click();
                        }
                    }

                    // Endereco de Envio 'residencial'
                    WebElement Element15 = wait.until(ExpectedConditions.elementToBeClickable(By.id("residencialRadio")));
                    Element15.click();

                    //numero de  telefone 
                    navegador.findElement(By.id("contactPhone01Text")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : telefone.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //alterandoa aba
                    navegador.findElement(By.linkText("Pagamento")).click();

                    // setando boleto bancario
                    navegador.findElement(By.id("boletoBancarioRadio")).click();

                    // setando cartao de credito
                    navegador.findElement(By.name("faturaEmCartaoCredito")).click();

                    //aguardando o recalut
                    Thread.sleep(500);

                    //botao prosseguir
                    navegador.findElement(By.name("btnNext")).click();

                    //aguardando o recalut
                    Thread.sleep(500);

                }

                //  ###############################################################################################################
                //  ####################                       FIM DA PAGINA               ####################################
                //  ###############################################################################################################	  				               
                if (TplanoN == 3) {

                    //pegando a tela principal
                    try {
                        Thread.sleep(3000);

                        navegador.findElement(By.name("txtNome")).click();
                        // colocar o robot na digitacao no WA
                        for (char character : nome.toCharArray()) {
                            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                        }
                        robo.delay(100);

          

                    } catch (Exception ex) {
                        System.out.println("problema em inserir nome");
                    }

                    //cpf
                    try {
                        cpfBackup = geradorCPF.mostraResultado();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    navegador.findElement(By.name("cpf")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : cpfBackup.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //Adicionando cep
                    navegador.findElement(By.xpath("//*[@id=\"preAnaliseCreditoCEP\"]/td[2]/input")).click();

                    // colocar o robot na digitacao no WA
                    for (char character : cep.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //data de nascimento
                    navegador.findElement(By.name("birthday")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : nascimento.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //selecionando o sexo
                    navegador.findElement(By.name("gender")).click();

                    
                        //selecionandonome da mae
                        Thread.sleep(1200);
                        WebElement Element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"preAnaliseCreditoNomeMae\"]/td[2]/input")));

                        Element1.click();
                        // colocar o robot na digitacao no WA
                        for (char character : mae.toCharArray()) {
                            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                        }
                        robo.delay(100);
                    
                    
                    //selecionando estado civil
                    WebElement comboboxElement = navegador.findElement(By.name("maritalStatus"));
                    Select combobox = new Select(comboboxElement);
                    combobox.selectByValue("1");

                    //selecionando profissao
                    WebElement comboboxElement2 = navegador.findElement(By.name("occupation"));
                    Select combobox2 = new Select(comboboxElement2);
                    combobox2.selectByValue("1");

                    //selecionando salario
                    WebElement comboboxElement3 = navegador.findElement(By.name("wageRange"));
                    Select combobox3 = new Select(comboboxElement3);
                    combobox3.selectByValue("6");

                    //Adicionando o DD
                    navegador.findElement(By.xpath("//*[@id=\"dddRow1\"]/td[2]/input")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : dd.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //pegando a tela principal
                    winHandleBefore = navegador.getWindowHandle();

                    //Simulacao
                    navegador.findElement(By.name("btnSimulateDK")).click();

                    Thread.sleep(3000);

                    // mudando para outra janela para processguir fechando automatico 	 	         
                    for (String winHandle_7 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_7);
                        if (!winHandle_7.equals(winHandleBefore)) {
                            navegador.switchTo().window(winHandle_7);
                            navegador.findElement(By.name("btnClose")).click();

                        }
                    }

                    // mudando para outra janela    
                    for (String winHandle_8 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_8);
                    }

                    Thread.sleep(3000);

                    //Tipo de oferta
                    navegador.findElement(By.xpath(TipoOfertaConta)).click();

                    //Botao Prosseguir
                    WebElement comboboxElement10 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnProsseguir")));
                    comboboxElement10.click();

                    Thread.sleep(3000);

                    //selecionando Simcard
                    WebElement comboboxElement11 = wait.until(ExpectedConditions.elementToBeClickable(By.id("simcardId")));
                    Select combobox11 = new Select(comboboxElement11);
                    combobox11.selectByValue("SIMCARD");

                    //selecionando oferta Promocionais
                    WebElement comboboxElement12 = navegador.findElement(By.name("promotionId"));
                    Select combobox12 = new Select(comboboxElement12);
                    combobox12.selectByIndex(3);
                    // combobox12.selectByValue("33241");

                    //selecionando campanha de chip
                    WebElement comboboxElement13 = wait.until(ExpectedConditions.elementToBeClickable(By.id("codeSimcardCampaignLevel1")));
                    Select combobox13 = new Select(comboboxElement13);
                    combobox13.selectByValue("SIM");

                    // calculando carencia
                    navegador.findElement(By.name("btnCalcCarencia")).click();

                    Thread.sleep(3000);

                    //botao proximo
                    navegador.findElement(By.name("btnNext")).click();

                    Thread.sleep(3000);

                    // mudando para outra janela para processguir fechando automatico 	 	         
                    for (String winHandle_8 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_8);
                    }

                    Thread.sleep(3000);

                    navegador.findElement(By.xpath("//*[@id=\"boxMensagem\"]/table/tbody/tr[9]/td/input[2]")).click();

                    //Voltando a tela principal
                    navegador.switchTo().window(winHandleBefore);

                    //Inserindo o iccd
                    try {
                       
                        navegador.findElement(By.name("iccid")).click();
                        // colocar o robot na digitacao no WA
//                        for (char character : IccdWa.toCharArray()) {
//                            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
//                            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
//                        }
                        robo.delay(100);
                    } catch (Exception ex) {
                        System.out.println("Erro ao inserir o iccd");
                    }

                    //botao proceguir
                    WebElement Element10 = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnNext")));
                    Element10.click();

                    Thread.sleep(3000);

////////////////////////////////////////////////////ETAPA 2 /////////////////////////////////		
                    //Mudundo de aba
                    WebElement Element11 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Aparelho")));
                    Element11.click();

                    // setando o botao pesquisar do msysdn           
                    navegador.findElement(By.name("btnSearch")).click();

                    //aguardando o recalut
                    Thread.sleep(3000);

                    // mudando para outra janela
                    for (String winHandle_2 : navegador.getWindowHandles()) {
                        navegador.switchTo().window(winHandle_2);
                    }

                    //aguardando o recalut
                    Thread.sleep(3000);

                    // Selecionando o msisdn
                    WebElement comboboxElement7 = wait.until(ExpectedConditions.elementToBeClickable(By.name("selectMsisdn")));
                    Select combobox7 = new Select(comboboxElement7);
                    combobox7.selectByIndex(0);

                    //botao proceguir
                    navegador.findElement(By.name("btnNext")).click();

                    //Voltando a tela principal
                    navegador.switchTo().window(winHandleBefore);

                    //botao proceguir
                    navegador.findElement(By.name("btnNext")).click();

////////////////////////////////////////////////////ETAPA 3 /////////////////////////////////		
                    //logadouro 
                    WebElement Element12 = wait.until(ExpectedConditions.elementToBeClickable(By.name("residentialStreetPrefix")));
                    Select combobox12_1 = new Select(Element12);
                    combobox12_1.selectByValue("21");

                    //Mudundo de aba
                    navegador.findElement(By.name("residentialNumber")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : NEndereco.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    // validando o endereco					 	     
                    navegador.findElement(By.name("btnValidarEnderecoCrivo")).click();

                    //aguardando o recalut
                    Thread.sleep(3000);

                    //Confirmando o Window Confirm
                    Alert alert2 = navegador.switchTo().alert();
                    alert2.accept();

                    //alterandoa aba
                    navegador.findElement(By.linkText("Info.Pes.")).click();

                    //RG
                    try {
                        rgBackup = geradorRg.mostraResultado();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    navegador.findElement(By.name("rg")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : rgBackup.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //DATA DE EMISSAO
                    navegador.findElement(By.name("rgExpeditionDate")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : emissao.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    // SSP
                    navegador.findElement(By.name("rgExpeditor")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : ssp.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //ESTADO DO RG
                    WebElement Element8 = navegador.findElement(By.name("rgUf"));
                    Select combobox8 = new Select(Element8);
                    combobox8.selectByValue("SP");

                    // SENHA DE RG
                    navegador.findElement(By.name("accountPassword")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : senha.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

                    //alterandoa aba
                    navegador.findElement(By.linkText("Fatura")).click();

                     Thread.sleep(900);
                    // escolhendo o dia da fatura  		 
                    WebElement Element13 = wait.until(ExpectedConditions.elementToBeClickable(By.name("cycleCodeAndPaymentDueDate")));
                    Select combobox13_1 = new Select(Element13);
                    combobox13_1.selectByVisibleText(vencimentoFatura);
//                 
                     Thread.sleep(900);
//                    // Adicionando email
//                    WebElement Element14 = wait.until(ExpectedConditions.elementToBeClickable(By.name("emailText")));
//                    Element14.click();
//                     int aux =0;
//                            String email = "emailemailcom";
//                          // colocar o robot na digitacao no WA
//                    for (char character : email.toCharArray()) {
//                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
//                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
//                        aux++;
//                        if (aux == 5){ Element14.sendKeys("@");}
//                        if (aux == 10){ Element14.sendKeys(".");}
//                         robo.delay(20);   
//                    }
//                    robo.delay(500);   
//                            
                    //desabilidando fatura digital
                    WebElement Element14 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"incentivoDebitoAutomatico\"]")));
                    Element14.click();

                    Thread.sleep(500);
                    
                    // confirmando envio pelo correio
                    ContadorSubSub = 0;
                    WebElement Element15 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tab-page-3_5\"]/table/tbody/tr[6]/td[2]/div/input[2]")));
                    Element15.click();
                                           
                    Thread.sleep(500);
                    
                    // Endereco de Envio 'residencial'
                    WebElement Element16 = wait.until(ExpectedConditions.elementToBeClickable(By.id("residencialRadio")));
                    Element16.click();

                    Thread.sleep(500);
                    
                    //numero de  telefone 
                    navegador.findElement(By.id("contactPhone01Text")).click();
                    // colocar o robot na digitacao no WA
                    for (char character : telefone.toCharArray()) {
                        robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
                        robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
                    }
                    robo.delay(100);

            //        //alterandoa aba
            //        navegador.findElement(By.linkText("Pagamento")).click();

                    // setando boleto bancario
                    navegador.findElement(By.id("boletoBancarioRadio")).click();

                    Thread.sleep(500);
                    
                    // setando cartao de credito
                    navegador.findElement(By.name("faturaEmCartaoCredito")).click();

                    //aguardando o recalut
                    Thread.sleep(500);

                    //botao prosseguir
                    navegador.findElement(By.name("btnNext")).click();

                    //aguardando o recalut
                    Thread.sleep(5000);

                }

            } catch (Exception e) {
                System.out.println("Erro na Execucao de WA! Iniciando novamente");
                TplanoN = Tela_WA.TplanoN;
                navegador.close();
                navegador.quit();
                navegador = Navegadores_WA.navegadores(navegador);
//Chamando a classe login
                System.out.println("Chamando a classe login Novamente ");
                Login_WA login = new Login_WA();
                login.login(navegador);
                continue;
            }//Fechamento do catch  	     
            loop = 1;
        }

    }

}
