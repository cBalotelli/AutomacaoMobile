package Geradores;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Henrique
 */
public class GeradorNome {
    public String GerarNome() throws Exception{
        
        Random numeroAleatorio = new Random();
        int nomeAleatorio = numeroAleatorio.nextInt(120);	         
             
        String nome="";
        
     	   //lista de nomes
	 	          ArrayList<String> nomes100 = new ArrayList<String> ();
	 	          nomes100.add("Miguel");nomes100.add("Arthur");nomes100.add("Bernardo");nomes100.add("Heitor");nomes100.add("Davi");nomes100.add("Lorenzo");nomes100.add("Theo");nomes100.add("Pedro");nomes100.add("Gabriel");nomes100.add("Enzo");nomes100.add("Matheus");nomes100.add("Lucas");nomes100.add("Benjamin");nomes100.add("Nicolas");nomes100.add("Guilherme");nomes100.add("Rafael");nomes100.add("Joaquim");
	 	          nomes100.add("Samuel");nomes100.add("Enzo Gabriel");nomes100.add("Joao Miguel");nomes100.add("Henrique");nomes100.add("Gustavo");nomes100.add("Murilo");nomes100.add("Pedro Henrique");nomes100.add("Pietro");nomes100.add("Lucca");nomes100.add("Felipe");nomes100.add("Joao Pedro");nomes100.add("Isaac");nomes100.add("Benicio");nomes100.add("Daniel");nomes100.add("Anthony");
	 	          nomes100.add("Leonardo");nomes100.add("Davi Lucca");nomes100.add("Bryan");nomes100.add("Eduardo");nomes100.add("Joao Lucas");nomes100.add("Victor");nomes100.add("Joao");nomes100.add("Caua");nomes100.add("Antonio");nomes100.add("Vicente");nomes100.add("Caleb");nomes100.add("Gael");nomes100.add("Bento");nomes100.add("Caio");nomes100.add("Emanuel");nomes100.add("Vinicius");nomes100.add("Joao Guilherme");nomes100.add("Davi Lucas");
	 	          nomes100.add("Noah");nomes100.add("Joao Gabriel");nomes100.add("Joao Victor");nomes100.add("Luiz Miguel");nomes100.add("Francisco");nomes100.add("Kaique");nomes100.add("Otavio");nomes100.add("Augusto");nomes100.add("Levi");nomes100.add("Yuri");nomes100.add("Enrico");nomes100.add("Thiago");nomes100.add("Ian");nomes100.add("Victor Hugo");nomes100.add("Thomas");nomes100.add("Henry");
	 	          nomes100.add("Luiz Felipe");nomes100.add("Ryan");nomes100.add("Arthur Miguel");nomes100.add("Davi Luiz");nomes100.add("Nathan");nomes100.add("Pedro Lucas");nomes100.add("Davi Miguel");nomes100.add("Raul");nomes100.add("Pedro Miguel");nomes100.add("Luiz Henrique");nomes100.add("Luan");nomes100.add("Erick");nomes100.add("Martin");nomes100.add("Bruno");nomes100.add("Rodrigo"); nomes100.add("Luiz Gustavo");nomes100.add("Anthony Gabriel");
	 	          nomes100.add("Arthur Gabriel");nomes100.add("Breno");nomes100.add("Kaue");nomes100.add("Enzo Miguel");nomes100.add("Fernando");nomes100.add("Arthur Henrique");nomes100.add("Luiz Otavio");nomes100.add("Carlos Eduardo");nomes100.add("Tomas");nomes100.add("Lucas Gabriel");nomes100.add("Andre");nomes100.add("José");nomes100.add("Yago");nomes100.add("Danilo"); 
	 	          nomes100.add("Ruan");nomes100.add("Miguel Henrique");nomes100.add("Oliver");nomes100.add("Alice");nomes100.add("Sophia");nomes100.add("Helena");nomes100.add("Valentina");nomes100.add("Laura");nomes100.add("Isabella");nomes100.add("Manuela");nomes100.add("Julia");nomes100.add("Heloisa");nomes100.add("Luiza");nomes100.add("Maria Luiza");nomes100.add("Lorena");nomes100.add("Livia");
	 	          nomes100.add("Giovanna");nomes100.add("Maria Eduarda");nomes100.add("Beatriz");nomes100.add("Maria Clara");nomes100.add("Cecilia");nomes100.add("Eloa");nomes100.add("Lara");nomes100.add("Maria Julia");nomes100.add("Isadora");nomes100.add("Mariana");nomes100.add("Emanuelly");nomes100.add("Ana Julia");nomes100.add("Ana Luiza");nomes100.add("Ana Clara");nomes100.add("Melissa");nomes100.add("Yasmin");nomes100.add("Maria Alice");
	 	          nomes100.add("Isabelly");nomes100.add("Lavínia");nomes100.add("Esther");nomes100.add("Sarah");nomes100.add("Elisa");nomes100.add("Antonella");nomes100.add("Rafaela");nomes100.add("Maria Cecilia");nomes100.add("Liz");nomes100.add("Marina");nomes100.add("Nicole");nomes100.add("Maite");nomes100.add("Isis");nomes100.add("Alicia");nomes100.add("Luna");nomes100.add("Rebeca");nomes100.add("Agatha");
	 	          nomes100.add("Leticia");nomes100.add("Maria");nomes100.add("Gabriela");nomes100.add("Ana Laura");nomes100.add("Catarina");nomes100.add("Clara");nomes100.add("Ana Beatriz");nomes100.add("Vitoria");nomes100.add("Olivia");nomes100.add("Maria Fernanda");nomes100.add("Emilly");nomes100.add("Maria Valentina");nomes100.add("Milena");nomes100.add("Maria Helena");nomes100.add("Bianca");nomes100.add("Larissa");
	 	          nomes100.add("Mirella");nomes100.add("Maria Flor");nomes100.add("Allana");nomes100.add("Ana Sophia");nomes100.add("Clarice");nomes100.add("Pietra");nomes100.add("Maria Vitoria");nomes100.add("Maya");nomes100.add("Lais");nomes100.add("Ayla");nomes100.add("Ana Livia");nomes100.add("Eduarda");nomes100.add("Mariah");nomes100.add("Stella");nomes100.add("Ana");nomes100.add("Gabrielly");nomes100.add("Sophie");
	 	          nomes100.add("Carolina");nomes100.add("Maria Laura");nomes100.add("Maria Heloisa");nomes100.add("Maria Sophia");nomes100.add("Fernanda");nomes100.add("Malu");nomes100.add("Analu");nomes100.add("Amanda");nomes100.add("Aurora");nomes100.add("Maria Isis");nomes100.add("Louise");nomes100.add("Heloise");nomes100.add("Ana Vitoria");nomes100.add("Ana Cecilia");nomes100.add("Ana Liz");
	 	          nomes100.add("Joana");nomes100.add("Luana");nomes100.add("Antonia");nomes100.add("Isabel");nomes100.add("Bruna");
	 	     
        
        nome = nomes100.get(nomeAleatorio);     
        System.out.println("Nome Gerado "+ nome);  
      return nome;
      
    }//fim do metodo geraCPF
    public String mostraResultado() throws Exception{
     String resultadosnome= GerarNome();
     return resultadosnome;
    }
}//fim da classe
