package Fabrica.Produto;

import Fabrica.Pedidos.Leitor;
import Fabrica.Maquinas.*;
import Fabrica.Pedidos.Order;
import java.io.*;
//import java.time.Clock;
import java.util.*;

public class DadosMaker {
    private long startTime;
    private long stopTime;
    private Order [] pedidos;
    private ArrayList <Dado> saida;
    
    public DadosMaker(Order [] pedidos){
        this.pedidos = pedidos;
        Processando_Dados();
    }
    
    
    public void Processando_Dados(){
        
        saida = new ArrayList<>();
        startTime = System.currentTimeMillis();

        MaquinaMolde moldador = new MaquinaMolde();
        MaquinaCorte cortador = new MaquinaCorte();
        MaquinaMontagem montador = new MaquinaMontagem();
        MaquinaPintura pintor = new MaquinaPintura();
        
        for(int i = 0; i < pedidos.length; i++){
            Dado inProcess = new Dado(pedidos[i].getTipo(), pedidos[i].getCor());       
            
            for(int j = 0; j < pedidos[i].getNumDados(); j++){
                System.out.print("IN PROCESS " + (i + 1) + "\n\nID: " + inProcess.getCod_dado() + "\n");
                if(inProcess.getTipo() == 1){
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
                    
                saida.add(inProcess);
                
            }
            //Runtime.getRuntime().exec("clear");
        }
        
        stopTime = System.currentTimeMillis();
        System.out.println("Quantidade de Dados produzidos:" + saida.size());
        System.out.println("DONE " + (stopTime - startTime) + " ms.");
    }

     public static void Processando_Dados_Teste() throws IOException{
        
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
        
}
