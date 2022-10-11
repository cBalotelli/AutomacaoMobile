/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impressao;

import Pacote_Principal.Transfers;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author henrique.rodrigues
 */
public class PrintTela {

   public  void printTela(WebDriver driver) throws IOException {

    JavascriptExecutor jsExec = (JavascriptExecutor)driver;  
    jsExec.executeScript("window.scrollTo(0, 0);"); //Scroll To Top

    Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
    Long scroll = innerHeight;
    Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); 
    scrollHeight = scrollHeight + scroll;

   // do{      
         Transfers.setContadorImagem(Transfers.getContadorImagem()+1) ;
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         String nomeDoArquivoImagem = Transfers.getContadorImagem()+".jpeg";
         FileUtils.copyFile(screenshot, new File(Transfers.getCaminhoPrint(), nomeDoArquivoImagem));
         jsExec.executeScript("window.scrollTo(0, "+innerHeight+");");
         innerHeight = innerHeight + scroll;
 //   }while(scrollHeight > innerHeight);
}  
   
      public  void printTelaScroll(WebDriver driver) throws IOException {

    JavascriptExecutor jsExec = (JavascriptExecutor)driver;  
    jsExec.executeScript("window.scrollTo(0, 0);"); //Scroll To Top

    Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
    Long scroll = innerHeight;
    Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;"); 
    scrollHeight = scrollHeight + scroll;

    do{      
         Transfers.setContadorImagem(Transfers.getContadorImagem()+1) ;
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         String nomeDoArquivoImagem = Transfers.getContadorImagem()+".jpeg";
         FileUtils.copyFile(screenshot, new File(Transfers.getCaminhoPrint(), nomeDoArquivoImagem));
         jsExec.executeScript("window.scrollTo(0, "+innerHeight+");");
         innerHeight = innerHeight + scroll;
    }while(scrollHeight > innerHeight);
} 

    public void criarEvidencia() {
        try {
           
            String NomeUsuario = System.getProperty("user.name");
            String CaminhoPrint = "C:\\Documents and Settings\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa\\Print_"+ Transfers.getContadorMassa();
            Transfers.setCaminhoPrint(CaminhoPrint);
            File diretorio = new File(CaminhoPrint);
            diretorio.mkdir();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio Pasta de evidencia");
            System.out.println(ex);
        }
    }
    
}
