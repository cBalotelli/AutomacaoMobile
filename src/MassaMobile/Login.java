package MassaMobile;

import Pacote_Principal.Transfers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {



	public boolean login(boolean sucesso, WebDriver navegador) {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
		String  usuario = "60001", senha = "unix22";
        //String site = "http://brux0802:20060/docroot/login/login.jsp";
        String site = Transfers.getLink();
        String tipo = Transfers.getTipoNavegador();
        int loopValidador =0, ContadorErro=0;
     //  navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       navegador.get(site);
       navegador.manage().window().maximize();
    
      
         while (loopValidador == 0) {
            try {   
       
       
       if (tipo == "Chrome") {
       // confirmação de tela antes de selecionar um elemento
       WebElement  btnConfirmarOKIe = navegador.findElement(By.name("user"));
        btnConfirmarOKIe.sendKeys(usuario);
       WebElement passwordLoginIe = navegador.findElement(By.name("password"));
       passwordLoginIe.sendKeys(senha);
      // navegador.findElement(By.name("loginBtn")).click();
       }
       
       if (tipo == "Ie") {
    	   	   
    	   WebElement  btnConfirmarOKIe = navegador.findElement(By.name("user"));
           btnConfirmarOKIe.sendKeys(usuario);
          WebElement passwordLoginIe = navegador.findElement(By.name("password"));
          passwordLoginIe.sendKeys(senha);
         // navegador.findElement(By.name("loginBtn")).click();
    	    	   
     //    WebElement usuarioLogin =  navegador.findElement(By.name("user"));
      // usuarioLogin.sendKeys(usuario);
    //   usuarioLogin.sendKeys("6");
    //   usuarioLogin.sendKeys(Keys.ARROW_DOWN);
   //    usuarioLogin.sendKeys(Keys.ARROW_DOWN);
   //    usuarioLogin.sendKeys(Keys.ENTER);
       }
       navegador.findElement(By.name("loginBtn")).click();
            } catch (Exception e) {
                System.out.println("Erro na Execucao da Oferta! Iniciando novamente");

                             ContadorErro++;
           
                if(ContadorErro == 15){
                    ContadorErro = 0;  
                    sucesso = false;
                    return sucesso;
                       
     }

        }
            loopValidador = 1;
            sucesso =true;
  }
       return sucesso;

       
	}

}
