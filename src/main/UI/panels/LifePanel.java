package main.UI.panels;

import javax.swing.*;
import java.awt.*;

public class LifePanel extends JPanel{
    private final JLabel labelHPtext;
    private final JLabel labelHealthBar;
    private double HP;

    public LifePanel(double hp) {
        this.HP = hp;
        /*Barre de vie*/
        this.setBounds(0,0, 200,15);
        this.setLayout(null);

        this.labelHPtext = new JLabel("HP :" + this.HP);
        this.labelHPtext.setBounds(20,0,200,15);

        JLabel labelHPImg = new JLabel(new ImageIcon("src/main/img/Window/Stat_Logos/heart.png"));
        labelHPImg.setBounds(0,0,21,15);

        this.labelHealthBar = new JLabel();
        this.labelHealthBar.setOpaque(true);
        this.labelHealthBar.setBackground(Color.GREEN);
        this.labelHealthBar.setBounds(0,0, (int) (this.HP * 4),15);

        this.add(labelHPImg);
        this.add(this.labelHPtext);
        this.add(labelHealthBar);
    }

    public void updateHP(double HP){
        this.HP = HP;
        this.labelHPtext.setText("HP : "+ this.HP);
        this.labelHealthBar.setBounds(0,0, (int) (this.HP * 4),15);
        this.repaint();
    }
}
