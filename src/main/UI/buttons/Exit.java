package main.UI.buttons;

import main.UI.windows.Window;

import javax.swing.*;

public class Exit extends JButton {
	public Exit(Window win){
		this.setIcon(new ImageIcon("src/main/img/Window/Buttons/exit_but.png"));
		this.setBounds(75,375,250,75);
		this.addActionListener(e -> {
			win.dispose();
			System.exit(0);
		}
		);
	}
}