package Perguntas;

import java.util.ArrayList;

public class Ciencia extends Pergunta{

    public Ciencia(String categoria, String pergunta, ArrayList<String> opcoes, String correta) {
        super(categoria, pergunta, opcoes, correta);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += getPontuacaoBase() + 5;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
