
package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMontagem extends AbstractMaquina implements Runnable{

    public MaquinaMontagem() {
        Liga();
    }
    
    public void Monta(Dado d){
        d.setMontado(true);
    }
    
    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isMontado()){
            try{
               Thread.sleep(45);
           }
           catch(InterruptedException e){}   
            Monta(d);
        }
//        return d;           
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
