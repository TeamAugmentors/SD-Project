/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.screens;

import SnakeGame.Wall;
import Libs.ColorEx;
import SnakeGame.SnakeParts;
import SnakeGame.graphics.GameOverScreen;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import static JFrame.SnakeGameMainMenu.SNAKE_BOARD;
import static SnakeGame.screens.MapEditor.MAP;
import static JFrame.UserScreen.SNAKE_GAME_MAIN_MENU;
import SnakeGame.graphics.Food;

/**
 *
 * @author Lassassin
 */
public class Screen extends JPanel implements Runnable {

    //-----------------------STATIC VARIABLES------
    public static final int WIDTH = 1600;
    public static final int HEIGHT = 800;
    public static final int TILE_SIZE = 20;
    public static int FRAMES_PER_SECOND = 30;
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
    private Key key;
    private double timePerTick = 1e9 / FRAMES_PER_SECOND;
    private double delta = 0;
    private long now;
    private long lastTime = System.nanoTime();
    private long timer = 0;
    private int ticks = 0;
    //---------------------------------------------

    //---------------------Map---------------------
    private ArrayList<Wall> map = MAP;

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

        snakeAddParts();

        deathCollisionDetection();

        snakeRemoveTail();

        movement();

        foodCollisionDetection();

    }

    public void paint(Graphics g) {

        drawBack(g);
        drawSnake(g);
        drawMap(g);
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

    public void run() {

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                repaint();
                delta--;
                ticks++;
            }

            if (timer >= 1e9) {
                System.out.println("Ticks and frames: " + ticks);
                ticks = 0;
                timer = 0;
            }

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

            yCoordinate = HEIGHT / TILE_SIZE;

        }

        if (xCoordiante > WIDTH / TILE_SIZE - 1) {
            xCoordiante = 0;
        }

        if (xCoordiante < 0) {
            xCoordiante = WIDTH / TILE_SIZE;
        }

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
        if (map != null) {

            for (int i = 0; i < map.size(); i++) {
                if (snake.get(size - 1).getXCoordinate() == map.get(i).getX() && snake.get(size - 1).getYCoordinate() == map.get(i).getY()) {
                    stop();
                }
            }
        }
    }

    private void gameOver() {
        new GameOverScreen().setVisible(true);

        SNAKE_BOARD.dispose();

    }
//

    private void drawMap(Graphics g) {
        if (map != null) {
            for (int i = 0; i < map.size(); i++) {
                map.get(i).draw(g);
            }

        }

    }

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

            if (key == KeyEvent.VK_ESCAPE) {
                SNAKE_BOARD.dispose();
                SNAKE_GAME_MAIN_MENU.setVisible(true);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

}
