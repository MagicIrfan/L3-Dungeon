package main.UI.windows;

import main.UI.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class Game_Window extends JFrame {
	
	public Game_Window(int x, int y){
		this.setTitle("Jeux de donjon");
		this.setSize(x, y);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/main/img/icon_window.PNG");
		this.setIconImage(icon);
		this.setLayout(null);
		this.setVisible(true);
		MainPanel panel = new MainPanel(this,x,y);
		this.getContentPane().add(panel);

		
	}
}