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

    public ArrayList<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(ArrayList<String> opcoes) {
        this.opcoes = opcoes;
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

    public abstract String getCorreta();

    public abstract void pontuacao(int pontuacao);

    @Override
    public String toString() {
        return "Pergunta " + getIndex() + "\nCategoria: " + getCategoria() + "\nPergunta: " + getPergunta() + "\nOpcoes: " + getOpcoes();
    }
}
