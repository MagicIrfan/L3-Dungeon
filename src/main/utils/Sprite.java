package main.utils;

import javax.swing.*;
import java.awt.*;

public class Sprite
{
    private JLabel label;
    private ImageIcon icon;

    public Sprite(String url){
        this.icon = new ImageIcon(url);
        this.label = new JLabel(this.icon);
        this.label.setPreferredSize(new Dimension(60,60));
    }

    public JLabel getSprite(){
        return label;
    }
}
