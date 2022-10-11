package QueryS;

import MassaWa.Automacao_WA;
import Pacote_Principal.Transfers;
import conexao.conectarWA;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Henrique
 */
public class Validar_cd_FASE {
    public Integer gerarCDFASE() throws Exception{
         Transfers dados = new Transfers();
       String pesq = Automacao_WA.validarCDFASE;
    //  String pesq ="119754377";
       String  query;
       int numeroGerado= 0 ;
 
     System.out.println("pesq cd fase: |"+ pesq+"|");
     
    query =           
  "       Select t.NU_MSISDN, t.SQ_TRANSACAO, t.NU_IMEI, t.nu_iccid, t.cd_fase,f.DS_FASE as DES_CD_FASE, t.cd_erro_api "+
  "       from transacao t, fase_processamento f                                                                       "+
  "       where t.CD_FASE = f.CD_FASE                                                                                  "+
  "       and t.sq_transacao in ('"+pesq+"')                                                                           ";

  
    
      //  conectarWA conectorWA = new conectarWA();
        Connection con = dados.getConexaoBancoWA();
        
        Statement pst = con.createStatement();
       
        
 do{       
        
        ResultSet RS = pst.executeQuery(query);

           while(RS.next()){
            numeroGerado = (RS.getInt("CD_FASE"));}
           
        if (numeroGerado == 3){System.out.println("Codigo de Autorização: " + numeroGerado);break;}       
       
}while(numeroGerado == 0 || numeroGerado == 1);
     System.out.println("Codigo de Autorização: " + numeroGerado);    
      return numeroGerado;
    }//fim do metodo geraCPF
   
}//fim da classe
