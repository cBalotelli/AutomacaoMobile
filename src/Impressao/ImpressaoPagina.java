/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impressao;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author henrique.rodrigues
 */
public class ImpressaoPagina {

    static void splitPdfFile(InputStream inputPdf,
            OutputStream outputStream, int startPage,
            int endPage) throws Exception {
        //Create document and pdfReader objects.
        Document document = new Document();
        PdfReader pdfReader = new PdfReader(inputPdf);

        //Get total no. of pages in the pdf file.
        int totalPages = pdfReader.getNumberOfPages();

        //Check the startPage should not be greater than the endPage
        //and endPage should not be greater than total no. of pages.
        if (startPage > endPage || endPage > totalPages) {
            System.out.println("Kindly pass the valid values "
                    + "for startPage and endPage.");
        } else {
            // Create writer for the outputStream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            //Open document
            document.open();

            //Contain the pdf data.
            PdfContentByte pdfContentByte
                    = writer.getDirectContent();
            PdfImportedPage page;

            while (startPage <= endPage) {
                document.newPage();
                page = writer.getImportedPage(pdfReader, startPage);
                pdfContentByte.addTemplate(page, 0, 0);
                startPage++;
            }

            //Close document and outputStream.
            outputStream.flush();
            document.close();
            outputStream.close();
        }
    }

    public void ImprimirPagina(int x, int y, String nomeArquivo , String file) {

    //    String file = ("C:\\Users\\henrique.rodrigues\\Desktop\\testePDF.pdf");
        try {
            //Prepare output stream for 
            //new pdf file after split process.
            OutputStream outputStream1
                    = //new FileOutputStream("C:\\Users\\henrique.rodrigues\\Desktop\\"+nomeArquivo+".pdf");
                    new FileOutputStream(leitorPDF_Principal.CaminhoSaida + "\\" + nomeArquivo + ".pdf");
            // OutputStream outputStream2 = 
            //		new FileOutputStream("C:\\Users\\henrique.rodrigues\\Desktop\\SplitFile2.pdf");

            //call method to split pdf file.
            splitPdfFile(new FileInputStream(file),
                    outputStream1, x, y);
            //   splitPdfFile(new FileInputStream(file),
            //   		outputStream2, 5, 8);  
            System.out.println("=============================================================");
            System.out.println("Impressao: " + nomeArquivo + " finalizado Com sucesso.");
            System.out.println("=============================================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean ImpressaoPrincipal(String file, String dados) {

        int paginaInicial = 0;
        int paginaFinal = 0;
        boolean  sucesso = false;

        try {
            PDFParser parser = new PDFParser(new RandomAccessBufferedFileInputStream(file));

            parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper pdfStripper = new PDFTextStripper();
            PDDocument pdDoc = new PDDocument(cosDoc);

            loop:

            for (int i = 0; i <= pdDoc.getNumberOfPages(); i++) {

                pdfStripper.setStartPage(i);
                pdfStripper.setEndPage(i);

                String parsedText = pdfStripper.getText(pdDoc);

                if (parsedText.contains(dados)) {
                    System.out.println("Numero da Página Encontrada " + i);

                    //pegando a quandidate de pagina
                    int aux = parsedText.length();
                    String auxx = parsedText.substring(aux - 25, aux);
                    auxx = auxx.replace(" ", "");
                    paginaInicial = Integer.parseInt(auxx.substring(5, 6));

                    if (paginaInicial == 1) {
                        paginaInicial = (i);
                    } else {
                        paginaInicial = (i - paginaInicial);
                    }
                    // paginaInicial = (paginaInicial - 1);

                    paginaFinal = Integer.parseInt(auxx.substring(7, 8));
                    paginaFinal = (i + paginaFinal);
                    paginaFinal = (paginaFinal - 1);
                    //System.out.println("paginaInicial: "+ paginaInicial );
                    System.out.println("paginaInicial: " + i);
                    System.out.println("paginaFinal: " + (paginaFinal));

                    //chamando a classe para impressao de paginas
                    ImprimirPagina(paginaInicial, paginaFinal, dados, file);
                    sucesso = true;
                    break loop;
                    
                }

                System.out.println("Arquivo não localizado");
                sucesso = false;
            }//for da pagina

        } catch (IOException e) {
            // Tratar a exceção adequadamente.
            e.printStackTrace();
        }
        return sucesso ;

    }

}
