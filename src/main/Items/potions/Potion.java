package main.Items.potions;

import main.Entities.Hero;
import main.Items.Item;

public interface Potion extends Item {
	void effectRatio(Hero h);
}