
package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public class MaquinaMontagem extends AbstractMaquina implements Runnable{

    public MaquinaMontagem() {
        Liga();
    }

    public MaquinaMontagem(Esteira input, Esteira output, String name) {
        super(input, output, name);
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
//             return; 
            //System.out.println("Retirei...processando " + this.nome);
            Processa(d);
            //System.out.println("Feito...enviando " + this.nome);
            output.submit(d);
//            System.out.println("Enviado " + this.name);

        }
    }
}
