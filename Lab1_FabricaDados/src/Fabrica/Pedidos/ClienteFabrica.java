/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica.Pedidos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unifggarcia
 */
public class ClienteFabrica extends Thread{
    
    private String pedido;
    private OrderManager manager;
    private Order O;
    
    public ClienteFabrica(){
        Socket sClient = null;
        Scanner in = null;
        Formatter out = null;
        //CRIA CONEXA 1
        try {
            sClient = new Socket("10.103.1.112", 5000);
        } catch (IOException ex) {
            System.out.println("Não foi possível conectar!");
        }

        try{
            in = new Scanner(sClient.getInputStream());
            out = new Formatter(sClient.getOutputStream());            
            
            out.format("pedido");
            out.flush();
            System.out.println("Comunicação com o servidor estabelecida");
            
            this.O = new Order(in.nextInt(), in.next().charAt(0), in.nextInt());           
            
            
            System.out.println(O.getTipo());
            System.out.println(O.getCor());
            System.out.println(O.getNumDados());
            
            
            
            System.out.println("Pedido:");
            System.out.println("   Tipo: " + O.getTipo());
            System.out.println("   Cor:" + O.getCor());
            System.out.println("   Quantidade: " + O.getNumDados());
            System.out.println("----------------------------------------");            
            
        } catch(IOException ex){
            System.out.println("Erro ao receber o pedido");
        }
        
        System.out.println("1 - Aceitar pedido.");
        System.out.println("2 - Recusar pedido.");
        
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        
        if(op == 1){
            this.manager = new OrderManager(O);
            
            try {          
                in = new Scanner(sClient.getInputStream());
                out = new Formatter(sClient.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClienteFabrica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.format(this.manager.getResp());
            out.flush();
            System.out.println("Resposta do servidor: " + in.next());
        }
        else if(op == 2){
            try {          
                in = new Scanner(sClient.getInputStream());
                out = new Formatter(sClient.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClienteFabrica.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            out.format("cancela");
            out.flush();
            System.out.println("Resposta do servidor: " + in.next());
        }
            
        try {
            sClient.close();
        } catch (IOException ex) {
            Logger.getLogger(ClienteFabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    
    public static void main (String [] args){
        ClienteFabrica a = new ClienteFabrica();
        //a.start();
    }
}

