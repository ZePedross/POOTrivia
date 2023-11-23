package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int screenWidth = 768;
    int screenHeight = 576;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }
}
