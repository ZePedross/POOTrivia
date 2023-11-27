package Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Pergunta {

    protected String[] pergunta;

    public Pergunta(String[] pergunta){
        this.pergunta = pergunta;
    }

    @Override
    public String toString() {
        return Arrays.toString(pergunta);
    }
}
