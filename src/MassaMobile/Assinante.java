package MassaMobile;

import Pacote_Principal.Transfers;
import QueryS.GerarIccd;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Impressao.PrintTela;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assinante {

    
    public static String iccdCompare = " ", iccdCompare1 = " ", iccdCompare2 = " ", iccdCompare3 = " ",
            iccdCompare4 = " ", iccdCompare5 = " ", iccdCompare6 = " ", iccdCompare7 = " ", iccdCompare8 = " ", iccdCompare9 = " ", iccdCompare10 = " ", CpfGerado = "";
    public static int diferenciarIccd = 0, PrimeiraRodadaIccd = 0;
    
    Transfers dados = new Transfers();
    PrintTela print = new PrintTela();

    public boolean assinante(boolean sucesso, WebDriver navegador) throws IOException {

        int contadorImgAss = 0 , contadorImagem = Transfers.getContadorImagem();
        
        

        int ContadorSubSub = 0, erroIccds = 0, loopValidador = 0,ContadorErro= 0;
        boolean ofertaAtiva = Tela_Mobile.ativaOfertaContrato;

        String TipoCliente = "", TipoClienteAssinante;

        String verificarCliente = "", verificarClientE = "";
        String nomeOfertaAssinante = SelecaoOfertaAssinante.TxpathTituloAssinante;
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 10);
        TipoCliente = Tela_Mobile.T_Cliente;
        TipoClienteAssinante = Tela_Mobile.boxClienteAssinante.getSelectedItem().toString();
        String winHandleBefore = navegador.getWindowHandle();
        //alterando a janela para "UNIDADE ORG."
        List<WebElement> auxiliarO = navegador.findElements(By.tagName("img"));
        auxiliarO.get(7).click();

      //  while (loopValidador == 0) {
      //      try {

               wait.until(ExpectedConditions.elementToBeClickable(By.id("OUT2t"))).click();
                
                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"OUT2s\"]/a"))).click();

                //Quebando a Localidade
                if (Tela_Mobile.AtivarLocalidade.isSelected() == true) {
                    navegador.switchTo().window(winHandleBefore);

                    // localidade
                    List<WebElement> auxiliar2 = navegador.findElements(By.tagName("img"));
                    auxiliar2.get(27).click();
                    
                    
                    
                            for (String winHandle_2 : navegador.getWindowHandles()) {
                                navegador.switchTo().window(winHandle_2);
                            }
                            WebElement localidade = wait.until(ExpectedConditions.elementToBeClickable(By.name("dealerCode")));
                            Select combo = new Select(localidade);
                            combo.selectByIndex(1);

                            navegador.switchTo().window(winHandleBefore);
                        }//Fechando o If do ContadorSubSub =2


                
                WebElement comboboxElement0 = wait.until(ExpectedConditions.elementToBeClickable(By.name("subscrType")));
                Select combobox0 = new Select(comboboxElement0);
                combobox0.selectByVisibleText(TipoClienteAssinante);
       
                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
              
               
                 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[1]"))).click();

                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
              
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                  
                //Print da Tela
                   if(Transfers.getPrintAll() == 1){
                      print.printTelaScroll(navegador);
                     }
  
                if (Tela_Mobile.AtivarLocalidade.isSelected() == true ) {
                    navegador.switchTo().window(winHandleBefore);
                    System.out.println("Entrou na Validacao de Varejo pelo Assinante");
                    //Tipo de varejo
                    List<WebElement> auxiliar3 = navegador.findElements(By.tagName("img"));
                    auxiliar3.get(26).click();
                    
                            for (String winHandle_3 : navegador.getWindowHandles()) {
                                navegador.switchTo().window(winHandle_3);
                            }
                            wait.until(ExpectedConditions.elementToBeClickable(By.name("dealerCode"))).sendKeys("Varejo");
                            navegador.switchTo().window(winHandleBefore);
                 
                }
               

               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                  print.printTela(navegador);
               }  
                
                // Verificando o tipo de Cliente CPF || CNPJ            
              
              WebElement auxiliarVerificar1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='PFieldsType']//table[3]//td[@class='fieldTitle']")));
              verificarCliente =  auxiliarVerificar1.getText();
              System.out.println("Tipo de Assinante Para Verificacao : " + verificarCliente);
            
                

//                // Verificando o tipo de Cliente CPF || CNPJ
//                contadorImgAss = 0;
//                List<WebElement> auxiliarVerificar = navegador.findElements(By.className("fieldTitle"));
//                verificarCliente = auxiliarVerificar.get(9).getText();
//                System.out.println("Tipo de Assinante Para Verificacao: " + verificarCliente);
//
//               

               wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                
               
               
              
               
               
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
        
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
          
                
                if (verificarCliente.contains("CPF")) {

                    if (TipoClienteAssinante == "Pos-Pago Banda Larga") {
                        System.out.println(">>> Banda Larga");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='bgTable']//tr[9]//input"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='bgTable']//tr[@id='trRelOffer_380527782_372001791']//input"))).click();
                    }

                    if (TipoClienteAssinante == "Pós-Pago Tecnologia GSM") {

                        System.out.println(">>> Pós-Pago Tecnologia GSM");
                        // grandes contas              cpp374001864rel372001791  
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta gsm
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_374001864_372001791\"]/td[2]/input"))).click();

                    }
                    
                        if (TipoClienteAssinante == "Controle Tecnologia GSM") {

                        System.out.println(">>> Controle Tecnologia GSM");
                        // grandes contas              cpp374001864rel372001791  
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta gsm
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_364001758_372001791\"]/td[2]/input"))).click();

                    }
                    

                    if (TipoClienteAssinante == "Controle Tecnologia 3G") {
                        System.out.println(">>> Controle Tecnologia 3G");
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta controle total
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_380523526_372001791\"]/td[2]/input"))).click();
                    }

                    if (TipoClienteAssinante == "Pós-Pago Tecnologia 3G") {
                        System.out.println(">>> Pós-Pago Tecnologia 3G");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// Pós-Pago Tecnologia 3G
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_380465365_372001791\"]/td[2]/input"))).click();
                    }

                }

                if (verificarClientE.contains("CNPJ")) {
                    System.out.println("Alterou o Tipo CNPJ  para Else");

                    if (TipoClienteAssinante == "Pós-Pago Tecnologia 3G") {
                        System.out.println(">>> Pós-Pago Tecnologia 3G");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta controle total
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_380465367_372001791\"]/td[2]/input"))).click();
                    }

                    if (TipoClienteAssinante == "Pos-Pago Banda Larga") {
                        System.out.println(">>> Pos-Pago Banda Larga");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta controle total
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_380465367_372001791\"]/td[2]/input"))).click();
                    }

                    if (TipoClienteAssinante == "Pós-Pago Tecnologia GSM") {  // Grandes Contas
                        System.out.println(">>> Pós-Pago Tecnologia GSM Grandes Contas");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta controle total
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_338001047_372001791\"]/td[2]/input"))).click();
                    }

                    if (TipoClienteAssinante == "Controle Tecnologia 3G") {  // Grandes Contas
                        System.out.println(">>> Controle Tecnologia 3G");
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupHeader_380455018\"]/td[1]/img"))).click();
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupIdRadio_380455018\"]"))).click();// conta controle total
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"trRelOffer_380465367_372001791\"]/td[2]/input"))).click();
                    }                                   //*[@id="trRelOffer_380465367_372001791"]/td[2]/input

                }

                
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     
               
               


               
                 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();

                 
     
   
                 
                 
                // Alterar o paramentro do iccd
              //  PrimeiraRodadaIccd = 0;
                
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }

                if (dados.isAtivaOfertaAssinante() == true) {
                    System.out.println("Oferta do Assinante: " + nomeOfertaAssinante);
                    if (nomeOfertaAssinante == "EUROPA") {
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414339987_30\"]/td[1]/input"))).click();
                    }
                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
                }
                    if (nomeOfertaAssinante == "MUNDO") {
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414380532_0\"]/td[1]/input"))).click();
                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
 
                    }
                    
                    if (nomeOfertaAssinante == "AMERICA") {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414311129_30\"]/td[1]/input"))).click();
                    }
                    if (nomeOfertaAssinante == "EUROPA_EMBUTIDO") {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414339987_33\"]/td[1]/input"))).click();
                                         
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    }
                    if (nomeOfertaAssinante == "MUNDO_EMBUTIDO") {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414380532_3\"]/td[1]/input"))).click();
                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    }
                    if (nomeOfertaAssinante == "AMERICA_EMBUTIDO") {
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414311129_33\"]/td[1]/input"))).click();
                                            
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    }
                    if (nomeOfertaAssinante == "Claro Controle Mais 4GB + Ilimitado") {
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414302387_3\"]/td[1]/input"))).click();
                                                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    }
                    if (nomeOfertaAssinante == "Claro Controle Mais 2GB + 100min") {
                       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_414302387_0\"]/td[1]/input"))).click();
                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
              
                }

                if (dados.getAtivarBuscaAssinante() == "S") {
                    System.out.println("Nome do Plano Assinante: " + dados.getNomeOfertaAssinante());
                    
                    
                if(SelecaoOfertaAssinante.Oferta_permanencia.isSelected() == true){
                    if(Tela_Mobile.boxClienteAssinante.getSelectedItem() == "Pos-Pago Banda Larga" || Tela_Mobile.boxClienteAssinante.getSelectedItem() == "Controle Tecnologia 3G" ){
                  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_380455420_11\"]/td[1]/input"))).click(); 
                    }else{
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"groupId_380455420_16\"]/td[1]/input"))).click(); 
                }
                    
                }
                    
//                    
//                    
//                    List<WebElement> ofertafiltro = navegador.findElements(By.tagName("img"));
//                    ofertafiltro.get(27).click();
//                     
//                    WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"filterRow\"]/td/input[2]")));
//                    element2.sendKeys(dados.getNomeOfertaAssinante());
//      
                    
//                                                //Print da Tela 
//               if(Transfers.getPrintAll() == 1){
//                   print.printTela(navegador);
//               }   
//                    WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"filterRow\"]/td/img")));
//                    element3.click();
                }
                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
               
         
               
               
               
               
               //Botao da lista de oferta assinantes
               wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();

                Alert alert = navegador.switchTo().alert();
                alert.accept();
                
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                

                
                while (erroIccds == 0) {

                    try {
                        // Adicionando o MSYSDN
                        wait.until(ExpectedConditions.elementToBeClickable(By.id("regular"))).findElement(By.tagName("img")).click();
                        // pegando o endere�o da tela
                        winHandleBefore = navegador.getWindowHandle();

                        for (String winHandle_Ass : navegador.getWindowHandles()) {
                            navegador.switchTo().window(winHandle_Ass);
                        }
                        String title = navegador.getCurrentUrl();
                        //Seleciona area tarifada
                        WebElement comboboxElement = navegador.findElement(By.name("categoryTypeSelect"));
                        //navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
                        Select combobox = new Select(comboboxElement);
                        combobox.selectByValue("Area Tarifaria");

                        //Seleciona area tarifada numero 11
                        WebElement comboboxElement1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("Area TarifariaSelect")));
                        //navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
                        Select combobox1 = new Select(comboboxElement1);
                        combobox1.selectByValue(Transfers.getDdd());
                        
                                                     //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                        Thread.sleep(500);
                        //Selecionarecurso
                        WebElement comboboxElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("resourcePool")));
                        //navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
                        Select combobox2 = new Select(comboboxElement2);
                        combobox2.selectByValue("30");
                         
                          Thread.sleep(500);
                        //Botao confirma o dd 
                         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[4]//td[1]//img[2]"))).click();
                        
                        
                 
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                        
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='tableText']//a[1]"))).click();

                        //Retornando a tela
                        navegador.switchTo().window(winHandleBefore);

                        
                        if (Tela_Mobile.GerarIccd.isSelected() == true) {
                            
                            if(Transfers.isIccdGeradoAntes() == false){
                            //Chamando a classe do iccd
                            if (PrimeiraRodadaIccd == 0) {
                               // System.out.println("Gerando o Iccd depois do Erro");
                                GerarIccd gerarIccd = new GerarIccd();
                                iccdCompare = gerarIccd.geraiccd();
                            }
                        }
                         Transfers.setIccdGeradoAntes(false);   
                         
                        } else {

                            iccdCompare = Tela_Mobile.iccd100.get(0);
                        }

                        String iccd = "";

                        switch (diferenciarIccd) {
                            case 0:
                                iccd = iccdCompare;
                                break;
                            case 1:
                                iccdCompare1 = iccdCompare;
                                iccd = iccdCompare1;
                                break;
                            case 2:
                                iccdCompare2 = iccdCompare;
                                iccd = iccdCompare2;
                                break;
                            case 3:
                                iccdCompare3 = iccdCompare;
                                iccd = iccdCompare3;

                                break;
                            case 4:
                                iccdCompare4 = iccdCompare;
                                iccd = iccdCompare4;
                                break;
                            case 5:
                                iccdCompare5 = iccdCompare;
                                iccd = iccdCompare5;
                                break;
                            case 6:
                                iccdCompare5 = iccdCompare;
                                iccd = iccdCompare5;
                                break;
                            case 7:
                                iccdCompare7 = iccdCompare;
                                iccd = iccdCompare7;
                                break;
                            case 8:
                                iccdCompare8 = iccdCompare;
                                iccd = iccdCompare8;
                                break;
                            case 9:
                                iccdCompare9 = iccdCompare;
                                iccd = iccdCompare9;
                                break;
                            case 10:
                                iccdCompare10 = iccdCompare;
                                iccd = iccdCompare10;
                                break;
                            default:
                                iccd = iccdCompare;
                        }
                        diferenciarIccd++;                           
                        WebElement iccdA = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"regular\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")));
                        iccdA.sendKeys(iccd);

                        PrimeiraRodadaIccd = 0;

                        //removendo se a duplicidade ou erro de Iccd
                        if (Tela_Mobile.GerarIccd.isSelected() == false) {
                            Tela_Mobile.iccd100.remove(0);
                        }
                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                        
                        //Botao do proximo apos a insersao do iccds
                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                        
                        
//                       JOptionPane.showMessageDialog(null, "Stop");
                        
                        
                        if(navegador.getTitle().contains("CM - Novo Assinante -Parâmetros")){
                           System.out.println("Iccd limpo para o uso"); 
                           erroIccds = 1;
                        }else{ 
                        // lista para verificar se ocorreu o erro
                        ContadorSubSub = 0;
                        List<WebElement> auxiliarbt1 = navegador.findElement(By.id("message")).findElements(By.tagName("input"));
                        for (WebElement titlebt1 : auxiliarbt1) {
                            ContadorSubSub++;
                        }
                        if (ContadorSubSub < 1) {
                            erroIccds = 1;
                            //Quebrando o Primeira consulta do Iccd || Caso Haja erro para a duplicidade de Iccd

                            System.out.println("Iccd limpo para o uso");
                            break; // titlebt1.click();
                        } else {
                            System.out.println("Erro na Execucao para inclusao de ICCDS! Iniciando novamente");
                            //Linpando o campo de iccds

                            WebElement iccd2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"regular\"]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/input")));
                            iccd2.clear();
                        }
                        
                    }
                        
                        
                    } catch (Exception ex) {
                        Logger.getLogger(Assinante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                
                
                //	 Par�metro das Ofertas
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();

                                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
          
                //	  Distribuição de Encargos
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                
               // if(Tela_Mobile.boxClienteAssinante.getSelectedItem() != "Pos-Pago Banda Larga" || Tela_Mobile.boxClienteAssinante.getSelectedItem() != "Controle Tecnologia 3G" ){
              //  if(Tela_Mobile.boxClienteAssinante.getSelectedIndex()< 6){
               
                    if(SelecaoOfertaAssinante.Oferta_permanencia.isSelected() == true){
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='commitOfrAmount_380603774']"))).clear(); 
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='commitOfrAmount_380603774']"))).sendKeys("200");
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();
                } 
            //    }
                   
                //Capturando  o CPF || CNPJ
                WebElement auxiliarbt4_1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='bgTable']//tr[21]//td[2]")));
                CpfGerado = auxiliarbt4_1.getText();
                 System.out.println("CPF | CNPJ: " + CpfGerado);
               
                             //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
               // Botao Ativar o assinante
               wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[3]"))).click();
               
    
                navegador.findElement(By.name("userTextArea")).sendKeys("Confirmacao do Assinante");
                
                
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();    
                
                
                       
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }   
                     
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }

                int clienteAux2 = Tela_Mobile.boxClienteS.getSelectedIndex();
                if (clienteAux2 == 9) {
                  
                    ContadorSubSub = 0;
                    List<WebElement> auxiliarbt6 = navegador.findElements(By.name("imageField"));
                    auxiliarbt6.get(2).click();
                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("userTextArea"))).sendKeys("Confirmacao do Assinante 2");
                
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img[2]"))).click();    

                    Alert alert2 = navegador.switchTo().alert();
                    alert2.accept();

                                                 //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
               
                    
                }    
                
    
//            } catch (Exception e) {
//                System.out.println("Erro na Execucao da Assinatura! Iniciando novamente");
//
//                             ContadorErro++;
//           
//                if(ContadorErro == 15){
//                    ContadorErro = 0;  
//                    sucesso = false;
//                    return sucesso;
//                }       
//                    
//                    
//                //Voltando para tela inicial da oferta
//                contadorImgAss = 0;
//                List<WebElement> auxiliarConta2 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
//                auxiliarConta2.get(1).click();
//                continue;
//
//            }
             sucesso =true;
            loopValidador = 1; // Parando o loop 	    	  
     //   }//while do lopping   	               //while do lopping   	               
        return sucesso;
    }

}
