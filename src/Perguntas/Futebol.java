package Perguntas;

import java.util.ArrayList;

public class Futebol extends Pergunta{

    public Futebol(String categoria, String pergunta, ArrayList<String> opcoes, String correta) {
        super(categoria, pergunta, opcoes, correta);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += 3 + 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
