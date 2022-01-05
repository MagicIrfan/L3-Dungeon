package main.UI.buttons;

import main.UI.windows.Window;
import main.app.Game;

import javax.swing.*;

public class Start extends JButton {
	public Game game_win;

	public Start(Window parent){
		this.setIcon(new ImageIcon("src/main/img/Window/Buttons/start_But.PNG"));
		this.setBounds(75,175,250,75);
		this.addActionListener(e->{
			parent.dispose();
			game_win = new Game();

		} );

	}

}