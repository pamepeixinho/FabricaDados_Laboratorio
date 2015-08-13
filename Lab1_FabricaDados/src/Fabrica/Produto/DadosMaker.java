package Fabrica.Produto;

import Fabrica.Maquinas.*;
import java.time.Clock;

public class DadosMaker {
    private Clock clock;
    
    public static void Processando_Dados(){
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
        
        System.out.println("isPintor? " + d.isPintado());
        pintor.Processa(d);
        System.out.println("isPintor? " + d.isPintado());
    }
    
    public static void main(String[] args) {
        Processando_Dados();
    
    }
}
