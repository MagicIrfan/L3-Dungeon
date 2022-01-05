package main.Entities;

import javax.swing.*;

public interface Monster extends Entity {
	void attack(Hero h);
	ImageIcon getBigMonster();
	int getnbPoints();
}