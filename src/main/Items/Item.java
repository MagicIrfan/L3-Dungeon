package main.Items;

import main.Entities.Hero;

import javax.swing.*;

public interface Item {
    void use(Hero hero);
    String name();

    JLabel getLabel();

}
