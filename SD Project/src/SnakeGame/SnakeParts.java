/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame;

import Libs.ColorEx;
import SnakeGame.screens.Screen;
import static SnakeGame.screens.Screen.TILE_SIZE;
import java.awt.Graphics;


/**
 *
 * @author Lassassin
 */
public class SnakeParts {

    private int xCoordinate,yCoordinate;
    private int width,height;
    
    
    public SnakeParts(int xCoordinate, int yCoordinate) {
        
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        
        width = TILE_SIZE;
        height = TILE_SIZE;
    
    }
    
    public void draw(Graphics g){
        g.setColor(ColorEx.SNAKE_PURPLE);
        
        g.fillRect(xCoordinate*TILE_SIZE, yCoordinate*TILE_SIZE, width, height);
       
        
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    
    
}
