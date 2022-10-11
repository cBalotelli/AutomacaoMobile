package MassaMobile;

import Geradores.GeradorCnpj;
import Geradores.GeradorCPF;
import Geradores.GeradorNome;
import Geradores.GeradorNomeMae;
import Geradores.GeradorRg;
import Geradores.GeradorSobrenome;
import Impressao.PrintTela;
import Pacote_Principal.Processando;
import Pacote_Principal.Transfers;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cliente {

    public static String cpfGerado = "";
    public static String NomeGerado = "";
    public static String CnpjGerado = "";
    PrintTela print = new PrintTela();

    public boolean cliente(boolean sucesso, WebDriver navegador) throws Exception {

        String winHandleBefore = navegador.getWindowHandle();
        String TipoCliente, codigodistribuidor = "12540", tipoNomeSubTipo;

        TipoCliente = Tela_Mobile.T_Cliente;
        String AuxCliente = Tela_Mobile.T_Cliente;
        tipoNomeSubTipo = Tela_Mobile.TipoNomeSubTipo;
        ArrayList<String> ListaCpf = new ArrayList<String>();
        boolean incluirCpf = Tela_Mobile.incluirCPF;
        boolean incluirNome = Tela_Mobile.incluirNome;

        ListaCpf = Tela_Mobile.ListaCPF;

        int ContadorErro = 0, loopValidador = 0, contadorImagem = Transfers.getContadorImagem();;

        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 6);

        //Chamando classe para nomes 
        GeradorNome geradorNome = new GeradorNome();
        GeradorSobrenome geradorSobrenome = new GeradorSobrenome();
        GeradorNomeMae geradorNomeMae = new GeradorNomeMae();
        Random numeroAleatorio = new Random();

        String nomeCliente = geradorNome.mostraResultado();
        String nomeSobrenome = geradorSobrenome.mostraResultado();
        String nomeMae = geradorNomeMae.mostraResultado();
        int nomeAleatorioEndereco = numeroAleatorio.nextInt(500);
        String NEndereco = Integer.toString(nomeAleatorioEndereco);

        while (loopValidador == 0) {
            try {

                //Chamando classe para nomes   
                WebElement element1 = navegador.findElement(By.id("OUT1t"));
                element1.click();
                WebElement element2 = navegador.findElement(By.linkText("Adicionar"));
                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                element2.click();

                navegador.findElement(By.cssSelector("input[name='dealerDesc']")).sendKeys(codigodistribuidor);

                //SELECIONANDO O TIPO DE CLIENTE              
                //Pegando o tipo de cliente
                WebElement tipoclientee = wait.until(ExpectedConditions.elementToBeClickable(By.name("custType")));
                Select Element1 = new Select(tipoclientee);
                Element1.selectByValue(TipoCliente);

                //Pegando o subtipo                                                                
                if (AuxCliente == "I") {

                    WebElement subTipo = wait.until(ExpectedConditions.elementToBeClickable(By.name("ISubTypeValue")));
                    Select Element2 = new Select(subTipo);
                    Element2.selectByValue(tipoNomeSubTipo);
                }
                //Pegando o subtipo                                                               
                if (AuxCliente == "B") {
                    WebElement subTipo = wait.until(ExpectedConditions.elementToBeClickable(By.name("BSubTypeValue")));
                    Select Element2 = new Select(subTipo);
                    Element2.selectByValue(tipoNomeSubTipo);
                }
                //Pegando o subtipo                                                              
                if (AuxCliente == "G") {
                    WebElement subTipo = wait.until(ExpectedConditions.elementToBeClickable(By.name("GSubTypeValue")));
                    Select Element2 = new Select(subTipo);
                    Element2.selectByValue(tipoNomeSubTipo);
                }

                //Quebrando o SubSubnavigation da pagina      
                List<WebElement> auxiliar1 = navegador.findElements(By.className("subSubNavigation"));
                auxiliar1.get(0).click();

                for (String winHandle : navegador.getWindowHandles()) {
                    navegador.switchTo().window(winHandle);
                }

                navegador.findElement(By.name("dealerCode")).sendKeys("12540 - RODRIGO SILVA DE FARIA");
                navegador.switchTo().window(winHandleBefore);

                // localidade
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='bgTable']//tr[5]//a"))).click();

                for (String winHandle_2 : navegador.getWindowHandles()) {
                    navegador.switchTo().window(winHandle_2);
                }
                wait.until(ExpectedConditions.elementToBeClickable(By.name("dealerCode"))).sendKeys("TL02 - CLARO S/A");

                navegador.switchTo().window(winHandleBefore);

                //Tipo de varejo
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='bgTable']//tr[6]//a"))).click();

                for (String winHandle_3 : navegador.getWindowHandles()) {
                    navegador.switchTo().window(winHandle_3);
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.name("dealerCode"))).sendKeys("Varejo");
                navegador.switchTo().window(winHandleBefore);

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.name("next_img"))).click();

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                //Tipo SPED 1 
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//img[2]"))).click();

                //Tipo de ciclo
                String Ncycle = Tela_Mobile.TnumeroCyclo;

                //Seleciona um parceiro
                WebElement comboboxElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("cycle")));
                Select combobox = new Select(comboboxElement);
                combobox.selectByValue(Ncycle);

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//img[2]"))).click();

                Transfers.setNomeCliente(nomeCliente + " " + nomeSobrenome);

                if (TipoCliente.equals("B")) {
                    navegador.findElement(By.name("BnameElement1")).sendKeys(nomeCliente);
                }

                if (TipoCliente.equals("I")) {

                    if (incluirNome == true) {
                        NomeGerado = Transfers.getListaNomeGerado().get(0);
                        String NomeSobrenome = NomeGerado;
                        String auxnome = "", sobrenome = "";
                        for (int y = 0; y <= NomeSobrenome.length(); y++) {
                            auxnome = (auxnome + NomeSobrenome.substring(y, (y + 1)));
                            if (auxnome.contains(" ")) {
                                auxnome = "";
                                y++;
                                for (int x = y; x <= NomeSobrenome.length(); x++) {
                                    sobrenome = (sobrenome + NomeSobrenome.substring(x, (x + 1)));
                                    if (sobrenome.contains(" ")) {
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        nomeCliente = NomeGerado;
                        nomeSobrenome = sobrenome;
                        Transfers.setNomeCliente(nomeCliente + " " + nomeSobrenome);
                    }

                    // GeradorNome geradorNome = new GeradorNome();                 
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"name_message_P\"]/table/tbody/tr[1]/td[2]/input"))).sendKeys(nomeCliente);
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("PnameElement2"))).sendKeys(nomeSobrenome);
                }

                // atribuindo o CEP                                      // AV. PAULISTA   01310923
                wait.until(ExpectedConditions.elementToBeClickable(By.name("SaddressElement6"))).sendKeys("01310");
                wait.until(ExpectedConditions.elementToBeClickable(By.name("SaddressElement7"))).sendKeys("923");
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='address_message_S']//tr//img"))).click();

                // mudando para outra janela
                for (String winHandle_3 : navegador.getWindowHandles()) {
                    navegador.switchTo().window(winHandle_3);
                }
                wait.until(ExpectedConditions.elementToBeClickable(By.name("address"))).click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@name='mainForm']//table//td//img[1]"))).click();

                navegador.switchTo().window(winHandleBefore);

                wait.until(ExpectedConditions.elementToBeClickable(By.name("SaddressElement3"))).sendKeys(NEndereco);

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                //botao proximo
                List<WebElement> auxiliarbt = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarbt.get(2).click();

                //Mercado Estado  
                WebElement comboboxElement0 = navegador.findElement(By.name("marketCompanyIndex"));
                Select combobox0 = new Select(comboboxElement0);
                combobox0.selectByIndex(Transfers.getEstadoMercado());

                // Chamando classe de gerados de cpf , Rg�s e Cnpj�s              
                GeradorCPF geradorCPF = new GeradorCPF();
                GeradorCnpj geradorCnpj = new GeradorCnpj();
                GeradorRg geradorRg = new GeradorRg();

                if (TipoCliente == "I") {
                    try {
                        if (incluirCpf == true) {
                            cpfGerado = ListaCpf.get(0);
                            navegador.findElement(By.name("privateTaxId")).sendKeys(cpfGerado);

                        } else {
                            cpfGerado = geradorCPF.mostraResultado();
                            navegador.findElement(By.name("privateTaxId")).sendKeys(cpfGerado);

                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();

                    }
                    try {
                        navegador.findElement(By.name("idDocNumber")).sendKeys(geradorRg.gerarRg());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("idEmissionBranch"))).sendKeys("SSP");
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("birthDate"))).sendKeys("10102000");

                    if (Tela_Mobile.boxCliente.getSelectedItem() == "COMERCIAL") {
                        JavascriptExecutor js = (JavascriptExecutor) navegador;
                        navegador.findElement(By.cssSelector("span[class='ctl00_ContentPlaceHolder1_DtgSelecao']")).click();

                        for (String winHandle : navegador.getWindowHandles()) {
                            navegador.switchTo().window(winHandle);
                        }

                        //Pegando o tipo de cliente
                        //    WebElement tipocnae = wait.until(ExpectedConditions.elementToBeClickable(By.name("custType")));
                        //    Select Elementcnae = new Select(tipocnae); Element1.selectByValue("0111201 - Cultivo de arroz");	
//                WebElement element98 = navegador.findElement(By.name("cnaeCode"));
//                js.executeScript("arguments[0].setAttribute('value', '0111201')", element98);
//                
//                 WebElement element99 = navegador.findElement(By.name("cnae_desc"));
//                js.executeScript("arguments[0].setAttribute('value', 'Cultivo de arroz')", element99);
//                
//                 WebElement element100 = navegador.findElement(By.name("submit"));
//                js.executeScript("arguments[0].setAttribute('value', 'Cultivo de arroz')", element100);
//             
//       
//                        navegador.findElement(By.name("submit")).click();
//                     
                    } else {

                        try {
                            // atribuindo o nome PEGANDO NA LISTA da mae
                            wait.until(ExpectedConditions.elementToBeClickable(By.name("motherName"))).sendKeys(nomeMae);
                        } catch (Exception ex) {
                            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }//Fechamento do if TipoCliente

                if (TipoCliente == "B") {
                    try {
                        if (incluirCpf == true) {
                            cpfGerado = ListaCpf.get(0);
                            wait.until(ExpectedConditions.elementToBeClickable(By.name("businessTaxId"))).sendKeys(CnpjGerado);
                        } else {
                            CnpjGerado = geradorCnpj.geraCNPJ();
                            wait.until(ExpectedConditions.elementToBeClickable(By.name("businessTaxId"))).sendKeys(CnpjGerado);
                        }

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTelaScroll(navegador);
                }

                //botao proximo
                List<WebElement> auxiliarbt1 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarbt1.get(2).click();

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                List<WebElement> auxiliarbt2 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarbt2.get(2).click();

                // TELA DE MEMORANDO DO CLIENTE
                wait.until(ExpectedConditions.elementToBeClickable(By.name("userTextArea"))).sendKeys("CLIENTE OK");

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                List<WebElement> auxiliarbt3 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarbt3.get(2).click();

                // TELA SALVANDO O CLIENTE
                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTelaScroll(navegador);
                }

                List<WebElement> auxiliarbt4 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarbt4.get(2).click();

                //Print da Tela 
                if (Transfers.getPrintAll() == 1) {
                    print.printTela(navegador);
                }

                sucesso = true;
            } catch (Exception e) {
                System.out.println("Erro na Execucao da Cliente! Iniciando novamente");
                ContadorErro++;

                if (ContadorErro == 15) {
                    ContadorErro = 0;
                    sucesso = false;
                    return sucesso;
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//img[1]"))).click();

                continue;
            }

            loopValidador = 1; // Parando o loop 	    	  

            if (incluirCpf == true) {
                ListaCpf.remove(0);
            }
            if (incluirNome == true) {
                Transfers.getListaNomeGerado().remove(0);
            }

        }
        return sucesso;
    }
}
