package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaCorte extends AbstractMaquina{

    public MaquinaCorte() {
        Liga();
    }
    
    public void Corta(Dado d){
         d.setCortado(true);
    }
    
    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isCortado()){
            try{
                 Thread.sleep(20);
             }
             catch(InterruptedException e){}       
            Corta(d);
        }
//        return d;
    }
    
}
