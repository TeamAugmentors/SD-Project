/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.graphics;

import Libs.ColorEx;
import static SnakeGame.graphics.Screen.TILE_SIZE;
import java.awt.Graphics;

/**
 *
 * @author Lassassin
 */
public class Wall {
    private int x,y;

    public Wall() {
        this.x = x;
        this.y = y;
    }
    
    
    void draw(Graphics g){
        g.setColor(ColorEx.WALL_BLUE);
        g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        g.setColor(ColorEx.DARK_PURPLE);
        g.fillRect(x * TILE_SIZE - 3, y * TILE_SIZE - 3, x, x);
    }
    
    
}
