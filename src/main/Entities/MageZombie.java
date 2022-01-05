package main.Entities;

import main.utils.Sprite;

import javax.swing.*;

public class MageZombie implements Monster{
	private double health;
	private final int nbPoints;
	private final double strength;
	private final double attack;
	private final double resistance;
	private final Sprite sprite;
	private final ImageIcon FullMonster;
	private boolean isMageDead;
	
	public MageZombie(){
		this.sprite = new Sprite("src/main/img/Squares/Monsters/mageZombie.png");
		this.FullMonster = new ImageIcon("src/main/img/Monters_Full/MageZombieFull.png");
		this.health = 15;
		this.nbPoints = 15;
		this.strength = 1;
		this.attack = 4;
		this.resistance = 5;
		this.isMageDead=false;
	}

	public boolean isDead(){
		return this.isMageDead;
	}
	public void setDead(boolean e){
		this.isMageDead = e;
	}

	@Override
	public Sprite getSprite() {
		return sprite;
	}

	public void attack(Hero h){
		h.setHealth((h.getHealth()-(this.attack * this.strength)));
	}
	
	public double getHealth(){
		return this.health;
	}
	
	public double getStrength(){
		return this.strength;
	}
	
	public void setHealth(double newHealth){
		this.health = newHealth;
		if(newHealth<=0)
			this.setDead(true);
	}

	@Override
	public ImageIcon getBigMonster() {
		return FullMonster;
	}

	@Override
	public int getnbPoints() {
		return this.nbPoints;
	}

	public double getAttack(){
		return this.attack*this.strength;
	}
	public double getResistance(){
		return this.resistance;
	}
	public void Position(int posX, int posY){}
}