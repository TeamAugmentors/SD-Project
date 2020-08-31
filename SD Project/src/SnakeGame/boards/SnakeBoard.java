/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.boards;

import SnakeGame.screens.Menu;
import SnakeGame.screens.Screen;
import static SnakeGame.screens.Screen.GAME_OVER;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lassassin
 */
public class SnakeBoard extends JFrame {

    Screen screen;
    Menu menu;

    public SnakeBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Snake");

        setResizable(false);

        init();

    }

    private void init() {

        setLayout(new GridBagLayout());

        GridBagConstraints gb = new GridBagConstraints();

        screen = new Screen();

        menu = new Menu();

        gb.gridx = 0;
        gb.gridy = 0;

        gb.weightx = 10;
        gb.weighty = 0;
        add(screen, gb);
        
        gb.gridx = 1;
        gb.gridy = 0;
        
        gb.weightx = 1;
        gb.weighty = 0;
        add(menu, gb);
        
        
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public Screen getScreen() {
        return screen;
    }

}
