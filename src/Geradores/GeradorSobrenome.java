package Geradores;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Henrique
 */
public class GeradorSobrenome {
    public String GerarNome() throws Exception{
        
        Random numeroAleatorio = new Random();
        int nomeAleatorio = numeroAleatorio.nextInt(100);	         
             
        String nome="";
        
     	          //lista de nomes
	         
	          ArrayList<String> Sobrenome100 = new ArrayList<String> ();
	          Sobrenome100.add("Muniz");Sobrenome100.add("Schumacher");Sobrenome100.add("Mazzaropi");Sobrenome100.add("Monteiro");Sobrenome100.add("Miller");Sobrenome100.add("Marques");
	          Sobrenome100.add("Moraes");Sobrenome100.add("Duarte");Sobrenome100.add("Vasconcelos");Sobrenome100.add("Montenegro");Sobrenome100.add("Fagundes");Sobrenome100.add("Trindade");
	          Sobrenome100.add("Vargas");Sobrenome100.add("Ferraz");Sobrenome100.add("Carvalho");Sobrenome100.add("Dolabella");Sobrenome100.add("Evelyn");Sobrenome100.add("Reymond");
	          Sobrenome100.add("Lins");Sobrenome100.add("Andrade");Sobrenome100.add("Boaventura");Sobrenome100.add("Barcellos");Sobrenome100.add("Dantas");
	          Sobrenome100.add("Oliveira");Sobrenome100.add("Carvalho");Sobrenome100.add("Vilela");Sobrenome100.add("Santana");Sobrenome100.add("Ribeiro");Sobrenome100.add("Barros");
	          Sobrenome100.add("Moscovis");Sobrenome100.add("Goncalves");Sobrenome100.add("Johnson");Sobrenome100.add("Castro");Sobrenome100.add("Assuncao");Sobrenome100.add("Kannenberg");
	          Sobrenome100.add("Torres");Sobrenome100.add("Gomes");Sobrenome100.add("Alves");Sobrenome100.add("Steves");Sobrenome100.add("Garcia");Sobrenome100.add("Moura");Sobrenome100.add("Albuquerque");
	          Sobrenome100.add("Antunes");Sobrenome100.add("Barcelos");Sobrenome100.add("Roriz");Sobrenome100.add("Ferrari");Sobrenome100.add("Castiel");Sobrenome100.add("Fischer");
	          Sobrenome100.add("Novaes");Sobrenome100.add("Gimenez");Sobrenome100.add("Schoemberger");Sobrenome100.add("Falabella");Sobrenome100.add("Martins");Sobrenome100.add("Drummond");
	          Sobrenome100.add("Figueiredo");Sobrenome100.add("Resende");Sobrenome100.add("Sampaio");Sobrenome100.add("Fernandes");Sobrenome100.add("Cavalcante");Sobrenome100.add("Arantes");Sobrenome100.add("Lombardi");Sobrenome100.add("Dieckmann");Sobrenome100.add("Goes");
	          Sobrenome100.add("Menezes");Sobrenome100.add("Ganzarolli");Sobrenome100.add("Guimaroes");Sobrenome100.add("Liberato");Sobrenome100.add("Alencar");Sobrenome100.add("Marinho");
	          Sobrenome100.add("Lambertini");Sobrenome100.add("Lafaiete");Sobrenome100.add("Sanches");Sobrenome100.add("Timberg");Sobrenome100.add("Bernardi");Sobrenome100.add("Werneck");
	          Sobrenome100.add("Schmotz");Sobrenome100.add("Annenberg");Sobrenome100.add("Campos");Sobrenome100.add("Medeiros");Sobrenome100.add("Lessa");Sobrenome100.add("Hickmann");
	          Sobrenome100.add("ontenelle");Sobrenome100.add("Bittencourt");Sobrenome100.add("Noronha");Sobrenome100.add("Abravanel");Sobrenome100.add("Sheherazade");Sobrenome100.add("Bastos");
	          Sobrenome100.add("Meneghel");Sobrenome100.add("Bonner");Sobrenome100.add("Riche");Sobrenome100.add("Chapelin");Sobrenome100.add("Rios");
	          Sobrenome100.add("Giecomo");Sobrenome100.add("Davila");Sobrenome100.add("Close");Sobrenome100.add("Bial");Sobrenome100.add("Maldonado");Sobrenome100.add("Bongiovanni");Sobrenome100.add("Vitti");Sobrenome100.add("Silverstone");
	          Sobrenome100.add("Agostinho");Sobrenome100.add("Aguiar");Sobrenome100.add("Albuquerque");Sobrenome100.add("Alegria");Sobrenome100.add("Alencastro");Sobrenome100.add("Almada");
	          Sobrenome100.add("Alves");Sobrenome100.add("Alvim");Sobrenome100.add("Amorim");Sobrenome100.add("Andrade");Sobrenome100.add("Antunes");Sobrenome100.add("Aparacio");
	          Sobrenome100.add("Apolinario");Sobrenome100.add("Araujo");Sobrenome100.add("Arruda");Sobrenome100.add("Assis");Sobrenome100.add("Assuncao");Sobrenome100.add("avila");	          
	            
        
        nome = Sobrenome100.get(nomeAleatorio);     
        System.out.println("Sobrenome Gerado: "+ nome);  
      return nome;
      
    }//fim do metodo geraCPF
    public String mostraResultado() throws Exception{
     String resultadosobrenome= GerarNome();
     return resultadosobrenome;
    }
}//fim da classe
