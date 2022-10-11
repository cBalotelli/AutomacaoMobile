/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacote_Principal;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author henrique.rodrigues
 */
public class Transfers {
    
    private static String nomeOfertaAssinante;
    private static String ativarBuscaAssinante;
    private static boolean ativaOfertaAssinante;
    private static String ofertaContrato;
    private static String ofertaContratoNome;
    private static String subTipo;
    private static int estadoMercado;
    private static String link ;
    private static String tipoNavegador;
    private static String ddd;
    private static int printAll;
    private static int contadorMassa;
    private static String CaminhoPrint;
    private static int contadorImagem;
    private static int planoPreSelecionado;
    private static String customerNome;
    private static String NomeCliente;
    private static boolean IccdGeradoAntes;
    private static int contadorErro ;
    private static Connection  ConexaoBanco;
     private static Connection  ConexaoBancoWA;
    
     private static ArrayList<String> ListaNomeGerado = new ArrayList<String>();
      private static ArrayList<String> ListaCustumer = new ArrayList<String>();
      
      
public static ArrayList<String> ListaCliente = new ArrayList<String> ();
public static ArrayList<String> ListaNomeCliente = new ArrayList<String> ();
public static ArrayList<String> ListaAssinante = new ArrayList<String> ();
public static ArrayList<String> ListaConta = new ArrayList<String> ();
public static ArrayList<String> ListaCpf = new ArrayList<String> ();
public static	ArrayList<String> ListaCustomer = new ArrayList<String> ();

    public static String getNomeCliente() {
        return NomeCliente;
    }

    public static ArrayList<String> getListaCliente() {
        return ListaCliente;
    }

    public static void setListaCliente(ArrayList<String> ListaCliente) {
        Transfers.ListaCliente = ListaCliente;
    }

    public static int getContadorErro() {
        return contadorErro;
    }

    public static Connection getConexaoBanco() {
        return ConexaoBanco;
    }

    public static void setConexaoBanco(Connection ConexaoBanco) {
        Transfers.ConexaoBanco = ConexaoBanco;
    }

    public static void setContadorErro(int contadorErro) {
        Transfers.contadorErro = contadorErro;
    }

    public static boolean isIccdGeradoAntes() {
        return IccdGeradoAntes;
    }

    public static void setIccdGeradoAntes(boolean IccdGeradoAntes) {
        Transfers.IccdGeradoAntes = IccdGeradoAntes;
    }

    public static Connection getConexaoBancoWA() {
        return ConexaoBancoWA;
    }

    public static void setConexaoBancoWA(Connection ConexaoBancoWA) {
        Transfers.ConexaoBancoWA = ConexaoBancoWA;
    }

 

    public static ArrayList<String> getListaNomeCliente() {
        return ListaNomeCliente;
    }

    public static void setListaNomeCliente(ArrayList<String> ListaNomeCliente) {
        Transfers.ListaNomeCliente = ListaNomeCliente;
    }

    public static ArrayList<String> getListaAssinante() {
        return ListaAssinante;
    }

    public static void setListaAssinante(ArrayList<String> ListaAssinante) {
        Transfers.ListaAssinante = ListaAssinante;
    }

    public static ArrayList<String> getListaConta() {
        return ListaConta;
    }

    public static void setListaConta(ArrayList<String> ListaConta) {
        Transfers.ListaConta = ListaConta;
    }

    public static ArrayList<String> getListaCpf() {
        return ListaCpf;
    }

    public static void setListaCpf(ArrayList<String> ListaCpf) {
        Transfers.ListaCpf = ListaCpf;
    }

    public static ArrayList<String> getListaCustomer() {
        return ListaCustomer;
    }

    public static void setListaCustomer(ArrayList<String> ListaCustomer) {
        Transfers.ListaCustomer = ListaCustomer;
    }

    public static void setNomeCliente(String NomeCliente) {
        Transfers.NomeCliente = NomeCliente;
    }
    private static String customerNomeCompleto;
   

    public static String getCustomerNomeCompleto() {
        return customerNomeCompleto;
    }

    public static void setCustomerNomeCompleto(String customerNomeCompleto) {
        Transfers.customerNomeCompleto = customerNomeCompleto;
    }

    public static String getCustomerNome() {
        return customerNome;
    }

    public static ArrayList<String> getListaCustumer() {
        return ListaCustumer;
    }

    public static void setListaCustumer(ArrayList<String> ListaCustumer) {
        Transfers.ListaCustumer = ListaCustumer;
    }

    public static ArrayList<String> getListaNomeGerado() {
        return ListaNomeGerado;
    }

    public static void setListaNomeGerado(ArrayList<String> ListaNomeGerado) {
        Transfers.ListaNomeGerado = ListaNomeGerado;
    }

    public static void setCustomerNome(String customerNome) {
        Transfers.customerNome = customerNome;
    }

    public static int getPlanoPreSelecionado() {
        return planoPreSelecionado;
    }

    public static void setPlanoPreSelecionado(int planoPreSelecionado) {
        Transfers.planoPreSelecionado = planoPreSelecionado;
    }



    public static int getContadorImagem() {
        return contadorImagem;
    }

    public static void setContadorImagem(int contadorImagem) {
        Transfers.contadorImagem = contadorImagem;
    }

    public static String getCaminhoPrint() {
        return CaminhoPrint;
    }

    public static void setCaminhoPrint(String CaminhoPrint) {
        Transfers.CaminhoPrint = CaminhoPrint;
    }

    public static int getContadorMassa() {
        return contadorMassa;
    }

    public static void setContadorMassa(int contadorMassa) {
        Transfers.contadorMassa = contadorMassa;
    }

    public static int getPrintAll() {
        return printAll;
    }

    public static void setPrintAll(int printAll) {
        Transfers.printAll = printAll;
    }

    public static String getDdd() {
        return ddd;
    }

    public static void setDdd(String ddd) {
        Transfers.ddd = ddd;
    }

 



    public static String getTipoNavegador() {
        return tipoNavegador;
    }

    public static void setTipoNavegador(String tipoNavegador) {
        Transfers.tipoNavegador = tipoNavegador;
    }

    public static String getLink() {
        return link;
    }

    public static void setLink(String link) {
        Transfers.link = link;
    }

    public static int getEstadoMercado() {
        return estadoMercado;
    }

    public static void setEstadoMercado(int estadoMercado) {
        Transfers.estadoMercado = estadoMercado;
    }
     
     
     
    public static String getSubTipo() {
        return subTipo;
    }

    public static void setSubTipo(String subTipo) {
        Transfers.subTipo = subTipo;
    }


    
 

    public static String getOfertaContratoNome() {
        return ofertaContratoNome;
    }

    public static void setOfertaContratoNome(String ofertaContratoNome) {
        Transfers.ofertaContratoNome = ofertaContratoNome;
    }

    public static String getOfertaContrato() {
        return ofertaContrato;
    }

    public static void setOfertaContrato(String ofertaContrato) {
        Transfers.ofertaContrato = ofertaContrato;
    }
 
    public boolean isAtivaOfertaAssinante() {
        return ativaOfertaAssinante;
    }

    public void setAtivaOfertaAssinante(boolean ativaOfertaAssinante) {
        this.ativaOfertaAssinante = ativaOfertaAssinante;
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
    public String getAtivarBuscaAssinante() {
        return ativarBuscaAssinante;
    }

    public void setAtivarBuscaAssinante(String ativarBuscaAssinante) {
        this.ativarBuscaAssinante = ativarBuscaAssinante;
    }
    
    
    

    public String getNomeOfertaAssinante() {
        return nomeOfertaAssinante;
    }

    public void setNomeOfertaAssinante(String nomeOfertaAssinante) {
        this.nomeOfertaAssinante = nomeOfertaAssinante;
    }
    
    
    
    
    
}
