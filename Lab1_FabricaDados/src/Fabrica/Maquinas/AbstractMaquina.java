package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public abstract class AbstractMaquina{
    public boolean ligado = false;

    public AbstractMaquina() {
    }

    public boolean isLigado() {
        return this.ligado;
    }
    
    public void Liga() {
        this.ligado = true;
    }
    public void Desliga(){
        this.ligado = false;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    
    //polimorfismo - abstract - (Processa) o dado fazendo a devida ação
    public abstract void Processa(Dado d);
}
