package main.inventory;

import main.Entities.Hero;
import main.Items.Item;

import java.util.*;

public class Inventory
{
    private final List<Item> items;
    private final int limit;
    private final InventoryPanel panel;
    public Inventory(Hero user){
        this.limit = 9;
        this.items = new ArrayList<>(limit);
        this.panel = new InventoryPanel(200,200,this,user);

    }

    public void add(Item item){
        if (!isFull()) {
            items.add(item);
            System.out.println("Taille : " + items.size());
            panel.addLast(item);
        }

    }

    public void remove(Item item){
        items.remove(item);
        System.out.println("Taille : " + items.size());
    }

    public boolean isFull() {
        return limit == items.size();
    }

    public List<Item> getItems(){
        return items;
    }

    public int getLimit() {
        return limit;
    }

    public InventoryPanel panel(){
        return panel;
    }

}
