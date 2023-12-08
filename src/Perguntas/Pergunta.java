package Perguntas;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Pergunta implements Serializable {

    protected String categoria, pergunta;

    protected ArrayList<String> opcoes;

    protected int pontuacaoBase, index;

    protected boolean acertou;

    public Pergunta(String categoria, String pergunta, ArrayList<String> opcoes, int index, int pontuacaoBase){
        this.categoria = categoria;
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.pontuacaoBase = pontuacaoBase;
        this.index = index;
    }

    public void setAcertou() {
        this.acertou = true;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public int getPontuacaoBase() {
        return pontuacaoBase;
    }

    public void setPontuacaoBase(int pontuacao) {
        this.pontuacaoBase = pontuacao;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public abstract ArrayList<String> getOpcoes();

    public abstract void setOpcoes(ArrayList<String> opcoes);

    public abstract String getCorreta();

    public abstract int pontuacao();

    @Override
    public String toString() {
        return "Pergunta " + getIndex() + "\nCategoria: " + getCategoria() + "\nPergunta: " + getPergunta() + "\nOpcoes: " + getOpcoes();
    }
}
