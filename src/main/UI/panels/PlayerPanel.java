package main.UI.panels;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    public PlayerPanel(int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        JLabel behindHero = new JLabel(new ImageIcon("src/main/img/Window/bg_hero.png"));
        behindHero.setPreferredSize(new Dimension(width,height));
        this.add(behindHero);
    }
}
