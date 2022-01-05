package main.states;

import main.UI.windows.Game_Window;

public interface State {
    void fight();
    boolean isObjectOnLeft();
    boolean isObjectOnRight();
    boolean isObjectOnNorth();
    boolean isObjectOnSouth();

    void isHeroOnTrap(Game_Window win);
    void isHeroOnDoor();
    void isOnChest();
    void isMonsterNearby(Game_Window win);
    void isOnTrophy(Game_Window win);

    void goNorth();
    void goSouth();
    void goEast();
    void goWest();

    void openMenu();
    void display();


}
