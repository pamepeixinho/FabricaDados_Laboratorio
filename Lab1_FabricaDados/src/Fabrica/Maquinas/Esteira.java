package Fabrica.Maquinas;

import Fabrica.Produto.Dado;
import java.util.concurrent.ArrayBlockingQueue;

public class Esteira extends ArrayBlockingQueue<Dado>{
        
    public Esteira(int qntDados) {
        super(qntDados);
    }

    public Esteira(int qntDados, boolean fair) {
        super(qntDados, fair);
    }
    
    public Dado receive() throws InterruptedException{
        return this.take();        
    }
    
    public void submit(Dado d){
        this.add(d);
    }
    
    public void wakeUpAll(){
       synchronized(this){
           this.notifyAll();
       } 
    }
    
    public void wakeUp(){
       synchronized(this){
           this.notify();
       } 
    }
    
}
