package main.Items.potions;

import main.Entities.Hero;
import main.Items.Item;

import javax.swing.*;
import java.awt.*;

public class HealPotion implements Item {
	private final double ratio;
	public JLabel label;

	public HealPotion() {
		this.ratio = 8;
		ImageIcon image = new ImageIcon("src/main/img/Items/Potions/potion_heal.png");
		Image image2 = image.getImage().getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // transform it
		image.setImage(image2);
		this.label = new JLabel(image);
		this.label.setSize(60,60);
	}

	public void effectRatio(Hero h) {
		h.setHealth(h.getHealth() + this.ratio);
	}

	@Override
	public void use(Hero hero) {
		System.out.println("Ancienne vie : " + hero.getHealth());
		effectRatio(hero);

		System.out.println("Nouvelle vie : " + hero.getHealth());
	}

	@Override
	public String name() {
		return "potion2";
	}

	@Override
	public JLabel getLabel() {
		return label;
	}
}