package main.Items.potions;

import main.Entities.Hero;

import javax.swing.*;
import java.awt.*;

public class StrengthPotion implements Potion {
	private final double ratio;
	public JLabel label;
	
	public StrengthPotion(){
		this.ratio = 0.1;
		ImageIcon image = new ImageIcon("src/main/img/Items/Potions/potion_strength.png");
		Image image2 = image.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // transform it
		image.setImage(image2);
		this.label = new JLabel(image);
		this.label.setSize(60,60);
	}
	
	public void effectRatio(Hero h){
		h.setStrength(h.getStrength() + this.ratio);
	}

	@Override
	public void use(Hero hero) {
		effectRatio(hero);
		System.out.println("Nouvelle force : " + hero.getStrength());
	}

	@Override
	public String name() {
		return "potion";
	}

	@Override
	public JLabel getLabel() {
		return label;
	}

}