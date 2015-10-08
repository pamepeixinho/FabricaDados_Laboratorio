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
    
    public ClienteFabrica(){
        Socket sClient = null;
        Scanner in = null;
        Formatter out = null;
        
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
            Order O = new Order(in.nextInt(), in.next().charAt(0), in.nextInt());           

            System.out.println(O.getTipo());
            System.out.println(O.getCor());
            System.out.println(O.getNumDados());
            
        } catch(IOException ex){
            System.out.println("Erro ao receber o pedido");
        }
        
    }
    
    public static void main (String [] args){
        ClienteFabrica a = new ClienteFabrica();
        //a.start();
    }
}

