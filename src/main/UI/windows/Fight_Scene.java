package main.UI.windows;
import main.Entities.Hero;
import main.Entities.Monster;

import javax.swing.*;

public class Fight_Scene extends JDialog{
    private final Hero hero;
    private final Monster monster;
    public Fight_Scene(Monster m, Hero h){
        this.hero=h;
        this.monster=m;
        Win_Fight();
    }

    public void Win_Fight(){
        this.setTitle("Jeux de donjon");
        this.setSize(500, 400);
        this.setResizable(false);
        this.setLayout(null);
        this.setContentPane(new JLabel(new ImageIcon("src/main/img/Window/fight_bg.png")));
        ImageIcon hero_Img = hero.hero_pic;
        JLabel heroLab = new JLabel(hero_Img);
        heroLab.setBounds(0,200,150,142);
        this.add(heroLab);

        JLabel monsterLab = new JLabel(monster.getBigMonster());
        monsterLab.setBounds(250,200,300,142);
        this.add(monsterLab);
        this.setLocationRelativeTo(null);


    }
}
