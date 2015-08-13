package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaPintura extends AbstractMaquina{

    public MaquinaPintura() {
    }

    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isPintado())
            d.Pinta();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
