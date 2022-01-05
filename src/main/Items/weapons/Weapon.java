package main.Items.weapons;

import main.Items.Item;

public interface Weapon extends Item {
	int damageWeapon();
	void setWeaponEquip(boolean e);
}