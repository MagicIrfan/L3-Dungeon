package main.UI.windows;

import main.Entities.Hero;
import main.app.Game;
import main.singleton.GameContext;
import main.states.MenuState;

import javax.swing.*;
import java.awt.*;

public class Ending_Screen extends JFrame{
    private final Game_Window gameWin;
    private final Hero hero;


    public Ending_Screen(Game_Window win, Hero h) {
        this.gameWin=win;
        this.hero = h;
        Winning_Window();
    }

    public void Winning_Window(){
        //La fenetre
        gameWin.dispose();
        this.setTitle("Jeux de donjon");
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JLabel(new ImageIcon("src/main/img/Window/main_window_bg.PNG")));

        //Changement de l'icone de la fenetre
        Image icon = Toolkit.getDefaultToolkit().getImage("src/main/img/Window/icon_window.PNG");
        this.setIconImage(icon);

        this.setLayout(null);
        this.setVisible(true);
        this.add(Game(this));
        this.add(Menu(this));
        setText(this);
    }

    public JButton Game(JFrame f){
        JButton game = new JButton();
        game.setIcon(new ImageIcon("src/main/img/Window/Buttons/replay_but.PNG"));
        game.setBounds(75,175,250,75);
        game.addActionListener(e -> {
            new Game();
            f.dispose();
            gameWin.dispose();
        });
        return game;
    }
    public JButton Menu(JFrame f){
        JButton menu = new JButton();
        menu.setIcon(new ImageIcon("src/main/img/Window/Buttons/menu_but.PNG"));
        menu.setBounds(75,275,250,75);
        menu.addActionListener(e -> {
            GameContext.getContext().setState(new MenuState());
            f.dispose();
            gameWin.dispose();
        });
        return menu;
    }

    public void setText(Ending_Screen e){
        JLabel text = new JLabel();
        JLabel text2 = new JLabel();
        if(hero.getIsWin()) {
            text.setText("Vous avez triomphez du donjon Heros");
            text2.setText("Total points : "+this.hero.getNbPoints());
        }else if(hero.isDead()){
            text.setText("Vous etes mort dans le donjon Heros");
            text2.setText("Total points : "+this.hero.getNbPoints());
        }
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text.setBounds(75,0,250,75);
        text2.setBounds(75,20,250,75);
        text.setForeground(Color.white);
        text2.setForeground(Color.white);
        text.setFont(new Font("Serif", Font.BOLD, 15));
        text2.setFont(new Font("Serif", Font.BOLD, 15));

        e.add(text);
        e.add(text2);
    }
}
