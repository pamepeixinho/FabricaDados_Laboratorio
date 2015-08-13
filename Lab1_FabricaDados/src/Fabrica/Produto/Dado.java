package Fabrica.Produto;

//import java.util.concurrent.atomic.AtomicInteger;;
import java.util.concurrent.atomic.AtomicReference;

public class Dado extends AtomicReference{


    //Dados Feature
    private String cod_dado;
    private char cor;
    private int tipo;
    
    //Process Step
    private boolean moldado;
    private boolean cortado;
    private boolean montado; //montado -> dobrado
    private boolean pintado;

    
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
     
    public Dado(int tipo, char cor) {

        this.cod_dado = "Dado" + cor;
        if (tipo == 1)
            this.cod_dado+="P";
        else 
            this.cod_dado+="G";
        
        this.cod_dado+= (int) Math.floor(Math.random()*10000);
        
        System.out.println("COD_DADO = " + cod_dado);
        
        this.cor = cor;
        this.tipo = tipo;
        this.cortado = false;
        this.moldado = false;
        this.montado = false;
        this.pintado = false;
    }

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

    public boolean isCortado() {
        return cortado;
    }
    public void setCortado(boolean cortado) {
        this.cortado = cortado;
    }

    
    public boolean isMontado() {
        return montado;
    }
    public void setMontado(boolean montado) {
        this.montado = montado;
    }
    
    public boolean isPintado() {
        return pintado;
    }
    public void setPintado(boolean pintado) {
        this.pintado = pintado;
    }

    
}
