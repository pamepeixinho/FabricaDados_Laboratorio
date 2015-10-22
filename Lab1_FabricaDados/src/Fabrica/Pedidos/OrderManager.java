package Fabrica.Pedidos;

import Fabrica.Produto.DadosMaker;
import java.io.FileNotFoundException;

//import java.io.IOException;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;



public class OrderManager {
   private Leitor l;
   private Order [] pedidos;
   private String resp;
   
    public OrderManager(Leitor l) {
        this.l = l;
        makeDados();
   
    }
   
    public OrderManager(){}
    
    public OrderManager(String str){
       try {
           l = new Leitor(str);
       }
       catch (FileNotFoundException ex) {
           //Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Arquivo não encontrado!");
           return;
       }
       catch(NullPointerException e){
           return;
       }
       
       try{
        makeDados();   
       }
       catch(NullPointerException e){    
       }
           
    }

    public String getResp() {
        return resp;
    }
        
     
    public OrderManager(Order pedido){
        this.pedidos = new Order[1];
        pedidos[0] = pedido;
        DadosMaker producao = new DadosMaker(this.pedidos);
        producao.Processando_Dados();
        resp = producao.returnToServidor();
    }
    
    private void makeDados(){
        this.pedidos = l.le_pedido();
        DadosMaker producao = new DadosMaker(pedidos);
        producao.Processando_Dados();
    }
}
