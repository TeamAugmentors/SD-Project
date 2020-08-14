/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import SnakeGame.graphics.Screen;
import static SnakeGame.graphics.Screen.GAME_OVER;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Lassassin
 */
public class Board extends JFrame {

    public Board() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Snake");

        setResizable(false);

        init();

    }

    private void init() {

        setLayout(new GridLayout(1, 1, 0, 0));

        Screen s = new Screen();

        add(s);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }

}
