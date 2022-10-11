/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaCRM;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author henrique.rodrigues
 */
public class planilha_Xml {

     
    public static String Cpf = "";
    public static String Nome = "";
    public static String Mae = "";
    public static String Nascimento = "";
    public static String Status = "";
    public static int linhaPlanilha = 0;

    public boolean leituraXml(boolean sucesso) throws IOException, BiffException {
  

        
        try {
               
            String caminho = "C:\\Automacao_Mobile\\Clientes_PF_CRM.xls";
            Workbook workbook = null;
            workbook = Workbook.getWorkbook(new File(caminho));
            Sheet sheet = workbook.getSheet(3);// aba #D
            int linhas = sheet.getRows();

            System.out.println("Iniciando a leitura da planilha XLS:");

            for (int i = 0; i < linhas; i++) {
                // lendo da planilha
                Cell a1 = sheet.getCell(0, i);//cpf
                Cell a2 = sheet.getCell(1, i);// nome cliente
                Cell a3 = sheet.getCell(2, i);// nome mae
                Cell a4 = sheet.getCell(3, i);// nascimento
                Cell a5 = sheet.getCell(4, i);// status

                Status = (a5.getContents());
                if (Status.equals("") && i > 2) {
                    linhaPlanilha = i;
                    Cpf = (a1.getContents());
                    Nome = (a2.getContents());
                    Mae = (a3.getContents());
                    Nascimento = (a4.getContents());                   
                    Nascimento = Nascimento.replaceAll("/","");
                    

                    break;
                }

            }

            sucesso = true;

            workbook.close();

        } catch (IOException ex) {
            System.out.println("Não foi possivel Ler a Planilha");
        }

        return sucesso;

    }

}
