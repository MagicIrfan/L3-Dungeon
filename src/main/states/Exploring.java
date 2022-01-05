package main.states;

import main.Entities.Hero;
import main.Entities.Monster;
import main.UI.windows.Game_Window;
import main.rooms.*;
import main.rooms.squares.Chest;
import main.rooms.squares.Door_Square;
import main.rooms.squares.Game_Square;
import main.rooms.squares.Trap_Square;
import main.singleton.GameContext;

import java.util.Objects;

public class Exploring implements State{
	
	private final Hero h;
	private Game_Room room;
	private final Game_Scene scene;
	
	public Exploring(Hero hero, Game_Room currentRoom, Game_Scene scn){
		this.h = hero;
		this.room = currentRoom;
		this.scene = scn;
	}

	@Override
	public void fight() {

	}

	@Override
	public boolean isObjectOnLeft(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		return Objects.equals(matrixRoom[(this.h.getPosX() / 60) - 1][this.h.getPosY() / 60], "W") || Objects.equals(matrixRoom[(this.h.getPosX() / 60) - 1][this.h.getPosY() / 60], "B");
	}
	@Override
	public boolean isObjectOnRight(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		return Objects.equals(matrixRoom[(this.h.getPosX() / 60) + 1][this.h.getPosY() / 60], "W") || Objects.equals(matrixRoom[(this.h.getPosX() / 60) + 1][this.h.getPosY() / 60], "B");
	}
	@Override
	public boolean isObjectOnNorth(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		return Objects.equals(matrixRoom[(this.h.getPosX() / 60)][(this.h.getPosY() / 60) - 1], "W") || Objects.equals(matrixRoom[(this.h.getPosX() / 60)][(this.h.getPosY() / 60) - 1], "B");
	}
	@Override
	public boolean isObjectOnSouth(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		return Objects.equals(matrixRoom[(this.h.getPosX() / 60)][(this.h.getPosY() / 60) + 1], "W") || Objects.equals(matrixRoom[(this.h.getPosX() / 60)][(this.h.getPosY() / 60) + 1], "B");
	}

	@Override
	public void isHeroOnTrap(Game_Window win){
		String[][] matrixRoom = this.room.getRoomMatrix();
		Game_Square[][] mR = this.room.getRoom();
		if (Objects.equals(matrixRoom[this.h.getPosX() / 60][this.h.getPosY() / 60], "T")) {
			Trap_Square trap = mR[this.h.getPosX() / 60][this.h.getPosY() / 60].isTrap();
			this.h.setHealth(h.getHealth() - trap.getDamage());
			if(!this.h.isDead())
				System.out.println("Vous marchez sur un piège et prenez " + trap.getDamage());
			else {
				System.out.println("Vous êtes mort");
				GameContext.getContext().setState(new EndState(win,h));
			}
		}
	}

	@Override
	public void isHeroOnDoor(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		Game_Square[][] mR = this.room.getRoom();
		if(Objects.equals(matrixRoom[this.h.getPosX() / 60][this.h.getPosY() / 60], "D"))
		{
			Door_Square doorTaken = mR[this.h.getPosX()/60][this.h.getPosY()/60].isDoor();
			this.room = room.DrawLinkedRoom(doorTaken.getLinkedRoom(),this.scene);
			int posx;
			int posy;
			if(doorTaken.getIdX() ==0)
				posx = 8;
			else if(doorTaken.getIdX() == 9)
				posx = 1;
			else
				posx = doorTaken.getIdX();

			if(doorTaken.getIdY() ==0)
				posy = 6;
			else if(doorTaken.getIdY() == 7)
				posy = 1;
			else
				posy = doorTaken.getIdY();
			h.Position(posx*60,posy*60);
		}
	}

	@Override
	public void isOnChest(){
		String[][] matrixRoom = this.room.getRoomMatrix();
		Game_Square[][] mR = this.room.getRoom();
		int x = this.h.getPosX()/60;
		int y = this.h.getPosY()/60;
		if(Objects.equals(matrixRoom[x][y], "C"))
		{
			Chest sq = (Chest) mR[x][y];
			sq.drop(this.h);
			room.ChangeSquare(x,y,60,60,scene);
		}
	}

	@Override
	public void goNorth() {
		h.goNorth();
		/*if(!explore.isObjectOnNorth() && !isWin && !isHeroDead)
		{
			posy = posy-60;
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
			isMonsterNearby(win);
			isHeroOnDoor();
			isHeroOnTrap(win);
			explore.isOnChest();
			explore.isOnTrophy(win);
			// System.out.println("x :"+this.posx+" / y :"+this.posy);
		}
		else
		{
			Dimension size = this.sprite.getSprite().getPreferredSize();
			this.sprite.getSprite().setBounds(posx,posy,size.width,size.height);
		}*/
	}

	@Override
	public void goSouth() {
		h.goSouth();
	}

	@Override
	public void goEast() {
		h.goEast();
	}

	@Override
	public void goWest() {
		h.goWest();
	}

	@Override
	public void openMenu() {

	}

	@Override
	public void display() {
		System.out.println("Explore");
	}


	@Override
	public void isOnTrophy(Game_Window win){
		String[][] matrixRoom = this.room.getRoomMatrix();
		this.room.getRoom();
		if (Objects.equals(matrixRoom[this.h.getPosX() / 60][this.h.getPosY() / 60], "TR")) {
			this.h.setIsWin(true);
			GameContext.getContext().setState(new EndState(win,this.h));
		}
	}

	@Override
	public void isMonsterNearby(Game_Window win){
		String[][] matrixRoom = this.room.getRoomMatrix();
		Game_Square[][] mR = this.room.getRoom();
		Monster m;
		if (Objects.equals(matrixRoom[this.h.getPosX() / 60][this.h.getPosY() / 60], "M"))
		{
			m = mR[this.h.getPosX()/60][this.h.getPosY()/60].getMonster();
			if(m!=null)
			{
				State fight = new Fight(this.h,m,scene, scene.getRoom());
				GameContext.getContext().setState(fight);
				fight.fight();
				if(m.isDead()){
					this.h.setNbPoints(m.getnbPoints());
				}
				this.room.Change_Room(scene);
			}
		}
		if(h.isDead())
		{
			GameContext.getContext().setState(new EndState(win,h));
		}
	}
}