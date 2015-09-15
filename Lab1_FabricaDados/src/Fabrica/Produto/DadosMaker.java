package Fabrica.Produto;

import Fabrica.Maquinas.*;
import Fabrica.Pedidos.Order;
//import java.time.Clock; #LOOK#
import java.util.*;

public class DadosMaker {
    //Pedidos a serem feitos
    private final Order [] pedidos;
    
    //Dados fabricados
    private ArrayList<Dado> saida;
    
    //Computando tempo total de fabricacao
    private long startTime;
    private long stopTime;
    
    //Gerenciador de Maquinas - Manda os pedidos as maquinas
    private GerenciadorMaquinas gMaquinas;
    
    
    public DadosMaker(Order [] pedidos){
        this.pedidos = pedidos;
    }
        
    public void Processando_Dados(){
        saida = new ArrayList<>();
        startTime = System.currentTimeMillis();

        for(int i = 0; i < pedidos.length; i++){
            System.out.println("Pedido #" + (i+1));
            System.out.println("Quantidade de Dados: " + pedidos[i].getNumDados());
            System.out.println("Tamanho dos Dados: " + (pedidos[i].getTipo() == 1? "Small" : "Big"));       
            System.out.println("Cor dos Dados: " + pedidos[i].getCor());
                       
            gMaquinas = new GerenciadorMaquinas(pedidos[i], 5,5,5,5);
            
            saida.addAll(gMaquinas.execute());
            
//            System.out.println("Pedido #" + (i+1) + " terminou com Sucesso");
//            System.out.println("");
            System.out.println("----------------------------------------");
//            System.out.println("");

        }
        
        stopTime = System.currentTimeMillis();
        
        System.out.println("--PROCESSO FINALIZADO--");
        System.out.println("Quantidade de Dados produzidos ao final do Processo:" + saida.size());
        System.out.println("Tempo final do Processo " + (stopTime - startTime) + " ms.");
    }
    
    //SEM THREAD
    public void Processando_Dados_NoThread(){
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
//                pintor.Processa(inProcess);
//                cortador.Processa(inProcess);
//                montador.Processa(inProcess);
                    
                saida.add(inProcess);
                
            }
            //Runtime.getRuntime().exec("clear");
        }
        
        stopTime = System.currentTimeMillis();
        System.out.println("Quantidade de Dados produzidos:" + saida.size());
        System.out.println("DONE " + (stopTime - startTime) + " ms.");
    }
}