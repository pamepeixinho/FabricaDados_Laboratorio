/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica.Maquinas;

import Fabrica.Pedidos.*;
import Fabrica.Produto.Dado;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author unifakhatib
 */
public class GerenciadorMaquinas {
    private MaquinaCorte mCorte;
    private MaquinaMolde mMolde;
    private MaquinaMontagem mMontagem;
    private MaquinaPintura mPintura;
    private Esteira e1;
    private Esteira e2;
    private Esteira e3;
    private Esteira e4;
    private Esteira e5;
    

    public GerenciadorMaquinas() {
        this.teste();
    }
    public GerenciadorMaquinas(Order pedido){
    }
    
    public final void teste(){
        int n = 2;
        e1 = new Esteira(10);
        e2 = new Esteira(10);
        e3 = new Esteira(10);
        e4 = new Esteira(10);
        e5 = new Esteira(10);
        
        mMolde = new MaquinaMolde(e1,e2,"M1");
        mPintura = new MaquinaPintura(e2,e3,"M2");
        mCorte = new MaquinaCorte(e3,e4,"M3");
        mMontagem = new MaquinaMontagem(e4,e5,"M4");
             
        Thread m3 = new Thread(mCorte);
        Thread m1 = new Thread(mMolde);
        Thread m4 = new Thread(mMontagem);
        Thread m2 = new Thread(mPintura);
        
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        
        for(int i = 0; i < n; i++)
            e1.add(new Dado(1,'p'));
        
        while(e5.size() < n){
        }
        System.out.println("Terminaram os Dados");
        
        mCorte.Desliga();
        mPintura.Desliga();
        mMolde.Desliga();
        mMontagem.Desliga();

//        e1.wakeUpAll();
//        e2.wakeUpAll();
//        e3.wakeUpAll();
//        e4.wakeUpAll();
//        e5.wakeUpAll();
        
        m1.interrupt();
        m2.interrupt();
        m3.interrupt();
        m4.interrupt();

    }
    
    public static void main(String [] args){
       GerenciadorMaquinas gm = new GerenciadorMaquinas();
       
    }
    
   
}
