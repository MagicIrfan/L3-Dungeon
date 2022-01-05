package main.states;
import main.Entities.Hero;
import main.Entities.Monster;
import main.UI.windows.Fight_Scene;
import main.UI.windows.Game_Window;
import main.rooms.Game_Room;
import main.rooms.Game_Scene;
import main.singleton.GameContext;

import java.awt.*;
import java.util.Random;
public class Fight implements State {
	private final Hero hero;
	private final Monster monster;
	private final Game_Scene scene;
	private final Game_Room room;
	
	public Fight(Hero hero, Monster monster, Game_Scene scene, Game_Room room){
		this.hero=hero;
		this.monster=monster;
		this.scene = scene;
		this.room = room;
	}
	
	public void FullFight(){
		Fight_Scene fight = new Fight_Scene(monster,hero);
		int turn = 1;
		TextArea fightRecap = new TextArea(500,50);
		while(!monster.isDead() && !hero.isDead())
		{
			fightRecap.setEditable(false);
			fightRecap.append("Tour numero " + turn + " :\n");
			fightRecap.append(" Vie du monstre :"+monster.getHealth()+"\n");
			fightRecap.append(" Votre vie :"+hero.getHealth()+"\n");
			Random randDice = new Random();
			if(randDice.nextInt(20)>monster.getResistance())
			{
				hero.attackMonster(monster);
				fightRecap.append(" Le monstre perd :"+hero.getAttack()+" points de vie\n");
			}
			else {
				fightRecap.append(" Votre ne touchez pas le monstre.\n");
			}
			
			if(monster.getHealth()>0)
			{
				if(randDice.nextInt(20)>hero.getResistance())
				{
					monster.attack(hero);
					fightRecap.append(" Vous perdez :"+monster.getAttack()+" points de vie\n");
				}
				else {
					fightRecap.append(" Le monstre vous a rate\n");
				}
			}
			turn++;

		}
		if(hero.getHealth()<=0){
			fightRecap.append(" Vous avez perdu\n");
		}
		else {
			fightRecap.append(" Vous gagnez haut la main !!!\n");
			System.out.println("gagné");
			Exploring explore = new Exploring(hero,room,scene);
			GameContext.getContext().setState(explore);
		}
		fightRecap.setBounds(100,100,250,100);
		fight.add(fightRecap);
		fight.setModal(true);
		fight.repaint();
        fight.setVisible(true);

	}

	@Override
	public void fight() {
		FullFight();

	}

	@Override
	public boolean isObjectOnLeft() {
		return false;
	}

	@Override
	public boolean isObjectOnRight() {
		return false;
	}

	@Override
	public boolean isObjectOnNorth() {
		return false;
	}

	@Override
	public boolean isObjectOnSouth() {
		return false;
	}

	@Override
	public void isHeroOnTrap(Game_Window win) {

	}

	@Override
	public void isHeroOnDoor() {

	}

	@Override
	public void isOnChest() {

	}

	@Override
	public void isMonsterNearby(Game_Window win) {

	}

	@Override
	public void isOnTrophy(Game_Window win) {

	}

	@Override
	public void goNorth() {

	}

	@Override
	public void goSouth() {

	}

	@Override
	public void goEast() {

	}

	@Override
	public void goWest() {

	}

	@Override
	public void openMenu() {

	}

	@Override
	public void display() {
		System.out.println("Combat");
	}
}