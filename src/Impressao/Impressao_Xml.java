/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impressao;

import MassaMobile.Automacao;
import MassaMobile.Tela_Mobile;
import Pacote_Principal.LoginBanco;
import Pacote_Principal.Transfers;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

/**
 *
 * @author henrique.rodrigues
 */
public class Impressao_Xml {
    
    
    public void Impressao(){
        
        
       System.out.println("Inicio da Impressao");
        
     
                             //------Criar uma string para o usuario trocar nas configuracao o endereco    
        String cabecario = "CRIACAO DE MASSAS";
        String nomeArquivo = "Massas do Ambiente "+LoginBanco.nomeMobile+" "+(String)getDateTime(); 
        String data = (String)getDateTime(),              
               titulo = "MASSA MOBILE",               
                valorTotal= "";
                valorTotal.replaceAll("TOTAL", "");
       HSSFWorkbook wb = new HSSFWorkbook();
       HSSFSheet sheet = (HSSFSheet) wb.createSheet("CRIACAO_MASSA");
            
              
               
 //--------->>>>>>>>> INICIO DA IMAGEM ADICIONADA                  
/** Ligando a figura ao Workbook**/
//        byte dataa[] = new byte[120000]; // o suficiente para caber a figura
//        try {                                             
//            new DataInputStream(new FileInputStream(LoginBanco.caminhoRedeLogin+"\\Imagem\\spread.JPG")).read(dataa);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   
//         int index = wb.addPicture(dataa, HSSFWorkbook.PICTURE_TYPE_JPEG);
///*Ligando a figura ao Sheet*/
//                                            coluna Inicio, linha inicio, (short) (INICIO DA IMAGEM NA COLUNA + LAGURA DO INICIO DA IMAGEM), TAMANHO DA ALTURA);
//         HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short) 1, 0, (short) (6 + 3), 10);
//         anchor.setAnchorType(2);
//         sheet.createDrawingPatriarch().createPicture(anchor, index);
//---------->>>>>>>>> FIM DA IMAGEM ADICIONADA        

//----->>>>>criando as  Pre linhas para imressao
              //endereco local          
              HSSFRow enderecoLocal = (HSSFRow) sheet.createRow((short) 3);
              HSSFCell endereco_Local = (HSSFCell) enderecoLocal.createCell((short) (1));
              
              //DATA
              HSSFRow PrelinhaData = (HSSFRow) sheet.createRow((short) 5);
              HSSFCell Prelinha_Data = (HSSFCell) PrelinhaData.createCell((short) (1));
                           
              //DESCRICAO
              HSSFRow Prelinha01 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_01 = (HSSFCell) Prelinha01.createCell((short) (1));                        
             
              //valor
              HSSFRow Prelinha02 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_02 = (HSSFCell) Prelinha02.createCell((short) (2));

              //DATA
              HSSFRow Prelinha03 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_03 = (HSSFCell) Prelinha03.createCell((short) (3));

              //QTD
              HSSFRow Prelinha04 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_04 = (HSSFCell) Prelinha04.createCell((short) (4));

//              TOTAL
              HSSFRow Prelinha05 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_05 = (HSSFCell) Prelinha05.createCell((short) (5));
 
//             USUARIO
              HSSFRow Prelinha06 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_06 = (HSSFCell) Prelinha06.createCell((short) (6));
              
              HSSFRow Prelinha07 = (HSSFRow) sheet.createRow((short) 8);
              HSSFCell Prelinha_07 = (HSSFCell) Prelinha07.createCell((short) (7));
           

//----->>>>> Criando as linhas de inclusao para imressao
              //DATA
              HSSFRow linha1 = (HSSFRow) sheet.createRow((short) 5);
              HSSFCell linha_1 = (HSSFCell) linha1.createCell((short) (2));

      //Formatando a fonte do cabecario
               HSSFFont fonteCabecario = (HSSFFont) wb.createFont();
               fonteCabecario.setFontHeightInPoints((short)40);
               fonteCabecario.setFontName("Bradley Hand ITC");
               fonteCabecario.setColor(HSSFColor.WHITE.index);
               fonteCabecario.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
               HSSFCellStyle estilo = (HSSFCellStyle) wb.createCellStyle();              
               estilo.setFont(fonteCabecario);
               
              sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 7));//mesclar o cabecario 
               
               
               //Formatando a fonte da Linha pre-cabecario
               HSSFFont fontePreLinha = (HSSFFont) wb.createFont();
               fontePreLinha.setFontHeightInPoints((short)10);
               fontePreLinha.setFontName("Arial");
             //  fontePreLinha.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);    
               HSSFCellStyle estiloPreLinha = (HSSFCellStyle) wb.createCellStyle();               
               estiloPreLinha.setFont(fontePreLinha);   

 
               //Formatando a fonte da Linha de inclusao
               HSSFFont fonteLinha = (HSSFFont) wb.createFont();
               fonteLinha.setFontHeightInPoints((short)10);
               fonteLinha.setFontName("Arial ");
               fonteLinha.setColor(HSSFColor.WHITE.index);
              // fonteLinha.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);   
               HSSFCellStyle estiloLinha = (HSSFCellStyle) wb.createCellStyle();
               estiloLinha.setFont(fonteLinha);    
                             
    // formata��o do stylo da lista de servicos - cabecario
    CellStyle styleCab = wb.createCellStyle();
    styleCab.setFont(fonteCabecario);
    styleCab.setBorderBottom(CellStyle.BORDER_THIN);
    styleCab.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    styleCab.setBorderLeft(CellStyle.BORDER_THIN);
    styleCab.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    styleCab.setBorderRight(CellStyle.BORDER_THIN);
    styleCab.setRightBorderColor(IndexedColors.BLACK.getIndex());
    styleCab.setBorderTop(CellStyle.BORDER_THIN);
    styleCab.setTopBorderColor(IndexedColors.BLACK.getIndex());
    styleCab.setAlignment(CellStyle.ALIGN_CENTER);
    styleCab.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    styleCab.setFillForegroundColor(IndexedColors.BLACK.getIndex()); 

    
    // formata��o do stylo da lista de servicos
    CellStyle style = wb.createCellStyle();
    style.setFont(fonteLinha);
    style.setBorderBottom(CellStyle.BORDER_THIN);
    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderLeft(CellStyle.BORDER_THIN);
    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderRight(CellStyle.BORDER_THIN);
    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderTop(CellStyle.BORDER_THIN);
    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
    style.setAlignment(CellStyle.ALIGN_CENTER);
    //style.setFillForegroundColor(HSSFColor.BLUE.index);
    style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    style.setFillForegroundColor(IndexedColors.BLACK.getIndex()); 
   
    CellStyle style2 = wb.createCellStyle();
    style2.setFont(fontePreLinha);
    style2.setBorderBottom(CellStyle.BORDER_THIN);
    style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    style2.setBorderLeft(CellStyle.BORDER_THIN);
    style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    style2.setBorderRight(CellStyle.BORDER_THIN);
    style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
    style2.setBorderTop(CellStyle.BORDER_THIN);
    style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
    style2.setAlignment(CellStyle.ALIGN_CENTER);
    //style.setFillForegroundColor(HSSFColor.BLUE.index);
   // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
   // style.setFillForegroundColor(IndexedColors.BLACK.getIndex());
    
    
// tamanho da coluna 
   sheet.setColumnWidth(1, 30 * 250);
   sheet.setColumnWidth(2, 22 * 250);
   sheet.setColumnWidth(3, 22 * 250);
   sheet.setColumnWidth(4, 22 * 250);
   sheet.setColumnWidth(5, 19 * 250);
   sheet.setColumnWidth(6, 28 * 250);
   sheet.setColumnWidth(7, 80 * 250);
                 
//----->>>>>>>>>>> inicio da impressao da Pre 1� linhas
            //ENDERECO LOCAL
            endereco_Local.setCellStyle(styleCab);
          //  endereco_Local.setCellStyle(estilo);
            endereco_Local.setCellValue(cabecario); 
            //DATA DO SERVI�O
            Prelinha_Data.setCellStyle(estiloPreLinha);      
            Prelinha_Data.setCellValue("DATA DO ARQUIVO:");

            //DATA
            linha_1.setCellStyle(estiloPreLinha);
            linha_1.setCellValue(data);
           
            //DESCRICAO
            Prelinha_01.setCellStyle(style);
            Prelinha_01.setCellValue("NOME CLIENTE");
            
            Prelinha_02.setCellStyle(style);
            Prelinha_02.setCellValue("CLIENTE");
       
            //CODIGO
            Prelinha_03.setCellStyle(style);       
            Prelinha_03.setCellValue("ASSINANTE");

           //DESCRI��O      
            Prelinha_04.setCellStyle(style);
            Prelinha_04.setCellValue("CONTA"); 

           //VALOR
            Prelinha_05.setCellStyle(style);
            Prelinha_05.setCellValue("CPF | CNPJ");

            Prelinha_06.setCellStyle(style);
            Prelinha_06.setCellValue("TIPO - SUBTIPO"); 
    
            Prelinha_07.setCellStyle(style);
            Prelinha_07.setCellValue("OFERTA"); 


int x=9;
 
//sheet.addMergedRegion(new CellRangeAddress(x,x,2,3));//mesclar o cabecario

   
int aux = Automacao.contadorMassa;
 for(int i=0; i<aux; i++){

     //formatando as celulas da lista
HSSFRow listaS= (HSSFRow) sheet.createRow((x));
HSSFCell col_1 = (HSSFCell) listaS.createCell((short) (1));
HSSFCell col_2 = (HSSFCell) listaS.createCell((short) (2)); 
HSSFCell col_3 = (HSSFCell) listaS.createCell((short) (3));
HSSFCell col_4 = (HSSFCell) listaS.createCell((short) (4));
HSSFCell col_5 = (HSSFCell) listaS.createCell((short) (5));
HSSFCell col_6 = (HSSFCell) listaS.createCell((short) (6));
HSSFCell col_7 = (HSSFCell) listaS.createCell((short) (7));

//finha da impressao da linha de impressao

col_1.setCellStyle(style2);
col_2.setCellStyle(style2); 
col_3.setCellStyle(style2); 
col_4.setCellStyle(style2);
col_5.setCellStyle(style2);
col_6.setCellStyle(style2);
col_7.setCellStyle(style2);
//fim da formata��o da lista

//Obtendo resultado da lista
col_1.setCellValue(Automacao.ListaNomeCliente.get(i));
col_2.setCellValue(Automacao.ListaCliente.get(i));
col_3.setCellValue(Automacao.ListaAssinante.get(i));
col_4.setCellValue(Automacao.ListaConta.get(i));
col_5.setCellValue(Automacao.ListaCpf.get(i));
col_6.setCellValue(Transfers.getSubTipo());
col_7.setCellValue(Transfers.getOfertaContratoNome());

// fim do obtida da lista

x= x+1;
System.out.println("linhas de servicos impressas da tabela = "+x);
//sheet.addMergedRegion(new CellRangeAddress(x,x,1,2));//cliente
 }
             
//>>>>> fechamento do processo    
               FileOutputStream fileOut = null;
               String NomeUsuario = System.getProperty("user.name");
               String path = "C:\\Documents and Settings\\"+NomeUsuario+"\\Desktop\\Evidencias de Massa\\"; 
               String localArquivo = path +nomeArquivo+".xls";
            //   String localArquivo = "C:\\System_Program\\Planilha_gastos\\gasto.xls";
        try {

            fileOut = new FileOutputStream(localArquivo);         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            wb.write(fileOut);
        } catch (IOException ex) {
            Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        try {
            fileOut.close();
        } catch (IOException ex) {
            Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Seu arquivo excel foi gerado com sucesso!");
          
            
    int resposta = JOptionPane.showConfirmDialog(null,"Deseja abrir arquivo", "Abrir o arquivo", JOptionPane.YES_NO_OPTION);
    //verfica se a resposta � verdadeira
    if (resposta == JOptionPane.YES_OPTION) {      
        System.out.println("Usuario solicito abertura do arquivo");
           try {
               java.awt.Desktop.getDesktop().open( new File(localArquivo) );
           } catch (IOException ex) {
               Logger.getLogger(Impressao_Xml.class.getName()).log(Level.SEVERE, null, ex);
           }
      }
      else {
          System.out.println("Nao solicitado abertura do arquivo");         
        // System.exit(0);
      }
    }

    //Capturando a data do sistema
	private Object getDateTime() {	
      //  DateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        DateFormat dataFormatada = new SimpleDateFormat("dd_MM_yyyy  HH-mm-ss");
        Date data1 = new Date();
        return dataFormatada.format(data1);
		
		
	}
}
