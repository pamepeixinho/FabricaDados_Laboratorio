package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaPintura extends AbstractMaquina implements Runnable{

    public MaquinaPintura() {
        Liga();
    }

    MaquinaPintura(Esteira input, Esteira output, String name) {
        super(input, output, name);
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
                System.out.println("Não foi possivel receber dado da Máquina anterior");
                return;
            }
                
            //System.out.println("Retirei...processando " + this.nome);
            Processa(d);
            //System.out.println("Feito...enviando " + this.nome);
            output.submit(d);
//            System.out.println("Enviado " + this.name);
        }
    }
    
    
}
