/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica.Maquinas;

import Fabrica.Pedidos.*;
/**
 *
 * @author unifakhatib
 */
public class Gerenciador {
    private MaquinaCorte mCorte;
    private MaquinaMolde mMolde;
    private MaquinaMontagem mMontagem;
    private MaquinaPintura mPintura;

    public Gerenciador() {}
    public Gerenciador(Order pedido){
        mCorte = new MaquinaCorte();
        mMolde = new MaquinaMolde();
        mMontagem = new MaquinaMontagem();
        mPintura = new MaquinaPintura();
   
        
    }
    
   // private 
}
