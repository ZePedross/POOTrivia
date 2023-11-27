package Perguntas;

import java.util.ArrayList;

public abstract class Pergunta {

    protected String categoria;

    protected String pergunta;

    protected ArrayList<String> opcoes;

    protected String correta;

    protected int pontuacaoBase;

    public Pergunta(String categoria, String pergunta, ArrayList<String> opcoes, String correta){
        this.categoria = categoria;
        this.pergunta = pergunta;
        this.opcoes = opcoes;
        this.correta = correta;
        this.pontuacaoBase = 5;
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

    public String getCorreta() {
        return correta;
    }

    public void setCorreta(String correta) {
        this.correta = correta;
    }

    public int getPontuacaoBase() {
        return pontuacaoBase;
    }

    public void setPontuacaoBase(int pontuacao) {
        this.pontuacaoBase = pontuacao;
    }

    public abstract void pontuacao(int pontuacao);

    @Override
    public String toString() {
        return "Categoria:" + categoria + "\nPergunta: " + pergunta + "\nOpcoes: " + opcoes + "\nOpção Correta:" + correta;
    }
}
