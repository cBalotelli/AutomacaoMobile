package MassaWa;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
  
public class Navegadores_WA {
	
	public static WebDriver navegadores(WebDriver navegador) {
      String tipo = Tela_WA.tipoNavegador;
		
         if(tipo.equals("Chrome")) {
               System.setProperty("webdriver.chrome.driver", "C:\\Automacao_Mobile\\Driver\\chromedriver.exe");     
           //    ChromeOptions options = new ChromeOptions();
           //    options.addExtensions(new File("C:\\Users\\henrique.rodrigues\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\hehijbfgiekmjfkfjpbkbammjbdenadd\\12.4.4.1_0.crx"));
               
               
            navegador = new ChromeDriver();
            

    

         }
         
                      if(tipo.equals("Firefox")) {
                          // Firefox
                          System.setProperty("webdriver.gecko.driver", "C:\\Automacao_Mobile\\Driver\\geckodriver.exe");
                          navegador = new FirefoxDriver();
                      }

                  if (tipo.equals( "Ie")) {
                      // IE
                      System.setProperty("webdriver.ie.driver", "C:\\Automacao_Mobile\\Driver\\IEDriverServer32.exe");
                    DesiredCapabilities dc = new DesiredCapabilities();
                    dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
                    dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
                    dc.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
                    dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
                    dc.setJavascriptEnabled(true);  
                      
                      navegador = new InternetExplorerDriver(dc);
                  
                  }
                  
               
        return navegador;
	
	  }
	}
	
	
	
	

