package main.Items.weapons;

import main.Entities.Hero;

import javax.swing.*;
import java.awt.*;

public class Pickaxe implements Weapon {
	private final int attack;
	public JLabel label;
	
	public Pickaxe(){
		this.attack = 4;
		ImageIcon image = new ImageIcon("src/main/img/Items/Weapons/pickaxe.png");
		Image image2 = image.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // transform it
		image.setImage(image2);
		this.label = new JLabel(image);
		this.label.setSize(60,60);
	}
	
	public int damageWeapon(){
		return this.attack;
	}
	
	public void setWeaponEquip(boolean e){
	}

	@Override
	public void use(Hero hero) {
		hero.setWeapon(this);

	}

	@Override
	public String name() {
		return "pioche";
	}

	@Override
	public JLabel getLabel() {
		return label;
	}
}