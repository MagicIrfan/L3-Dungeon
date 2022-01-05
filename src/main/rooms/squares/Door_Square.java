package main.rooms.squares;

import main.Entities.Monster;
import main.rooms.Game_Room;

import javax.swing.*;

public class Door_Square extends Game_Square {

	private final int idX;
	private final int idY;
	private Game_Room linkedRoom;
	
	public Door_Square(int posx,int posy,int length,int height,int i,int j){
		this.setBounds(posx,posy,length,height);
		this.setLayout(null);
		this.idX=i;
		this.idY=j;
		ImageIcon icon;
		if(posy== 0) {
			icon = new ImageIcon("src/main/img/Squares/Doors/door.png");
		}else if(posy == 420){
			icon = new ImageIcon("src/main/img/Squares/Doors/door_down.png");
		}else if(posx == 0){
			icon = new ImageIcon("src/main/img/Squares/Doors/door_left.png");
		} else
			icon =  new ImageIcon("src/main/img/Squares/Doors/door_right.png");

		JLabel img = new JLabel(icon);
		img.setBounds(0,0,length,height);
		this.add(img);
		this.linkedRoom = null;
	}
	
	public int getIdX(){
		return this.idX;
	}
	public void setLinkedRoom(Game_Room Gr){
		this.linkedRoom=Gr;
	}
	public Game_Room getLinkedRoom(){
		return this.linkedRoom;
	}

	public int getIdY(){
		return this.idY;
	}

	@Override
	public Monster getMonster(){
		return null;
	}
	@Override
	public Door_Square isDoor(){
		return this;
	}

	@Override
	public Trap_Square isTrap() {
		return null;
	}

}