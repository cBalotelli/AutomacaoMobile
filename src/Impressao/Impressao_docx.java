/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impressao;

import Pacote_Principal.Transfers;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
/**
 *
 * @author henrique.rodrigues
 */
public class Impressao_docx {
    
    public boolean impressao_docx(String data){
        boolean sucesso =false;
          try {
              
            String NomeUsuario = System.getProperty("user.name");
            String caminho2 = "C:\\Users\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa\\"+Transfers.getCustomerNome()+"_"+data+".docx";
               
            XWPFDocument doc = new XWPFDocument();
            
                for(int i = 1; i <= Transfers.getContadorImagem() ; i++){
                 
                XWPFParagraph title = doc.createParagraph();
                XWPFRun run = title.createRun();
                
                String imagem  =  "C:\\Users\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa\\Print_"+Transfers.getContadorMassa()+"\\"+i+".jepg";
                
                                  
           // run.setText(Transfers.getCustomerNomeCompleto());                    
            run.setFontSize(14);      
            run.setBold(true);
            title.setAlignment(ParagraphAlignment.LEFT);
            
            FileInputStream is = new FileInputStream(imagem);
            run.addBreak();
            
            run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, imagem, Units.toEMU(480), Units.toEMU(350)); // 200x200 pixels
          //  title.setAlignment(ParagraphAlignment.CENTER);
            is.close();           
            }        
            FileOutputStream fos = new FileOutputStream(caminho2);
            doc.write(fos);
            fos.close();             
            System.out.println("Documento Word Criado com sucesso");          
            sucesso = true;
            
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Impressao_docx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Impressao_docx.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Impressao_docx.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return sucesso;
 
     
    }
    
}
