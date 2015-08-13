package Fabrica.Produto;

import java.util.concurrent.atomic.AtomicReference;

public class Dado extends AtomicReference{

    public Dado(String cod_dado, char cor, int tipo, Object initialValue) {
        super(initialValue);
        this.cod_dado = cod_dado;
        this.cor = cor;
        this.tipo = tipo;
    }

    public Dado() {
    }
    
    public Dado(String cod_dado, char cor, int tipo) {
        this.cod_dado = cod_dado;
        this.cor = cor;
        this.tipo = tipo;
        this.cortado = false;
        this.moldado = false;
        this.montado = false;
        this.pintado = false;
    }
      
    //Dados Feature
    private String cod_dado;
    private char cor;
    private int tipo;
    
    //Process Step
    private boolean moldado;
    private boolean cortado;
    private boolean montado; //montado -> dobrado
    private boolean pintado;

    public String getCod_dado() {
        return cod_dado;
    }
    public void setCod_dado(String cod_dado) {
        this.cod_dado = cod_dado;
    }

    public char getCor() {
        return cor;
    }
    public void setCor(char cor) {
        this.cor = cor;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isMoldado() {
        return moldado;
    }
    public void setMoldado(boolean moldado) {
        this.moldado = moldado;
    }
    public void Molda(){
        this.moldado = true;
    }

    public boolean isCortado() {
        return cortado;
    }
    public void setCortado(boolean cortado) {
        this.cortado = cortado;
    }
    public void Corta(){
        this.cortado = true;
    }
    
    public boolean isMontado() {
        return montado;
    }
    public void setMontado(boolean montado) {
        this.montado = montado;
    }
    public void Monta(){
        this.montado = true;
    }
    
    public boolean isPintado() {
        return pintado;
    }
    public void setPintado(boolean pintado) {
        this.pintado = pintado;
    }
    public void Pinta(){
        this.pintado = true;
    }
    
}
