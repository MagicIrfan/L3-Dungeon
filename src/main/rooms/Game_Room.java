package main.rooms;
import main.Entities.Monster;
import main.rooms.squares.*;

import java.util.*;
public class Game_Room {
	private Game_Square[][] room;
	private String[][] matrix;
	private int nbDoor;
	private int xLinkedRoom;
	private int yLinkedRoom;
	private final Game_Scene scene;

	public Game_Room(Game_Scene scn) {
		this.room = Build_Start_Room();
		this.scene = scn;

	}

	public Game_Room(Game_Room linked_Room, Game_Scene scn, int i, int j, int nbR) {
		this.xLinkedRoom = i;
		this.yLinkedRoom = j;
		this.scene = scn;
		this.room = Build_Room(linked_Room, nbR);


	}

	public Game_Square[][] Build_Start_Room() {
		Game_Square[][] startRoom = new Game_Square[10][8];
		Random random = new Random();
		boolean randSquare;
		this.matrix = new String[10][8];
		for (int index = 0; index < 10; index++) {
			if (index == 5)
				nbDoor = 0;
			for (int Jindex = 0; Jindex < 8; Jindex++) {
				if (index == 0 || Jindex == 0 || index == 9 || Jindex == 7) {
					randSquare = random.nextBoolean();
					if (randSquare && isPlaceDoorOk(this.matrix, index, Jindex) && nbDoor < 5) {
						Door_Square tempDoor = new Door_Square(index * 60, Jindex * 60, 60, 60, index, Jindex);
						startRoom[index][Jindex] = tempDoor;
						Game_Room next = new Game_Room(this, scene, tempDoor.getIdX(), tempDoor.getIdY(), 2);
						tempDoor.setLinkedRoom(next);
						this.matrix[index][Jindex] = ("D");
					} else {
						startRoom[index][Jindex] = new Wall_Square(index * 60, Jindex * 60, 60, 60);
						this.matrix[index][Jindex] = ("W");
					}
					nbDoor += 1;
				} else {
					startRoom[index][Jindex] = new Ground_Square(index * 60, Jindex * 60, 60, 60);
					this.matrix[index][Jindex] = ("G");
				}
			}
		}

		return startRoom;
	}

	public Game_Square[][] Build_Room(Game_Room linkedRoom, int nbRoom) {
		Game_Square[][] Room = new Game_Square[10][8];
		Random random = new Random();
		boolean randSquare;
		int nbMonster = 0;
		int nbTrap = 0;
		int nbObject = 0;
		this.matrix = new String[10][8];

		linkedRoom.getRoomMatrix();
		linkedRoom.getRoom();
		nbDoor = 0;
		nbRoom = nbRoom - 1;

		int posx;
		int posy;
		if (this.xLinkedRoom == 0)
			posx = 9;
		else if (this.xLinkedRoom == 9)
			posx = 0;
		else
			posx = this.xLinkedRoom;

		if (this.yLinkedRoom == 0)
			posy = 7;
		else if (this.yLinkedRoom == 7)
			posy = 0;
		else
			posy = this.yLinkedRoom;
		this.matrix[posx][posy] = ("D");
		Door_Square tempDoor = new Door_Square(posx * 60, posy * 60, 60, 60, posx, posy);
		tempDoor.setLinkedRoom(linkedRoom);
		Room[posx][posy] = tempDoor;

		if (nbRoom == 0) {
			Room[4][5] = new Trophy_Square(4 * 60, 5 * 60, 60, 60);
			this.matrix[4][5] = ("TR");
		}

		for (int index = 0; index < 10; index++) {
			if (index == 5) {
				nbMonster = 0;
				nbObject = 0;
				nbTrap = 0;
			}
			boolean isMonstre = false;
			for (int Jindex = 0; Jindex < 8; Jindex++) {
				randSquare = random.nextBoolean();
				if (index == 0 || Jindex == 0 || index == 9 || Jindex == 7) {
					if (randSquare && nbRoom > 0 && isPlaceDoorOk(this.matrix, index, Jindex) && Objects.equals(Room[index][Jindex], null)) {
						Door_Square tempD = new Door_Square(index * 60, Jindex * 60, 60, 60, index, Jindex);
						Room[index][Jindex] = tempD;
						Game_Room next = new Game_Room(this, scene, tempD.getIdX(), tempD.getIdY(), nbRoom);
						tempD.setLinkedRoom(next);
						this.matrix[index][Jindex] = ("D");
						nbDoor += 1;
					} else if (Objects.equals(Room[index][Jindex], null)) {
						Room[index][Jindex] = new Wall_Square(index * 60, Jindex * 60, 60, 60);
						this.matrix[index][Jindex] = ("W");
					}
				} else {
					if (randSquare && nbMonster < 2 && !isMonstre && !isMonsterNearby(this.matrix, index, Jindex) && Objects.equals(Room[index][Jindex], null)) {
						Room[index][Jindex] = new Monster_Square(index * 60, Jindex * 60, 60, 60);
						nbMonster = nbMonster + 1;
						isMonstre = true;
						this.matrix[index][Jindex] = ("M");
					} else if (randSquare && nbTrap < 2 && !isTrapNearby(this.matrix, index, Jindex) && isPlaceTrapOk(this.matrix, index, Jindex) && Objects.equals(Room[index][Jindex], null)) {
						Room[index][Jindex] = new Trap_Square(index * 60, Jindex * 60, 60, 60);
						this.matrix[index][Jindex] = "T";
						nbTrap += 1;
					} else {
						randSquare = random.nextBoolean();
						if (randSquare && nbObject < 6 && index < 8 && Jindex < 6 && index > 1 && Jindex > 1 && Objects.equals(Room[index][Jindex], null)) {
							Room[index][Jindex] = new Barrel_Square(index * 60, Jindex * 60, 60, 60);
							this.matrix[index][Jindex] = ("B");
							nbObject = nbObject + 1;
						} else {
							double rand = Math.random();
							random.nextBoolean();
							if (rand > 0 && rand <= 0.95 && Objects.equals(Room[index][Jindex], null)) {
								Room[index][Jindex] = new Ground_Square(index * 60, Jindex * 60, 60, 60);
								this.matrix[index][Jindex] = ("G");
							} else if (Room[index][Jindex] == null) {
								Room[index][Jindex] = new Chest(index * 60, Jindex * 60, 60, 60);
								this.matrix[index][Jindex] = ("C");
							}

						}
					}
				}
			}
		}
		return Room;
	}

	public void Change_Room(Game_Scene scn) {
		Game_Square[][] q = this.getRoom();
		String[][] tempM = this.getRoomMatrix();
		Monster m;
		for (int index = 0; index < q.length; index++) {
			for (int Jindex = 0; Jindex < q[index].length; Jindex++) {
				if (Objects.equals(tempM[index][Jindex], "M")) {
					m = q[index][Jindex].getMonster();
					if (m != null && m.isDead()) {
						scn.remove(q[index][Jindex]);
						q[index][Jindex] = new Ground_Square(index * 60, Jindex * 60, 60, 60);
						tempM[index][Jindex] = "G";
						scn.add(q[index][Jindex]);
						scn.repaint();
					}
				}
			}
		}
		this.room = q;
		this.matrix = tempM;


	}

	public Game_Room DrawLinkedRoom(Game_Room next, Game_Scene scn) {
		Game_Square[][] q = this.getRoom();
		for (Game_Square[] game_squares : q) {
			for (Game_Square game_square : game_squares) {
				scn.remove(game_square);
			}
		}
		q = next.getRoom();
		for (Game_Square[] game_squares : q) {
			for (Game_Square game_square : game_squares) {
				scn.add(game_square);
				scn.repaint();
			}
		}
		return next;
	}

	public boolean isMonsterNearby(String[][] g, int i, int j) {
		if (i != 0 && j != 0 && i != 10 && j != 8) {
			return Objects.equals(g[i + 1][j + 1], "M") || Objects.equals(g[i + 1][j], "M") || Objects.equals(g[i + 1][j - 1], "M") || Objects.equals(g[i][j + 1], "M") || Objects.equals(g[i][j - 1], "M") || Objects.equals(g[i - 1][j + 1], "M") || Objects.equals(g[i - 1][j], "M") || Objects.equals(g[i - 1][j - 1], "M");
		}
		return false;
	}

	public boolean isTrapNearby(String[][] g, int i, int j) {
		if (i != 0 && j != 0 && i != 10 && j != 8) {
			return Objects.equals(g[i + 1][j + 1], "T") || Objects.equals(g[i + 1][j], "T") || Objects.equals(g[i + 1][j - 1], "T") || Objects.equals(g[i][j + 1], "T") || Objects.equals(g[i][j - 1], "T") || Objects.equals(g[i - 1][j + 1], "T") || Objects.equals(g[i - 1][j], "T") || Objects.equals(g[i - 1][j - 1], "T");
		}
		return false;
	}

	public boolean isPlaceTrapOk(String[][] g, int i, int j) {
		for (int Jindex = 0; Jindex < g[i].length; Jindex++) {
			if (Objects.equals(g[i][Jindex], "T"))
				return false;
		}
		for (String[] strings : g) {
			if (Objects.equals(strings[j], "T"))
				return false;
		}
		return true;
	}

	public boolean isPlaceDoorOk(String[][] g, int i, int j) {
		if ((i != 0 && j != 0) || (i != 10 && j != 8)) {
			for (int index = 0; index < g[i].length; index++) {
				if (Objects.equals(g[i][index], "D"))
					return false;
			}
			for (String[] strings : g) {
				if (Objects.equals(strings[j], "D"))
					return false;
			}
		}
		if (i == 0 && j == 0)
			return false;
		if (i == 0 && j == 9)
			return false;
		if (i == 10 && j == 9)
			return false;
		return i != 10 || j != 0;
	}

	public Game_Square[][] getRoom() {
		return this.room;
	}

	public String[][] getRoomMatrix() {
		return this.matrix;
	}

	public void ChangeSquare(int x, int y, int width, int height, Game_Scene scn) {
		System.out.println("Position : " + "(" + x + "," + y + ")");
		scn.remove(room[x][y]);
		room[x][y] = new Ground_Square(x * 60, y * 60, width, height);
		matrix[x][y] = "G";
		scn.add(room[x][y]);
		scn.revalidate();
		scn.repaint();
	}
}