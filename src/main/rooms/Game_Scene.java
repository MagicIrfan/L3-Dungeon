package main.rooms;

import main.Entities.Hero;
import main.rooms.squares.Game_Square;

import javax.swing.*;

public class Game_Scene extends JPanel {

	private final Game_Room room;

	public Game_Scene(Hero hero){
		//private Exploring exp;
		Dungeon newDungeon = new Dungeon(this);
		this.room = newDungeon.getCurrentRoom();
		this.setBounds(0,0,600,480);
		this.setLayout(null);
		this.add(hero.getSprite().getSprite());
		Draw_Room(this.room);
		repaint();


	}

	public void Draw_Room(Game_Room r){
		Game_Square[][] q = r.getRoom();
		for (Game_Square[] game_squares : q) {
			for (Game_Square game_square : game_squares) {
				this.add(game_square);
			}
		}
	}

	public Game_Room getRoom(){
		return room;
	}
}