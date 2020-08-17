/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.boards;

import SnakeGame.screens.MapEditor;
import SnakeGame.screens.Screen;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Lassassin
 */
public class MapBoard extends JFrame{

     public MapBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Map Editor");

        setResizable(false);

        init();

    }

    private void init() {

        setLayout(new GridLayout(1, 1, 0, 0));

        MapEditor s = new MapEditor();

        add(s);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    
    
}
