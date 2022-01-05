package main.Items.weapons;

import main.Entities.Hero;

import javax.swing.*;
import java.awt.*;

public class Sword implements Weapon {
	private final int attack;
	public JLabel label;
	
	public Sword(){
		this.attack = 10;
		ImageIcon image = new ImageIcon("src/main/img/Items/Weapons/epee.png");
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
		System.out.println("Nouvelle attaque : " + hero.getAttack());

	}

	@Override
	public String name() {
		return "Epee";
	}

	@Override
	public JLabel getLabel() {
		return label;
	}
}