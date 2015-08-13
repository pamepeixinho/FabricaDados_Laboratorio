package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaPintura extends AbstractMaquina{

    public MaquinaPintura() {
        Liga();
    }

    public void Pinta(Dado d){
        d.setPintado(true);
    }
            
    @Override //annotation
    public Dado Processa(Dado d) {
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
        return d;
    }
    
    
}
