package main.rooms.squares;

import main.Entities.Monster;

import javax.swing.*;

public class Wall_Square extends Game_Square {

	public Wall_Square(int posx,int posy,int length,int height){
		this.setBounds(posx,posy,length,height);
		this.setLayout(null);
		ImageIcon icon;
		if( posx == 0 && posy==420) {
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_left_down.png");
		}else if(posx == 540 && posy == 420){
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_right_down.png");
		}else if(posx == 0 && posy == 0){
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_left_top.png");
		} else if(posx == 540 && posy == 0){
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_right_top.png");
		}else if (posx == 540) {
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_right.png");
		} else if(posy == 420){
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_down.png");
		}else if( posx == 0){
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_left.png");
		} else
			icon = new ImageIcon("src/main/img/Squares/Walls/wall_up.png");
		JLabel img = new JLabel(icon);
		img.setBounds(0,0,length,height);
		this.add(img);
	}

    @Override
	public Monster getMonster(){
		return null;
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