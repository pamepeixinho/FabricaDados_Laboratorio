package Fabrica.Produto;

import Fabrica.Maquinas.*;
import java.io.*;
//import java.time.Clock;
import java.util.*;

public class DadosMaker {
//    private Clock clock;
    
    public static void Processando_Dados() throws IOException{
        
        //Scanner input = new Scanner(System.in);
        int pedidos;
        int num_dados = 0; 
        int tipo = 0;
        char cor = 0;
        
        //System.out.println("n = " + num_dados);
        //System.out.println("tipo = " + tipo);
        //System.out.println("cor = " + cor);
        
        Dado []  manufacturedDices = new Dado[num_dados];
        
//        Dado d = new Dado(1, 'v');
        long startTime = System.currentTimeMillis();
        
        MaquinaMolde moldador = new MaquinaMolde();
        MaquinaCorte cortador = new MaquinaCorte();
        MaquinaMontagem montador = new MaquinaMontagem();
        MaquinaPintura pintor = new MaquinaPintura();
       
        
        for(int i = 0; i < num_dados; i++){
            
            Dado inProcess = new Dado(tipo, cor);
            
            System.out.print("IN PROCESS " + (i + 1) + "\n\nID: " + inProcess.getCod_dado() + "\n");
            if(tipo == 1){
                System.out.print("SIZE: SMALL\n");
            } 
            else {
                System.out.print("SIZE: BIG\n");
            }
            
            System.out.print("COLOR: " + inProcess.getCor() + "\n\n");
            
            moldador.Processa(inProcess);
            pintor.Processa(inProcess);
            cortador.Processa(inProcess);
            montador.Processa(inProcess);
            
            manufacturedDices[i] = inProcess;
            
            Runtime.getRuntime().exec("clear");
            
        }
        
        long stopTime = System.currentTimeMillis();
        
        System.out.println("DONE " + (stopTime - startTime) + " ms.");

    }
    
    /**
     *
     * @param dir
     * @throws FileNotFoundException
     */
    public static void le_pedido(String dir) throws FileNotFoundException{
        
        FileInputStream file = new FileInputStream(dir);
        
        Scanner s = new Scanner(file);
        int n_pedidos = s.nextInt();
        
        Vector <Order> pedidos = new Vector(n_pedidos);
        
        for (int i = 0; i < n_pedidos; i++){
            
            Order pd;
            System.out.println(s.nextInt());
            System.out.println(s.next().charAt(0));
            System.out.println(s.next());
            //pd = new Order(s.nextInt(), s.next().charAt(0), s.nextInt());
            
            //pedidos.setElementAt(pd, i);
            
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        
        // /Users/Victorroveda/Google Drive/4 Semestre/Lab Guigs/pedidos.txt
        
        le_pedido("/Users/Victorroveda/Google Drive/4 Semestre/Lab Guigs/pedidos.txt");
        //Processando_Dados();
    }
    
}
