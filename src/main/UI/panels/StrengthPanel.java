package main.UI.panels;

import javax.swing.*;
import java.awt.*;

public class StrengthPanel extends JPanel {
    private final JLabel labelStrength;
    private final JLabel labelStrengthBar;
    private double strength;

    public StrengthPanel(double s){
        this.strength=s;
        this.setBounds(0,15, 200,15);
        this.setLayout(null);

        this.labelStrength = new JLabel("Force : " + this.strength);
        this.labelStrength.setBounds(20,0,200,15);

        JLabel labelStrengthImg = new JLabel(new ImageIcon("src/main/img/Window/Stat_Logos/strength_icon.png"));
        labelStrengthImg.setBounds(0,0,21,15);

        this.labelStrengthBar = new JLabel();
        this.labelStrengthBar.setOpaque(true);
        this.labelStrengthBar.setBackground(Color.blue);
        this.labelStrengthBar.setBounds(0,0,(int)(this.strength * 100),15);

        this.add(labelStrengthImg);
        this.add(this.labelStrength);
        this.add(this.labelStrengthBar);
    }

    public void updateStrength(double s){
        this.strength = s;
        this.labelStrength.setText("Force : " + this.strength);
        this.labelStrengthBar.setBounds(0,0,(int)(this.strength * 100),15);
        this.repaint();
    }
}
