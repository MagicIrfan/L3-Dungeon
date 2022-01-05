package main.rooms;

public class Dungeon {
	private final Game_Room currentRoom;

	public Dungeon(Game_Scene s){
		this.currentRoom = new Game_Room(s);

    }

	public Game_Room getCurrentRoom(){return this.currentRoom;}
	

}
