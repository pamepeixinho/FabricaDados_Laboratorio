package Fabrica.Produto;

import Fabrica.Maquinas.*;
import java.time.Clock;
import java.util.*;

public class DadosMaker {
    private Clock clock;
    
    public static void Processando_Dados(){
        
        Scanner input = new Scanner(System.in);
        
        int num_dados = input.nextInt();
        int tipo = input.nextInt();
        char cor = input.next().charAt(0);
        
        System.out.println("n = " + num_dados);
        System.out.println("tipo = " + tipo);
        System.out.println("cor = " + cor);
        
        Dado d = new Dado(1, 'v');
        
        MaquinaMolde moldador = new MaquinaMolde();
        MaquinaCorte cortador = new MaquinaCorte();
        MaquinaMontagem montador = new MaquinaMontagem();
        MaquinaPintura pintor = new MaquinaPintura();
       
        System.out.println("isMoldado? " + d.isMoldado());
        moldador.Processa(d);
        System.out.println("isMoldado? " + d.isMoldado());

        System.out.println("isPintado? " + d.isPintado());
        pintor.Processa(d);
        System.out.println("isPintado? " + d.isPintado());
        
        System.out.println("isCortado? " + d.isCortado());
        cortador.Processa(d);
        System.out.println("isCortado? " + d.isCortado());
        
        System.out.println("isMontado? " + d.isMontado());
        montador.Processa(d);
        System.out.println("isMontado? " + d.isMontado());
        
    }
    
    public static void main(String[] args) {
        Processando_Dados();
    }
}
