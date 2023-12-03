package Main;

import java.util.ArrayList;

public class Player {

    protected String name;

    protected ArrayList<String> respostasDadas;

    protected int pontuacao;

    public Player(String name, ArrayList<String> respostasDadas) {
        this.name = name;
        this.respostasDadas = respostasDadas;
        this.pontuacao = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getRespostasDadas() {
        return respostasDadas;
    }

    public void setRespostasDadas(ArrayList<String> respostasDadas) {
        this.respostasDadas = respostasDadas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Username: " + getName() + "\nRespostas Dadas: " + getRespostasDadas();
    }
}
