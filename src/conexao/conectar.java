/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;
 
import Pacote_Principal.LoginBanco;
import Pacote_Principal.Transfers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author Henrique
 */
public class conectar {
    Connection con=null;
    public static boolean loginLiberado;  
    public Connection conexao() throws ClassNotFoundException{
      
        Transfers dados = new Transfers();
 //---alterando o  OptionPane
       //UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Myriad Pro", Font.PLAIN, 35))); 
        try {
            //carregar driver
         
           // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Driver JDBC � Fonte de Dados ODBC
                   // con=DriverManager.getConnection("jdbc:odbc:Academia");
                  // Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\henrique.rodrigues\\Documents\\NetBeansProjects\\Combat\\Academia.accdb");
         //   con=DriverManager.getConnection("jdbc:ucanaccess://C:\\System_Program\\BancoDados.accdb");
   
            
             DriverManager.registerDriver(new OracleDriver());
            Class.forName("oracle.jdbc.driver.OracleDriver");
         
              String usuario ="spread";
              String senha   ="spread_1896";  
              String host    = LoginBanco.host;
              String banco   = LoginBanco.banco;
              String porta   = LoginBanco.porta;
             
              
          // "jdbc:oracle:thin:@host:porta:nome do serviço", "usuário", "senha"); 
            //String url = "jdbc:oracle:thin:@Localhost:0209:t06mb11";
            
            String url = "jdbc:oracle:thin:@"+host+":"+porta+":"+banco+"";
            
            Connection conn = DriverManager.getConnection(url,usuario,senha);  
          
            con =conn;
            dados.setConexaoBanco(con);
            loginLiberado = true;
                   
                  System.out.println("conexao establecida");
            //JOptionPane.showMessageDialog(null,"conexao estabelecida");
        } catch (SQLException e){
            System.out.println("Erro de conexao");
         //   JOptionPane.showMessageDialog(null, " Erro de conexao \n"+e);
            
        }
        return con;
    }

    
}

  