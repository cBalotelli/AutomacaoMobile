package Geradores;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Henrique
 */
public class GeradorNomeMae {
    public String GerarNome() throws Exception{
        
        Random numeroAleatorio = new Random();
        int nomeAleatorio = numeroAleatorio.nextInt(50);	         
             
        String nome="";
        
     	    
	 	          // Nomes de mae
	 	          ArrayList<String> nomesMae100 = new ArrayList<String> ();
	 	          nomesMae100.add("Alice");nomesMae100.add("Sophia");nomesMae100.add("Helena");nomesMae100.add("Valentina");nomesMae100.add("Laura");nomesMae100.add("Isabella");nomesMae100.add("Manuela");nomesMae100.add("Julia");nomesMae100.add("Heloisa");nomesMae100.add("Luiza");nomesMae100.add("Maria Luiza");nomesMae100.add("Lorena");nomesMae100.add("Livia");
	 	          nomesMae100.add("Giovanna");nomesMae100.add("Maria Eduarda");nomesMae100.add("Beatriz");nomesMae100.add("Maria Clara");nomesMae100.add("Cecilia");nomesMae100.add("Eloa");nomesMae100.add("Lara");nomesMae100.add("Maria Julia");nomesMae100.add("Isadora");nomesMae100.add("Mariana");nomesMae100.add("Emanuelly");nomesMae100.add("Ana Julia");nomesMae100.add("Ana Luiza");nomesMae100.add("Ana Clara");nomesMae100.add("Melissa");nomesMae100.add("Yasmin");nomesMae100.add("Maria Alice");
	 	          nomesMae100.add("Isabelly");nomesMae100.add("Lavinia");nomesMae100.add("Esther");nomesMae100.add("Sarah");nomesMae100.add("Elisa");nomesMae100.add("Antonella");nomesMae100.add("Rafaela");nomesMae100.add("Maria Cecilia");nomesMae100.add("Liz");nomesMae100.add("Marina");nomesMae100.add("Nicole");nomesMae100.add("Maite");nomesMae100.add("Isis");nomesMae100.add("Alicia");nomesMae100.add("Luna");nomesMae100.add("Rebeca");nomesMae100.add("Agatha");
	 	          nomesMae100.add("Leticia");nomesMae100.add("Maria");nomesMae100.add("Gabriela");nomesMae100.add("Ana Laura");nomesMae100.add("Catarina");nomesMae100.add("Clara");nomesMae100.add("Ana Beatriz");nomesMae100.add("Vitoria");nomesMae100.add("Olivia");nomesMae100.add("Maria Fernanda");nomesMae100.add("Emilly");nomesMae100.add("Maria Valentina");nomesMae100.add("Milena");nomesMae100.add("Maria Helena");nomesMae100.add("Bianca");nomesMae100.add("Larissa");
	 	          nomesMae100.add("Mirella");nomesMae100.add("Maria Flor");nomesMae100.add("Allana");nomesMae100.add("Ana Sophia");nomesMae100.add("Clarice");nomesMae100.add("Pietra");nomesMae100.add("Maria Vitoria");nomesMae100.add("Maya");nomesMae100.add("Lais");nomesMae100.add("Ayla");nomesMae100.add("Ana Livia");nomesMae100.add("Eduarda");nomesMae100.add("Mariah");nomesMae100.add("Stella");nomesMae100.add("Ana");nomesMae100.add("Gabrielly");nomesMae100.add("Sophie");
	 	          nomesMae100.add("Carolina");nomesMae100.add("Maria Laura");nomesMae100.add("Maria Heloisa");nomesMae100.add("Maria Sophia");nomesMae100.add("Fernanda");nomesMae100.add("Malu");nomesMae100.add("Analu");nomesMae100.add("Amanda");nomesMae100.add("Aurora");nomesMae100.add("Maria Isis");nomesMae100.add("Louise");nomesMae100.add("Heloise");nomesMae100.add("Ana Vitoria");nomesMae100.add("Ana Cecília");nomesMae100.add("Ana Liz");
	 	          nomesMae100.add("Joana");nomesMae100.add("Luana");nomesMae100.add("Antonia");nomesMae100.add("Isabel");nomesMae100.add("Bruna");
	       
        Thread.sleep(200);
        nome = nomesMae100.get(nomeAleatorio);     
        System.out.println("Nome Mae Gerado  "+ nome);  
      return nome;
      
    }//fim do metodo geraCPF
    public String mostraResultado() throws Exception{
     String nomemae = GerarNome();
     return nomemae;
    }
}//fim da classe
