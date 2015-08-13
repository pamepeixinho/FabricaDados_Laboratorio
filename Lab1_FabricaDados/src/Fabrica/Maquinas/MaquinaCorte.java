package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaCorte extends AbstractMaquina{

    public MaquinaCorte() {
    }

    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isCortado())
            d.Corta();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
