package Main;

import Perguntas.Pergunta;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    protected String name;

    protected String iniciaisnome;

    protected ArrayList<Pergunta> respostasDadas;

    private String dataeHora;


    public Player(String name, ArrayList<Pergunta> respostasDadas, String dataeHora) {
        this.name = name;
        this.respostasDadas = respostasDadas;
        this.iniciaisnome = getIniciaisnome();
        this.dataeHora = dataeHora;
    }

    public String getIniciaisnome() {
        String in = "";
        String nome = getName();
        for(int n = 0; n < nome.length(); n++){
            if(Character.isUpperCase(nome.charAt(n))){
                in += nome.charAt(n);
            }
        }
        return in;
    }

    public void setIniciaisnome(String iniciaisnome) {
        this.iniciaisnome = iniciaisnome;
    }

    public String getDataeHora() {
        return dataeHora;
    }

    public void setDataeHora(String dataeHora) {
        this.dataeHora = dataeHora;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pergunta> getRespostasDadas() {
        return respostasDadas;
    }

    public void setRespostasDadas(ArrayList<Pergunta> respostasDadas) {
        this.respostasDadas = respostasDadas;
    }

    @Override
    public String toString() {
        return "Username: " + getName() + "\nRespostas Dadas: " + getRespostasDadas();
    }
}
