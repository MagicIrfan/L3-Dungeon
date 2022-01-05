package main.UI.panels;

import main.observer.EventListener;

import javax.swing.*;
import java.awt.*;

public class StatPanel extends JPanel implements EventListener {
    LifePanel life;
    StrengthPanel strengthP;
    AttackPanel attackP;

    public StatPanel(double hp,double strength,double attack){

        /*La barre de vie*/
        this.life = new LifePanel(hp);

        /*La force*/
        this.strengthP = new StrengthPanel(strength);

        /*L'attaque*/
        this.attackP = new AttackPanel(attack);

        this.setPreferredSize(new Dimension(200,50));
        this.setLayout(null);
        this.add(this.life);
        this.add(this.strengthP);
        this.add(this.attackP);
    }

    @Override
    public void update(String eventType, double attribute) {
        switch (eventType) {
            case "HP" -> this.life.updateHP(attribute);
            case "Strength" -> this.strengthP.updateStrength(attribute);
            case "Attack" -> this.attackP.updateAttack(attribute);
            default -> {
            }
        }
    }
}
