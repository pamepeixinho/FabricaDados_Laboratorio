package Fabrica.Maquinas;

import Fabrica.Produto.Dado;

public abstract class AbstractMaquina{
    Esteira input;
    Esteira output;
    String name;
    
    public boolean ligado = false;

    public AbstractMaquina() {
    }

    public AbstractMaquina(Esteira input, Esteira output, String name) {
        this.input = input;
        this.output = output;
        this.name = name;
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

    public Esteira getInput() {
        return input;
    }
    public void setInput(Esteira input) {
        this.input = input;
    }
    
    public Esteira getOutput() {
        return output;
    }
    public void setOutput(Esteira output) {
        this.output = output;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
}
