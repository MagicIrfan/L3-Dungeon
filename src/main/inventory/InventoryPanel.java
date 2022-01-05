package main.inventory;

import main.Entities.Hero;
import main.Items.Item;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class InventoryPanel extends JPanel
{
    private final List<ItemSlot> slots;
    private final int limit;

    public InventoryPanel(int width, int height, Inventory inventory, Hero user){
        this.limit = inventory.getLimit();
        this.slots = new ArrayList<>(limit);
        this.setLayout(new GridLayout(limit/3,limit/3));
        this.setPreferredSize(new Dimension(width,height));
        this.create(user);
        this.draw();
    }

    public ItemSlot at(int index){
        return slots.get(index);
    }


    public void addLast(Item item){
        ItemSlot current;
        for(int index = 0; index < limit; index++){
            if(at(index).isEmpty()) {
                current = at(index);
                current.setItem(item);
                break;
            }
        }


    }

    public void create(Hero user){
        for(int index = 0; index < limit; index++) {
            slots.add(new ItemSlot(user));
        }
    }

    public void draw()
    {
        for(int i=0; i<limit; ++i){
            this.add(slots.get(i));
        }
    }

}




