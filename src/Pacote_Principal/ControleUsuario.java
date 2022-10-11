/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote_Principal;

/**
 *
 * @author erik.francisco
 */
public class  ControleUsuario {


    private static String User;   
    private static String Password;
    private static String Server;
    private static String Userbase;
    private static String PasswordBase;
    private static String ServerBase;
    private static String DataBase;
    private static final String StringUrl = "jdbc:oracle:thin:@";
    private static String Owner;
    //private static final String ExpirationDate="15022016";
    public static String ExpirationDate;

    public static String getExpirationDate() {
        return ExpirationDate;
    }
        
    public static String getStringUrl() {
    	String porta = getServerBase();
        
       
    	if(porta.contains("brux0040")) {
    	     porta = ":1521:";	    	
    	}else {
    		porta = ":0209:";
    	}
        return StringUrl +getServerBase()+ porta;
    }
    
    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String Password) {
        ControleUsuario.Password = Password;
    }

    public static String getServer() {
        return Server;
    }

    public static void setServer(String Server) {
        ControleUsuario.Server = Server;
    }

    public static String getUser() {
        return User;
    }

    public static void setUser(String User) {     
        ControleUsuario.User = User;
    }

    public static String getDataBase() {
        return DataBase;
    }

    public static void setDataBase(String DataBase) {
        ControleUsuario.DataBase = DataBase;
    }

    public static String getPasswordBase() {
        return PasswordBase;
    }

    public static void setPasswordBase(String PasswordBase) {
        ControleUsuario.PasswordBase = PasswordBase;
    }

    public static String getServerBase() {
        return ServerBase;
    }

    public static void setServerBase(String ServerBase) {
        ControleUsuario.ServerBase = ServerBase;
    }

    public static String getUserbase() {
        return Userbase;
    }

    public static void setUserbase(String Userbase) {
        ControleUsuario.Userbase = Userbase;
    }

    public static String getOwner() {
        
        return Owner;
    }

    public static void setOwner(String Owner) {
        ControleUsuario.Owner = Owner;
    }
    
    
    
    
}
