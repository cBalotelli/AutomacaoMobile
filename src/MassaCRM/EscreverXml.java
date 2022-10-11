/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaCRM;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jxl.read.biff.BiffException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
/**
 *
 * @author henrique.rodrigues
 */
public class EscreverXml {
   

    public boolean EscreverXml(boolean sucesso)throws IOException, BiffException{
          
       int contador = planilha_Xml.linhaPlanilha;
        
        try {
             String filename = "C:\\Automacao_Mobile\\Clientes_PF_CRM.xls";
         //  ListaEscrever.addAll(Tela_ListaCep.EnderecoCep);
   
                    FileInputStream file = new FileInputStream(new File( filename));
  
                    HSSFWorkbook workbook = new HSSFWorkbook(file);
                    HSSFSheet sheetAlunos = (HSSFSheet) workbook.getSheetAt(3);
                 
                           Row row = sheetAlunos.getRow(contador); 
                           Cell cellEndereco = row.getCell(4);
                           cellEndereco.setCellValue("1");
           
                    file.close();
  
                    FileOutputStream outFile = new FileOutputStream(new File(filename));
                    workbook.write(outFile);
                    outFile.close();
                    System.out.println("Arquivo Excel editado com sucesso!");
                    sucesso = true;
  
             } catch (FileNotFoundException e) {
                    e.printStackTrace();               
                    System.out.println("Arquivo Excel não encontrado!\n" +e);
                    sucesso = false;
               //     JOptionPane.showMessageDialog(null,"Arquivo Excel não encontrado \n  Ou esta Uso","Mensagem" , JOptionPane.ERROR);
             } catch (IOException e) {
                    e.printStackTrace();
                 //   JOptionPane.showMessageDialog(null,"Erro na edição do arquivo!","Mensagem" , JOptionPane.ERROR);
                    System.out.println("Erro na edição do arquivo!");
                     sucesso = false;
             }
             
             
        return sucesso;
  
       }
  

    
    
    
    
    
    
}
