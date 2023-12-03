package Perguntas;

import java.util.ArrayList;

public abstract class Pergunta {

    protected String categoria, pergunta;

    protected ArrayList<String> opcoes;

    protected int pontuacaoBase, index;

    public Pergunta(String categoria, String pergunta, ArrayList<String> opcoes, int index){
        this.categoria = categoria;
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.pontuacaoBase = 5;
        this.index = index;
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
