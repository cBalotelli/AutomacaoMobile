package QueryS;

import MassaMobile.Assinante;
import static Otc.Otc.somaOtc;
import conexao.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Henrique
 */
public class GerarOtc {

    public Boolean GerarOtc(ArrayList<String> ListaOtc, String data, String valorOtc) {
  
   // public String geraiccd() throws Exception{

    //   String iccCompare = Assinante.iccdCompare,iccCompareAux = null;
    
     ArrayList<String> ListaOtcSql = new ArrayList<String> ();
     ListaOtcSql = ListaOtc;
     Boolean numeroGerado=false;
     String  msisdn = "";
     int cont = ListaOtc.size();
     System.out.println("Msisdn a ser executado "+ cont);
     
      for (int i=0; i<= cont; i++ ){
    
         
          
 //       msisdn = ListaOtcSql.get(i);
     System.out.println("OTC numero get ." + i);
 //       System.out.println("OTC msisdn." + msisdn);
   
        String query = 
                
                
   
"             alter session set current_schema =mtaappc;                                                                                                                                "+
"                                                                                                                                                                                       "+
"             Declare                                                                                                                                                                   "+
"                    msisdn_in           NUMBER := 11932260054;                                                                                                                         "+
"                    otc_value_in        NUMBER := 89.99;                                                                                                                               "+
"                    activity_date_in    DATE := to_date( '20181219', 'YYYYMMDD' );                                                                                                     "+
"                    charge_code_in      VARCHAR2(15) := 'CONTROLEOTC';                                                                                                                 "+
"                    act_rsn_code_in     VARCHAR2(15) := 'CRCRP';                                                                                                                       "+
"                    fee_in              NUMBER := 0;                                                                                                                                   "+
"                    operator_id_in      NUMBER := 12019375;                                                                                                                            "+
"                    trx_seq_no_out      NUMBER;                                                                                                                                        "+
"                    var_trx_seq_no      NUMBER;                                                                                                                                        "+
"                    var_subscriber_no   NUMBER;                                                                                                                                        "+
"                    var_customer_id     NUMBER;                                                                                                                                        "+
"                    var_ch_node_id      NUMBER;                                                                                                                                        "+
"                    var_ban             NUMBER;                                                                                                                                        "+
"                    var_ben             NUMBER;                                                                                                                                        "+
"                    var_pym_channel_no  NUMBER;                                                                                                                                        "+
"                    var_group_seq_no    NUMBER;                                                                                                                                        "+
"                    var_general_data    VARCHAR(4000);                                                                                                                                 "+
"                    var_header_data     VARCHAR(4000);                                                                                                                                 "+
"                    var_effec_date_str  VARCHAR2(14);                                                                                                                                  "+
"                    var_estado_ban      VARCHAR2(20);                                                                                                                                  "+
"                    var_compania_ban    VARCHAR2(20);                                                                                                                                  "+
"                    var_issue_date      DATE;                                                                                                                                          "+
"                    var_issue_date_str  VARCHAR2(14);                                                                                                                                  "+
"                    var_otc_value_str   VARCHAR2(20);                                                                                                                                  "+
"                    var_offer           VARCHAR2(15);                                                                                                                                  "+
"                    var_actv_code       VARCHAR2(5);                                                                                                                                   "+
"                    var_ent_seq_no      NUMBER(9);                                                                                                                                     "+
"                    var_qtde_ent        NUMBER;                                                                                                                                        "+
"                    var_mes_impl        NUMBER(1);                                                                                                                                     "+
"                    var_change_cycle    NUMBER(1);                                                                                                                                     "+
"             BEGIN                                                                                                                                                                     "+
"                                                                                                                                                                                       "+
"                  SELECT logical_date                                                                                                                                                  "+
"                    INTO var_issue_date                                                                                                                                                "+
"                    FROM logical_date                                                                                                                                                  "+
"                   WHERE logical_date_type = 'O';                                                                                                                                      "+
"                                                                                                                                                                                       "+
"                   var_mes_impl := 1;                                                                                                                                                  "+
"                   var_change_cycle := 1;                                                                                                                                              "+
"                                                                                                                                                                                       "+
"                   IF var_mes_impl = 1 or var_change_cycle = 1 THEN                                                                                                                    "+
"                              SELECT s.subscriber_no  , s.customer_id  , s.ch_node_id  , p.ban  , p.ben  , p.pym_channel_no  , market_company  , state         , e.soc                 "+
"                                INTO var_subscriber_no, var_customer_id, var_ch_node_id, var_ban, var_ben, var_pym_channel_no, var_compania_ban, var_estado_ban, var_offer             "+
"                                FROM subscriber          s,                                                                                                                            "+
"                                     event_distribute    e,                                                                                                                            "+
"                                     csm_pay_channel     p,                                                                                                                            "+
"                                     csm_additional_data a                                                                                                                             "+
"                               WHERE s.prim_resource_val = msisdn_in                                                                                                                   "+
"                                 AND e.agreement_no = s.subscriber_no                                                                                                                  "+
"                                 AND e.expiration_date > sysdate                                                                                                                       "+
"                                 AND p.pym_channel_no = e.target_pcn                                                                                                                   "+
"                                 AND a.fields_level = 'A'                                                                                                                              "+
"                                 AND a.customer_id = s.customer_id                                                                                                                     "+
"                                 AND a.account_id = p.ban;                                                                                                                             "+
"                                                                                                                                                                                       "+
"                              SELECT transaction_log_1sq.NEXTVAL                                                                                                                       "+
"                                INTO var_trx_seq_no                                                                                                                                    "+
"                                FROM DUAL                                                                                                                                              "+
"                                                                                                                                                                                       "+
"                              SELECT csm_trx_1sq.NEXTVAL                                                                                                                               "+
"                                INTO var_group_seq_no                                                                                                                                  "+
"                                FROM DUAL                                                                                                                                              "+
"                                                                                                                                                                                       "+
"                                                                                                                                                                                       "+
"                              var_effec_date_str := to_char(activity_date_in ,'yyyymmdd') || '000000';                                                                                 "+
"                              var_issue_date_str := to_char(var_issue_date   ,'yyyymmdd') || '000000';                                                                                 "+
"                              var_otc_value_str  := to_char(trunc(otc_value_in * 100));                                                                                                "+
"                                                                                                                                                                                       "+
"                              IF otc_value_in > 0 THEN                                                                                                                                 "+
"                                 var_actv_code := 'CHG';                                                                                                                               "+
"                                                                                                                                                                                       "+
"                                 var_general_data   := 'actv_code=' || var_actv_code || ';get_amount_ind=N;chg_creation_date='                                                         "+
"                                                    || var_effec_date_str || ';effective_date=' || var_effec_date_str                                                                  "+
"                                                    || '; charge_code=' || charge_code_in || '; get_offer_ind=Y;offer='                                                                "+
"                                                    || var_offer || ';payment_category=POST;market_code=MTA;bl_ignore_ind=N;charge_level=C;waiving_ind=;actv_amt='                     "+
"                                                    || var_otc_value_str ||';ba_number=1;pcn_number=1;crg_revenue_code=;geo_zone='                                                     "+
"                                                    || var_estado_ban || ';company_code=' || var_compania_ban || ';gross_amt_ind=N;';                                                  "+
"                                                                                                                                                                                       "+
"                                 var_header_data    := 'source_component=CSM;target_component=BILL;rqust_notfy_cd=R;actv_code=' || var_actv_code || ';actv_rsn_code='                  "+
"                                                    || act_rsn_code_in ||';transaction_level=S;customer_id='                                                                           "+
"                                                    || var_customer_id || ';ban=' || var_ban || ';ben=' || var_ben                                                                     "+
"                                                    || ';subscriber_seq_no=' || var_subscriber_no || ';primary_resource='                                                              "+
"                                                    ||  msisdn_in || ';payment_channel=' || var_pym_channel_no                                                                         "+
"                                                    || ';node_id=' || var_ch_node_id || ';issue_date=' || var_issue_date_str                                                           "+
"                                                    || ';effective_date=' || var_effec_date_str || ';group_trx_seq_no=' || var_group_seq_no                                            "+
"                                                    || ';rel_trx_seq_no=0;day_partition=9;trx_seq_no='                                                                                 "+
"                                                    || var_trx_seq_no || ';';                                                                                                          "+
"                                                                                                                                                                                       "+
"                              ELSE                                                                                                                                                     "+
"                                 var_actv_code := 'CRDT';                                                                                                                              "+
"                                                                                                                                                                                       "+
"                                 SELECT MAX(ent_seq_no) AS ent_seq_no                                                                                                                  "+
"                                   INTO var_ent_seq_no                                                                                                                                 "+
"                                   FROM charge                                                                                                                                         "+
"                                  WHERE ban = var_ban                                                                                                                                  "+
"                                    AND actv_bill_seq_no = 0                                                                                                                           "+
"                                    AND actv_code = 'CHG'                                                                                                                              "+
"                                    AND charge_code = charge_code_in;                                                                                                                  "+
"                                                                                                                                                                                       "+
"                                 SELECT SUM(1) AS qtde                                                                                                                                 "+
"                                   INTO var_qtde_ent                                                                                                                                   "+
"                                   FROM charge                                                                                                                                         "+
"                                  WHERE ban = var_ban                                                                                                                                  "+
"                                    AND actv_bill_seq_no = 0                                                                                                                           "+
"                                    AND charge_code = charge_code_in                                                                                                                   "+
"                                    AND ent_seq_no = var_ent_seq_no;                                                                                                                   "+
"                                                                                                                                                                                       "+
"                                 IF (var_qtde_ent = 1) THEN                                                                                                                            "+
"                                    var_general_data   := 'actv_code=' || var_actv_code || ';get_amount_ind=N;chg_creation_date='                                                      "+
"                                            || var_effec_date_str || ';effective_date=' || var_effec_date_str                                                                          "+
"                                            || '; charge_code=' || charge_code_in || '; get_offer_ind=Y;offer='                                                                        "+
"                                            || var_offer || ';payment_category=POST;market_code=MTA;bl_ignore_ind=N;charge_level=C;waiving_ind=;actv_amt='                             "+
"                                            || var_otc_value_str ||';ba_number=1;pcn_number=1;crg_revenue_code=;geo_zone='                                                             "+
"                                            || var_estado_ban || ';company_code=' || var_compania_ban || ';gross_amt_ind=N;ent_seq_no=' || var_ent_seq_no || ';';                      "+
"                                                                                                                                                                                       "+
"                                    var_header_data    := 'source_component=CSM;target_component=BILL;rqust_notfy_cd=R;actv_code=' || var_actv_code || ';actv_rsn_code='               "+
"                                            || act_rsn_code_in ||';transaction_level=S;customer_id='                                                                                   "+
"                                            || var_customer_id || ';ban=' || var_ban || ';ben=' || var_ben                                                                             "+
"                                            || ';subscriber_seq_no=' || var_subscriber_no || ';primary_resource='                                                                      "+
"                                            ||  msisdn_in || ';payment_channel=' || var_pym_channel_no                                                                                 "+
"                                            || ';node_id=' || var_ch_node_id || ';issue_date=' || var_issue_date_str                                                                   "+
"                                            || ';effective_date=' || var_effec_date_str || ';group_trx_seq_no=' || var_group_seq_no                                                    "+
"                                            || ';rel_trx_seq_no=0;day_partition=9;trx_seq_no='                                                                                         "+
"                                            || var_trx_seq_no || ';';                                                                                                                  "+
"                                 ELSE                                                                                                                                                  "+
"                                      raise_application_error(-20020, 'Assinante já possui uma cobrança e desconto com ent_seq_no:' || var_ent_seq_no || '.');                         "+
"                                 END IF;                                                                                                                                               "+
"                                                                                                                                                                                       "+
"                              END IF;                                                                                                                                                  "+
"                                                                                                                                                                                       "+
"                              INSERT INTO transaction_log                                                                                                                              "+
"                                     (trx_seq_no       , sys_creation_date, sys_update_date   , operator_id     ,                                                                      "+
"                                      application_id   , dl_service_code  , dl_update_stamp   , source_component,                                                                      "+
"                                      target_component , rqust_notfy_cd   , actv_code         , actv_rsn_code   ,                                                                      "+
"                                      transaction_level, customer_id      , ban               , ben             ,                                                                      "+
"                                      subscriber_seq_no, primary_resource , payment_channel   , node_id         ,                                                                      "+
"                                      issue_date       , effective_date   , group_trx_seq_no  , rel_trx_seq_no  ,                                                                      "+
"                                      general_data     , day_partition    , header_data       )                                                                                        "+
"                              VALUES (var_trx_seq_no   , SYSDATE          , NULL              , operator_id_in  ,                                                                      "+
"                                      'OTCNGP'         , NULL             , NULL              , 'CSM'           ,                                                                      "+
"                                      'BILL'           , 'R'              , 'CRCRG'           , act_rsn_code_in ,                                                                      "+
"                                      'S'              , var_customer_id  , var_ban           , var_ben         ,                                                                      "+
"                                      var_subscriber_no, msisdn_in        , var_pym_channel_no, var_ch_node_id  ,                                                                      "+
"                                      var_issue_date   , activity_date_in , var_group_seq_no  , NULL            ,                                                                      "+
"                                      var_general_data , '9'              , var_header_data  );                                                                                        "+
"                                                                                                                                                                                       "+
"                              trx_seq_no_out := var_trx_seq_no;                                                                                                                        "+
"                              COMMIT;                                                                                                                                                  "+
"                  ELSE                                                                                                                                                                 "+
"                      trx_seq_no_out :=0;                                                                                                                                              "+
"                  END IF;                                                                                                                                                              "+
"                                                                                                                                                                                       "+
"             EXCEPTION                                                                                                                                                                 "+
"                  WHEN no_data_found THEN                                                                                                                                              "+
"                       raise_application_error(-20021, 'Durante a execucao da procedure ngp_inserir_otc nao foram localizadas informação para o MSISDN:' || msisdn_in || '.');         "+
"                  WHEN OTHERS THEN                                                                                                                                                     "+
"                       raise_application_error(-20022, 'Ocorreu um erro durante a execucao da procedure ngp_inserir_otc MSISDN:' || msisdn_in || '. ERRO: '||SQLERRM);                 "+
"             END;																	                         	";            
                
                
                
                

    try {
        conectar con = new conectar ();
         con.conexao();   
        
		//Statement ptm = con.createStatement();	
               Statement ptm = con.conexao().createStatement();
                ptm.executeQuery(query);
              
                    ptm.close();
            
            
		
                
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getErrorCode());
             
                
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
        System.out.println("OTC executado com sucesso." + i);
        
        
        } //for
        
        numeroGerado = true;
    
         return numeroGerado;
}

   
}//fim da classe
