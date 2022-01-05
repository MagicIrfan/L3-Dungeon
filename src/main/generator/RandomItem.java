package main.generator;

import main.Items.potions.HealPotion;
import main.Items.Item;
import main.Items.potions.StrengthPotion;
import main.Items.weapons.Sword;
import main.Items.weapons.Axe;
import main.Items.weapons.Pickaxe;

import java.util.ArrayList;
import java.util.List;

public class RandomItem {
    private final List<Item> items;
    public RandomItem(){
        this.items = new ArrayList<>();
        this.items.add(new StrengthPotion());
        this.items.add(new Sword());
        this.items.add(new HealPotion());
        this.items.add(new Pickaxe());
        this.items.add(new Axe());
    }

    public Item getItem(){
        return items.get(getRandIndex());
    }

    public int getIndex(){
        return items.size();
    }

    public int getRandIndex(){
        return (int)(Math.random()*getIndex());
    }


}
