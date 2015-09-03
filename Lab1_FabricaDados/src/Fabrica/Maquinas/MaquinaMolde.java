package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMolde extends AbstractMaquina implements Runnable{

    public MaquinaMolde(){
        Liga();
    }
    
    public void Molda(Dado d){
        d.setMoldado(true);
    }
    
    @Override //annotation 
    public void Processa(Dado d) {
       if(!d.isMoldado()){
           if(d.getTipo() == 2){
             try{
                   Thread.sleep(50);
               }
               catch(InterruptedException e){}   
           }
           else if(d.getTipo() == 1){
               try{
                   Thread.sleep(30);
               }
               catch(InterruptedException e){}   
           }
           Molda(d);
           
        }
//       return d;
    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
