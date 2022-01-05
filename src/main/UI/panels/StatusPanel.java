package main.UI.panels;

import main.inventory.InventoryPanel;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    public StatusPanel(PlayerPanel playerPanel, StatPanel lifePanel, InventoryPanel inventoryPanel){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.setBounds(598,0,200,485);
        this.add(playerPanel);
        this.add(lifePanel);
        this.add(inventoryPanel);
    }
}
