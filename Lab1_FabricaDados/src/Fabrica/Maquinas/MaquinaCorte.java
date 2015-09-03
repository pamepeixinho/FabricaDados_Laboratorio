package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaCorte extends AbstractMaquina implements Runnable{

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

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
