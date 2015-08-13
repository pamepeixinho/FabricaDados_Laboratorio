package Fabrica.Produto;

import Fabrica.Maquinas.*;

public class DadosMaker {
    
    public static void main(String[] args) {
        MaquinaMolde moldador = new MaquinaMolde();
        
        Dado d = new Dado("CC1010", 'V', 1);
        System.out.println("isMoldado? " + d.isMoldado());
        moldador.Processa(d);
        System.out.println("isMoldado? " + d.isMoldado());
    }
}
