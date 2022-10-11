/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryS;

import static MassaMobile.Assinante.iccdCompare;
import MassaMobile.Tela_Mobile;
import MassaWa.ClienteWA;
import Pacote_Principal.Transfers;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique.rodrigues
 */
public class PrimeiroIccd {           
 //Desparari ICCD para a primeira consulta
public void primeiroIccd(){
        System.out.println("Buscando o Primeiro Iccd pelo 'Void Run'");
        GerarIccd gerarIccd = new GerarIccd();
        try {
            String iccdAux= "";
            
            iccdAux = gerarIccd.geraiccd();
            
            iccdCompare = iccdAux;
            ClienteWA.IccdWA = iccdAux;
            
            
              Transfers.setIccdGeradoAntes(true);
        } catch (Exception ex) {
            System.out.println("Erro Em Busca o Primeiro Iccd");
            Logger.getLogger(Tela_Mobile.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
