/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.graphics;

import static SnakeGame.MapEditor.MAP;
import static SnakeGame.screens.Screen.HEIGHT;
import static SnakeGame.screens.Screen.TILE_SIZE;
import static SnakeGame.screens.Screen.WIDTH;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Lassassin
 */
public class Food {

    private int x, y;
    private Random random;
    private BufferedImage img = null;

    public Food() {
        random = new Random();
        try {
            img = ImageIO.read(new File("resources/food.png"));
        } catch (IOException e) {
            System.out.println("couldnt find image");
        }
        onCreateFood();
    }

    public void onCreateFood() {

        x = random.nextInt(WIDTH) / TILE_SIZE * TILE_SIZE;
        y = random.nextInt(HEIGHT) / TILE_SIZE * TILE_SIZE;

        if (MAP != null) {
            for (int i = 0; i < MAP.size(); i++) {
                if (x == MAP.get(i).getX() && y == MAP.get(i).getY()) {
                    onCreateFood();
                }
            }

        }

    }

    public void drawFood(Graphics g) {
        g.drawImage(img, x + 1, y + 1, null);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
