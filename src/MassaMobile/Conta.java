package MassaMobile;

import Geradores.GeradorContrato;
import Impressao.PrintTela;
import Pacote_Principal.Transfers;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import Impressao.PrintTela;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Conta {

    PrintTela print = new PrintTela();

    public boolean conta(boolean sucesso ,WebDriver navegador) throws IOException {

        boolean nContrato = Tela_Mobile.nContrato, nContratoAutomatico = Tela_Mobile.nContratoAutomatico;
        ArrayList<String> ListaContrato = new ArrayList<String>();
        ListaContrato = Tela_Mobile.ListaContrato;
        String Contrato = "";
        int contadorImg = 0, contadorImg1 = 0, contadorImg2 = 0, loopValidador= 0 , ContadorErro =0;
 

        // confirmacao de tela antes de selecionar um elemento
        WebDriverWait wait = new WebDriverWait(navegador, 5);

        WebElement btnConfirmarOK = wait.until(ExpectedConditions.elementToBeClickable(By.id("OUT1t")));
        btnConfirmarOK.click();

        //Print da Tela 
        if (Transfers.getPrintAll() == 1) {
            print.printTela(navegador);
        }

                while (loopValidador == 0) {
            try {

        
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("OUT1s"))).findElement(By.linkText("Adicionar")).click();

        //Caso seja selecionado numero de contrato para conta   
        if (nContrato == true) {
            //classe gerador de contrato

            if (nContratoAutomatico == true) {
                GeradorContrato geradorContrato = new GeradorContrato();
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.name("accountComboExternalId"))).sendKeys(geradorContrato.mostraResultado());
                } catch (Exception ex) {
                    Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Erro Em gerar o Numero de Contrato");
                }
            } else {
                Contrato = ListaContrato.get(0);
                System.out.println("Numero de Contaro da Lista: " + Contrato);
                wait.until(ExpectedConditions.elementToBeClickable(By.name("accountComboExternalId"))).sendKeys(Contrato);
                ListaContrato.remove(0);
            }
        }

        //Listando a primeira tela Informacoes Gerais da Conta
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='bgButtons']//td[2]//img"))).click();

        int n = 0, x = 0;
        List<WebElement> auxiliarConta = null;
        while (n < 6) {

            n++;
            auxiliarConta = wait.until(ExpectedConditions.elementToBeClickable(By.className("bgButtons"))).findElements(By.tagName("img"));
            
            for (WebElement titleImg : auxiliarConta) {
                contadorImg++;
                if (contadorImg == 3) {
                    x++;
                    if (x == 3) {
                        if (Transfers.getPrintAll() == 1) {
                            print.printTelaScroll(navegador);
                        }
                    } // Print scroll
                    if (x == 4) {
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("payDescription"))).sendKeys("Tester");
                    } // Inserindo o nome na Descricao
                    if (x == 5) {
                        wait.until(ExpectedConditions.elementToBeClickable(By.name("userTextArea"))).sendKeys("Nova Conta");
                    }// Inserindo o nome na Descricao no Memorando
                    if (x == 6) {
                        if (Transfers.getPrintAll() == 1) {
                            print.printTelaScroll(navegador);
                        }
                    } else { // Print scroll
                        if (Transfers.getPrintAll() == 1) {
                            print.printTela(navegador);
                        }
                    }
                    titleImg.click();
                }// fechamento do If
            }//fechamento do FOr
            auxiliarConta = null;
            contadorImg = 0;
        }//fechamentodo while

        //Confirmando o Window Confirm
        Alert alert = navegador.switchTo().alert();
        alert.accept();

        //Print da Tela 
        if (Transfers.getPrintAll() == 1) {
            print.printTela(navegador);
        }

        //alterando a janela para "UNIDADE ORG."
        List<WebElement> auxiliarConta2 = navegador.findElements(By.tagName("img"));
        auxiliarConta2.get(7).click();

        
                    } catch (Exception e) {
                System.out.println("Erro na Execucao da Assinatura! Iniciando novamente");

                             ContadorErro++;
           
                if(ContadorErro == 15){
                    ContadorErro = 0;  
                    sucesso = false;
                    return sucesso;
                }       
                    
                    
                //Voltando para tela inicial da oferta
              
                List<WebElement> auxiliarConta2 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
                auxiliarConta2.get(1).click();
 
                continue;

            }
            sucesso = true;
            loopValidador =1;
                }
        
        return sucesso;
    }

}
