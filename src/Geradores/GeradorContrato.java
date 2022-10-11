package Geradores;

import java.util.Random;

/**
 *
 * @author Henrique
 */
public class GeradorContrato {
    public String geraContrato() throws Exception{

     String numeroGerado = "0000";
     Random numeroAleatorio = new Random();
      //numeros gerados
     int n1 = numeroAleatorio.nextInt(9);
     int n2 = numeroAleatorio.nextInt(9);
     int n3 = numeroAleatorio.nextInt(9); 
     int n4 = numeroAleatorio.nextInt(9); 
     int n5 = numeroAleatorio.nextInt(9);
     int n6 = numeroAleatorio.nextInt(9);
     int n7 = numeroAleatorio.nextInt(9); 
     int n8 = numeroAleatorio.nextInt(9);
        
      numeroGerado = numeroGerado +(Integer.toString(n1)+Integer.toString(n2)+Integer.toString(n3)+Integer.toString(n4)+
                                    Integer.toString(n5)+Integer.toString(n6)+Integer.toString(n7)+Integer.toString(n8));
      
      System.out.println("Contrato Gerado " + numeroGerado);
      return numeroGerado;
    }//fim do metodo geraCPF
    public String mostraResultado() throws Exception{
     String resultadoContrato = geraContrato();
     return resultadoContrato;
    }
}//fim da classe
