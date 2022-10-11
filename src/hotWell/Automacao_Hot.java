package hotWell;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.gargoylesoftware.htmlunit.javascript.host.html.Image;


class Automacao_Hot {
public WebDriver navegador;
private boolean liberado ;
private int QMassa = 0, QMassaOld=0, msysdnInseridos=0; 
public static  String msysdnsLista ="";
private ArrayList<String> MsysdnList = new ArrayList<String> ();



	//@Test
	void test() {
	
		String Planta = "3gp ";


	do {
	   // esperando resultado o plano de massa	
	
	  
	  if(Tela_Hot.Tmsysdn > 0) { liberado = true;  }
		 	
	   System.out.println("Esperando a Configura��o");

	 } while (liberado == false );	
	
	navegador = Navegadores.navegadores(navegador);
	
	
	//Chamando a classe login
	System.out.println("Chamando a classe login");
	Login login =new Login ();
	login.login(navegador);
	
	
	QMassa = Tela_Hot.TQuantidadeMassa;
	//QMassa ++;
	 System.out.println("quantidade"+ QMassa);
	
	//Tranferindo para outra lista
    MsysdnList.addAll(Tela_Hot.msysdn);

    
	while(QMassa >= 1) {
		
		

     msysdnsLista = MsysdnList.get(0);
	//Chamando a classe Criar Cliente
	System.out.println("Chamando a classe AlterarServico");
	AlterarServico claro = new AlterarServico();
	claro.claro(navegador);
	msysdnInseridos++;
	System.out.println("Alterado com Sucesso");
	
	//
	navegador.get("http://arcoiris:8910/wpp/consultaPrincipal.do?acao=abrirConsultaMSISDN");
	
    
	MsysdnList.remove(0);
	   
    
    //Chamando a classe para Print
	//System.out.println("Chamando a classe para Print");
	 //Object dataPrint = getDateTime();
	 //String nomePrint = (Planta+dataPrint+".jpeg") ;//
	 //takeSnapShot  (navegador , nomePrint );
  
     //
	

	 QMassa = (QMassa -1);
	 
	 }// fechamento do While
	
	QMassaOld = AlterarServico.QMassaAlterar;
	
	 
		 
		
		 if (QMassa == 0) {	
			JOptionPane.showMessageDialog(null,"           "+ msysdnInseridos+"   Msysdn \nTranferidos  com Sucesso");
		
		}
	 
	     navegador.close(); 
	     
	 	
	
	
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
        String imageFileDir = "C:\\Users\\"+NomeUsuario+"\\Desktop\\PrintMassas";
        String nomeDoArquivoImagem = nomePrint;
		try {
			FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
          
	}

	//Capturando a data do sistema
	private Object getDateTime() {	
        DateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date data1 = new Date();
        return dataFormatada.format(data1);
		
		
	}


	
}
