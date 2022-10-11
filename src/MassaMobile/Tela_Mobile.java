/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MassaMobile;

import static MassaMobile.Assinante.iccdCompare;
import Pacote_Principal.LoginBanco;
import Pacote_Principal.Processando;
import Pacote_Principal.SystemOut;
import Pacote_Principal.Transfers;
import QueryS.GerarIccd;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author henrique.rodrigues
 */
public class Tela_Mobile extends javax.swing.JFrame {

    Transfers dados = new Transfers();
    
    public static int contadorQuantidade=0,r_completo=0,somaContrato=0, somaNomeGerado =0,somaCPF=0,somaIccd=0,somaCustomer=0,r_cliente= 0, r_conta=0, r_oferta=0, r_assinante=0,TnumeroEmpresa , ofertaAtiva=0, ofertaAssinanteAtiva=0 ;
    public static String numeroEmpresa = "",getCliente="",auxCliente= "", getSubTipo="" , habilitadoNavegador ="",TQuantidadeMassa, T_Cliente,TipoNomeSubTipo, Tcyclo, TnumeroCyclo, TCustomerNumero, Tcontrato ;
    public static Boolean nContratoAutomatico = false, nContrato = false,liberarAutomacao= false ,incluirNome = false,incluirCPF= false, ativaOfertaContrato = false,ativaOfertaAssinante1= false, AtivarLista = false , ativaOferta = false;
    private Color oldColor = null;
    public static ArrayList<String> iccd100 = new ArrayList<String> ();
    public static ArrayList<String> ListaCustomer = new ArrayList<String> ();
    public static ArrayList<String> ListaCPF = new ArrayList<String> ();
    public static ArrayList<String> ListaContrato = new ArrayList<String> ();
  //  public static String caminhoRede = "\\\\srv-arq-02.intra_sp_spread\\Fabrica_de_Testes\\Fábrica de Teste Spread\\Automacao_mobile";
    /**
     * Creates new form Tela_Mobile
     */
    public Tela_Mobile() {
        initComponents();
         this.setExtendedState(MAXIMIZED_BOTH);
         
         //inserindo imagem no fundo 
        TelaPrincipal.setImagem(new File(LoginBanco.caminhoRedeLogin+"\\Imagem\\Tela_Principal2.jpg"));
         marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/marca.png")));
        //Alterando o icone 
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/spread.png")).getImage());
    
        //---------Alterando o OptionPane            
     UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Segoe UI Semibold",Font.PLAIN,15)));
        
        
        
        //Pegando o nome do Banco
        NomeBanco.setText(LoginBanco.nomeBancoConectado);
        
        //Pegando o nome do usuario
        String NomeUsuario = System.getProperty("user.name");
        //NomeUsuario = NomeUsuario.replaceAll(".", " ");
        usuarioNome.setText("Bem vindo: "+NomeUsuario);
        
        
        
        
        
        //Deixando Todos campo inviseveis
        
        //Area do tipo de cliente
        TClienteNome.setVisible(false);
        boxCliente.setVisible(false);
        boxClienteS.setVisible(false);
        TClientenomeSubTipo.setVisible(false);
        TClientenomeCiclo.setVisible(false);
        TClienteCiclo.setVisible(false);
        gerarCpfAutomatico.setVisible(false);
        gerarNomeAutomatico.setVisible(false);
        PainelNumeroCpf.setVisible(false);   
        PainelNome.setVisible(false);
        painelList.setVisible(false);
        painelList.setEnabled(false);
        TNomeEstado.setVisible(false);
        boxEstado.setVisible(false);
         
         
        // Area do tipo conta
        addNumeroContrato.setVisible(false);
        gerarContratoAutomatico.setVisible(false);
        painelNumeroContrato.setVisible(false);
       
        // Area tipo Oferta
        addOferta.setVisible(false);
        criarContrato.setVisible(false);
        ofertaS.setVisible(false);
        
        // Area tipo Assinante 
        addOfertaAssinante.setVisible(false);
        ofertaAssinante.setVisible(false);
        TClienteNomeAssinante.setVisible(false);
        boxClienteAssinante.setVisible(false);
        painelNumeroiccd.setVisible(false);
        GerarIccd.setVisible(false);
        AtivarLocalidade.setVisible(false);
        TClientenomeSubTipo1.setVisible(false);
        boxClienteSOferta.setVisible(false);
        dados.setAtivaOfertaAssinante(false);
        ddd.setVisible(false);
        TDddAssinante.setVisible(false);
        
        TPrint.setVisible(false);
        TChrome.setVisible(false);
        iE.setVisible(false);
        jLabel2.setVisible(false);
        TQuantidade.setVisible(false);
        iniciar.setVisible(false);
        
      //Estabelecendo parametros
          areaTextCpf.setDocument(new Numeric(1000));
          areaTextNumeroContarto.setDocument(new Numeric(1000));       
          areaTextcustumer.setDocument(new Numeric(1000));
          TClienteCiclo.setDocument(new Numeric(2));
         

          
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaPrincipal = new componentes.UJPanelImagem();
        jLabel1 = new javax.swing.JLabel();
        massaCompleta = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        boxCliente = new javax.swing.JComboBox<>();
        TClienteNome = new javax.swing.JLabel();
        TClientenomeSubTipo = new javax.swing.JLabel();
        boxClienteS = new javax.swing.JComboBox<>();
        TClientenomeCiclo = new javax.swing.JLabel();
        TClienteCiclo = new javax.swing.JTextField();
        gerarCpfAutomatico = new javax.swing.JRadioButton();
        PainelNumeroCpf = new javax.swing.JPanel();
        scrollCpf = new javax.swing.JScrollPane();
        areaTextCpf = new javax.swing.JTextArea();
        TNomeEstado = new javax.swing.JLabel();
        boxEstado = new javax.swing.JComboBox<>();
        gerarNomeAutomatico = new javax.swing.JRadioButton();
        PainelNome = new javax.swing.JPanel();
        scrollNome = new javax.swing.JScrollPane();
        areaTextNome = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        addOferta = new javax.swing.JButton();
        criarContrato = new javax.swing.JRadioButton();
        ofertaS = new javax.swing.JRadioButton();
        boxClienteSOferta = new javax.swing.JComboBox<>();
        TClientenomeSubTipo1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        addOfertaAssinante = new javax.swing.JButton();
        ofertaAssinante = new javax.swing.JRadioButton();
        boxClienteAssinante = new javax.swing.JComboBox<>();
        TClienteNomeAssinante = new javax.swing.JLabel();
        GerarIccd = new javax.swing.JRadioButton();
        painelNumeroiccd = new javax.swing.JPanel();
        scrollNumeroContrato1 = new javax.swing.JScrollPane();
        areaTextNumeroIccd = new javax.swing.JTextArea();
        AtivarLocalidade = new javax.swing.JRadioButton();
        ddd = new javax.swing.JComboBox<>();
        TDddAssinante = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        painelNumeroContrato = new javax.swing.JPanel();
        scrollNumeroContrato = new javax.swing.JScrollPane();
        areaTextNumeroContarto = new javax.swing.JTextArea();
        gerarContratoAutomatico = new javax.swing.JRadioButton();
        addNumeroContrato = new javax.swing.JRadioButton();
        TOferta = new javax.swing.JRadioButton();
        TAssinante = new javax.swing.JRadioButton();
        TConta = new javax.swing.JRadioButton();
        TCliente = new javax.swing.JRadioButton();
        iE = new javax.swing.JRadioButton();
        TChrome = new javax.swing.JRadioButton();
        painelList = new javax.swing.JPanel();
        scrolCustumer = new javax.swing.JScrollPane();
        areaTextcustumer = new javax.swing.JTextArea();
        NomeBanco = new javax.swing.JLabel();
        usuarioNome = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TQuantidade = new javax.swing.JComboBox<>();
        TPrint = new javax.swing.JRadioButton();
        marca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Massa Mobile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MASSA  MOBILE");

        massaCompleta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        massaCompleta.setForeground(new java.awt.Color(255, 153, 51));
        massaCompleta.setText("MASSA COMPLETA");
        massaCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massaCompletaActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        boxCliente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        boxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "INDIVIDUAL", "COMERCIAL", "GOVERNO" }));
        boxCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        boxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClienteActionPerformed(evt);
            }
        });

        TClienteNome.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClienteNome.setText("Tipo de Cliente");

        TClientenomeSubTipo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClientenomeSubTipo.setText("Tipo de SubTipo");

        boxClienteS.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        boxClienteS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        boxClienteS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClienteSActionPerformed(evt);
            }
        });

        TClientenomeCiclo.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClientenomeCiclo.setText("Ciclo");

        TClienteCiclo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TClienteCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TClienteCicloActionPerformed(evt);
            }
        });

        gerarCpfAutomatico.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gerarCpfAutomatico.setText("Gerar CPF | CNPJ Automatico");
        gerarCpfAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarCpfAutomaticoActionPerformed(evt);
            }
        });

        areaTextCpf.setColumns(9);
        areaTextCpf.setRows(5);
        areaTextCpf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione CPF", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrollCpf.setViewportView(areaTextCpf);

        javax.swing.GroupLayout PainelNumeroCpfLayout = new javax.swing.GroupLayout(PainelNumeroCpf);
        PainelNumeroCpf.setLayout(PainelNumeroCpfLayout);
        PainelNumeroCpfLayout.setHorizontalGroup(
            PainelNumeroCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(PainelNumeroCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );
        PainelNumeroCpfLayout.setVerticalGroup(
            PainelNumeroCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
            .addGroup(PainelNumeroCpfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );

        TNomeEstado.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TNomeEstado.setText("Mercado  - Estado   ");

        boxEstado.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        boxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amazonas", "Amapa", "Bhaia", "Ceara", "Distrito Federal", "Espirito Santo", "Goias", "Maranhao", "Minas Gerais", "Mato Grosso do Sul", "Mato Grosso", "Para", "Paraiba", "Pernambuco", "Piaui", "Parana", "Rio de Janeiro", "Rio grande do Norte", "Rondonia", "Roraima", "Rio grande do sul", "Santa Catarina", "Sergipe", "Sao Paulo - capital", "Sao Paulo - Interior", "Tocantins" }));
        boxEstado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        boxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEstadoActionPerformed(evt);
            }
        });

        gerarNomeAutomatico.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gerarNomeAutomatico.setText("Gerar Nome Automatico");
        gerarNomeAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarNomeAutomaticoActionPerformed(evt);
            }
        });

        scrollNome.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaTextNome.setColumns(9);
        areaTextNome.setRows(5);
        areaTextNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione Nome", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrollNome.setViewportView(areaTextNome);

        javax.swing.GroupLayout PainelNomeLayout = new javax.swing.GroupLayout(PainelNome);
        PainelNome.setLayout(PainelNomeLayout);
        PainelNomeLayout.setHorizontalGroup(
            PainelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );
        PainelNomeLayout.setVerticalGroup(
            PainelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollNome, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(TClientenomeCiclo)
                        .addGap(18, 18, 18)
                        .addComponent(TClienteCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PainelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PainelNumeroCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gerarCpfAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gerarNomeAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxClienteS, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TClienteNome)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TClientenomeSubTipo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TClienteNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TClientenomeSubTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxClienteS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TClientenomeCiclo)
                    .addComponent(TClienteCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TNomeEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gerarCpfAutomatico)
                .addGap(11, 11, 11)
                .addComponent(PainelNumeroCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gerarNomeAutomatico)
                .addGap(8, 8, 8)
                .addComponent(PainelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        addOferta.setBackground(new java.awt.Color(255, 255, 255));
        addOferta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        addOferta.setText("ADICIONE OFERTA");
        addOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfertaActionPerformed(evt);
            }
        });

        criarContrato.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        criarContrato.setText("Criar Contrato a Conta");
        criarContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarContratoActionPerformed(evt);
            }
        });

        ofertaS.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        ofertaS.setText("Adicionar Oferta");
        ofertaS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaSActionPerformed(evt);
            }
        });

        boxClienteSOferta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        boxClienteSOferta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        boxClienteSOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClienteSOfertaActionPerformed(evt);
            }
        });

        TClientenomeSubTipo1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClientenomeSubTipo1.setText("Tipo de SubTipo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TClientenomeSubTipo1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ofertaS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(criarContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addComponent(boxClienteSOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(criarContrato)
                .addGap(18, 18, 18)
                .addComponent(ofertaS)
                .addGap(18, 18, 18)
                .addComponent(TClientenomeSubTipo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxClienteSOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(addOferta)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addOfertaAssinante.setBackground(new java.awt.Color(255, 255, 255));
        addOfertaAssinante.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        addOfertaAssinante.setText("ADICIONE OFERTA");
        addOfertaAssinante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfertaAssinanteActionPerformed(evt);
            }
        });

        ofertaAssinante.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        ofertaAssinante.setText("Adicionar Oferta Assin.");
        ofertaAssinante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ofertaAssinanteActionPerformed(evt);
            }
        });

        boxClienteAssinante.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        boxClienteAssinante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "Pós-Pago Tecnologia GSM", "Pós-Pago Tecnologia TDMA", "Controle Tecnologia TDMA", "Controle Tecnologia GSM", "Telemetria Multimidia", "Pós-Pago Tecnologia 3G", "Controle Tecnologia 3G", "Pos-Pago Banda Larga" }));
        boxClienteAssinante.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));
        boxClienteAssinante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxClienteAssinanteActionPerformed(evt);
            }
        });

        TClienteNomeAssinante.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TClienteNomeAssinante.setText("Tipo de Assinante");

        GerarIccd.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        GerarIccd.setText("Gerar Iccid Pelo Banco");
        GerarIccd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerarIccdActionPerformed(evt);
            }
        });

        scrollNumeroContrato1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaTextNumeroIccd.setColumns(9);
        areaTextNumeroIccd.setRows(5);
        areaTextNumeroIccd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione nº Iccd", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrollNumeroContrato1.setViewportView(areaTextNumeroIccd);

        javax.swing.GroupLayout painelNumeroiccdLayout = new javax.swing.GroupLayout(painelNumeroiccd);
        painelNumeroiccd.setLayout(painelNumeroiccdLayout);
        painelNumeroiccdLayout.setHorizontalGroup(
            painelNumeroiccdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(painelNumeroiccdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollNumeroContrato1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
        );
        painelNumeroiccdLayout.setVerticalGroup(
            painelNumeroiccdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(painelNumeroiccdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollNumeroContrato1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        );

        AtivarLocalidade.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        AtivarLocalidade.setForeground(new java.awt.Color(255, 51, 0));
        AtivarLocalidade.setText("Ativar a Localidade Nulo");
        AtivarLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtivarLocalidadeActionPerformed(evt);
            }
        });

        ddd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12", "13", "14", "15", "16", "17", "18", "19", "21", "22", "24", "27", "28", "31", "32", "33", "34", "35", "37", "38", "41", "42", "43", "44", "45", "46", "47", "48", "49", "51", "53", "54", "55", "61", "62", "63", "64", "65", "66", "67", "68", "69", "71", "73", "74", "75", "77", "79", "81", "82", "83", "84", "85", "86", "87", "88", "89", "91", "92", "93", "94", "95", "96", "97", "98" }));
        ddd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dddActionPerformed(evt);
            }
        });

        TDddAssinante.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        TDddAssinante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TDddAssinante.setText("DDD");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ofertaAssinante, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(TDddAssinante, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AtivarLocalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GerarIccd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TClienteNomeAssinante)
                    .addComponent(painelNumeroiccd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boxClienteAssinante, javax.swing.GroupLayout.Alignment.TRAILING, 0, 233, Short.MAX_VALUE)
                    .addComponent(addOfertaAssinante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TClienteNomeAssinante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxClienteAssinante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ofertaAssinante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addOfertaAssinante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddd, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TDddAssinante))
                .addGap(12, 12, 12)
                .addComponent(GerarIccd)
                .addGap(18, 18, 18)
                .addComponent(painelNumeroiccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(AtivarLocalidade)
                .addGap(16, 16, 16))
        );

        jScrollPane3.setViewportView(jPanel3);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        scrollNumeroContrato.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaTextNumeroContarto.setColumns(9);
        areaTextNumeroContarto.setRows(5);
        areaTextNumeroContarto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione nº Contrato", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrollNumeroContrato.setViewportView(areaTextNumeroContarto);

        javax.swing.GroupLayout painelNumeroContratoLayout = new javax.swing.GroupLayout(painelNumeroContrato);
        painelNumeroContrato.setLayout(painelNumeroContratoLayout);
        painelNumeroContratoLayout.setHorizontalGroup(
            painelNumeroContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollNumeroContrato, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );
        painelNumeroContratoLayout.setVerticalGroup(
            painelNumeroContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollNumeroContrato, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
        );

        gerarContratoAutomatico.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        gerarContratoAutomatico.setText("Gerar Contrato Automatico");
        gerarContratoAutomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarContratoAutomaticoActionPerformed(evt);
            }
        });

        addNumeroContrato.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        addNumeroContrato.setText("Add Numero de  Contrato ");
        addNumeroContrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNumeroContratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelNumeroContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gerarContratoAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNumeroContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(addNumeroContrato)
                .addGap(189, 189, 189)
                .addComponent(gerarContratoAutomatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelNumeroContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel4);

        TOferta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TOferta.setForeground(new java.awt.Color(255, 255, 255));
        TOferta.setText("TIPO OFERTA");
        TOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TOfertaActionPerformed(evt);
            }
        });

        TAssinante.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TAssinante.setForeground(new java.awt.Color(255, 255, 255));
        TAssinante.setText("TIPO ASSINANTE");
        TAssinante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAssinanteActionPerformed(evt);
            }
        });

        TConta.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TConta.setForeground(new java.awt.Color(255, 255, 255));
        TConta.setText("TIPO CONTA");
        TConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TContaActionPerformed(evt);
            }
        });

        TCliente.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TCliente.setForeground(new java.awt.Color(255, 255, 255));
        TCliente.setText("TIPO CLIENTE");
        TCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TClienteActionPerformed(evt);
            }
        });

        iE.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        iE.setForeground(new java.awt.Color(255, 255, 255));
        iE.setText("INTERNET EXPLORER");
        iE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iEActionPerformed(evt);
            }
        });

        TChrome.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TChrome.setForeground(new java.awt.Color(255, 255, 255));
        TChrome.setText("CHROME");
        TChrome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TChromeActionPerformed(evt);
            }
        });

        scrolCustumer.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        areaTextcustumer.setColumns(9);
        areaTextcustumer.setRows(5);
        areaTextcustumer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicione Customer", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Sylfaen", 0, 11))); // NOI18N
        scrolCustumer.setViewportView(areaTextcustumer);

        javax.swing.GroupLayout painelListLayout = new javax.swing.GroupLayout(painelList);
        painelList.setLayout(painelListLayout);
        painelListLayout.setHorizontalGroup(
            painelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrolCustumer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        painelListLayout.setVerticalGroup(
            painelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrolCustumer, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        NomeBanco.setBackground(new java.awt.Color(204, 204, 204));
        NomeBanco.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        NomeBanco.setForeground(new java.awt.Color(0, 204, 51));
        NomeBanco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NomeBanco.setText("Conectado: MOBILE 12");

        usuarioNome.setBackground(new java.awt.Color(204, 204, 204));
        usuarioNome.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        usuarioNome.setForeground(new java.awt.Color(255, 153, 51));
        usuarioNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarioNome.setText("Bem vindo!");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Será Criado uma Pasta na area de trabalho para 'EVIDENCIAS'");

        iniciar.setBackground(new java.awt.Color(255, 153, 51));
        iniciar.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        iniciar.setText("INICIAR");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUANTIDADE MASSA:");

        TQuantidade.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        TQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "30", "40", "50" }));
        TQuantidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TQuantidade.setEnabled(false);

        TPrint.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        TPrint.setText("Realizar todos Print´s ");
        TPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(TPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        marca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TelaPrincipalLayout = new javax.swing.GroupLayout(TelaPrincipal);
        TelaPrincipal.setLayout(TelaPrincipalLayout);
        TelaPrincipalLayout.setHorizontalGroup(
            TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addContainerGap(487, Short.MAX_VALUE)
                        .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(469, 469, 469))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                                .addComponent(massaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(402, 402, 402)
                                .addComponent(NomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                                .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(199, 199, 199)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(TCliente)
                .addGap(222, 222, 222)
                .addComponent(TConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TOferta)
                .addGap(252, 252, 252)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                        .addComponent(usuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                        .addComponent(TAssinante)
                        .addGap(134, 134, 134))))
            .addGroup(TelaPrincipalLayout.createSequentialGroup()
                .addGap(648, 648, 648)
                .addComponent(painelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(TChrome, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        TelaPrincipalLayout.setVerticalGroup(
            TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(usuarioNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeBanco))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TelaPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(massaCompleta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TConta)
                    .addComponent(TCliente)
                    .addComponent(TAssinante)
                    .addComponent(TOferta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TChrome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iE, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(TelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TelaPrincipalLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void massaCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_massaCompletaActionPerformed
    
        
        if (massaCompleta.isSelected() == true){
            
            TCliente.setEnabled(false);
            TConta.setEnabled(false);
            TOferta.setEnabled(false);
            TAssinante.setEnabled(false);                      
            TCliente.setSelected(true);
            TAssinante.setSelected(true);
            TOferta.setSelected(true);
            TConta.setSelected(true);        
            boxCliente.setVisible(true);
            addNumeroContrato.setVisible(true);          
            criarContrato.setVisible(true);
            criarContrato.setSelected(true);
           // addOferta.setVisible(true);          
            iniciar.setVisible(true);
            TQuantidade.setEnabled(true);
             ofertaS.setVisible(true);
        //    ofertaAssinante.setVisible(true);
             boxClienteAssinante.setVisible(true);
             TClienteNomeAssinante.setVisible(true);
          //   GerarIccd.setVisible(true);        
             painelList.setVisible(false);
             painelList.setEnabled(false);
             AtivarLocalidade.setVisible(true);
             TClientenomeSubTipo1.setVisible(false);
             boxClienteSOferta.setVisible(false);
             ofertaS.setSelected(false);
             TQuantidade.setVisible(true);
             jLabel2.setVisible(true);
             TClienteNome.setVisible(true);
             TPrint.setVisible(true);
           
           }else{ 
            boxClienteS.setVisible(false);
            TClientenomeSubTipo.setVisible(false);
            TCliente.setEnabled(true);
            TConta.setEnabled(true);
            TOferta.setEnabled(true);
            TAssinante.setEnabled(true);           
            TCliente.setSelected(false);
            TAssinante.setSelected(false);
            TOferta.setSelected(false);
            TConta.setSelected(false);          
            boxCliente.setVisible(false);
            criarContrato.setVisible(false);
            addOferta.setVisible(false);
            addNumeroContrato.setVisible(false);
            iniciar.setVisible(false);
            TQuantidade.setEnabled(false);
            ofertaS.setVisible(false);
            boxClienteAssinante.setVisible(false);
            TClienteNomeAssinante.setVisible(false);
            ofertaAssinante.setVisible(false);
            GerarIccd.setVisible(false);
            GerarIccd.setSelected(false);
            AtivarLocalidade.setVisible(false);
            TClienteNome.setVisible(false);
            TClienteCiclo.setVisible(false);
            gerarCpfAutomatico.setVisible(false);
            gerarNomeAutomatico.setVisible(false);
            TClientenomeCiclo.setVisible(false);
            TClientenomeSubTipo1.setVisible(false);
            boxClienteSOferta.setVisible(false);
            TQuantidade.setVisible(false);
            jLabel2.setVisible(false);
            TPrint.setVisible(false);
            ddd.setVisible(false);
            TDddAssinante.setVisible(false);
            boxEstado.setVisible(false);
            TNomeEstado.setVisible(false);
            PainelNumeroCpf.setVisible(false);
            PainelNome.setVisible(false);
            painelNumeroiccd.setVisible(false);
            
            
            r_cliente =0;
            r_conta = 0;
            r_oferta = 0;
            r_assinante = 0;
        }




// TODO add your handling code here:
    }//GEN-LAST:event_massaCompletaActionPerformed

    private void boxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClienteActionPerformed
     
        
          if (boxCliente.getFocusTraversalKeysEnabled()== true){
              boxCliente.removeItem("SELECIONE");
          }
              
        if (boxCliente.getSelectedItem().equals("INDIVIDUAL")){
            
            TClientenomeSubTipo.setVisible(true);
            boxClienteS.setVisible(true);
            boxClienteS.removeAllItems();
            boxClienteS.addItem("SELECIONE");
            boxClienteS.addItem("Combo MultiClaro");
            boxClienteS.addItem("Formador_opiniao");
            boxClienteS.addItem("Grandes Clientes");
            boxClienteS.addItem("Profissional Literal");
            boxClienteS.addItem("Normal");
            boxClienteS.addItem("Triple A");
            boxClienteS.addItem("Claro Combo Fixo");
            boxClienteS.addItem("Combo Multi UNO");
            boxClienteS.addItem("Associado");
            boxClienteS.addItem("Combo Multi Net");  
             addOferta.setEnabled(true);
         //   ativaOfertaContrato =  true;
        }   
        if (boxCliente.getSelectedItem().equals("IN.CONTROLE")){
            
            TClientenomeSubTipo.setVisible(true);
            boxClienteS.setVisible(true);
            boxClienteS.removeAllItems();
            boxClienteS.addItem("SELECIONE");
            boxClienteS.addItem("Combo MultiClaro");
            boxClienteS.addItem("Formador_opiniao");
            boxClienteS.addItem("Grandes Clientes");
            boxClienteS.addItem("Profissional Literal");
            boxClienteS.addItem("Normal");
            boxClienteS.addItem("Triple A");
            boxClienteS.addItem("Claro Combo Fixo");
            boxClienteS.addItem("Combo Multi UNO");
            boxClienteS.addItem("Associado");
            boxClienteS.addItem("Combo Multi Net");
            addOferta.setEnabled(false);
            ofertaAtiva = 1 ;
            ofertaAssinanteAtiva = 1;
         //   ativaOfertaContrato =  false;
    }       
        if (boxCliente.getSelectedItem().equals("COMERCIAL")){
            
             TClientenomeSubTipo.setVisible(true);
             boxClienteS.setVisible(true);
             boxClienteS.removeAllItems();
             boxClienteS.addItem("SELECIONE");
             boxClienteS.addItem("Grandes contas");
             boxClienteS.addItem("Top acco.especiais");
             boxClienteS.addItem("Associacoes e corp");
             boxClienteS.addItem("Teste");
             boxClienteS.addItem("Rast. e telemetria");
             boxClienteS.addItem("Peq&media empresa");
             boxClienteS.addItem("Top accounts");
             boxClienteS.addItem("Comercial aace");
             boxClienteS.addItem("Produtor rural");
             boxClienteS.addItem("Mvo");
             boxClienteS.addItem("Street seller");     
           //   ativaOfertaContrato =  true;
        }
        if (boxCliente.getSelectedItem().equals("GOVERNO")){
           
             boxClienteS.setVisible(true);
             TClientenomeSubTipo.setVisible(true);
             boxClienteS.removeAllItems();            
             boxClienteS.addItem("SELECIONE");
             boxClienteS.addItem("Normal"); 
            //  ativaOfertaContrato =  true;
             
        }
        
            getCliente = boxCliente.getSelectedItem().toString();
                
                
            switch (getCliente){
            
            case "INDIVIDUAL":
                 getCliente = "I";
            break;  
            
            case "IN.CONTROLE":
                 getCliente = "I";
            break;         
            case "COMERCIAL":
                 getCliente = "B";
                break;
            case "GOVERNO":
                 getCliente = "G";
                break;
        }    
        

// TODO add your handling code here:
    }//GEN-LAST:event_boxClienteActionPerformed

    private void boxClienteSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClienteSActionPerformed

        if (boxClienteS.getSelectedIndex() > 0 ){     
                 
         TClientenomeCiclo.setVisible(true);
         TClienteCiclo.setVisible(true);
         boxClienteS.removeItem("SELECIONE"); 
         gerarCpfAutomatico.setSelected(true);
         gerarCpfAutomatico.setVisible(true);
         gerarNomeAutomatico.setSelected(true);
         gerarNomeAutomatico.setVisible(true);
         
         TNomeEstado.setVisible(true);
         boxEstado.setVisible(true);
         boxEstado.setSelectedIndex(25);
         
       //  scrollCpf.setVisible(true);
       //  areaTextCpf.setVisible(true);
       //  gerarContratoAutomatico.setSelected(true);
       
       
       
       if(boxClienteS.getSelectedItem().equals("Combo Multi Net") || boxClienteS.getSelectedItem().equals("Combo Multi UNO")
               || boxClienteS.getSelectedItem().equals("Combo MultiClaro")){
           addNumeroContrato.setSelected(true);
       }else{
           addNumeroContrato.setSelected(false);
       }
       
       
       
       
       
}
      
        
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_boxClienteSActionPerformed

    private void gerarCpfAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarCpfAutomaticoActionPerformed

      if (gerarCpfAutomatico.isSelected()== true){
       PainelNumeroCpf.setVisible(false);  
      
         incluirCPF = false;
         TQuantidade.setEnabled(false);
      }else{
         PainelNumeroCpf.setVisible(true); 
         
          incluirCPF = true;
          TQuantidade.setEnabled(false);
          
      }


        // TODO add your handling code here:
    }//GEN-LAST:event_gerarCpfAutomaticoActionPerformed

    private void TClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TClienteActionPerformed

         if ( TCliente.isSelected()== true){
             TClienteNome.setVisible(true);
             boxCliente.setVisible(true);
             iniciar.setVisible(true);
             TClientenomeSubTipo1.setVisible(false);
             boxClienteSOferta.setVisible(false);
             TPrint.setVisible(true);
             
         }else{
             
         TClienteNome.setVisible(false);    
         boxCliente.setVisible(false);
         scrollCpf.setVisible(false);
         areaTextCpf.setVisible(false);
         gerarCpfAutomatico.setVisible(false);
         gerarNomeAutomatico.setVisible(false);
         TClientenomeSubTipo.setVisible(false);
         TClientenomeCiclo.setVisible(false);
         TClienteCiclo.setVisible(false);
         boxClienteS.setVisible(false);
         TNomeEstado.setVisible(false);
         boxEstado.setVisible(false);
         TPrint.setVisible(false);
        
          
         }

        // TODO add your handling code here:
    }//GEN-LAST:event_TClienteActionPerformed

    private void TContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TContaActionPerformed

        
        if (TConta.isSelected()== true){
            TCliente.setSelected(false);
            
        }
        
      //  arrumar o scroll list
    if (TConta.isSelected()== true && TCliente.isSelected() == false){
          painelList.setVisible(true);
          painelList.setEnabled(true);
          addNumeroContrato.setVisible(true);
           iniciar.setVisible(true);
           TPrint.setVisible(true);
          
    }else{
        painelList.setVisible(false);
        painelList.setEnabled(false);
        addNumeroContrato.setVisible(false);
         iniciar.setVisible(false);
         TPrint.setVisible(false);
       
    }
    
     
    
        // TODO add your handling code here:
    }//GEN-LAST:event_TContaActionPerformed

    private void gerarContratoAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarContratoAutomaticoActionPerformed

    if (gerarContratoAutomatico.isSelected()== true){        
         painelNumeroContrato.setVisible(false);  
         nContratoAutomatico = true;
      }else{
         painelNumeroContrato.setVisible(true);  
           nContratoAutomatico = false;
      }

        // TODO add your handling code here:
    }//GEN-LAST:event_gerarContratoAutomaticoActionPerformed

    private void addNumeroContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNumeroContratoActionPerformed

if (addNumeroContrato.isSelected()== true ){
        gerarContratoAutomatico.setVisible(true);
        gerarContratoAutomatico.setSelected(true);
        nContrato = true;
        nContratoAutomatico = true;
     }else{
          gerarContratoAutomatico.setVisible(false);
           nContrato = false;
           nContratoAutomatico = false;
     }
       // TODO add your handling code here:
    }//GEN-LAST:event_addNumeroContratoActionPerformed

    private void criarContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarContratoActionPerformed

    

        // TODO add your handling code here:
    }//GEN-LAST:event_criarContratoActionPerformed

    private void TOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TOfertaActionPerformed

     if (TOferta.isSelected() == true){
         painelList.setVisible(true);
         painelList.setEnabled(true);
     //    addOferta.setVisible(true);
         criarContrato.setVisible(true);
          iniciar.setVisible(true);
          ofertaS.setVisible(true);
          TPrint.setVisible(true);
        //  TClientenomeSubTipo1.setVisible(true);
       //   boxClienteSOferta.setVisible(true);
       
     }else{
         painelList.setVisible(false);
         painelList.setEnabled(false);
      //   addOferta.setVisible(false);
          criarContrato.setVisible(false);
          iniciar.setVisible(false);
           ofertaS.setVisible(false);
           TClientenomeSubTipo1.setVisible(false);
           boxClienteSOferta.setVisible(false);
          addOferta.setVisible(false);
           TPrint.setVisible(false);
     }



        // TODO add your handling code here:
    }//GEN-LAST:event_TOfertaActionPerformed

    private void TAssinanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAssinanteActionPerformed

              if (TAssinante.isSelected()== true){

                painelList.setVisible(true);  
                painelList.setEnabled(true);
                boxClienteAssinante.setVisible(true);
                ofertaAssinante.setVisible(true);
                iniciar.setVisible(true);
                GerarIccd.setVisible(true);
                GerarIccd.setSelected(true);
                AtivarLocalidade.setVisible(true);
                TClienteNomeAssinante.setVisible(true);
                TPrint.setVisible(true);

              }else{  
                painelList.setVisible(false);  
                painelList.setEnabled(false);
                 boxClienteAssinante.setVisible(false);
                 ofertaAssinante.setVisible(false);
                 iniciar.setVisible(false);
                 GerarIccd.setVisible(false);
                AtivarLocalidade.setVisible(false);
                TClienteNomeAssinante.setVisible(false);
                 TPrint.setVisible(false);
                

              }




        // TODO add your handling code here:
    }//GEN-LAST:event_TAssinanteActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        try {
            
//        if(liberarAutomacao == false ){
        
                        
    if (TCliente.isSelected() == true){
                         // pegando os dados do box e passando para classe       
                          getSubTipo = boxClienteS.getSelectedItem().toString();


                          if (boxCliente.getSelectedItem()== "INDIVIDUAL" || boxCliente.getSelectedItem()== "IN.CONTROLE"){
                          switch (getSubTipo){

                              case ("Combo MultiClaro"):
                                    getSubTipo = "B";
                                    break;
                              case ("Formador_opiniao"):
                                    getSubTipo = "F";
                                     break;
                              case ("Grandes Clientes"):
                                    getSubTipo = "J";
                                     break;
                              case ("Profissional Literal"):
                                    getSubTipo = "P";
                                     break;
                              case ("Normal"):
                                    getSubTipo = "R";
                                     break;
                              case ("Triple A"):
                                    getSubTipo = "T";
                                     break;
                              case ("Claro Combo Fixo"):
                                   getSubTipo = "W";
                                    break;
                              case ("Combo Multi UNO"):
                                    getSubTipo = "X";
                                     break;
                              case ("Associado"):
                                    getSubTipo = "Y";
                                     break;
                              case ("Combo Multi Net"):               
                                    getSubTipo = "Z";
                                     break;
                          }
                              }    

                            if (boxCliente.getSelectedItem()== "COMERCIAL"){
                          switch (getSubTipo){

                        case ("Grandes contas"):
                             getSubTipo = "A";	
                             break;  
                        case ("Top acco.especiais"):
                             getSubTipo = "D";	
                             break;      

                        case ("Associacoes e corp"):
                             getSubTipo = "G";	
                             break;		
                        case ("Teste"):
                             getSubTipo = "H";	
                             break;

                        case ("Rast. e telemetria"):
                                 getSubTipo = "L";	
                             break;

                        case ("Peq&media empresa"):
                             getSubTipo = "M";	
                             break;

                        case ("Top accounts"):
                             getSubTipo = "N";	
                             break;

                        case ("Comercial aace"):
                                 getSubTipo = "S";	
                             break;

                        case ("Produtor rural"):
                             getSubTipo = "U";	
                             break;

                        case ("Mvo"):
                             getSubTipo = "V";	
                             break;

                        case ("Street seller"): 
                             getSubTipo = "Z";	
                             break;        

                          }
                            }


                            if (boxCliente.getSelectedItem()== "COMERCIAL"){
                          switch (getSubTipo){

                        case ("Grandes contas"):
                             getSubTipo = "R";	
                             break;  
                          }
                            }      

        }
                //*******************************************************************************************
                //                         Iniciando a validacao do campos                                  *
                //*******************************************************************************************
                //Verificando a link da pagina
//                if (TLink.getText().equals("") || TLink.getText().equals(null) ){
//                    JOptionPane.showMessageDialog(null,"Link Mobile Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
//                    TLink.setBackground(new Color(255 ,106, 106));
//                    return;}else {TLink.setBackground(oldColor);
//                }
                //Verificando O Cliente
                 if (TCliente.isSelected() == true){
                if (boxCliente.getSelectedItem().equals("SELECIONE") || boxCliente.getSelectedItem().equals(null) ){
                    JOptionPane.showMessageDialog(null,"Cliente Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
                    boxCliente.setBackground(new Color(255 ,106, 106));
                    return;}else {boxCliente.setBackground(oldColor);
                }
                //Verificando o subTipo
                if (boxClienteS.getSelectedItem().equals("SELECIONE") || boxClienteS.getSelectedItem().equals(null) ){
                    JOptionPane.showMessageDialog(null,"SubTipo Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
                    boxClienteS.setBackground(new Color(255 ,106, 106));
                    return;}else {boxClienteS.setBackground(oldColor);
                }
                //Verificando o ciclo
                if (TClienteCiclo.getText().equals("") || TClienteCiclo.getText().equals(null) || TClienteCiclo.getText().equals("00") || TClienteCiclo.getText().equals("0")){
                    JOptionPane.showMessageDialog(null,"Ciclo Invalido","Mensagem",JOptionPane.ERROR_MESSAGE);
                    TClienteCiclo.setBackground(new Color(255 ,106, 106));
                    return;}else {TClienteCiclo.setBackground(oldColor);
                }
                 }
                //Verificando a oferta
                if (addOferta.isVisible() == true  && ofertaAtiva == 0 ) {
                    JOptionPane.showMessageDialog(null,"Adicione uma Oferta ","Mensagem",JOptionPane.ERROR_MESSAGE);
                    addOferta.setBackground(new Color(255 ,106, 106));
                    return;}else {addOferta.setBackground(oldColor);
                }
                  if (boxClienteAssinante.isVisible() == true && boxClienteAssinante.getSelectedItem() == "SELECIONE" ) {
                    JOptionPane.showMessageDialog(null,"Adicione um Tipo de Assinante ","Mensagem",JOptionPane.ERROR_MESSAGE);
                    boxClienteAssinante.setBackground(new Color(255 ,106, 106));
                    return;}else {boxClienteAssinante.setBackground(oldColor);
                }


                //Verificando se a lista de custumer esta ativo
                if(painelList.isEnabled() == true){
                    AtivarLista = true;
                    if (areaTextcustumer.getText().equals("")) {
                        JOptionPane.showMessageDialog(null,"Lista de Customer Invalidos ","Mensagem",JOptionPane.ERROR_MESSAGE);
                        areaTextcustumer.setBackground(new Color(255 ,106, 106));
                        return;}else {areaTextcustumer.setBackground(oldColor);
                    } }


                //*******************************************************************************************
                //                       Fim a validacao do campos                                          *
                //*******************************************************************************************



                if (massaCompleta.isSelected() == true) {
                    r_completo =1;
                    if (TCliente.isSelected() == true) {r_cliente = 1;}else {r_cliente = 0;}
                    if (TConta.isSelected()== true) {r_conta =1;}else {r_conta = 0;}
                    if (TOferta.isSelected()== true) {r_oferta =1;}else {r_oferta = 0;}
                    if (TAssinante.isSelected()== true) {r_assinante = 1;}else {r_assinante = 0;}

                }else {
                    r_completo =0;
                    if (TCliente.isSelected() == true) {r_cliente = 1;}else {r_cliente = 0;}
                    if (TConta.isSelected()== true) {r_conta =1;}else {r_conta = 0;}
                    if (TOferta.isSelected()== true) {r_oferta =1;}else {r_oferta = 0;}
                    if (TAssinante.isSelected()== true) {r_assinante = 1;}else {r_assinante = 0;}
                }
                //Verificando contrato
                if(criarContrato.isSelected() == true) {Tcontrato = "ATIVO";}else {Tcontrato = "";}    


                TQuantidadeMassa = TQuantidade.getSelectedItem().toString();


                Transfers.setTipoNavegador("Chrome");

                //Pegando dados do Customer
                String texto0 = areaTextNome.getText() ;
                StringTokenizer st0 = new StringTokenizer(texto0,"\n") ;
                while (st0.hasMoreTokens())
                {
                    String line0 = st0.nextToken();
                    Transfers.getListaNomeGerado().add(line0);
                    somaNomeGerado ++;
                    System.out.println("Lista de Nome: "+ somaNomeGerado);
                }
                
                                //Pegando dados do Customer
                String texto00 = areaTextcustumer.getText() ;
                StringTokenizer st00 = new StringTokenizer(texto00,"\n") ;
                while (st00.hasMoreTokens())
                {
                    String line00 = st00.nextToken();
                    dados.getListaCustumer().add(line00);
                    somaNomeGerado ++;
                    System.out.println("Lista de Nome: "+ somaNomeGerado);
                }
  

                // pegando varios lista de CPF criando o parametro para oferta
                if (incluirCPF == true){
                String texto2 = areaTextCpf.getText() ;
                StringTokenizer st2 = new StringTokenizer(texto2,"\n") ;
                while (st2.hasMoreTokens())
                {
                    String line2 = st2.nextToken();
                    if(line2 != ""){
                    ListaCPF.add(line2);
                    somaCPF ++;
                    System.out.println("Lista de CPF: "+ ListaCPF);
                    }
                }
                 }
                //pegando Iccd
                if (GerarIccd.isSelected() == false){
                String texto4 = areaTextNumeroIccd.getText() ;
                StringTokenizer st4 = new StringTokenizer(texto4,"\n") ;
                while (st4.hasMoreTokens())
                {
                    String line4 = st4.nextToken();
                    iccd100.add(line4);
                    somaIccd ++;
                    System.out.println("Lista de Iccd: "+ iccd100);
                }
                
                
                 int auxq = Integer.parseInt(TQuantidadeMassa);          
                 if(TAssinante.isSelected() == true){
                 if(somaIccd < auxq ){
                    JOptionPane.showMessageDialog(null,"Numero de Iccd Igual o Menor \n a Quantidade de Massa");
                areaTextNumeroIccd.setBackground(new Color(255 ,106, 106));return;}
                else {areaTextNumeroIccd.setBackground(oldColor);}
                
                }    
                }

                // pegando varios lista de Contrato criando o parametro para oferta
                String texto3 = areaTextNumeroContarto.getText() ;
                StringTokenizer st3 = new StringTokenizer(texto3,"\n") ;
                while (st3.hasMoreTokens())
                {
                    String line3 = st3.nextToken();
                    ListaContrato.add(line3);
                    somaContrato ++;
                    System.out.println("Lista de Contarto: "+ ListaContrato);
                }


                TipoNomeSubTipo = getSubTipo;
                T_Cliente = getCliente;
                auxCliente = boxCliente.getSelectedItem().toString();
                
                Transfers.setEstadoMercado(boxEstado.getSelectedIndex());             
                Transfers.setDdd(ddd.getSelectedItem().toString());
                Transfers.getPrintAll();

                TnumeroCyclo = TClienteCiclo.getText();

                System.out.println("Tipo de Cliente: " + getCliente);
                System.out.println("SubTipo da Empresa: " + TipoNomeSubTipo);

//                if (habilitadoNavegador != "habilitado") {JOptionPane.showMessageDialog(null,"Selecione um Navegador");
//                iE.setBackground(new Color(255 ,106, 106));TChrome.setBackground(new Color(255 ,106, 106));return;}
//                else {TChrome.setBackground(oldColor);iE.setBackground(oldColor);}

                
                //conatdor
                if(somaCustomer > 1){
                    contadorQuantidade = somaCustomer;
                }else{
                contadorQuantidade = Integer.parseInt(TQuantidade.getSelectedItem().toString());
                }


                liberarAutomacao = true;
                



                                        //Executa em Thread.
                                        new Thread() {
                                            @Override
                                            public void run(){
                                                try {
                                                     
                                                    new Automacao();
                                                } catch (Exception ex) {
                                                    Logger.getLogger(Tela_Mobile.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        }.start();
                                       
                                                                         //Executa em Thread.
                    
                                        
//                        } else{                   
//
//                                                }

                dispose();

                // TODO add your handling code here:
                        } catch (Exception ex) {
                            Logger.getLogger(Tela_Mobile.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }//GEN-LAST:event_iniciarActionPerformed

    private void addOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOfertaActionPerformed

       
        
        ofertaAtiva = 1 ;
        SelecaoOferta oferta = new SelecaoOferta();
        oferta.setVisible(true);
         


        // TODO add your handling code here:
    }//GEN-LAST:event_addOfertaActionPerformed

    private void addOfertaAssinanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOfertaAssinanteActionPerformed

        ofertaAssinanteAtiva = 1 ;
       
    new SelecaoOfertaAssinante().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_addOfertaAssinanteActionPerformed

    private void TPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TPrintActionPerformed

     if(TPrint.isSelected() == true){
         Transfers.setPrintAll(1);
     }else{
         Transfers.setPrintAll(0);
     }

        // TODO add your handling code here:
    }//GEN-LAST:event_TPrintActionPerformed

    private void TChromeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TChromeActionPerformed
   
          habilitadoNavegador = "habilitado";

        // TODO add your handling code here:
    }//GEN-LAST:event_TChromeActionPerformed

    private void iEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iEActionPerformed

  
        habilitadoNavegador = "habilitado";
         
        // TODO add your handling code here:
    }//GEN-LAST:event_iEActionPerformed

    private void ofertaSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaSActionPerformed

       if(ofertaS.isSelected()== true){
           addOferta.setVisible(true);
           ativaOfertaContrato =  true;
           ativaOferta = true;
           if (massaCompleta.isSelected() == false && TCliente.isSelected() == false){
           TClientenomeSubTipo1.setVisible(true);
           boxClienteSOferta.setVisible(true);
           boxClienteSOferta.addItem("Normal");
           boxClienteSOferta.addItem("Peq&media empresa");
           boxClienteSOferta.addItem("Grandes contas");
           
           
           
           
           }
       }else{
           ofertaAtiva = 0 ;
            ativaOferta = false;
            addOferta.setVisible(false);
            ativaOfertaContrato =  true;
            TClientenomeSubTipo1.setVisible(false);
            boxClienteSOferta.setVisible(false);
            boxClienteSOferta.removeAllItems();
       }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaSActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

  // new Principal().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void ofertaAssinanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ofertaAssinanteActionPerformed

if (ofertaAssinante.isSelected()== true){
    addOfertaAssinante.setVisible(true);
    
}else{
    addOfertaAssinante.setVisible(false);
    dados.setAtivaOfertaAssinante( false);
}
        // TODO add your handling code here:
    }//GEN-LAST:event_ofertaAssinanteActionPerformed

    private void boxClienteAssinanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClienteAssinanteActionPerformed


     if(boxClienteAssinante.getSelectedItem() != "SELECIONE"){
         GerarIccd.setVisible(true);  
         GerarIccd.setSelected(true);
         ofertaAssinante.setVisible(true);
         ddd.setVisible(true);
         ddd.setSelectedItem("11");
         TDddAssinante.setVisible(true);

     }

        // TODO add your handling code here:
    }//GEN-LAST:event_boxClienteAssinanteActionPerformed

    private void GerarIccdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerarIccdActionPerformed


if (GerarIccd.isSelected()== true){
    painelNumeroiccd.setVisible(false);

}else{
  
    painelNumeroiccd.setVisible(true);
}

        // TODO add your handling code here:
    }//GEN-LAST:event_GerarIccdActionPerformed

    private void TClienteCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TClienteCicloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TClienteCicloActionPerformed

    private void AtivarLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtivarLocalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtivarLocalidadeActionPerformed

    private void boxClienteSOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxClienteSOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxClienteSOfertaActionPerformed

    private void boxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEstadoActionPerformed

    private void dddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dddActionPerformed

       String Dd =  ddd.getSelectedItem().toString();
       Dd = Dd. substring(0,1);
       
//       JOptionPane.showMessageDialog(null, Dd);
       Transfers.setDdd(Dd);

     

        // TODO add your handling code here:
    }//GEN-LAST:event_dddActionPerformed

    private void gerarNomeAutomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarNomeAutomaticoActionPerformed

      if (gerarNomeAutomatico.isSelected()== true){
       PainelNome.setVisible(false);  
      
         incluirNome = false;
         TQuantidade.setEnabled(false);
      }else{
         PainelNome.setVisible(true); 
         
          incluirNome = true;
          TQuantidade.setEnabled(false);
          
      }     // TODO add your handling code here:
    }//GEN-LAST:event_gerarNomeAutomaticoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Mobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Mobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Mobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Mobile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {   
                new Tela_Mobile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton AtivarLocalidade;
    public static javax.swing.JRadioButton GerarIccd;
    public static javax.swing.JLabel NomeBanco;
    private javax.swing.JPanel PainelNome;
    private javax.swing.JPanel PainelNumeroCpf;
    public static javax.swing.JRadioButton TAssinante;
    private javax.swing.JRadioButton TChrome;
    public static javax.swing.JRadioButton TCliente;
    private javax.swing.JTextField TClienteCiclo;
    private javax.swing.JLabel TClienteNome;
    private javax.swing.JLabel TClienteNomeAssinante;
    private javax.swing.JLabel TClientenomeCiclo;
    private javax.swing.JLabel TClientenomeSubTipo;
    private javax.swing.JLabel TClientenomeSubTipo1;
    private javax.swing.JRadioButton TConta;
    private javax.swing.JLabel TDddAssinante;
    private javax.swing.JLabel TNomeEstado;
    public static javax.swing.JRadioButton TOferta;
    private javax.swing.JRadioButton TPrint;
    private javax.swing.JComboBox<String> TQuantidade;
    private componentes.UJPanelImagem TelaPrincipal;
    private javax.swing.JRadioButton addNumeroContrato;
    private javax.swing.JButton addOferta;
    private javax.swing.JButton addOfertaAssinante;
    private javax.swing.JTextArea areaTextCpf;
    private javax.swing.JTextArea areaTextNome;
    private javax.swing.JTextArea areaTextNumeroContarto;
    private javax.swing.JTextArea areaTextNumeroIccd;
    private javax.swing.JTextArea areaTextcustumer;
    public static javax.swing.JComboBox<String> boxCliente;
    public static javax.swing.JComboBox<String> boxClienteAssinante;
    public static javax.swing.JComboBox<String> boxClienteS;
    public static javax.swing.JComboBox<String> boxClienteSOferta;
    public static javax.swing.JComboBox<String> boxEstado;
    private javax.swing.JRadioButton criarContrato;
    private javax.swing.JComboBox<String> ddd;
    private javax.swing.JRadioButton gerarContratoAutomatico;
    private javax.swing.JRadioButton gerarCpfAutomatico;
    private javax.swing.JRadioButton gerarNomeAutomatico;
    private javax.swing.JRadioButton iE;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel marca;
    public static javax.swing.JRadioButton massaCompleta;
    private javax.swing.JRadioButton ofertaAssinante;
    private javax.swing.JRadioButton ofertaS;
    public static javax.swing.JPanel painelList;
    private javax.swing.JPanel painelNumeroContrato;
    private javax.swing.JPanel painelNumeroiccd;
    private javax.swing.JScrollPane scrolCustumer;
    private javax.swing.JScrollPane scrollCpf;
    private javax.swing.JScrollPane scrollNome;
    private javax.swing.JScrollPane scrollNumeroContrato;
    private javax.swing.JScrollPane scrollNumeroContrato1;
    public static javax.swing.JLabel usuarioNome;
    // End of variables declaration//GEN-END:variables

    
    
}
     
   

