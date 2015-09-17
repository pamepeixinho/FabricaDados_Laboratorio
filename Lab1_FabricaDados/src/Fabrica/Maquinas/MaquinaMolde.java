package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMolde extends AbstractMaquina implements Runnable{

    public MaquinaMolde(){
        Liga();
    }

    public MaquinaMolde(Esteira input, Esteira output, String name) {
        super(input, output, name);
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
        Dado d;
        while(this.isLigado()){
//            System.out.println("Vou retirar " + this.name);
            try{
                d = input.receive();
            }
            catch(InterruptedException e){
//                System.out.println("Maquina " + name + " Finalizada");
                return;
            }
            catch( Exception e){
                System.out.println("Não foi possivel receber Dado da Máquina anterior");
                return;
            }
//            if(!this.isLigado())
//                return;
            //System.out.println("Retirei...processando " + this.nome);
            Processa(d);
            //System.out.println("Feito...enviando " + this.nome);
            output.submit(d);
//            System.out.println("Enviado " + this.name);

        }
    }
    
    
}
