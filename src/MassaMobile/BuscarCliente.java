package MassaMobile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuscarCliente {
	public static void  buscarCliente(WebDriver navegador ) {
		
	       //Cliente 102417714
		
        String numeroCliente = "";
        
        numeroCliente = Automacao.customerLista;
            System.out.println("Custumer para buscaCliente: "+ numeroCliente);
      
        //Retornando para tela inicila de cadastro de cliente para loop de massas    
        List<WebElement> auxiliarCiclo = navegador.findElements(By.tagName("img"));
        int ContadorSubSubb =0;
        for (WebElement titleCiclo : auxiliarCiclo) { ContadorSubSubb++;if (ContadorSubSubb == 17) {titleCiclo.click(); }}   
        
         // BUSCANDO PARA O CHROME
        navegador.findElement(By.name("selectById")).sendKeys(Keys.HOME);
        navegador.findElement(By.name("searchForId")).clear();
        navegador.findElement(By.name("searchForId")).sendKeys(numeroCliente);
        navegador.findElement((By.name("imageField"))).click();
        navegador.findElement(By.className("tableLinks")).click();	
	}

}
