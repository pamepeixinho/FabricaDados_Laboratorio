package Fabrica.Pedidos;

import Fabrica.Produto.DadosMaker;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;



public class OrderManager {
   private Leitor l;
   private Order [] pedidos;
   
   
    public OrderManager(Leitor l) {
        this.l = l;
    }
   
    public OrderManager(){}
    
    public OrderManager(String str){
       try {
           l = new Leitor(str);
       } catch (FileNotFoundException ex) {
           //Logger.getLogger(OrderManager.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("File not found");
       }
    }
    
    public void makeDados(){
        pedidos = l.le_pedido();
        
//        DadosMaker make = new DadosMaker();
        //PARAMOS AQUI
        
       
    }
}
