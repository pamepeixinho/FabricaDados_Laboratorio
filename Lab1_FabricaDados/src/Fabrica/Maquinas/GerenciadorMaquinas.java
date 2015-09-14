
package Fabrica.Maquinas;

import Fabrica.Pedidos.*;
import Fabrica.Produto.Dado;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;


public class GerenciadorMaquinas {
    //Maquinas Threads
    private final Thread [] mMolde; 
    private final Thread [] mPintura;
    private final Thread [] mCorte;
    private final Thread [] mMontagem;
    
    //Object - ArrayBlockingList
    private final Esteira [] esteira;
    
    //Pedido
    private Order pedido;
    
    
    public GerenciadorMaquinas(int qM1, int qM2, int qM3, int qM4) {
        this.mMolde = new Thread[qM1];
        this.mPintura = new Thread[qM2];
        this.mCorte = new Thread[qM3];
        this.mMontagem = new Thread[qM4];
        this.esteira = new Esteira[qM1 + qM2 + qM3 + qM4 + 1];
    }
    
    public GerenciadorMaquinas(Order pedido, int qM1, int qM2, int qM3, int qM4){
        this.pedido = pedido;
        this.mMolde = new Thread[qM1];
        this.mPintura = new Thread[qM2];
        this.mCorte = new Thread[qM3];
        this.mMontagem = new Thread[qM4];
        this.esteira = new Esteira[qM1 + qM2 + qM3 + qM4 + 1];
    }
        
    @SuppressWarnings("empty-statement")
    public ArrayList<Dado> execute(){
        int k = 0, numDados = pedido.getNumDados();
        
        ArrayBlockingQueue<Dado> d= new ArrayBlockingQueue<>(pedido.getNumDados());
        
        for(int i = 0; i < numDados; i++)
            d.add(new Dado(pedido.getTipo(),pedido.getCor()));
                
        for(int i = 0; i < esteira.length; i++ )
            esteira[i] = new Esteira(numDados);

        for(int i = 0; i < mMolde.length; i++){
            mMolde[i] = new Thread(new MaquinaMolde(esteira[k],esteira[k+1],("M" + (k+1) + " - Molde")));
            k++;
            mMolde[i].start();
        }
        
        for(int i = 0; i < mPintura.length; i++){
            mPintura[i] = new Thread(new MaquinaPintura(esteira[k],esteira[k+1],("M" + (k+1) + " - Pintura")));    
            k++;
            mPintura[i].start();
        }
        
        for(int i = 0; i < mCorte.length; i++){
            mCorte[i] = new Thread(new MaquinaCorte(esteira[k],esteira[k+1],("M" + (k+1) + " - Corte")));
            k++;
            mCorte[i].start();
        }
        
        for(int i = 0; i < mMontagem.length; i++){
            mMontagem[i] = new Thread(new MaquinaMontagem(esteira[k],esteira[k+1],("M" + (k+1) + " - Montagem")));    
            k++;
            mMontagem[i].start();
        }

        esteira[0].addAll(d);
        
        while(esteira[esteira.length - 1].size() < numDados)
            ;
        
//        System.out.println("Terminaram os Dados");
               
        for (Thread mMolde1 : mMolde) 
            mMolde1.interrupt();
              
        for (Thread mPintura1 : mPintura)
            mPintura1.interrupt();
        
        for (Thread mCorte1 : mCorte)
            mCorte1.interrupt();
       
        for (Thread mMontagem1 : mMontagem)
            mMontagem1.interrupt();
        
        
        ArrayList<Dado> d1 = new ArrayList<>(esteira[esteira.length-1]);        
        return d1;
        
    }
    
    public final void teste(){
        int n = 2, k = 0;
        for(int i = 0; i < esteira.length; i++ )
            esteira[i] = new Esteira(n);

       
        for(int i = 0; i < mMolde.length; i++){
            mMolde[i] = new Thread(new MaquinaMolde(esteira[k],esteira[k+1],("M" + (k+1) + " - Molde")));
            k++;
            mMolde[i].start();
         
        }
        
        for(int i = 0; i < mPintura.length; i++){
            mPintura[i] = new Thread(new MaquinaPintura(esteira[k],esteira[k+1],("M" + (k+1) + " - Pintura")));    
            k++;
            mPintura[i].start();
            
        }
        
        for(int i = 0; i < mCorte.length; i++){
            mCorte[i] = new Thread(new MaquinaCorte(esteira[k],esteira[k+1],("M" + (k+1) + " - Corte")));
            k++;
            mCorte[i].start();
            
        }
        
        for(int i = 0; i < mMontagem.length; i++){
            mMontagem[i] = new Thread(new MaquinaMontagem(esteira[k],esteira[k+1],("M" + (k+1) + " - Montagem")));    
            k++;
            mMontagem[i].start();
        }

        
        for(int i = 0; i < n; i++)
            esteira[0].add(new Dado(1,'p'));
        
        while(esteira[esteira.length - 1].size() < n){
        }
        
        System.out.println("Terminaram os Dados");
               
        for (Thread mMolde1 : mMolde) {
            mMolde1.interrupt();
        }
             
        for (Thread mPintura1 : mPintura) {
            mPintura1.interrupt();
        }
        
        for (Thread mCorte1 : mCorte) {
            mCorte1.interrupt();
        }
            
        for (Thread mMontagem1 : mMontagem) {
            mMontagem1.interrupt();
        }

    }
    
    public Order getPedido() {
        return pedido;
    }

    public void setPedido(Order pedido) {
        this.pedido = pedido;
    }

//    public static void main(String [] args){
////       GerenciadorMaquinas gm = new GerenciadorMaquinas(1,2,1,1);
////       gm.teste();
//    }
//    
   
}
