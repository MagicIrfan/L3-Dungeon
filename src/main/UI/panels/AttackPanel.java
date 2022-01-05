package main.UI.panels;

import javax.swing.*;
import java.awt.*;

public class AttackPanel extends JPanel {
    private final JLabel labelAttack;
    private final JLabel labelAttackBar;
    private double attack;

    public AttackPanel(double a){
        this.attack=a;
        this.setBounds(0,30,200,15);
        this.setLayout(null);

        this.labelAttack = new JLabel("Attaque : " + this.attack);
        this.labelAttack.setBounds(20,0,200,15);

        JLabel labelAttackImg = new JLabel(new ImageIcon("src/main/img/Window/Stat_Logos/attack_logo.png"));
        labelAttackImg.setBounds(0,0,21,15);

        this.labelAttackBar = new JLabel();
        this.labelAttackBar.setOpaque(true);
        this.labelAttackBar.setBackground(Color.RED);
        this.labelAttackBar.setBounds(0,0, (int) (this.attack * 10),15);

        this.add(labelAttackImg);
        this.add(this.labelAttack);
        this.add(this.labelAttackBar);
    }

    public void updateAttack(double a){
        this.attack = a;
        this.labelAttack.setText("Attaque : " + this.attack);
        this.labelAttackBar.setBounds(0,0, (int) (this.attack * 10),15);
        this.repaint();
    }
}
