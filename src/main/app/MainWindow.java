package main.app;

import main.singleton.GameContext;
import main.states.MenuState;


public class MainWindow{
	public static void main(String[] args){
		GameContext.getContext().setState(new MenuState());
		GameContext.getContext().openMenu();
	}
}