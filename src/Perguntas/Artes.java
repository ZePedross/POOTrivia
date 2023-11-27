package Perguntas;

import java.util.ArrayList;

public class Artes extends Pergunta{

    public Artes(String categoria, String pergunta, ArrayList<String> opcoes, String correta) {
        super(categoria, pergunta, opcoes, correta);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += getPontuacaoBase() * 10;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
