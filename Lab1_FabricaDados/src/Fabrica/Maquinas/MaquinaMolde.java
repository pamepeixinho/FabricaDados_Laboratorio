package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMolde extends AbstractMaquina{

    public MaquinaMolde(){
    }
    
    @Override //annotation 
    public void Processa(Dado d) {
       if(!d.isMoldado())
           d.Molda();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
