package Perguntas;

import java.util.ArrayList;

public class Natacao extends Pergunta{

    public Natacao(String categoria, String pergunta, ArrayList<String> opcoes, String correta) {
        super(categoria, pergunta, opcoes, correta);
    }

    public void pontuacao(int pontuacao) {
        pontuacao += 13;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
