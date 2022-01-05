package main.singleton;

import main.states.State;

public class GameContext {

    private State state;
    private static final GameContext instance = new GameContext();

    public GameContext()
    {}

    public void setState(State state){
        this.state = state;
        state.display();
    }

    public void display(){
        state.display();
    }

    public static GameContext getContext(){
        return instance;
    }

    public void goNorth(){
        state.goNorth();
    }

    public void goSouth(){
        state.goSouth();
    }

    public void goEast(){
        state.goEast();
    }

    public void goWest(){
        state.goWest();
    }

    public void openMenu(){
        state.openMenu();
    }

}
