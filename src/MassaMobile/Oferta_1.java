package MassaMobile;

import Pacote_Principal.Transfers;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import Impressao.PrintTela;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Oferta_1 {
    
    Transfers dados = new Transfers();
    PrintTela print = new PrintTela();
    
public boolean oferta(boolean sucesso,WebDriver navegador) throws IOException {
	 int contadorImgOrg = 0,  erroOferta = 1,semGrupos=0 ,contadorImagem = Transfers.getContadorImagem(),loopValidador =0,ContadorErro= 0;
         boolean ofertaAtiva = Tela_Mobile.ativaOfertaContrato;
	 String TipoCliente="", Tcontrato,tituloOferta, planoOferta, planoDefault , nomePlano,boxOferta;
	 TipoCliente = Tela_Mobile.T_Cliente;
	 Tcontrato = Tela_Mobile.Tcontrato;
	 tituloOferta = SelecaoOferta.TxpathTitulo;
	 planoOferta = SelecaoOferta.Txpathplano;	
	 nomePlano= SelecaoOferta.TipoOfertaTexto;
	 boxOferta = SelecaoOferta.boxSelect;
         navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(navegador, 6);
         
         
         
     //alterando a janela para "UNIDADE ORG."
     List<WebElement> auxiliarConta2 = navegador.findElements(By.tagName("img"));
     for (WebElement titleImg2 : auxiliarConta2) { contadorImgOrg++;
         if (contadorImgOrg == 7) { titleImg2.click(); }  }//fechamento do FOr     
     
//  while (loopValidador == 0) {
//            try {   
                
     if(Tcontrato.equals("ATIVO")) {
    	Tcontrato = "ATIVO";
         
       
         
     WebElement btnConfirmarOK = navegador.findElement(By.id("OUT1t"));
     btnConfirmarOK.click();
     
                                  //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     
     navegador.findElement(By.id("OUT1s")).findElement(By.linkText("Adicionar Novo Contrato")).click();
     contadorImgOrg =0;
     //Listando a primeira tela Informa��es de CONTRATO
     List<WebElement> auxiliarConta1 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
     for (WebElement titleImg1 : auxiliarConta1) {contadorImgOrg++;      
         if (contadorImgOrg == 2) {
                                          //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
             titleImg1.click();  }}//fechamento do FOr  

     int  n = 0, x=0;
     List<WebElement> auxiliarConta= null;
    contadorImgOrg = 0; 
    
    
     while(n < 4 ) {
         n++;     
         auxiliarConta = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
         for (WebElement titleImg : auxiliarConta) { contadorImgOrg++;        
             if (contadorImgOrg == 3) {x++;                                                       //payDescription
                 if (x == 3) {navegador.findElement(By.name("userTextArea")).sendKeys("Novo Contrato");}  // Inserindo o nome na Descricao                
                                            //Print da Tela 
                 if(x == 2 || x == 4){
                    if(Transfers.getPrintAll() == 1){
                   print.printTelaScroll(navegador); 
                    }
                 }else{
                     if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
                 }
                 titleImg.click(); }// fechamento do If  
         }//fechamento do FOr
         auxiliarConta = null;
         contadorImgOrg = 0;  
     }// while

         
     System.out.println("Contrato Criado com Sucesso");
     
       Tcontrato = "ATIVO";
      }  //Se nao tiver Habilitado o contrato segue daqui para baixo
     
 
    

     
     //QUEBRANDO O NIVEL DE CLIENTE CONTROLE
     //CONTROLE N�O POSSUI OFERTA E CONTRATO
     
      if(ofertaAtiva == true) {
 	 
                                   //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }    
          
     //Selecionando o numero do Contrato
     navegador.findElement(By.className("tableText")).click();

                                  //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     //Selecionando Oferta
     navegador.findElement(By.linkText("Ofertas")).click();
     
                                  //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     // Adicionando Oferta
     navegador.findElement(By.linkText("Adicionar Oferta")).click();

     //INDIVIDUAL
     //COMERCIAL
     //GOVERNO

     if(Transfers.getOfertaContrato() == "S") {  
     //Selecionando  plano por default           
     navegador.findElement(By.xpath(tituloOferta)).click();
     navegador.findElement(By.xpath(planoOferta)).click();
         
                                  //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     
     }else {
         contadorImgOrg=0;
          System.out.println("Nome do Plano: "+nomePlano);
             List<WebElement> ofertafiltro = navegador.findElements(By.tagName("img"));contadorImgOrg = 0;                   
             for (WebElement titleC : ofertafiltro) { contadorImgOrg++; if (contadorImgOrg == 29) { titleC.click();  } }//Pegando  o filtro 
             navegador.findElement(By.name("filterValue")).sendKeys(nomePlano);         
             navegador.findElement(By.xpath("//*[@id=\"filterRow\"]/td/img")).click();       
             List<WebElement> ofertabusca2 = navegador.findElements(By.tagName("img"));contadorImgOrg = 0;                   
             for (WebElement titleB : ofertabusca2) { contadorImgOrg++; if (contadorImgOrg == 40) { titleB.click();  } }//Pegando   seta de busca   
             List<WebElement> ofertabusca3 = navegador.findElements(By.className("tableText"));contadorImgOrg = 0;   
             for (WebElement titleB2 : ofertabusca3) { contadorImgOrg++; if (contadorImgOrg == 2) { titleB2.click();  } }//Pegando   seta de busca             
    
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               } 
     }
     
     //Botao PROXIMO dentro da lista de oferta
      navegador.findElement(By.name("imageField")).click();
       
      
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               } 
      
      
       //Seleciando o botao confirma a oferta 
      //verificando a tela de plano  inclusos dentro da oferta
        contadorImgOrg = 0; String titulo="";
        
        
       
        List<WebElement> auxiliarInput = navegador.findElements(By.className("fieldTitle"));      
      for (WebElement titleImg3 : auxiliarInput) { contadorImgOrg++;    
      if (contadorImgOrg == 1) { titulo = titleImg3.getText();titulo = titleImg3.getText(); semGrupos = 1; }   }//fechamento do FOr    
      
      System.out.println("Titulo " + titulo);
     
            if (semGrupos == 1) {contadorImgOrg =0;         	
        	 List<WebElement> auxiliarSetar = navegador.findElements(By.name("imageField"));       	
             for (WebElement titleInput : auxiliarSetar) {contadorImgOrg++;          
            	 if (contadorImgOrg == 2 ) { 
                       //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
                     titleInput.click(); } }         		            	   	
             System.out.println("Entro no if grupo igual a 1");
            
      }//else {
    	  System.out.println("Grupos Zerados de planos dentro da oferta");
               
           if (Transfers.getPlanoPreSelecionado() == 8 || Transfers.getPlanoPreSelecionado() == 9 ){
              
         //tarifa embratel 29   
       if ( Transfers.getPlanoPreSelecionado() == 8){//2gb
       WebElement embratel_29 = wait.until(ExpectedConditions.elementToBeClickable(By.name("cpp414279549rel380466132")));  
       embratel_29.click();  }
         
       if ( Transfers.getPlanoPreSelecionado() == 9){// 4gb
       WebElement embratel_29 = wait.until(ExpectedConditions.elementToBeClickable(By.name("cpp414279564rel380466132")));  
       embratel_29.click();  }
     
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
            
       //botao proximo           
       WebElement proximo = wait.until(ExpectedConditions.elementToBeClickable(By.name("imageField")));  
       proximo.click();
       
          }    
                            //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               } 
     
        
//    		  if (titulo != "") {
//     contadorImgOrg = 0;
//     List<WebElement> auxiliarOferta3 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
//     for (WebElement titleImg3 : auxiliarOferta3) {  contadorImgOrg++;	
//        if (contadorImgOrg == 3) {titleImg3.click();} }//fechamento do FOr      	  
//                  }
     
                //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }        
                  
     //Seleciando o botao SALVAR de 3 botao azul 
     if (Transfers.getPlanoPreSelecionado() < 8 ){
     contadorImgOrg = 0;
     List<WebElement> auxiliarOferta4 = navegador.findElement(By.className("bgButtons")).findElements(By.tagName("img"));
     for (WebElement titleImg3 : auxiliarOferta4) { 
    	 contadorImgOrg++;
         if (contadorImgOrg == 3) {
                                          //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
             
             titleImg3.click();} }//fechamento do FOr   
     }
 
     //Botao de confirma��o de oferta 
      contadorImgOrg = 0;
     List<WebElement> ofertaC1 = navegador.findElements(By.name("imageField"));             
     for (WebElement titleC1 : ofertaC1) {contadorImgOrg++;  	 
        if (contadorImgOrg == 2) { 
                       //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
            
            titleC1.click();} }//fechamento do FOr        	     
     
   // inserindo dados no memorando
     navegador.findElement((By.name("userTextArea"))).sendKeys("Nova Oferta");

               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
     
     //botao de confirma��o de oferta do Memorando
     contadorImgOrg = 0;
     List<WebElement> auxiliarOferta5 = navegador.findElements(By.name("imageField"));
     for (WebElement titleImg4 : auxiliarOferta5) { contadorImgOrg++;
     
         if (contadorImgOrg == 3) {
             titleImg4.click();  } }//fechamento do FOr
     
      erroOferta = 0;
      
               //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
  
      
     //Confirmando o Window Confirm
     Alert alert = navegador.switchTo().alert();
     alert.accept();
     
//     Thread.sleep(900);
              //Print da Tela 
               if(Transfers.getPrintAll() == 1){
                   print.printTela(navegador);
               }
             
     }//fechamento do if para cliente controle
      
      
//    	 }catch(Exception e){
//    		 System.out.println("Erro na ExecuCao da Oferta! Iniciando novamente");      
//               String nome = null; int resposta;
//    		              		   
//    		   	 try {	   		 
// 	    	      
// 	    	        wait.until(ExpectedConditions.alertIsPresent());
// 	    	        Alert alert = navegador.switchTo().alert();  	       
// 	    	        alert.accept(); } catch (Exception e1) {  }
// 	    	   	      
//             if( erroOferta == 1) {            	 
//            	 
//         	// resposta = JOptionPane.showConfirmDialog(null, "Ocorreu um Erro ao inserir esta oferta \n   Insira uma nova Oferta ");
//    		
//                   int respostaa = JOptionPane.showConfirmDialog(null, "Ocorreu um Erro ao inserir esta oferta! \n   Insira uma nova Oferta ",
//                "Mensagem", JOptionPane.YES_NO_OPTION);
//                 
//                 
//                 if (respostaa == 1) {
//          			  navegador.close();
//                                  
//    		 }else{
//                           // 		verifica se o usu�rio clicou no bot�o YES
// 				try {
//					Runtime.getRuntime().exec("cmd /C  "
//					                    		+"C:\\Automacao_Mobile\\Ofertas_offline\\Oferta_simples.html");
//				} catch (IOException e1) {e1.printStackTrace();}
//                   			
//   		 
//             nome = JOptionPane.showInputDialog("Insira uma nova Oferta! ");
//        	 nomePlano = nome;
//    		 SelecaoOferta.TipoOfertaTexto = nome;                   
//             } }//verificacao da mensagem de nao encontrado
//              
// 		 		    //Voltando para tela inicial da oferta
//    		        List<WebElement> auxiliarErro = navegador.findElements(By.tagName("img"));
//    		        contadorImgOrg = 0;
//    		        for (WebElement titleErro : auxiliarErro) { contadorImgOrg++;if (contadorImgOrg == 7) {titleErro.click(); }}   		 
//    		                       //iniciando novamente o nome ds imagem
//                       Transfers.setContadorImagem(contadorImagem);
//                        continue;
//    			}   
   
//      } catch (Exception e) {
//                System.out.println("Erro na Execucao da Oferta! Iniciando novamente");
//
//                             ContadorErro++;
//           
//                if(ContadorErro == 15){
//                    ContadorErro = 0;  
//                    sucesso = false;
//                    return sucesso;
//                       
//     }
//
//        }
//            loopValidador = 1;
            sucesso =true;
//  }
//    	 
//     while do lopping   
     return sucesso;
}

}
