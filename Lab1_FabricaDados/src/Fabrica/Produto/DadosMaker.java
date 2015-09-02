package Fabrica.Produto;

import Fabrica.Pedidos.Leitor;
import Fabrica.Maquinas.*;
import java.io.*;
//import java.time.Clock;
import java.util.*;

public class DadosMaker {

    public DadosMaker() throws IOException {
        Processando_Dados();
    }
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

    
        
        
    
    
    public static void main(String[] args) throws IOException {
        
        // /Users/Victorroveda/Google Drive/4 Semestre/Lab Guigs/pedidos.txt
        Leitor l = new Leitor("C:\\Users\\unifakhatib\\LAB\\FabricaDados_Laboratorio\\Lab1_FabricaDados\\Pedidos\\pedidos.txt");
        //le_pedido("/Users/Victorroveda/Google Drive/4 Semestre/Lab Guigs/pedidos.txt");
        //Processando_Dados();
    }
    
}
