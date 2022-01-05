package main.rooms.squares;

import main.Entities.Hero;
import main.Entities.Monster;
import main.Items.Item;
import main.generator.RandomItem;
import main.utils.Sprite;

import javax.swing.*;

public class Chest extends Game_Square {
    private final Item item;

    public Chest(int x,int y, int width, int height){
        this.item = new RandomItem().getItem();
        Sprite icon = new Sprite("src/main/img/Squares/coffre.png");
        JLabel label = icon.getSprite();
        this.setLayout(null);
        this.setBounds(x,y,width,height);
        label.setBounds(0,0,width,height);
        this.add(label);
    }

    public void drop(Hero player){

        player.getInventory().add(item);
        System.out.println("Vous avez droppé " + item.name());
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
        return null;
    }

}
