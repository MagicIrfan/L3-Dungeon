package main.Entities;

import main.Items.Item;
import main.UI.windows.Game_Window;
import main.inventory.Inventory;
import main.observer.EventManager;
import main.states.Exploring;
import main.Items.weapons.Pickaxe;
import main.Items.weapons.Weapon;
import main.utils.Sprite;

import javax.swing.*;
import java.awt.*;

public class Hero implements Entity {
	private double health;
	private double strength;
	private int nbPoints;
	private final double resistance;
	private double attack;
	private Weapon weapon;
	private Sprite sprite;
	public ImageIcon hero_pic;
	private int posx;
	private int posy;
	private Exploring explore;
	private boolean isHeroDead;
	private boolean isWin;
	private final Inventory inventory;
	private EventManager manager;
	private final Game_Window win;
	public Hero(Game_Window parent){
		this.posx = 120;
		this.posy = 180;
		this.win = parent;
		this.isHeroDead=false;
		this.isWin = false;
		this.health = 50;
		this.strength = 1.2;
		this.resistance = 14;
		this.nbPoints=0;
		this.weapon = new Pickaxe();
		this.weapon.setWeaponEquip(true);
		this.attack = weapon.damageWeapon() * strength;
		this.sprite = new Sprite("src/main/img/Hero/hero.png");
		this.hero_pic = new ImageIcon("src/main/img/Hero/heroFull.png");
		Dimension size = this.sprite.getSprite().getPreferredSize();
		this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		this.inventory = new Inventory(this);
	}

	public void setManager(EventManager manager){
		this.manager = manager;
	}

	public Sprite getSprite(){
		return sprite;
	}

	public boolean isDead(){
		return this.isHeroDead;
	}
	public void setDead(boolean e){
		this.isHeroDead = e;
	}
	public void setExplore(Exploring e){
		this.explore=e;
	}
	public double getHealth(){
		return this.health;
	}

	public int getNbPoints(){return this.nbPoints;}
	public void setNbPoints(int nb){ this.nbPoints = this.nbPoints + nb;}


	public double getStrength(){
		return this.strength;
	}
	
	public void setStrength(double newStrength){
		this.strength = newStrength;
		manager.notify("Strength",strength);
	}
	
	public void setHealth(double newHealth){
		if(newHealth<50) {
			this.health = newHealth;
			if(newHealth<=0) {
				this.setDead(true);
				this.health=0;
			}
		}
		else
			this.health = 50;
		manager.notify("HP",health);
	}

	public void setIsWin(boolean e){
		this.isWin = e;
	}
	public boolean getIsWin(){return this.isWin;}

	public double getAttack(){
		return this.attack;
	}
	
	public double getResistance(){
		return this.resistance;
	}
	
	public void attackMonster(Monster m){
		m.setHealth(m.getHealth()-this.attack);
	}
	
	public void setWeapon(Weapon newWeapon){
		this.weapon.setWeaponEquip(false);
		this.weapon = newWeapon;
		this.attack = weapon.damageWeapon() * strength;
		manager.notify("Attack",attack);
		this.weapon.setWeaponEquip(true);
	}


	public void goNorth(){
		if(!explore.isObjectOnNorth() && !isWin && !isHeroDead)
		{
			posy = posy-60;
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
			explore.isMonsterNearby(win);
			explore.isHeroOnDoor();
			explore.isHeroOnTrap(win);
			explore.isOnChest();
			explore.isOnTrophy(win);
			// System.out.println("x :"+this.posx+" / y :"+this.posy);
		}
		else
		{
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		}
	}

	public void goSouth(){
		if(!explore.isObjectOnSouth()  && !isWin && !isHeroDead)
		{
			posy = posy+60;
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
			explore.isMonsterNearby(win);
			explore.isHeroOnDoor();
			explore.isHeroOnTrap(win);
			explore.isOnChest();
			explore.isOnTrophy(win);
			// System.out.println("x :"+this.posx+" / y :"+this.posy);
		}
		else
		{
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		}
	}

	public void goEast()
	{
		if(!explore.isObjectOnRight() && !isWin && !isHeroDead)
		{
			posx = posx+60;
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
			explore.isMonsterNearby(win);
			explore.isHeroOnDoor();
			explore.isHeroOnTrap(win);
			explore.isOnChest();
			explore.isOnTrophy(win);
			// System.out.println("x :"+this.posx+" / y :"+this.posy);
		}
		else
		{
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		}
	}

	public void goWest()
	{
		if(!explore.isObjectOnLeft() && !isWin && !isHeroDead)
		{
			posx = posx-60;
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
			explore.isMonsterNearby(win);
			explore.isHeroOnDoor();
			explore.isHeroOnTrap(win);
			explore.isOnChest();
			explore.isOnTrophy(win);
			// System.out.println("x :"+this.posx+" / y :"+this.posy);
		}
		else
		{
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		}
	}

	public int getPosX(){
		return this.posx;
	}
	
	public int getPosY(){
		return this.posy;
	}

	public Inventory getInventory(){
		return inventory;
	}

	public void Position(int posX, int posY)
	{
		this.posx = posX;
		this.posy = posY;
		Dimension size = this.sprite.getSprite().getPreferredSize();
		this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
	}

	public void useObject(Item item){
		item.use(this);
	}

}