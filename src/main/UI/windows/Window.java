package main.UI.windows;

import main.UI.buttons.Exit;
import main.UI.buttons.Start;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
	
public Window(int x, int y){
		
		//La fenetre
		this.setTitle("Jeux de donjon");
		this.setSize(x, y);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new JLabel(new ImageIcon("src/main/img/Window/main_window_bg.PNG")));
		
		//Changement de l'icone de la fenetre
		Image icon = Toolkit.getDefaultToolkit().getImage("src/main/img/Window/icon_window.PNG");
		this.setIconImage(icon);

		Start start = new Start(this);
		Exit exit = new Exit(this);
		this.add(start);
		this.add(exit);
		this.setVisible(true);
	}
}