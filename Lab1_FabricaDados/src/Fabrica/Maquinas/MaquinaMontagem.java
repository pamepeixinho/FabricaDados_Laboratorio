
package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMontagem extends AbstractMaquina{

    public MaquinaMontagem() {
        Liga();
    }
    
    public void Monta(Dado d){
        d.setMontado(true);
    }
    
    @Override //annotation
    public Dado Processa(Dado d) {
        if(!d.isMontado()){
            try{
               Thread.sleep(45);
           }
           catch(InterruptedException e){}   
            Monta(d);
        }
        return d;           
    }
}
