package MassaWa;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

public class Login_WA {
    
    

    public void login(WebDriver navegador) throws AWTException, InterruptedException {
        
            
        String usuario = "l011q", senha = "claro#123";
        //String site = "http://brux0802:20060/docroot/login/login.jsp";
        
        String extensao = "chrome-extension://hehijbfgiekmjfkfjpbkbammjbdenadd/nhc.htm#url=";
        String site = Tela_WA.Tlink;
        String tipo = Tela_WA.tipoNavegador;
        Robot robo =new Robot();

        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(navegador, 20);

        navegador.get(site);
        //navegador.close();

        navegador.manage().window().maximize();
        
        
        
    
     
//     
//   Screen screen = new Screen();
//   Pattern btnLogon = new Pattern ("C:\\Users\\henrique.rodrigues\\Desktop\\ElementoSikuli\\btnLogon.PNG");
//        screen.click(btnLogon);
//        

        if (tipo == "Chrome") {
            
            
              navegador.get(site);
        //navegador.close();

      //  navegador.manage().window().maximize();
        
        
//        
//                    
//            
//            
//    ArrayList<String> tabs2 = new ArrayList<String> (navegador.getWindowHandles());
//    navegador.switchTo().window(tabs2.get(1));
//    navegador.close();
//    navegador.switchTo().window(tabs2.get(0));
//      
            
         
            } 
             Thread.sleep(1000);
             
            // confirmação de tela antes de selecionar um elemento
            WebElement btnConfirmarOKIe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("j_username")));
            btnConfirmarOKIe.sendKeys(usuario);
            
           // colocar o robot na digitacao no WA
           
            
            WebElement passwordLoginIe = navegador.findElement(By.name("j_password"));
            passwordLoginIe.sendKeys(senha);
                    
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='button']"))).click();
     
       



    }

}
