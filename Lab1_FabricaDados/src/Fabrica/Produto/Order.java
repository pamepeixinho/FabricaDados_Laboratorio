/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica.Produto;

/**
 *
 * @author Victorroveda
 */
public class Order {
    
    int numDados;
    int tipo;
    char cor;

    public Order(int tipo, char cor, int numDados) {
        this.numDados = numDados;
        this.tipo = tipo;
        this.cor = cor;
    }

    public int getNumDados() {
        return numDados;
    }

    public void setNumDados(int numDados) {
        this.numDados = numDados;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public char getCor() {
        return cor;
    }

    public void setCor(char cor) {
        this.cor = cor;
    }
    
}
