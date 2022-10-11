/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaCRM;

import com.beust.jcommander.Strings;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import static javax.management.Query.gt;
import static javax.management.Query.lt;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author henrique.rodrigues
 */
public class ProcessoCRM {

    private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public boolean Bollean() throws AWTException, InterruptedException, IOException, UnsupportedFlavorException {

        boolean sucesso = false;
        int contador = 0;

        Robot robo = new Robot();

        JOptionPane.showMessageDialog(null, "Posicione o cursor na Tela do CRM");
        // Agaurdando o usuario selecionar a tela de login
        robo.delay(2000);

        //    robo.keyPress(KeyEvent.VK_DEAD_CEDILLA);
//            //usuario
//            robo.keyPress('S');
//            robo.keyPress('A');
//
//            Thread.sleep(2000);
//
//            robo.keyPress(KeyEvent.VK_TAB);
//
//            Thread.sleep(2000);
//            // senha
//            robo.keyPress('S');
//            robo.keyPress('A');
//
//            Thread.sleep(2000);
//
//            robo.keyPress(KeyEvent.VK_TAB);
//
//            //selecionando login
//            for (int i = 0; i <= 2; i++) {
//
//                Thread.sleep(2000);
//
//                robo.keyPress(KeyEvent.VK_TAB);
//            }
//
//            // cliclando no login
//            robo.keyPress(KeyEvent.VK_ENTER);
//
//            
//        //Aguardando a pagina carregar    
        Thread.sleep(500);
//         
////          //habilitando o menu
//         robo.keyPress(KeyEvent.VK_CONTROL);
//         robo.delay(500);
//         robo.keyPress('O');
//       //  robo.delay(1000);
//        // robo.keyPress(KeyEvent.VK_CONTROL);
//          robo.delay(1000);
//         robo.keyPress(KeyEvent.VK_ESCAPE);
//   

//---------------------------------------------------------------------------//        
//                       Tratamento do campos                                   //
//---------------------------------------------------------------------------//  
        ArrayList<String> QuebrarNome = new ArrayList<String>();
        //Pegando dados do Customer
        String sobrenome = "";
        String texto0 = planilha_Xml.Nome;
        StringTokenizer st0 = new StringTokenizer(texto0, " ");
        while (st0.hasMoreTokens()) {
            String line0 = st0.nextToken();
            QuebrarNome.add(line0);
        }
        String nome = (QuebrarNome.get(0) + " " + QuebrarNome.get(1));
        sobrenome = QuebrarNome.get(QuebrarNome.size() - 1);
        String cpf = planilha_Xml.Cpf;
        String mae = planilha_Xml.Mae;
        String nascimento = planilha_Xml.Nascimento;
        String dia, mes, ano;
        
        if (nascimento.length() == 8){
         dia = nascimento.substring(0, 2);
         mes = nascimento.substring(2, 4);
         ano = nascimento.substring(4, 8);
        }else{
         dia = nascimento.substring(0, 2);
         mes = nascimento.substring(4, 6);
         ano = nascimento.substring(8, 12);
    }
        String telefone = "31313131";
        String cep = "89801000";// 89801051
        String descricaoOferta = "NET TOP HD MAX";
        int contadorImagem = 1;
        String NomeUsuario = System.getProperty("user.name");
        String imageFileDir = "C:\\Documents and Settings\\" + NomeUsuario + "\\Desktop\\Evidencias de Massa";
        BufferedImage bi = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

        //print de Tela  
        ImageIO.write(bi, "jpg", new File("" + imageFileDir + "/Imagem_" + contadorImagem + ".jpg"));
        robo.delay(1000);
        contadorImagem++;

//---------------------------------------------------------------------------//        
//                                 INICIO                                    //
//---------------------------------------------------------------------------//  
        //Tempo para o posicionamento do cursor
        robo.delay(5000);


        //Botao de atalho para iniciar
//        robo.keyPress(KeyEvent.VK_CONTROL);
//        robo.keyPress('O');
//        robo.keyRelease(KeyEvent.VK_CONTROL);
//        robo.delay(1000);
        
       //indo para o localizar
        robo.delay(300);
        robo.mouseMove(867, 115);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(300);
        
        //indo para criar contato
        robo.delay(100);
        robo.mouseMove(439, 828);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(300);





        //campo CPF     
        for (int Contador = 0; Contador <= 44; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(1000);

        robo.keyPress(KeyEvent.VK_DOWN);
        robo.keyRelease(KeyEvent.VK_DOWN);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(1000);

        for (char character : cpf.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);

        }
        robo.delay(500);

        //quebrando o nao pesquisar cpf
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(200);
        //caixa box
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
        robo.delay(200);

        for (int Contador = 0; Contador <= 3; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(900);

        //   final String string = "camera";
        for (char character : nome.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }

        robo.delay(200);

        //sobrenome
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(200);
        //   final String string = "camera";
        for (char character : sobrenome.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(200);

        //nome Mae
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);

        for (char character : mae.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(200);

        // Data de nascimento
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.delay(300);
        robo.mouseMove(514, 355);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);

        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(100);

        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(200);
        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(200);
        //dia 
        for (char character : dia.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }

        robo.delay(200);
        robo.keyPress(KeyEvent.VK_RIGHT);
        robo.delay(200);

        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(200);
        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(200);
        //mes
        for (char character : mes.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);

        }
        robo.delay(200);
        robo.keyPress(KeyEvent.VK_RIGHT);
        robo.delay(200);

        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_DELETE);
        robo.delay(100);
        //ano
        for (char character : ano.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(500);

        // sexo
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.delay(500);

        // estado civil
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.delay(500);

        // profissao
        robo.keyPress(KeyEvent.VK_TAB);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.delay(500);

        //telefone
        // indo para o numero de telefone
        robo.delay(500);
        for (int Contador = 0; Contador <= 4; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(50);
        }
        robo.delay(500);

        for (char character : telefone.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(500);

        // indo para o campo cep
        for (int Contador = 0; Contador <= 20; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(50);
        }
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        robo.delay(300);

        //indo ate o fim da barra de rolagem cep
        //   Thread.sleep(5000);
        robo.delay(500);
        robo.mouseMove(1182, 782);
        robo.delay(300);

        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);

        // indo´para o campo cep
        robo.delay(800);
        for (int Contador = 0; Contador <= 29; Contador++) {

            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(50);
        }

        // JOptionPane.showMessageDialog(null,"teste");
        robo.delay(900);
        //adicionando o cep
        for (char character : cep.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(1000);

        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
        robo.delay(900);

        // selecionando o cep     89801000
        for (int Contador = 0; Contador <= 3; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(50);
        }

        //botao selecionar
        robo.delay(900);
        robo.mouseMove(325, 802);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //botao salvar
        robo.delay(1000);
        robo.mouseMove(1339, 826);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);
        //Print da Tela
        bi = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(bi, "jpg", new File("" + imageFileDir + "/Imagem_" + contadorImagem + ".jpg"));
        contadorImagem++;

//---------------------------------------------------------------------------//        
//                            Proxima Tela                                   //
//---------------------------------------------------------------------------//   
        //AGUARDANDO DELAY
         robo.delay(15000);
        //botao canal
        robo.delay(1000);
        robo.mouseMove(1018, 259);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //selecioando tecnica
        robo.keyPress(KeyEvent.VK_DOWN);
        robo.keyRelease(KeyEvent.VK_DOWN);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
        robo.delay(500);

        //Print da Tela de tecnica
        bi = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(bi, "jpg", new File("" + imageFileDir + "/Imagem_" + contadorImagem + ".jpg"));
        contadorImagem++;

        //Selecionando nome
        robo.delay(2000);
        robo.mouseMove(357, 54);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //Selecionando o botao Criar
        robo.delay(3000);
        robo.mouseMove(736, 445);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //indo para o campo subtipo de cliente  
        for (int Contador = 0; Contador <= 5; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(1000);

        //selecionando 'SEM SEGMENTO'   
        for (int Contador = 0; Contador <= 4; Contador++) {
            robo.keyPress(KeyEvent.VK_DOWN);
            robo.keyRelease(KeyEvent.VK_DOWN);
            robo.delay(20);
        }
        robo.delay(1000);

        //indo para o selecao de ciclo
        for (int Contador = 0; Contador <= 4; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(900);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);

        //indo para o selecao de ciclo 4
        robo.delay(1000);
        for (int Contador = 0; Contador <= 17; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(30);
        }
        robo.delay(900);

        //Selecionando o botao Selecionar
        robo.delay(1000);
        robo.mouseMove(323, 803);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //indo para o selecao salvar
        robo.delay(1000);
        robo.mouseMove(1335, 826);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //indo para o selecao salvar
        robo.delay(1000);
        
        //Print da Tela de ciclo
        bi = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(bi, "jpg", new File("" + imageFileDir + "/Imagem_" + contadorImagem + ".jpg"));
        contadorImagem++;

        //Selecionando o botao 'AÇOES'
        robo.delay(1000);
        robo.mouseMove(271, 31);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(900);

        //indo para o GESTAO DE ORDENS
        for (int Contador = 0; Contador <= 4; Contador++) {
            robo.keyPress(KeyEvent.VK_DOWN);
            robo.keyRelease(KeyEvent.VK_DOWN);
            robo.delay(20);
        }
        robo.delay(500);
        robo.keyPress(KeyEvent.VK_RIGHT);
        robo.keyRelease(KeyEvent.VK_RIGHT);
        robo.delay(100);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        
         //AGUARDANDO DELAY
         robo.delay(6000);

        //INDO PARA OFERTAS
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(200);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        robo.delay(20);

        //aguardando o delay
        robo.delay(60000);

        //fechando a janela
        robo.delay(1000);
        robo.mouseMove(1004, 559);
        robo.mousePress(InputEvent.BUTTON1_MASK);
        robo.mouseRelease(InputEvent.BUTTON1_MASK);
        robo.delay(1000);

        //INDO PARA DESCRICAO DE OFERTA
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(20);
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(20);
        
        //descircao   NET TOP HD MAX
        robo.delay(1000);
        for (char character : descricaoOferta.toCharArray()) {
            robo.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.keyRelease(KeyEvent.getExtendedKeyCodeForChar(character));
            robo.delay(10);
        }
        robo.delay(500);

        //indo botao pesquisar
        robo.keyPress(KeyEvent.VK_TAB);
        robo.keyRelease(KeyEvent.VK_TAB);
        robo.delay(20);
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        robo.delay(20);

         //aguardando o delay
        robo.delay(20000);
        
        //indo para o campo subtipo de cliente  
        for (int Contador = 0; Contador <= 2; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(500);
        //botao selecionar oferta    
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        robo.delay(20);

        //indo para o boat o 'PROXIMO'  
        for (int Contador = 0; Contador <= 5; Contador++) {
            robo.keyPress(KeyEvent.VK_TAB);
            robo.keyRelease(KeyEvent.VK_TAB);
            robo.delay(20);
        }
        robo.delay(3000);

        //botao selecionar oferta    
        robo.keyPress(KeyEvent.VK_SPACE);
        robo.keyRelease(KeyEvent.VK_SPACE);
        robo.delay(20);

          //aguardando o delay
        robo.delay(90000);
        
      //Print da Tela de ativar ordem acao
        bi = robo.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(bi, "jpg", new File("" + imageFileDir + "/Imagem_" + contadorImagem + ".jpg"));
        contadorImagem++;   
        
        
        
       // preparar a oredem de acao
        
        
        
        
        JOptionPane.showMessageDialog(null, "fim");

        sucesso = true;

        return sucesso;
    }

    private static String capturarTextoDaAreaDeTransferencia() throws UnsupportedFlavorException, IOException, InterruptedException {

        System.out.println("\n> Texto no ClipBoard imediatamente após o 'Ctrl+C':\n" + capturarTextoDaAreaDeTransferencia());

        try {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                return clipboard.getData(DataFlavor.stringFlavor).toString();//Retorna o texto na Área de Transferência.
            } else {
                return "";//Não há texto na Área de Transferência, então Retorna uma String vazia.
            }
        } catch (IllegalStateException e) {
            System.out.println("\n> A Área de Transferência está indisponível neste instante: " + e);
            sleep(100); //"Thread.sleep(100)": aguardamos 100ms para depois tentar ler a Clipboard novamente.
            return capturarTextoDaAreaDeTransferencia(); //Recursividade: Tentamos ler a Clipboard novamente, até conseguir.
        }
    }
}
