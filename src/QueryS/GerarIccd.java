package QueryS;

import MassaMobile.Assinante;
import Pacote_Principal.Transfers;
import conexao.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */
public class GerarIccd {
    public String geraiccd() throws Exception{  
        
         Transfers dados = new Transfers();
        
        String compare = Assinante.iccdCompare;
        String compare1 = Assinante.iccdCompare1;
        String compare2 = Assinante.iccdCompare2;
        String compare3 = Assinante.iccdCompare3;
        String compare4 = Assinante.iccdCompare4;
        String compare5 = Assinante.iccdCompare5;
        String compare6 = Assinante.iccdCompare6;
        String compare7 = Assinante.iccdCompare7;
        String compare8 = Assinante.iccdCompare8;
        String compare9 = Assinante.iccdCompare9;
        String compare10 = Assinante.iccdCompare10;

     String  query;
     String numeroGerado="";
     String dd = Transfers.getDdd();
    
   
     query =    

 "              SELECT a.rp_package_value AS ICCID,                                              "+
"              c.rrs_resource_value AS IMSI,                                                     "+
"              (                                                                                 "+
"              CASE                                                                              "+
"              WHEN (SUBSTR (c.rrs_resource_value, 6, 1) = SUBSTR (a.rp_package_value, 9, 1))    "+
"              AND (SUBSTR (c.rrs_resource_value, 6, 2) <> '00')                                 "+
"              THEN 'Valid'                                                                      "+
"              ELSE 'Invalid'                                                                    "+
"              END ) AS IMSI_CHECK ,                                                             "+
"              rrs_resource_sts Status, rp_package_sts                                           "+
"              FROM mtaappc.rm_packages a,                                                       "+
"              mtaappc.rm_package_content b,                                                     "+
"              mtaappc.rm_resource_stock c                                                       "+
"              WHERE                                                                             "+
"                  a.rp_package_value <> '"+compare+"'                                           "+ 
"              and a.rp_package_value <> '"+compare1+"'                                          "+  
"              and a.rp_package_value <> '"+compare2+"'                                          "+ 
"              and a.rp_package_value <> '"+compare3+"'                                          "+ 
"              and a.rp_package_value <> '"+compare4+"'                                          "+ 
"              and a.rp_package_value <> '"+compare5+"'                                          "+ 
"              and a.rp_package_value <> '"+compare6+"'                                          "+  
"              and a.rp_package_value <> '"+compare7+"'                                          "+ 
"              and a.rp_package_value <> '"+compare8+"'                                          "+ 
"              and a.rp_package_value <> '"+compare9+"'                                          "+ 
"              and a.rp_package_value <> '"+compare10+"'                                         "+ 
"               and a.rp_package_value IN                                                        "+
"              (SELECT RRS_RESOURCE_VALUE                                                        "+
"              FROM mtaappc.rm_resource_stock c                                                  "+
"              WHERE c.rrs_resource_tp_id = 6                                                    "+
"              AND SUBSTR (RRS_RESOURCE_VALUE, 9,2) = '"+dd+"'                                   "+
"              AND c.rrs_resource_sts = 'ASSIGNED'                                               "+
"              )                                                                                 "+
"              AND a.rp_package_id = b.rpc_package_id                                            "+
"              AND c.rrs_resource_sts = a.rp_package_sts                                         "+
"              AND b.rpc_component_tp_id = 5                                                     "+
"              AND b.rpc_component_vl_id = c.rrs_id                                              "+
"              ORDER BY a.sys_creation_date, SUBSTR (RRS_RESOURCE_VALUE, 9, 2)DESC               ";

 
  
     
       Connection con = dados.getConexaoBanco();
        
        
        
        Statement pst=con.createStatement();
        ResultSet RS = pst.executeQuery(query);

        while(RS.next()){
           
            numeroGerado = (RS.getString("ICCID"));
            
        }

      System.out.println("Iccd Gerado: " + numeroGerado);
      return numeroGerado;
    }//fim do metodo geraCPF
   
}//fim da classe
