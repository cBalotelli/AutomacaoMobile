package Geradores;

import java.util.Random;

/**
 *
 * @author Henrique
 */
public class GeradorRg {
    public String gerarRg() throws Exception{
     String  nDigResult;
     String numerosContatenados;
     String numeroGerado;
     Random numeroAleatorio = new Random();
      //numeros gerados
     int n1 = numeroAleatorio.nextInt(10);
     int n2 = numeroAleatorio.nextInt(10);
     int n3 = numeroAleatorio.nextInt(10);
     int n4 = numeroAleatorio.nextInt(10);
     int n5 = numeroAleatorio.nextInt(10);
     int n6 = numeroAleatorio.nextInt(10);
     int n7 = numeroAleatorio.nextInt(10);
     int n8 = numeroAleatorio.nextInt(10);
     int n9 = numeroAleatorio.nextInt(10);
      //Conctenando os numeros
     numerosContatenados = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3)  + String.valueOf(n4) +
                           String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) +String.valueOf(n8)  +
                           String.valueOf(n9);
     numeroGerado = numerosContatenados;
   
     System.out.println("RG Gerado " + numeroGerado);
       return numeroGerado;
    }
    public String mostraResultado() throws Exception{
     String resultadoRG = gerarRg();
     return resultadoRG;
    }
}
