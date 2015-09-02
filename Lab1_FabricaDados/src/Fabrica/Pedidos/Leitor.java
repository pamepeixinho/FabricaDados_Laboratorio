/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica.Pedidos;
import ExceptionPackage.EmptyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import jdk.nashorn.internal.parser.TokenType;

public class Leitor {
    private static String path;
    public Leitor(String path) throws FileNotFoundException {
        this.path = path;
//        le_pedido();
    }
       
    public Order [] le_pedido(){
        
         FileInputStream file = null;
        
         try{
             file = new FileInputStream(path);
         }
         catch(FileNotFoundException e){
             System.out.println("Arquivo não encontrado!");
             return null;
         }
//         catch(EmptyFile e){
//            System.out.println("Arquivo vazio!");
//         }
           
        Scanner s = new Scanner(file);
        int n_pedidos = 0;
        try{
            n_pedidos = s.nextInt();
        }catch(Exception e){
            System.out.println("FUDEU");
        }
        
         System.out.println(n_pedidos);
        
//         Vector <Order> pedidos = new Vector(n_pedidos);
         Order [] pedidos = new Order[n_pedidos];
                  
        int tipo = 0, quantidade = 0;
        char cor = 0;
       
        for (int i = 0; i < n_pedidos; i++){
           
            try{
                tipo = s.nextInt();
                cor = s.next().charAt(0);
                quantidade = s.nextInt(); 
//                System.out.println("MAROON 5");
            }catch(Exception e){
                System.out.println("fudeu muito");
                return null;
            }
            
            pedidos[i]  = new Order(tipo, cor, quantidade);
            
        }
        return pedidos;
    }
     
     
}
