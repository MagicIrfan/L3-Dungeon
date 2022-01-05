package main.inventory;

import main.Entities.Hero;
import main.Items.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ItemSlot extends JPanel implements MouseListener{

    private Item item;
    private final Hero user;
    public ItemSlot(Hero user){
        this.user = user;
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        addMouseListener(this);
    }

    public void setItem(Item item){
        this.item = item;
        System.out.println(item);
        this.add(item.getLabel());
    }

    public void useItem(Hero hero){
        hero.useObject(item);
    }

    public boolean isEmpty(){
        return item == null;
    }

    public void clearPanel(){
        this.item = null;
        for(int index = 0; index < getComponentCount(); index++){
            remove(index);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(!isEmpty())
        {
            if(e.getButton() == 1)
                useItem(user);
            user.getInventory().remove(item);
            clearPanel();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Color.BLACK);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(Color.WHITE);
    }
}
