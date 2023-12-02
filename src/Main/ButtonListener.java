package Main;

import Perguntas.Pergunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ButtonListener implements ActionListener {


    protected String resp;
    private GamePanel panel;
    private ArrayList<Pergunta> perguntas;

    private int pergunta = 0;

    public ButtonListener(GamePanel panel, ArrayList<Pergunta> perguntas) {
        this.panel = panel;
        this.perguntas = perguntas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Novo Jogo")) {
            novaPergunta(pergunta);
            pergunta++;
        }else if (e.getActionCommand().equals("Sair do Jogo")) {
            if (JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }else if (e.getActionCommand().equals(resp)) {
            novaPergunta(pergunta);
            pergunta++;
        }else if (e.getActionCommand().equals(resp) && pergunta == 5) {

        }
    }

    public void novaPergunta(int index) {
        panel.repaint();
        String cat = perguntas.get(index).getCategoria();
        String perg = perguntas.get(index).getPergunta();
        ArrayList<String> opcoes = perguntas.get(index).getOpcoes();
        resp = perguntas.get(index).getCorreta();
        Collections.shuffle(opcoes);
        if (opcoes.size() == 2) {
            panel.painelPerguntasVF(cat, perg, opcoes);
        } else {
            panel.painelPerguntasOpcoes(cat, perg, opcoes);
        }
    }
}

