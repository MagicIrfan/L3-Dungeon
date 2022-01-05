package main.states;

import main.Entities.Hero;
import main.UI.windows.Ending_Screen;
import main.UI.windows.Game_Window;

public class EndState implements State{

    public EndState(Game_Window win, Hero hero){
        new Ending_Screen(win, hero);
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

    }
}
