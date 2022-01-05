package main.rooms.squares;

import main.Entities.*;
import main.Entities.Werewolf;

import javax.swing.*;
import java.util.Random;

public class Monster_Square extends Game_Square {

	private Monster m;
	
	public Monster_Square(int posx,int posy,int length,int height){
		setMonster();
		this.setBounds(posx,posy,length,height);
		this.setLayout(null);
		JLabel img = m.getSprite().getSprite();
		img.setBounds(0,0,length,height);
		this.add(img);
	}
	
	public void setMonster(){
		Random random = new Random();
		int randMonster = random.nextInt(5);

		switch (randMonster) {
			case 0 -> this.m = new Bat();
			case 1 -> this.m = new FireGolem();
			case 2 -> this.m = new IcyGolem();
			case 3 -> this.m = new MageZombie();
			case 4 -> this.m = new Werewolf();
		}
	}

    @Override
	public Monster getMonster(){
		return this.m;
	}
	@Override
	public Door_Square isDoor(){
		return null;
	}

	@Override
	public Trap_Square isTrap() {
		return null;
	}

}