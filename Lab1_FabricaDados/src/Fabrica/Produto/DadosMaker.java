package Fabrica.Produto;

import Fabrica.Maquinas.*;
import java.io.IOException;
//import java.time.Clock;
import java.util.*;

public class DadosMaker {
//    private Clock clock;
    
    public static void Processando_Dados() throws IOException{
        
        Scanner input = new Scanner(System.in);
        
        int num_dados = input.nextInt();
        int tipo = input.nextInt();
        char cor = input.next().charAt(0);
        
        System.out.println("n = " + num_dados);
        System.out.println("tipo = " + tipo);
        System.out.println("cor = " + cor);
        
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
//        System.out.println("isMoldado? " + d.isMoldado());
//        moldador.Processa(d);
//        System.out.println("isMoldado? " + d.isMoldado());
//
//        System.out.println("isPintado? " + d.isPintado());
//        pintor.Processa(d);
//        System.out.println("isPintado? " + d.isPintado());
//        
//        System.out.println("isCortado? " + d.isCortado());
//        cortador.Processa(d);
//        System.out.println("isCortado? " + d.isCortado());
//        
//        System.out.println("isMontado? " + d.isMontado());
//        montador.Processa(d);
//        System.out.println("isMontado? " + d.isMontado());
        
    }
    
    public static void main(String[] args) throws IOException {
        Processando_Dados();
    }
}
