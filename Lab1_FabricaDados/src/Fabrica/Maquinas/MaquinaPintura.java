package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaPintura extends AbstractMaquina implements Runnable{

    public MaquinaPintura() {
        Liga();
    }

    public void Pinta(Dado d){
        d.setPintado(true);
    }
            
    @Override //annotation
    public void Processa(Dado d) {
        if(!d.isPintado()){
            if(d.getCor() == 'v'){
                             try{
                   Thread.sleep(35);
               }
               catch(InterruptedException e){}   
            }
            else if (d.getCor() == 'p'){
                             try{
                   Thread.sleep(35);
               }
               catch(InterruptedException e){}   
            }
            else if(d.getCor() == 'e'){
                             try{
                   Thread.sleep(45);
               }
               catch(InterruptedException e){}   
            }
            Pinta(d);
        }
//        return d
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
