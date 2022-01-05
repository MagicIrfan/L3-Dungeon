package main.states;

import main.UI.windows.Game_Window;
import main.UI.windows.Window;

public class MenuState implements State{

    public MenuState(){
        Window win = new Window(400,500);
    }
    @Override
    public void fight() {

    }

    @Override
    public boolean isObjectOnLeft() {
        return false;
    }

    @Override
    public boolean isObjectOnRight() {
        return false;
    }

    @Override
    public boolean isObjectOnNorth() {
        return false;
    }

    @Override
    public boolean isObjectOnSouth() {
        return false;
    }

    @Override
    public void isHeroOnTrap(Game_Window win) {

    }

    @Override
    public void isHeroOnDoor() {

    }

    @Override
    public void isOnChest() {

    }

    @Override
    public void isMonsterNearby(Game_Window win) {

    }

    @Override
    public void isOnTrophy(Game_Window win) {

    }

    @Override
    public void goNorth() {

    }

    @Override
    public void goSouth() {

    }

    @Override
    public void goEast() {

    }

    @Override
    public void goWest() {

    }

    @Override
    public void openMenu() {

    }

    @Override
    public void display() {
        System.out.println("Menu");
    }
}
