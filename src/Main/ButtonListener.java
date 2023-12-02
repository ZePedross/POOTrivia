package Main;

import Perguntas.Pergunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {


    protected String resp;
    private GamePanel panel;
    private ArrayList<Pergunta> pergunta;

    private int idx = 0;

    public ButtonListener(GamePanel panel,ArrayList<Pergunta> pergunta) {
        this.panel = panel;
        this.pergunta = pergunta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Novo Jogo")) {
            mostraPergunta(e);
        }else if(e.getActionCommand().equals("Sair do Jogo")) {
            if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }

    }

    private void mostraPergunta(ActionEvent e) {
        panel.repaint();
        Pergunta perguntatual = pergunta.get(idx);
        ArrayList<String> opcoesatuais = perguntatual.getOpcoes();
        if (perguntatual.getOpcoes().size() == 2) {
            panel.painelPerguntasVF(perguntatual.getPergunta(), opcoesatuais);
        } else {
            panel.painelPerguntasOpcoes(perguntatual.getPergunta(), opcoesatuais);
            if (e.getActionCommand().equals(perguntatual.getOpcoes().get(0))) {
                System.out.println("Boa");
            }
            e.getActionCommand().equals("panel.opc2");
            e.getActionCommand().equals(perguntatual.getOpcoes().get(2));
            e.getActionCommand().equals(perguntatual.getOpcoes().get(3));
            e.getActionCommand().equals(perguntatual.getOpcoes().get(4));
        }

    }
}

