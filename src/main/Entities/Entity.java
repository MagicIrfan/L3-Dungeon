package main.Entities;

import main.utils.Sprite;

public interface Entity{
	void Position(int posX, int posY);
	double getHealth();
	double getStrength();
	double getResistance();
	double getAttack();
	void setHealth(double e);
	boolean isDead();
	void setDead(boolean e);
	Sprite getSprite();
}