package hotWell;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {



	public void login(WebDriver navegador) {
		
		 
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
		String  usuario = "999999999", senha = "999999999";
        String site = Tela_Hot.Tlink;
      
      navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       navegador.get(site);
       navegador.manage().window().maximize();
          
       // confirmação de tela antes de selecionar um elemento
       WebElement  btnConfirmarOKIe = navegador.findElement(By.name("j_username"));
        btnConfirmarOKIe.sendKeys(usuario);
     //  btnConfirmarOKIe.sendKeys("9");
     //  btnConfirmarOKIe.sendKeys(Keys.ARROW_DOWN);
     //  btnConfirmarOKIe.sendKeys(Keys.ENTER);
       WebElement passwordLoginIe = navegador.findElement(By.name("j_password"));
       passwordLoginIe.sendKeys(senha);
       
      navegador.findElement(By.xpath("//*[@id=\"mainContent\"]/form/table/tbody/tr[2]/td/center/table/tbody/tr[5]/td/input")).click();
  
	}

}
