package MassaCRM;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
  
public class Navegadores {
	
	public static WebDriver navegadores(WebDriver navegador) {
  
                      // IE
                      System.setProperty("webdriver.ie.driver", "C:\\Automacao_Mobile\\Driver\\IEDriverServer.exe");
                      
                      DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                      caps.setCapability("platform", "Windows");
                      caps.setCapability("version", "10");                    
                      navegador = new InternetExplorerDriver(caps);               
                                              
        return navegador;
	
	  }
	}
	
	
	
	

