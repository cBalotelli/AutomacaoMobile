package MassaMobile;




import Pacote_Principal.LoginBanco;
import Pacote_Principal.Transfers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
  
public class Navegadores {
	public static WebDriver navegador= null;
	public static boolean navegadores(boolean sucesso) {
      
            String tipo = Transfers.getTipoNavegador();		   
  
         if(tipo.equals("Chrome")) {
                //  String extensao = "chrome-extension://hehijbfgiekmjfkfjpbkbammjbdenadd/nhc.htm#url=";
                  // Chrome
                  System.setProperty("webdriver.chrome.driver", LoginBanco.caminhoRedeLogin+"\\Driver\\chromedriver.exe");              
                 
                   ChromeOptions options = new ChromeOptions();
                   
                   
               //    options.addArguments("headless");
                   navegador = new ChromeDriver(options);
     
              }
                      if(tipo.equals("Firefox")) {
                          // Firefox
                          System.setProperty("webdriver.gecko.driver", LoginBanco.caminhoRedeLogin+"\\Driver\\geckodriver.exe");
                          navegador = new FirefoxDriver();
                      }

                  if (tipo.equals( "Ie")) {
                      // IE
                      System.setProperty("webdriver.ie.driver", LoginBanco.caminhoRedeLogin+"\\Driver\\IEDriverServer.exe");
                      
                      DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                      caps.setCapability("platform", "Windows");
                      caps.setCapability("version", "10");                    
                      navegador = new InternetExplorerDriver(caps);               
                  }  
                  
                  sucesso = true;
        return sucesso;
	
	  }
	}
	
	
	
	

