/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.graphics;

import static JFrame.SnakeGameMainMenu.BOARD;
import Libs.ColorEx;
import SnakeGame.Board;
import SnakeGame.SnakeParts;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lassassin
 */
public class Screen extends JPanel implements Runnable {

    //-----------------------STATIC VARIABLES------
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;
    public static final int TILE_SIZE = 20;
    public static final int FRAME_RATE = 60;
    public static final boolean GAME_OVER = false;
    //---------------------------------------------

    //----------------------Coordinates------------
    private int xCoordiante;
    private int yCoordinate;
    //---------------------------------------------

    //----------------------Snake------------------
    private ArrayList<SnakeParts> snake;
    private SnakeParts parts;
    private int size;
    //---------------------------------------------

    //----------------------Movement Booleans------
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    //---------------------------------------------
    //---------------------Food--------------------
    private Food food;

    //---------------------------------------------
    //----------------------Game Variables---------
    private Thread thread;
    private boolean running = false;
    private int frames = 0;
    private Key key;

    //---------------------------------------------

    public Screen() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        key = new Key();
        setFocusable(true);
        addKeyListener(key);

        

        xCoordiante = WIDTH / 40;
        yCoordinate = HEIGHT / 40;
        
        size = 1;

        snake = new ArrayList<SnakeParts>();

        food = new Food();

        start();
    }

    public void start() {
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();
    }

    public void tick() {

        initializeHeadOfSnake();

        if (frames > FRAME_RATE * 5000) {

            snakeAddParts();

            deathCollisionDetection();

            snakeRemoveTail();

            movement();

            foodCollisionDetection();

            frames = 0;

        }
        
        frames++;

    }
//

    public void paint(Graphics g) {

        drawBack(g);
        drawSnake(g);
        drawGrid(g);

        food.drawFood(g);

    }

    public void stop() {

        running = false;
        gameOver();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//

    public void run() {
        while (running) {

            tick();
            repaint();
        }

    }

    private void drawGrid(Graphics g) {
        g.setColor(ColorEx.GRID_BLUE);

        for (int i = TILE_SIZE; i < HEIGHT; i = i + TILE_SIZE) {
            g.drawLine(0, i, WIDTH, i);
        }

        for (int i = TILE_SIZE; i < WIDTH; i = i + TILE_SIZE) {
            g.drawLine(i, 0, i, HEIGHT);
        }

    }

    private void drawBack(Graphics g) {

        g.setColor(ColorEx.DARK_PURPLE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

    private void initializeHeadOfSnake() {
        if (snake.isEmpty()) {
            parts = new SnakeParts(xCoordiante, yCoordinate);
            snake.add(parts);
        }
    }

    private void snakeAddParts() {
        parts = new SnakeParts(xCoordiante, yCoordinate);
        snake.add(parts);
    }

    private void snakeRemoveTail() {
        if (snake.size() > size) {
            snake.remove(0);
        }
    }

    private void movement() {

        if (up) {

            yCoordinate--;
        }
        if (down) {

            yCoordinate++;
        }
        if (left) {

            xCoordiante--;

        }
        if (right) {

            xCoordiante++;

        }

      
        if (yCoordinate > HEIGHT / TILE_SIZE - 1) {
            yCoordinate = 0;
        }
        
          if (yCoordinate < 0) {
            
            yCoordinate = HEIGHT/TILE_SIZE;
           
        }


        if (xCoordiante < 0) {
            xCoordiante = WIDTH / TILE_SIZE;
        }

        if (xCoordiante > WIDTH / TILE_SIZE) {
            xCoordiante = 0;
        }

        System.out.println("y " + yCoordinate);
    }

    private void foodCollisionDetection() {

        if (snake.get(size - 1).getXCoordinate() * TILE_SIZE == food.getX() && snake.get(size - 1).getYCoordinate() * TILE_SIZE == food.getY()) {
            size++;
            food.onCreateFood();
        }

    }

    private void drawSnake(Graphics g) {
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
    }

    private void deathCollisionDetection() {
        if (size > 4) {

            for (int i = 0; i < size - 1; i++) {

                if (snake.get(size - 1).getXCoordinate() == snake.get(i).getXCoordinate() && snake.get(size - 1).getYCoordinate() == snake.get(i).getYCoordinate()) {
                    stop();
                }

            }

        }
    }

    private void gameOver() {
        new GameOverScreen().setVisible(true);

        BOARD.dispose();

    }
//

    public class Key implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (size == 1) {
                if (key == KeyEvent.VK_UP) {
                    up = true;
                    down = false;
                    left = false;
                    right = false;
                }
                if (key == KeyEvent.VK_DOWN) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;
                }
                if (key == KeyEvent.VK_LEFT) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;
                }

            } else {

                if (key == KeyEvent.VK_UP && !down) {
                    up = true;
                    left = false;
                    right = false;

                }
                if (key == KeyEvent.VK_DOWN && !up) {
                    down = true;
                    left = false;
                    right = false;
                }
                if (key == KeyEvent.VK_LEFT && !right) {
                    up = false;
                    down = false;
                    left = true;

                }
                if (key == KeyEvent.VK_RIGHT && !left) {
                    up = false;
                    down = false;
                    right = true;
                }

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

}
