package hotWell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AlterarServico {
	
		public static int QMassaAlterar = 0;

	public void claro (WebDriver navegador) {
		
		String unicoMsysdn = Automacao_Hot.msysdnsLista;
			

		
		//pegando e inserindo primeiro mysdns
		navegador.findElement(By.name("telefone")).sendKeys(unicoMsysdn);
		navegador.findElement(By.xpath("//*[@id=\"mainContent\"]/form/table/tbody/tr[2]/td/center/table/tbody/tr[9]/td/input")).click();
		
		
		navegador.get("http://arcoiris:8910/wpp/servicosBasicos.do?acao=abrirServicos");
   
        //Seleciona o hot
  		WebElement comboboxElement = navegador.findElement(By.name("servicosContratados"));
  		//navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
  		Select combobox = new Select(comboboxElement); 
  	
  		//Verificando se esta na area de tranferencia
  		combobox.getAllSelectedOptions();  		
  		if(combobox.equals("WELL")) {
  			
  			System.out.println("WELLCOME_HOT encontrado");
  			
  			
  			WebElement comboboxElement1 = navegador.findElement(By.name("servicosContratados"));
  	  		//navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
  	  		Select combobox1 = new Select(comboboxElement1); 
  			
  			combobox1.selectByValue("WELL");  			
  			navegador.findElement(By.xpath("//*[@id=\"mainContent\"]/form/table/tbody/tr[2]/td/center/table/tbody/tr[3]/td[2]/img[2]")).click();
  		                                    //*[@id=\"mainContent\"]/form/table/tbody/tr[2]/td/center/table/tbody/tr[3]/td[2]/img[2]
  		
  		//Alterando o motivo
  		WebElement comboboxElement2 = navegador.findElement(By.name("motivo"));
  		//navegador.findElement(By.xpath("//*[@id='ddlPartner']")).click();
  		Select combobox2 = new Select(comboboxElement2); combobox2.selectByValue("PEDIDOCLIENTE"); 		
  		
  	    //botao salvar
        navegador.findElement(By.xpath("//*[@id=\"mainContent\"]/form/table/tbody/tr[2]/td/center/table/tbody/tr[7]/td/input")).click(); 		
  		
        //Confirmacao
        navegador.findElement(By.xpath("//*[@id=\"mainContent\"]/table/tbody/tr[2]/td/center/table/tbody/tr[3]/td/a/img")).click();
        
	
		 System.out.println("Alterado com Sucesso");
		
 			
  		}else {
  		System.out.println("Ja tranferido ");
  		 QMassaAlterar ++;
  		}
        
	}
	

}
