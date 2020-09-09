/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SnakeGame.screens;

import JFrame.HangManGame;
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import sd.project.MyConnection;

/**
 *
 * @author Lassassin
 */
public class Screen extends JPanel implements Runnable {

    //--------------------Storing userInfo to DB---
    ArrayList<String> field = new ArrayList<String>();
    //---------------------------------------------

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
    private int score = 0;
    //---------------------------------------------

    //---------------------Map---------------------
    private ArrayList<Wall> map = MAP;
    //---------------------------------------------

    //---------------------Files-------------------
    File scoreFile;
    //---------------------------------------------

    public Screen() throws IOException {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        //-------importing userInfo from file------
        File file = new File("resources/Status/id.txt");
        try {
            BufferedReader bfr;
            bfr = new BufferedReader(new FileReader(file));
            String line;

            try {
                while ((line = bfr.readLine()) != null) {
                    field.add(line);
                }
            } catch (IOException ex) {
                Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
        //-----------------------------------------

        initScoreFile();

        addComponentListener(
                new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e
            ) {
                System.out.println("SELECTED`````1");
                Screen.this.requestFocusInWindow();
            }
        }
        );

        key = new Key();

        addKeyListener(key);

        xCoordiante = WIDTH / 40;
        yCoordinate = HEIGHT / 40;

        size = 1;

        snake = new ArrayList<>();

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

        setScore();

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
            Logger.getLogger(Screen.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void stop(String exit) {

        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Screen.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            score += 50;
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
        try {
            if (score > Integer.parseInt(field.get(8))) {
                //------updating to DB----------------------
                PreparedStatement ps;
                String sql = "UPDATE userinfo SET u_fname=?,u_lname=?,u_username=?,u_pass=?,u_squestion=?,u_sanswer=?,hangman=?,snake=? WHERE u_email = ?";
                try {
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    
                    field.add(8,String.valueOf(score));
                    
                    ps.setString(1, field.get(0));
                    ps.setString(2, field.get(1));
                    ps.setString(3, field.get(2));
                    ps.setString(4, field.get(3));
                    ps.setString(5, field.get(5));
                    ps.setString(6, field.get(6));
                    ps.setString(7, field.get(7));
                    ps.setString(8, field.get(8));
                    ps.setString(9, field.get(4));

                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(Screen.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                //----------------------------------------

                updateUserFile();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "");
        }
        SNAKE_BOARD.dispose();

    }

    private void drawMap(Graphics g) {
        if (map != null) {
            for (int i = 0; i < map.size(); i++) {
                map.get(i).draw(g);
            }

        }

    }

    private void updateUserFile() throws IOException {
        FileWriter file = new FileWriter("resources/Status/id.txt");
        for (int i = 0; i < 9; i++) {
            file.write(field.get(i) + "\n");
        }
        file.close();
    }

    private void setScore() {
        Menu.SCORE_LABEL.setText(score + "");
    }

    private int getScoreFromFile() {
        try {
            String data = "";
            Scanner myReader = new Scanner(scoreFile);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
            return Integer.parseInt(data);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. " + e.getMessage());
            return 0;
        }
    }

    private void initScoreFile() {
        scoreFile = new File("resources/Snake.Resources/scores.txt");

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
                stop("EXIT");
                SNAKE_BOARD.dispose();
                SNAKE_GAME_MAIN_MENU.setVisible(true);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

    }

}
