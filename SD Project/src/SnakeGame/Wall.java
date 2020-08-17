/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import Libs.ColorEx;
import static SnakeGame.screens.Screen.TILE_SIZE;
import java.awt.Graphics;

/**
 *
 * @author Lassassin
 */
public class Wall {
    private int x,y;

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public void draw(Graphics g){
        g.setColor(ColorEx.WALL_BLUE);
        g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(ColorEx.DARK_PURPLE);
        g.fillRect(x * TILE_SIZE + 3, y * TILE_SIZE + 3, TILE_SIZE - 6, TILE_SIZE - 6);
    }
    
    
}
