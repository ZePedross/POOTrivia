package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    protected String resp;

    @Override
    public void actionPerformed(ActionEvent e) {
        GamePanel panel = new GamePanel();
        POOTrivia pooTrivia = new POOTrivia();
        if(e.getActionCommand().equals("Novo Jogo")) {

        }else if(e.getActionCommand().equals("Sair do Jogo")) {
            if(JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair?", "Sair", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
    }
}
