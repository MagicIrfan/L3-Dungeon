package main.Entities;

import main.utils.Sprite;

import javax.swing.*;

public class FireGolem implements Monster {
	private double health;
	private final int nbPoints;
	private final double strength;
	private final double attack;
	private final double resistance;
	private final Sprite sprite;
	private final ImageIcon FullMonster;
	private boolean isFireGolemDead;
	
	public FireGolem(){
		this.health = 50;
		this.nbPoints = 50;
		this.strength = 0.5;
		this.attack = 15;
		this.resistance = 12;
		this.sprite = new Sprite("src/main/img/Squares/Monsters/fireGolem.png");
		this.FullMonster = new ImageIcon("src/main/img/Monters_Full/FireGolemFull.png");
		this.isFireGolemDead=false;
	}
	public boolean isDead(){
		return this.isFireGolemDead;
	}
	public void setDead(boolean e){
		this.isFireGolemDead = e;
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