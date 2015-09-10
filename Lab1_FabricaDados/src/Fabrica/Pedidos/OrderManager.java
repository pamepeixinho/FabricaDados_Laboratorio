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
       }
       
       try{
        makeDados();   
       }
       catch(NullPointerException e){    
       }
           
    }
    
    public void makeDados(){

        this.pedidos = l.le_pedido();
        DadosMaker producao = new DadosMaker(pedidos);
    }
}
