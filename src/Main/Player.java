package Main;

public class Player {

    protected String name;

    protected int pontuacao;

    public Player(String name, int pontuacao) {
        this.name = name;
        this.pontuacao = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Username: " + getName() + "\nPontuação: " + getPontuacao();
    }
}
