package main.rooms.squares;

import main.Entities.Monster;

import javax.swing.*;

public class Trap_Square extends Game_Square {

    public Trap_Square(int posx,int posy,int length,int height){
        this.setBounds(posx,posy,length,height);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon("src/main/img/Squares/trap.png");
        JLabel img = new JLabel(icon);
        img.setBounds(0,0,length,height);
        this.add(img);
    }

    public int getDamage(){
        return 2;
    }

    @Override
    public Monster getMonster() {
        return null;
    }

    @Override
    public Door_Square isDoor() {
        return null;
    }

    @Override
    public Trap_Square isTrap() {
        return this;
    }

}
