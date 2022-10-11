package hotWell;


import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.SessionId;
  
public class Navegadores {
	
	public static WebDriver navegadores(WebDriver navegador) {
      String tipo = Tela_Hot.tipoNavegador;
		
                  String extensao = "chrome-extension://hehijbfgiekmjfkfjpbkbammjbdenadd/nhc.htm#url=";
                  // Chrome
                  System.setProperty("webdriver.chrome.driver", "C:\\System_Program_Automacao\\driver\\chromedriver.exe");
                  ChromeOptions options = new ChromeOptions();
                  navegador = new ChromeDriver();
                  
                  //Ie
                 // System.setProperty("webdriver.ie.driver", "C:\\Eclipse projeto\\driver\\IEDriverServer.exe");
                  //navegador = new InternetExplorerDriver();
                  
        return navegador;
	
	  }
	}
	
	
	
	

