package main.rooms.squares;

import main.Entities.Monster;

import javax.swing.*;

public abstract class Game_Square extends JPanel {
	public abstract Monster getMonster();
	public abstract Door_Square isDoor();
	public abstract Trap_Square isTrap();
}