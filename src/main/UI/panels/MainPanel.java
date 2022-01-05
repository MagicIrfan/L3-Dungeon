package main.UI.panels;

import main.Entities.Hero;
import main.UI.windows.Game_Window;
import main.singleton.GameContext;
import main.states.Exploring;
import main.utils.EventController;
import main.observer.EventManager;
import main.rooms.Game_Scene;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {


    public MainPanel(Game_Window parent, int width, int height){
        EventManager manager = new EventManager();
        Hero hero = new Hero(parent);
        Game_Scene scene = new Game_Scene(hero);
        Exploring exploring = new Exploring(hero,scene.getRoom(),scene);
        GameContext.getContext().setState(exploring);
        hero.setExplore(exploring);
        new EventController(parent);
        StatPanel statPanel = new StatPanel(hero.getHealth(),hero.getStrength(),hero.getAttack());
        manager.setListener(statPanel);
        hero.setManager(manager);
        PlayerPanel playerPanel = new PlayerPanel(200,230);
        StatusPanel panel = new StatusPanel(playerPanel,statPanel,hero.getInventory().panel());
        this.setSize(new Dimension(width,height));
        this.setLayout(null);
        this.add(scene);
        this.add(panel);
    }
}
