package main.utils;

import main.singleton.GameContext;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventController implements KeyListener
{
    public EventController(JFrame gameFrame)
    {
        gameFrame.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP -> GameContext.getContext().goNorth();
            case KeyEvent.VK_DOWN -> GameContext.getContext().goSouth();
            case KeyEvent.VK_RIGHT -> GameContext.getContext().goEast();
            case KeyEvent.VK_LEFT -> GameContext.getContext().goWest();
        }
        GameContext.getContext().display();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
