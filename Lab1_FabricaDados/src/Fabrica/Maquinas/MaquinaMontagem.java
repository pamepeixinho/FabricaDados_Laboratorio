
package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMontagem extends AbstractMaquina{

    public MaquinaMontagem() {
    }
    
    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isMontado())
            d.Monta();
    }
}
