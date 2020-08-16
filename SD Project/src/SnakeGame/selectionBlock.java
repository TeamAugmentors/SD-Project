/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import Libs.ColorEx;
import SnakeGame.screens.Screen;
import java.awt.Graphics;

/**
 *
 * @author Lassassin
 */
class selectionBlock {

    private int x,y;
    
    public selectionBlock(int x, int y) {
        move(x, y);
    }
    
    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    void draw(Graphics g){
        g.setColor(ColorEx.SELECTOR_GREEN);
        g.drawRect(x*Screen.TILE_SIZE, y*Screen.TILE_SIZE, Screen.TILE_SIZE, Screen.TILE_SIZE);
        g.setColor(ColorEx.DARK_PURPLE);
        g.drawRect(x*Screen.TILE_SIZE+3, y*Screen.TILE_SIZE+3, Screen.TILE_SIZE-6, Screen.TILE_SIZE-6);
    }
    
}
