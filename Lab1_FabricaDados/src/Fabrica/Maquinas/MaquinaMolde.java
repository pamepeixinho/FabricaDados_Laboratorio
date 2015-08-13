package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMolde extends AbstractMaquina{

    public MaquinaMolde(){
        Liga();
    }
    
    public void Molda(Dado d){
        d.setMoldado(true);
    }
    
    @Override //annotation 
    public Dado Processa(Dado d) {
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
       return d;
    }
    
    
}
