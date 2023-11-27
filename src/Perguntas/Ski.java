package Perguntas;

import java.util.ArrayList;

public class Ski extends Pergunta{

    public Ski(String categoria, String pergunta, ArrayList<String> opcoes, String correta) {
        super(categoria, pergunta, opcoes, correta);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += 3 + getPontuacaoBase() * 2;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
